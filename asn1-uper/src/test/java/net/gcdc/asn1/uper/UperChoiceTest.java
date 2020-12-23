package net.gcdc.asn1.uper;

import net.gcdc.asn1.datatypes.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

/**
 * @author zhangyong
 * @date 2020/11/11  14:20
 */
public class UperChoiceTest {
    @Test
    public void choiceEncodeTest() {
        UperSequenceOne one = new UperSequenceOne("one", new Number(14));
        UperSequenceTwo two = new UperSequenceTwo("two", new Number(22), new Number(0));
        UperSequenceThird third = new UperSequenceThird("third", new Number(33), new Number(44));
        final UperChoice choice = UperChoice.oneChoice(one);
        final byte[] encode = UperEncoder.encode(choice);
        Assert.assertArrayEquals(encode, new byte[]{0, -9, -18, -54, 56});
        //System.out.println(Arrays.toString(encode));
    }

    @Test
    public void choiceDecodeTest() {
        byte[] des = new byte[]{0, -9, -18, -54, 56};
        final UperChoice decode = UperEncoder.decode(des, UperChoice.class);
        UperSequenceOne one = new UperSequenceOne("one", new Number(14));
        Assert.assertEquals(decode.getOne(), one);
    }

    @Choice
    public static class UperChoice {
        UperSequenceOne one;
        UperSequenceTwo two;
        UperSequenceThird third;

        private UperChoice() {

        }

        private UperChoice(UperSequenceOne one, UperSequenceTwo two, UperSequenceThird third) {
            this.one = one;
            this.two = two;
            this.third = third;
        }

        public static UperChoice oneChoice(UperSequenceOne one) {
            return new UperChoice(one, null, null);
        }

        public static UperChoice twoChoice(UperSequenceTwo two) {
            return new UperChoice(null, two, null);
        }

        public static UperChoice thirdChoice(UperSequenceThird third) {
            return new UperChoice(null, null, third);
        }

        public UperSequenceOne getOne() {
            return one;
        }

        public UperSequenceTwo getTwo() {
            return two;
        }

        public UperSequenceThird getThird() {
            return third;
        }
    }

    @Sequence
    public static class UperSequenceOne {
        @RestrictedString(CharacterRestriction.VisibleString)
        String name;
        Number num;

        public UperSequenceOne() {
            this("", new Number(0));
        }

        public UperSequenceOne(String name, Number num) {
            this.name = name;
            this.num = num;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            UperSequenceOne that = (UperSequenceOne) o;
            return Objects.equals(name, that.name) &&
                    Objects.equals(num, that.num);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, num);
        }
    }

    @Sequence
    public static class UperSequenceTwo {
        @RestrictedString(CharacterRestriction.VisibleString)
        String name;
        Number num;
        @Asn1Optional
        Number height;

        public UperSequenceTwo() {
            this("", new Number(0), null);
        }

        public UperSequenceTwo(String name, Number num, Number height) {
            this.name = name;
            this.num = num;
            this.height = height;
        }
    }

    @Sequence
    public static class UperSequenceThird {
        @RestrictedString(CharacterRestriction.VisibleString)
        String name;
        Number num;
        @Asn1Optional
        Number length;

        public UperSequenceThird() {
            this("", new Number(0), null);
        }

        public UperSequenceThird(String name, Number num, Number length) {
            this.name = name;
            this.num = num;
            this.length = length;
        }
    }

    @IntRange(minValue = 0, maxValue = 127)
    public static class Number extends Asn1Integer {
        public Number() {
            this(0);
        }

        public Number(int value) {
            super(value);
        }

    }
}
