/**
 * Annotations to create Java classes that correspond to ASN.1 specifications.
 * <p>
 * Some annotations (e.g. {@link net.gcdc.asn1.datatypes.SizeRange}, {@link net.gcdc.asn1.datatypes.FixedSize}, {@link net.gcdc.asn1.datatypes.IntRange},
 * {@link net.gcdc.asn1.datatypes.RestrictedString}) are Type-only annotations and sometime require creating extra classes,
 * they can be extended to work as Field annotations too, but this will require modifications to the
 * Encoder.
 */
package net.gcdc.asn1.datatypes;
