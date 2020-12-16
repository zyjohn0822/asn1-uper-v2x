
package org.v2x;

import org.bn.CoderFactory;
import org.bn.annotations.ASN1Choice;
import org.bn.annotations.ASN1Element;
import org.bn.annotations.ASN1PreparedElement;
import org.bn.coders.IASN1PreparedElement;
import org.bn.coders.IASN1PreparedElementData;
import org.v2x.bsm.BasicSafetyMessage;
import org.v2x.map.MapData;
import org.v2x.rsi.RoadSideInformation;
import org.v2x.rsm.RoadsideSafetyMessage;
import org.v2x.spat.SPAT;


/**
 * @author zhangyong
 */
@ASN1PreparedElement
@ASN1Choice(name = "MessageFrame")
public class MessageFrame implements IASN1PreparedElement {

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

    public boolean isBsmFrameSelected() {
        return this.bsmFrame != null;
    }

    private void setBsmFrame(BasicSafetyMessage value) {
        this.bsmFrame = value;
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

    public boolean isMapFrameSelected() {
        return this.mapFrame != null;
    }

    private void setMapFrame(MapData value) {
        this.mapFrame = value;
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

    public boolean isRsmFrameSelected() {
        return this.rsmFrame != null;
    }

    private void setRsmFrame(RoadsideSafetyMessage value) {
        this.rsmFrame = value;
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

    public boolean isSpatFrameSelected() {
        return this.spatFrame != null;
    }

    private void setSpatFrame(SPAT value) {
        this.spatFrame = value;
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

    public boolean isRsiFrameSelected() {
        return this.rsiFrame != null;
    }

    private void setRsiFrame(RoadSideInformation value) {
        this.rsiFrame = value;
    }


    public void selectRsiFrame(RoadSideInformation value) {
        this.rsiFrame = value;

        setBsmFrame(null);

        setMapFrame(null);

        setRsmFrame(null);

        setSpatFrame(null);

    }


    public void initWithDefaults() {
    }

    private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(MessageFrame.class);

    public IASN1PreparedElementData getPreparedData() {
        return preparedData;
    }


}
            