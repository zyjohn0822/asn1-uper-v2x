package com.hisense.hiatmp.asn.v2x.MsgFrame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author zhangyong
 * @date 2020/12/17  10:48
 */
public class VehicleSafetyExtensionsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void per_decode() throws IOException {
        /*
        {
        "events":"0001110001111",
        "pathHistory":{"initialPosition":{"utcTime":null,"pos":{"lat":283433333,"long_":1202323232,"elevation":null},"heading":null,"transmission":null,"speed":null,"posAccuracy":null,"posConficence":null,"timeConfidence":null,"motionCfd":null},"currGNSSstatus":11110000,"crumbData":[{"llvOffset":{"offsetLL":{"choiceID":0,"position_LL1":{"lon":22,"lat":21},"position_LL2":null,"position_LL3":null,"position_LL4":null,"position_LL5":null,"position_LL6":null,"position_LatLon":null},"offsetV":{"choiceID":0,"offset1":15,"offset2":null,"offset3":null,"offset4":null,"offset5":null,"offset6":null,"elevation":null}},"timeOffset":633,"speed":500,"posAccuracy":null,"heading":20}]},
        "pathPrediction":{"radiusOfCurve":3276,"confidence":100},
        "lights":"000111000"}

         */
        byte[] decodeBytes = new byte[]{120, 113, -20, 0, -115, 19, -124, -21, 101,
                -25, -94, 63, -32, 5, -120, 22, -127, 81, 60, 9, -32, 62, -126, -120, -52, -74, 64, -32};
        final VehicleSafetyExtensions vehicleSafetyExtensions = VehicleSafetyExtensions.per_decode(false, new ByteArrayInputStream(decodeBytes));
        System.out.println(vehicleSafetyExtensions);
    }
}