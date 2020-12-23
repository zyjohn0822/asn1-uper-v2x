package com.hisense.hiatmp.asn.v2x.basic;

import net.gcdc.asn1.uper.UperEncoder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangyong
 * @date 2020/12/15  16:52
 */
public class VehicleSafetyExtensionsTest {
    VehicleSafetyExtensions vehicleSafetyExtensions;
    VehicleEventFlags vehicleEventFlags;
    PathHistory pathHistory;
    PathPrediction pathPrediction;
    ExteriorLights exteriorLights;

    @Before
    public void setUp() throws Exception {
        final List<Boolean> eventFlags = Arrays.asList(false, false, false, true, true, true, false, false, false, true, true, true, true);
        vehicleEventFlags = new VehicleEventFlags(eventFlags);
        //
        Position3D position3D = new Position3D(
                new Position3D.Latitude(283433333),
                new Position3D.Longitude(1202323232)
        );
        FullPositionVector fullPositionVector = new FullPositionVector(position3D);
        //---------------------------------------------------------------------
        List<Boolean> gs = Arrays.asList(true, true, true, true, false, false, false, false);
        //---------------------------------------------------------------------
        GNSSstatus gnsSstatus = new GNSSstatus(gs);
        //---------------------------------------------------------------------
        List<PathHistoryPoint> pathHistoryPoints = new ArrayList<>();
        //positionOffsetLL
        PositionOffsetLL.OffsetLLB12 offsetLLB12 = new PositionOffsetLL.OffsetLLB12(22);
        PositionOffsetLL.OffsetLLB12 offsetLLB121 = new PositionOffsetLL.OffsetLLB12(21);
        final PositionOffsetLL.PositionLL24B positionLL24B = new PositionOffsetLL.PositionLL24B(offsetLLB12,
                offsetLLB121);
        PositionOffsetLL positionOffsetLL = PositionOffsetLL.positionLL1(positionLL24B);
        //verticalOffset
        VerticalOffset.VertOffset_B07 vertOffsetB07 = new VerticalOffset.VertOffset_B07(15);
        VerticalOffset verticalOffset = VerticalOffset.offset1(vertOffsetB07);

        //-----------
        PositionOffsetLLV positionOffsetLLV = new PositionOffsetLLV(positionOffsetLL, verticalOffset);

        pathHistoryPoints.add(new PathHistoryPoint(positionOffsetLLV,
                new DDateTime.TimeOffset(633),
                new Speed(500), null, new CoarseHeading(20)));
        PathHistory.PathHistoryPointList pathHistoryPointList = new PathHistory.PathHistoryPointList(pathHistoryPoints);

        pathHistory = new PathHistory(fullPositionVector, gnsSstatus, pathHistoryPointList);
        //
        pathPrediction = new PathPrediction(new PathPrediction.RadiusOfCurvature(3276),
                new PathPrediction.Confidence(100));
        //
        final List<Boolean> booleans = Arrays.asList(false, false, false, true, true, true, false, false, false);
        exteriorLights = new ExteriorLights(booleans);
        vehicleSafetyExtensions = new VehicleSafetyExtensions(
                vehicleEventFlags,
                pathHistory,
                pathPrediction,
                exteriorLights);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void encode() throws Exception {
        final byte[] encode = UperEncoder.encode(vehicleSafetyExtensions);
        System.out.println(Arrays.toString(encode));
    }

    @Test
    public void decode() throws Exception {
    }
}