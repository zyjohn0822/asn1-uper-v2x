package net.gcdc.asn1.uper;

import net.gcdc.asn1.datatypes.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Example of encoding the following definitions:
 * <pre>
 * ON-PDU DEFINITIONS AUTOMATIC TAGS ::=
 * BEGIN
 * IMPORTS
 * FOO
 * FROM ON-API;
 * Packet ::= SEQUENCE {
 * foo FOO
 * }
 * END
 *
 * ON-API DEFINITIONS AUTOMATIC TAGS ::=
 * BEGIN
 * FOO ::= SEQUENCE {
 * bar BAR,
 * baz BAZ
 * }
 * BAR ::= OCTET STRING (SIZE(3))
 * BAZ ::= BIT STRING (SIZE(8))
 * END
 * </pre>
 */
public class UperEncoderQuestion1Test {
    private final static Logger logger = LoggerFactory.getLogger(UperEncoderQuestion1Test.class);

    @Test
    public void QuestionTest() throws IllegalArgumentException, IllegalAccessException {
        Object pdu =
                new Foo(
                        new Bar((byte) 0xff, (byte) 0xff, (byte) 0xff),
                        new Baz(BitSet.valueOf(new byte[]{(byte) 0xff}))
                );
        byte[] encoded = UperEncoder.encode(pdu);
        logger.debug("data hex: {}", UperEncoder.hexStringFromBytes(encoded));
        assertEquals("FFFFFFFF",
                UperEncoder.hexStringFromBytes(encoded));
    }

    @Sequence
    public static class Foo {
        Bar bar;
        Baz baz;

        public Foo(Bar bar, Baz baz) {
            this.bar = bar;
            this.baz = baz;
        }
    }

    @FixedSize(3)
    public static class Bar extends Asn1SequenceOf<Byte> {
        // Two constructors -- choose any, or add more.
        public Bar(Byte... coll) {
            this(Arrays.asList(coll));
        }

        public Bar(Collection<Byte> coll) {
            super(coll);
        }
    }

    @Bitstring
    @FixedSize(8)
    public static class Baz extends Asn1VarSizeBitstring {

        // Two constructors -- choose any.
        public Baz(BitSet bitset) {
            super(bitset);
        }

        public Baz(Collection<Boolean> coll) {
            super(coll);
        }
    }
}
