package net.gcdc.asn1.typetools;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

/**
 * @author zhangyong
 * @date 2020/12/24  17:21
 */
public class ReifiedParameterizedType {
    private final ParameterizedType original;
    private final Type[] reifiedTypeArguments;

    ReifiedParameterizedType(ParameterizedType original) {
        this.original = original;
        this.reifiedTypeArguments = new Type[original.getActualTypeArguments().length];
    }

    public Type[] getActualTypeArguments() {
        return this.reifiedTypeArguments;
    }

    public Type getRawType() {
        return this.original.getRawType();
    }

    public Type getOwnerType() {
        return this.original.getOwnerType();
    }

    void setReifiedTypeArguments(Type[] reifiedTypeArguments) {
        System.arraycopy(reifiedTypeArguments, 0, this.reifiedTypeArguments, 0, this.reifiedTypeArguments.length);
    }

    public String toString() {
        Type ownerType = this.getOwnerType();
        Type rawType = this.getRawType();
        Type[] actualTypeArguments = this.getActualTypeArguments();
        StringBuilder sb = new StringBuilder();
        if (ownerType != null) {
            if (ownerType instanceof Class) {
                sb.append(((Class)ownerType).getName());
            } else {
                sb.append(ownerType.toString());
            }

            sb.append(".");
            if (ownerType instanceof ParameterizedType) {
                sb.append(rawType.getTypeName().replace(((ParameterizedType)ownerType).getRawType().getTypeName() + "$", ""));
            } else {
                sb.append(rawType.getTypeName());
            }
        } else {
            sb.append(rawType.getTypeName());
        }

        if (actualTypeArguments != null && actualTypeArguments.length > 0) {
            sb.append("<");
            boolean first = true;
            Type[] var6 = actualTypeArguments;
            int var7 = actualTypeArguments.length;

            for(int var8 = 0; var8 < var7; ++var8) {
                Type t = var6[var8];
                if (!first) {
                    sb.append(", ");
                }

                sb.append(t == null ? "null" : t.getTypeName());
                first = false;
            }

            sb.append(">");
        }

        return sb.toString();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            ReifiedParameterizedType that = (ReifiedParameterizedType)o;
            return this.original.equals(that.original) && Arrays.equals(this.reifiedTypeArguments, that.reifiedTypeArguments);
        } else {
            return false;
        }
    }

    public int hashCode() {
        int result = this.original.hashCode();
        result = 31 * result + Arrays.hashCode(this.reifiedTypeArguments);
        return result;
    }
}
