package org.v2x;

import org.bn.annotations.ASN1Choice;
import org.bn.annotations.ASN1Element;
import org.v2x.bsm.BasicSafetyMessage;
import org.v2x.map.MapData;
import org.v2x.rsi.RoadSideInformation;
import org.v2x.rsm.RoadsideSafetyMessage;
import org.v2x.spat.SPAT;


/**
 * @author zhangyong
 */
@ASN1Choice(name = "MessageFrame")
public class MessageFrame {

    @ASN1Element(name = "bsmFrame", isOptional = false, hasTag = false, hasDefaultValue = false)
    private BasicSafetyMessage bsmFrame = null;

    @ASN1Element(name = "mapFrame", isOptional = false, hasTag = false, hasDefaultValue = false)
    private MapData mapFrame = null;

    @ASN1Element(name = "rsmFrame", isOptional = false, hasTag = false, hasDefaultValue = false)
    private RoadsideSafetyMessage rsmFrame = null;

    @ASN1Element(name = "spatFrame", isOptional = false, hasTag = false, hasDefaultValue = false)
    private SPAT spatFrame = null;

    @ASN1Element(name = "rsiFrame", isOptional = false, hasTag = false, hasDefaultValue = false)
    private RoadSideInformation rsiFrame = null;


    public BasicSafetyMessage getBsmFrame() {
        return this.bsmFrame;
    }

    private void setBsmFrame(BasicSafetyMessage value) {
        this.bsmFrame = value;
    }

    public boolean isBsmFrameSelected() {
        return this.bsmFrame != null;
    }

    public void selectBsmFrame(BasicSafetyMessage value) {
        this.bsmFrame = value;

        setMapFrame(null);

        setRsmFrame(null);

        setSpatFrame(null);

        setRsiFrame(null);

    }


    public MapData getMapFrame() {
        return this.mapFrame;
    }

    private void setMapFrame(MapData value) {
        this.mapFrame = value;
    }

    public boolean isMapFrameSelected() {
        return this.mapFrame != null;
    }

    public void selectMapFrame(MapData value) {
        this.mapFrame = value;

        setBsmFrame(null);

        setRsmFrame(null);

        setSpatFrame(null);

        setRsiFrame(null);

    }


    public RoadsideSafetyMessage getRsmFrame() {
        return this.rsmFrame;
    }

    private void setRsmFrame(RoadsideSafetyMessage value) {
        this.rsmFrame = value;
    }

    public boolean isRsmFrameSelected() {
        return this.rsmFrame != null;
    }

    public void selectRsmFrame(RoadsideSafetyMessage value) {
        this.rsmFrame = value;

        setBsmFrame(null);

        setMapFrame(null);

        setSpatFrame(null);

        setRsiFrame(null);

    }


    public SPAT getSpatFrame() {
        return this.spatFrame;
    }

    private void setSpatFrame(SPAT value) {
        this.spatFrame = value;
    }

    public boolean isSpatFrameSelected() {
        return this.spatFrame != null;
    }

    public void selectSpatFrame(SPAT value) {
        this.spatFrame = value;

        setBsmFrame(null);

        setMapFrame(null);

        setRsmFrame(null);

        setRsiFrame(null);

    }


    public RoadSideInformation getRsiFrame() {
        return this.rsiFrame;
    }

    private void setRsiFrame(RoadSideInformation value) {
        this.rsiFrame = value;
    }

    public boolean isRsiFrameSelected() {
        return this.rsiFrame != null;
    }

    public void selectRsiFrame(RoadSideInformation value) {
        this.rsiFrame = value;

        setBsmFrame(null);

        setMapFrame(null);

        setRsmFrame(null);

        setSpatFrame(null);

    }


}
            