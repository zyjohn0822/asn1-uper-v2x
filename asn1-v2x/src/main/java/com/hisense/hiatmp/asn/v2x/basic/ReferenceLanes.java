package com.hisense.hiatmp.asn.v2x.basic;

import net.gcdc.asn1.datatypes.Asn1SequenceOf;
import net.gcdc.asn1.datatypes.SizeRange;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ReferenceLanes ::= BIT STRING {<br/>
 * -- With bits as defined:<br/>
 * reserved(0),<br/>
 * lane1(1),<br/>
 * lane2(2),<br/>
 * lane3(3),<br/>
 * lane4(4),<br/>
 * lane5(5),<br/>
 * lane6(6),<br/>
 * lane7(7),<br/>
 * lane8(8),<br/>
 * lane9(9),<br/>
 * lane10(10),<br/>
 * lane11(11),<br/>
 * lane12(12),<br/>
 * lane13(13),<br/>
 * lane14(14),<br/>
 * lane15(15)<br/>
 * } (SIZE (16))<br/>
 * -- Set bit to 1 if the related lane is effective<br/>
 * -- Support maximum 15 lanes<br/>
 *
 * @author zhangyong
 * @date 2020/12/23  11:47
 */
@SizeRange(minValue = 16, maxValue = 16)
public class ReferenceLanes extends Asn1SequenceOf<Boolean> {
    public ReferenceLanes() {
        this(new ArrayList<Boolean>());
    }

    public ReferenceLanes(Collection<Boolean> coll) {
        super(coll);
    }

    public boolean getOrFalse(int i) {
        return (i < size()) ? get(i) : false;
    }

    public boolean reserved() {
        return getOrFalse(0);
    }

    public boolean lane1() {
        return getOrFalse(0);
    }

    public boolean lane2() {
        return getOrFalse(0);
    }

    public boolean lane3() {
        return getOrFalse(0);
    }

    public boolean lane4() {
        return getOrFalse(0);
    }

    public boolean lane5() {
        return getOrFalse(0);
    }

    public boolean lane6() {
        return getOrFalse(0);
    }

    public boolean lane7() {
        return getOrFalse(0);
    }

    public boolean lane8() {
        return getOrFalse(0);
    }

    public boolean lane9() {
        return getOrFalse(0);
    }

    public boolean lane10() {
        return getOrFalse(0);
    }

    public boolean lane11() {
        return getOrFalse(0);
    }

    public boolean lane12() {
        return getOrFalse(0);
    }

    public boolean lane13() {
        return getOrFalse(0);
    }

    public boolean lane14() {
        return getOrFalse(0);
    }

    public boolean lane15() {
        return getOrFalse(0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\"");
        for (boolean s : bakingList) {
            if (s) {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }
        sb.append("\"");
        return sb.toString();
    }
}
