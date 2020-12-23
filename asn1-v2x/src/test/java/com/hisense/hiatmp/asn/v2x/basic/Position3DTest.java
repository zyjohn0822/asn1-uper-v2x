package com.hisense.hiatmp.asn.v2x.basic;

import com.hisense.hiatmp.asn.v2x.basic.Position3D.Elevation;
import com.hisense.hiatmp.asn.v2x.basic.Position3D.Latitude;
import com.hisense.hiatmp.asn.v2x.basic.Position3D.Longitude;
import net.gcdc.asn1.uper.UperEncoder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhangyong
 * @date 2020/12/15  16:36
 */
public class Position3DTest {
    Position3D position3D;

    @Before
    public void setUp() throws Exception {
        Latitude lat = new Latitude(281260343);
        Longitude lon = new Longitude(1128799971);
        Elevation elevation = new Elevation(1233);
        position3D = new Position3D(lat, lon, elevation);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void encode() throws Exception {
        final byte[] encode = UperEncoder.encode(position3D);
        System.out.println(Arrays.toString(encode));
    }

    @Test
    public void decode() throws Exception {

    }
}