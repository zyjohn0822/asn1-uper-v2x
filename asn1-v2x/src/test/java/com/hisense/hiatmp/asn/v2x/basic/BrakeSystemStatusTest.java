package com.hisense.hiatmp.asn.v2x.basic;

import net.gcdc.asn1.uper.UperEncoder;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.hisense.hiatmp.asn.v2x.basic.BrakeSystemStatus.*;

/**
 * @author zhangyong
 * @date 2020/12/15  16:31
 */
public class BrakeSystemStatusTest {
    @Test
    public void encode() throws Exception {
        BrakePedalStatus brakePedalStatus = BrakePedalStatus.off;
        //
        List<Boolean> bs = Arrays.asList(true, true, true, false, false);
        BrakeAppliedStatus brakeAppliedStatus = new BrakeAppliedStatus(bs);
        //
        TractionControlStatus tractionControlStatus = TractionControlStatus.on;
        //
        AntiLockBrakeStatus antiLockBrakeStatus = AntiLockBrakeStatus.on;
        //
        StabilityControlStatus stabilityControlStatus = StabilityControlStatus.off;
        //
        BrakeBoostApplied brakeBoostApplied = BrakeBoostApplied.off;
        //
        AuxiliaryBrakeStatus auxiliaryBrakeStatus = AuxiliaryBrakeStatus.off;
        BrakeSystemStatus brakeSystemStatus = new BrakeSystemStatus(brakePedalStatus,
                brakeAppliedStatus,
                tractionControlStatus,
                antiLockBrakeStatus,
                stabilityControlStatus,
                brakeBoostApplied,
                auxiliaryBrakeStatus);
        final byte[] encode = UperEncoder.encode(brakeSystemStatus);
        System.out.println(Arrays.toString(encode));
    }

    @Test
    public void decode() throws Exception {
    }
}