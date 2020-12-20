package org.v2x.map.node;


import org.bn.annotations.ASN1BoxedType;
import org.bn.annotations.ASN1String;
import org.bn.annotations.constraints.ASN1ValueRangeConstraint;
import org.bn.coders.UniversalTag;


/**
 * @author zhangyong
 */
@ASN1BoxedType(name = "DescriptiveName")
public class DescriptiveName {

    @ASN1String(name = "DescriptiveName",
            stringType = UniversalTag.IA5String, isUCS = false)
    @ASN1ValueRangeConstraint(
            min = 1L,
            max = 63L
    )

    private String value;

    public DescriptiveName() {
    }

    public DescriptiveName(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }


}
            