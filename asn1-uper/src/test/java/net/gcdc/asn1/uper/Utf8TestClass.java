package net.gcdc.asn1.uper;

import net.gcdc.asn1.datatypes.*;

/**
 * A class for testing UTF8String.
 * <pre>
 * TestSeq ::= SEQUENCE {
 * companyName     UTF8String (SIZE (1..200))}
 * </pre>
 */
@Sequence
public class Utf8TestClass {
    CompanyName companyName;

    public Utf8TestClass() {
        this(new CompanyName());
    }

    public Utf8TestClass(CompanyName companyName) {
        this.companyName = companyName;
    }

    @Asn1AnonymousType
    @SizeRange(minValue = 1, maxValue = 1000)
    @RestrictedString(CharacterRestriction.UTF8String)
    public static class CompanyName extends Asn1String {
        public CompanyName() {
            this("");
        }

        public CompanyName(String value) {
            super(value);
        }
    }
}