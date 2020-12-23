package net.gcdc.asn1.datatypes;

import java.lang.annotation.*;

/**
 * Indicates that the field is OPTIONAL in ASN.1. Implemented as null. Equivalent to {@code @Nullable}.
 * <p>
 * Using {@code Optional<T>} would require Manifests to capture generics (like in Gson).
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Asn1Optional {

}
