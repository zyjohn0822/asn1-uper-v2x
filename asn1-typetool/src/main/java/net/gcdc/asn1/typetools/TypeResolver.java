package net.gcdc.asn1.typetools;

import sun.misc.Unsafe;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.*;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.*;

/**
 * @author zhangyong
 * @date 2020/12/24  17:27
 */
public class TypeResolver {
    private static final Map<Class<?>, Reference<Map<TypeVariable<?>, Type>>> TYPE_VARIABLE_CACHE = Collections.synchronizedMap(new WeakHashMap());
    private static volatile boolean CACHE_ENABLED = true;
    private static boolean RESOLVES_LAMBDAS;
    private static Method GET_CONSTANT_POOL;
    private static Method GET_CONSTANT_POOL_SIZE;
    private static Method GET_CONSTANT_POOL_METHOD_AT;
    private static final Map<String, Method> OBJECT_METHODS = new HashMap();
    private static final Map<Class<?>, Class<?>> PRIMITIVE_WRAPPERS;
    private static final Double JAVA_VERSION = Double.parseDouble(System.getProperty("java.specification.version", "0"));

    private TypeResolver() {
    }

    public static void enableCache() {
        CACHE_ENABLED = true;
    }

    public static void disableCache() {
        TYPE_VARIABLE_CACHE.clear();
        CACHE_ENABLED = false;
    }

    public static <T, S extends T> Class<?> resolveRawArgument(Class<T> type, Class<S> subType) {
        return resolveRawArgument(resolveGenericType(type, subType), subType);
    }

    public static Class<?> resolveRawArgument(Type genericType, Class<?> subType) {
        Class<?>[] arguments = resolveRawArguments(genericType, subType);
        if (arguments == null) {
            return TypeResolver.Unknown.class;
        } else if (arguments.length != 1) {
            throw new IllegalArgumentException("Expected 1 argument for generic type " + genericType + " but found " + arguments.length);
        } else {
            return arguments[0];
        }
    }

    public static <T, S extends T> Class<?>[] resolveRawArguments(Class<T> type, Class<S> subType) {
        return resolveRawArguments(resolveGenericType(type, subType), subType);
    }

    public static <T, S extends T> Type reify(Class<T> type, Class<S> context) {
        return reify(resolveGenericType(type, context), getTypeVariableMap(context, (Class)null));
    }

    public static Type reify(Type type, Class<?> context) {
        return reify(type, getTypeVariableMap(context, (Class)null));
    }

    public static Type reify(Type type) {
        return reify((Type)type, (Map)(new HashMap(0)));
    }

    public static Class<?>[] resolveRawArguments(Type genericType, Class<?> subType) {
        Class<?>[] result = null;
        Class<?> functionalInterface = null;
        if (RESOLVES_LAMBDAS && subType.isSynthetic()) {
            Class<?> fi = genericType instanceof ParameterizedType && ((ParameterizedType)genericType).getRawType() instanceof Class ? (Class)((ParameterizedType)genericType).getRawType() : (genericType instanceof Class ? (Class)genericType : null);
            if (fi != null && fi.isInterface()) {
                functionalInterface = fi;
            }
        }

        if (genericType instanceof ParameterizedType) {
            ParameterizedType paramType = (ParameterizedType)genericType;
            Type[] arguments = paramType.getActualTypeArguments();
            result = new Class[arguments.length];

            for(int i = 0; i < arguments.length; ++i) {
                result[i] = resolveRawClass(arguments[i], subType, functionalInterface);
            }
        } else if (genericType instanceof TypeVariable) {
            result = new Class[]{resolveRawClass(genericType, subType, functionalInterface)};
        } else if (genericType instanceof Class) {
            TypeVariable<?>[] typeParams = ((Class)genericType).getTypeParameters();
            result = new Class[typeParams.length];

            for(int i = 0; i < typeParams.length; ++i) {
                result[i] = resolveRawClass(typeParams[i], subType, functionalInterface);
            }
        }

        return result;
    }

    public static Type resolveGenericType(Class<?> type, Type subType) {
        Class rawType;
        if (subType instanceof ParameterizedType) {
            rawType = (Class)((ParameterizedType)subType).getRawType();
        } else {
            rawType = (Class)subType;
        }

        if (type.equals(rawType)) {
            return subType;
        } else {
            Type result;
            if (type.isInterface()) {
                Type[] var4 = rawType.getGenericInterfaces();
                int var5 = var4.length;

                for(int var6 = 0; var6 < var5; ++var6) {
                    Type superInterface = var4[var6];
                    if (superInterface != null && !superInterface.equals(Object.class) && (result = resolveGenericType(type, superInterface)) != null) {
                        return result;
                    }
                }
            }

            Type superClass = rawType.getGenericSuperclass();
            return superClass != null && !superClass.equals(Object.class) && (result = resolveGenericType(type, superClass)) != null ? result : null;
        }
    }

    public static Class<?> resolveRawClass(Type genericType, Class<?> subType) {
        return resolveRawClass(genericType, subType, (Class)null);
    }

    private static Class<?> resolveRawClass(Type genericType, Class<?> subType, Class<?> functionalInterface) {
        if (genericType instanceof Class) {
            return (Class)genericType;
        } else if (genericType instanceof ParameterizedType) {
            return resolveRawClass(((ParameterizedType)genericType).getRawType(), subType, functionalInterface);
        } else if (genericType instanceof GenericArrayType) {
            GenericArrayType arrayType = (GenericArrayType)genericType;
            Class<?> component = resolveRawClass(arrayType.getGenericComponentType(), subType, functionalInterface);
            return Array.newInstance(component, 0).getClass();
        } else {
            if (genericType instanceof TypeVariable) {
                TypeVariable<?> variable = (TypeVariable)genericType;
                Type genericTypeCopy = (Type)getTypeVariableMap(subType, functionalInterface).get(variable);
                genericType = genericTypeCopy == null ? resolveBound(variable) : resolveRawClass(genericType, subType, functionalInterface);
            }

            return genericType instanceof Class ? (Class)genericType : TypeResolver.Unknown.class;
        }
    }

    private static Type reify(Type genericType, Map<TypeVariable<?>, Type> typeVariableTypeMap) {
        if (genericType == null) {
            return null;
        } else {
            return genericType instanceof Class ? genericType : reify(genericType, typeVariableTypeMap, new HashMap());
        }
    }

    private static Type reify(Type genericType, Map<TypeVariable<?>, Type> typeVariableMap, Map<Type, Type> cache) {
        if (genericType instanceof Class) {
            return genericType;
        } else {
            while(cache.containsKey(genericType)) {
                genericType = (Type)cache.get(genericType);
            }

            Type[] upperBounds;
            Type[] lowerBounds;
            if (!(genericType instanceof ParameterizedType)) {
                Type mapping;
                if (genericType instanceof GenericArrayType) {
                    GenericArrayType genericArrayType = (GenericArrayType)genericType;
                    mapping = genericArrayType.getGenericComponentType();
                    Type reifiedComponentType = reify(genericArrayType.getGenericComponentType(), typeVariableMap, cache);
                    if (mapping == reifiedComponentType) {
                        return mapping;
                    } else if (reifiedComponentType instanceof Class) {
                        return Array.newInstance((Class)reifiedComponentType, 0).getClass();
                    } else {
                        throw new UnsupportedOperationException("Attempted to reify generic array type, whose generic component type could not be reified to some Class<?>. Handling for this case is not implemented");
                    }
                } else if (genericType instanceof TypeVariable) {
                    TypeVariable<?> typeVariable = (TypeVariable)genericType;
                    mapping = (Type)typeVariableMap.get(typeVariable);
                    if (mapping != null) {
                        cache.put(typeVariable, mapping);
                        return reify(mapping, typeVariableMap, cache);
                    } else {
                        lowerBounds = typeVariable.getBounds();
                        Map<Type, Type> cache2 = new HashMap(cache);
                        cache2.put(typeVariable, lowerBounds[0]);
                        return reify(lowerBounds[0], typeVariableMap, cache2);
                    }
                } else if (genericType instanceof WildcardType) {
                    WildcardType wildcardType = (WildcardType)genericType;
                    upperBounds = wildcardType.getUpperBounds();
                    lowerBounds = wildcardType.getLowerBounds();
                    if (upperBounds.length == 1 && lowerBounds.length == 0) {
                        return reify(upperBounds[0], typeVariableMap, cache);
                    } else {
                        throw new UnsupportedOperationException("Attempted to reify wildcard type with name '" + wildcardType + "' which has " + upperBounds.length + " upper bounds and " + lowerBounds.length + " lower bounds. Reification of wildcard types is only supported for the trivial case of exactly one upper bound and no lower bounds.");
                    }
                } else {
                    throw new UnsupportedOperationException("Reification of type with name '" + genericType.getTypeName() + "' and class name '" + genericType.getClass().getName() + "' is not implemented.");
                }
            } else {
                ParameterizedType parameterizedType = (ParameterizedType)genericType;
                upperBounds = parameterizedType.getActualTypeArguments();
                lowerBounds = new Type[upperBounds.length];
                ReifiedParameterizedType result = new ReifiedParameterizedType(parameterizedType);
                cache.put(genericType, (Type) result);
                boolean changed = false;

                for(int i = 0; i < upperBounds.length; ++i) {
                    if (upperBounds[i] == null) {
                        return parameterizedType;
                    }

                    lowerBounds[i] = reify(upperBounds[i], typeVariableMap, cache);
                    changed = changed || lowerBounds[i] != upperBounds[i];
                }

                if (!changed) {
                    return parameterizedType;
                } else {
                    result.setReifiedTypeArguments(lowerBounds);
                    return (Type) result;
                }
            }
        }
    }

    private static Map<TypeVariable<?>, Type> getTypeVariableMap(Class<?> targetType, Class<?> functionalInterface) {
        Reference<Map<TypeVariable<?>, Type>> ref = (Reference)TYPE_VARIABLE_CACHE.get(targetType);
        Map<TypeVariable<?>, Type> map = ref != null ? (Map)ref.get() : null;
        if (map == null) {
            map = new HashMap();
            if (functionalInterface != null) {
                populateLambdaArgs(functionalInterface, targetType, (Map)map);
            }

            populateSuperTypeArgs(targetType.getGenericInterfaces(), (Map)map, functionalInterface != null);
            Type genericType = targetType.getGenericSuperclass();

            Class type;
            for(type = targetType.getSuperclass(); type != null && !Object.class.equals(type); type = type.getSuperclass()) {
                if (genericType instanceof ParameterizedType) {
                    populateTypeArgs((ParameterizedType)genericType, (Map)map, false);
                }

                populateSuperTypeArgs(type.getGenericInterfaces(), (Map)map, false);
                genericType = type.getGenericSuperclass();
            }

            for(type = targetType; type.isMemberClass(); type = type.getEnclosingClass()) {
                genericType = type.getGenericSuperclass();
                if (genericType instanceof ParameterizedType) {
                    populateTypeArgs((ParameterizedType)genericType, (Map)map, functionalInterface != null);
                }
            }

            if (CACHE_ENABLED) {
                TYPE_VARIABLE_CACHE.put(targetType, new WeakReference(map));
            }
        }

        return (Map)map;
    }

    private static void populateSuperTypeArgs(Type[] types, Map<TypeVariable<?>, Type> map, boolean depthFirst) {
        Type[] var3 = types;
        int var4 = types.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            Type type = var3[var5];
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType)type;
                if (!depthFirst) {
                    populateTypeArgs(parameterizedType, map, depthFirst);
                }

                Type rawType = parameterizedType.getRawType();
                if (rawType instanceof Class) {
                    populateSuperTypeArgs(((Class)rawType).getGenericInterfaces(), map, depthFirst);
                }

                if (depthFirst) {
                    populateTypeArgs(parameterizedType, map, depthFirst);
                }
            } else if (type instanceof Class) {
                populateSuperTypeArgs(((Class)type).getGenericInterfaces(), map, depthFirst);
            }
        }

    }

    private static void populateTypeArgs(ParameterizedType type, Map<TypeVariable<?>, Type> map, boolean depthFirst) {
        if (type.getRawType() instanceof Class) {
            TypeVariable<?>[] typeVariables = ((Class)type.getRawType()).getTypeParameters();
            Type[] typeArguments = type.getActualTypeArguments();
            if (type.getOwnerType() != null) {
                Type owner = type.getOwnerType();
                if (owner instanceof ParameterizedType) {
                    populateTypeArgs((ParameterizedType)owner, map, depthFirst);
                }
            }

            for(int i = 0; i < typeArguments.length; ++i) {
                TypeVariable<?> variable = typeVariables[i];
                Type typeArgument = typeArguments[i];
                if (typeArgument instanceof Class) {
                    map.put(variable, typeArgument);
                } else if (typeArgument instanceof GenericArrayType) {
                    map.put(variable, typeArgument);
                } else if (typeArgument instanceof ParameterizedType) {
                    map.put(variable, typeArgument);
                } else if (typeArgument instanceof TypeVariable) {
                    TypeVariable<?> typeVariableArgument = (TypeVariable)typeArgument;
                    Type resolvedType;
                    if (depthFirst) {
                        resolvedType = (Type)map.get(variable);
                        if (resolvedType != null) {
                            map.put(typeVariableArgument, resolvedType);
                            continue;
                        }
                    }

                    resolvedType = (Type)map.get(typeVariableArgument);
                    if (resolvedType == null) {
                        resolvedType = resolveBound(typeVariableArgument);
                    }

                    map.put(variable, resolvedType);
                }
            }
        }

    }

    public static Type resolveBound(TypeVariable<?> typeVariable) {
        Type[] bounds = typeVariable.getBounds();
        if (bounds.length == 0) {
            return TypeResolver.Unknown.class;
        } else {
            Type bound = bounds[0];
            if (bound instanceof TypeVariable) {
                bound = resolveBound((TypeVariable)bound);
            }

            return (Type)(bound == Object.class ? TypeResolver.Unknown.class : bound);
        }
    }

    private static void populateLambdaArgs(Class<?> functionalInterface, Class<?> lambdaType, Map<TypeVariable<?>, Type> map) {
        if (RESOLVES_LAMBDAS) {
            Method[] var3 = functionalInterface.getMethods();
            int var4 = var3.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                Method m = var3[var5];
                if (!isDefaultMethod(m) && !Modifier.isStatic(m.getModifiers()) && !m.isBridge()) {
                    Method objectMethod = (Method)OBJECT_METHODS.get(m.getName());
                    if (objectMethod == null || !Arrays.equals(m.getTypeParameters(), objectMethod.getTypeParameters())) {
                        Type returnTypeVar = m.getGenericReturnType();
                        Type[] paramTypeVars = m.getGenericParameterTypes();
                        Member member = getMemberRef(lambdaType);
                        if (member == null) {
                            return;
                        }

                        if (returnTypeVar instanceof TypeVariable) {
                            Class<?> returnType = member instanceof Method ? ((Method)member).getReturnType() : ((Constructor)member).getDeclaringClass();
                            returnType = wrapPrimitives(returnType);
                            if (!returnType.equals(Void.class)) {
                                map.put((TypeVariable)returnTypeVar, returnType);
                            }
                        }

                        Class<?>[] arguments = member instanceof Method ? ((Method)member).getParameterTypes() : ((Constructor)member).getParameterTypes();
                        int paramOffset = 0;
                        if (paramTypeVars.length > 0 && paramTypeVars[0] instanceof TypeVariable && paramTypeVars.length == arguments.length + 1) {
                            Class<?> instanceType = member.getDeclaringClass();
                            map.put((TypeVariable)paramTypeVars[0], instanceType);
                            paramOffset = 1;
                        }

                        int argOffset = 0;
                        if (paramTypeVars.length < arguments.length) {
                            argOffset = arguments.length - paramTypeVars.length;
                        }

                        for(int i = 0; i + argOffset < arguments.length; ++i) {
                            if (paramTypeVars[i] instanceof TypeVariable) {
                                map.put((TypeVariable)paramTypeVars[i + paramOffset], wrapPrimitives(arguments[i + argOffset]));
                            }
                        }

                        return;
                    }
                }
            }
        }

    }

    private static boolean isDefaultMethod(Method m) {
        return JAVA_VERSION >= 1.8D && m.isDefault();
    }

    private static Member getMemberRef(Class<?> type) {
        Object constantPool;
        try {
            constantPool = GET_CONSTANT_POOL.invoke(type);
        } catch (Exception var5) {
            return null;
        }

        Member result = null;

        for(int i = getConstantPoolSize(constantPool) - 1; i >= 0; --i) {
            Member member = getConstantPoolMethodAt(constantPool, i);
            if (member != null && (!(member instanceof Constructor) || !member.getDeclaringClass().getName().equals("java.lang.invoke.SerializedLambda")) && !member.getDeclaringClass().isAssignableFrom(type)) {
                result = member;
                if (!(member instanceof Method) || !isAutoBoxingMethod((Method)member)) {
                    break;
                }
            }
        }

        return result;
    }

    private static boolean isAutoBoxingMethod(Method method) {
        Class<?>[] parameters = method.getParameterTypes();
        return method.getName().equals("valueOf") && parameters.length == 1 && parameters[0].isPrimitive() && wrapPrimitives(parameters[0]).equals(method.getDeclaringClass());
    }

    private static Class<?> wrapPrimitives(Class<?> clazz) {
        return clazz.isPrimitive() ? (Class)PRIMITIVE_WRAPPERS.get(clazz) : clazz;
    }

    private static int getConstantPoolSize(Object constantPool) {
        try {
            return (Integer)GET_CONSTANT_POOL_SIZE.invoke(constantPool);
        } catch (Exception var2) {
            return 0;
        }
    }

    private static Member getConstantPoolMethodAt(Object constantPool, int i) {
        try {
            return (Member)GET_CONSTANT_POOL_METHOD_AT.invoke(constantPool, i);
        } catch (Exception var3) {
            return null;
        }
    }

    static {
        try {
            Unsafe unsafe = (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() {
                public Unsafe run() throws Exception {
                    Field f = Unsafe.class.getDeclaredField("theUnsafe");
                    f.setAccessible(true);
                    return (Unsafe)f.get((Object)null);
                }
            });
            GET_CONSTANT_POOL = Class.class.getDeclaredMethod("getConstantPool");
            String constantPoolName = JAVA_VERSION < 9.0D ? "sun.reflect.ConstantPool" : "jdk.internal.reflect.ConstantPool";
            Class<?> constantPoolClass = Class.forName(constantPoolName);
            GET_CONSTANT_POOL_SIZE = constantPoolClass.getDeclaredMethod("getSize");
            GET_CONSTANT_POOL_METHOD_AT = constantPoolClass.getDeclaredMethod("getMethodAt", Integer.TYPE);
            Field overrideField = AccessibleObject.class.getDeclaredField("override");
            long overrideFieldOffset = unsafe.objectFieldOffset(overrideField);
            unsafe.putBoolean(GET_CONSTANT_POOL, overrideFieldOffset, true);
            unsafe.putBoolean(GET_CONSTANT_POOL_SIZE, overrideFieldOffset, true);
            unsafe.putBoolean(GET_CONSTANT_POOL_METHOD_AT, overrideFieldOffset, true);
            Object constantPool = GET_CONSTANT_POOL.invoke(Object.class);
            GET_CONSTANT_POOL_SIZE.invoke(constantPool);
            Method[] var7 = Object.class.getDeclaredMethods();
            int var8 = var7.length;

            for(int var9 = 0; var9 < var8; ++var9) {
                Method method = var7[var9];
                OBJECT_METHODS.put(method.getName(), method);
            }

            RESOLVES_LAMBDAS = true;
        } catch (Exception var11) {
        }

        Map<Class<?>, Class<?>> types = new HashMap();
        types.put(Boolean.TYPE, Boolean.class);
        types.put(Byte.TYPE, Byte.class);
        types.put(Character.TYPE, Character.class);
        types.put(Double.TYPE, Double.class);
        types.put(Float.TYPE, Float.class);
        types.put(Integer.TYPE, Integer.class);
        types.put(Long.TYPE, Long.class);
        types.put(Short.TYPE, Short.class);
        types.put(Void.TYPE, Void.class);
        PRIMITIVE_WRAPPERS = Collections.unmodifiableMap(types);
    }

    public static final class Unknown {
        private Unknown() {
        }
    }
}
