package org.v2x.position;


import org.bn.annotations.ASN1Choice;
import org.bn.annotations.ASN1Element;

/**
 * @author zhangyong
 */
@ASN1Choice(name = "PositionOffsetLL")
public class PositionOffsetLL {

    @ASN1Element(name = "position-LL1", isOptional = false, hasTag = false, hasDefaultValue = false)
    private Position_LL_24B position_LL1 = null;

    @ASN1Element(name = "position-LL2", isOptional = false, hasTag = false, hasDefaultValue = false)
    private Position_LL_28B position_LL2 = null;

    @ASN1Element(name = "position-LL3", isOptional = false, hasTag = false, hasDefaultValue = false)
    private Position_LL_32B position_LL3 = null;

    @ASN1Element(name = "position-LL4", isOptional = false, hasTag = false, hasDefaultValue = false)
    private Position_LL_36B position_LL4 = null;

    @ASN1Element(name = "position-LL5", isOptional = false, hasTag = false, hasDefaultValue = false)
    private Position_LL_44B position_LL5 = null;

    @ASN1Element(name = "position-LL6", isOptional = false, hasTag = false, hasDefaultValue = false)
    private Position_LL_48B position_LL6 = null;

    @ASN1Element(name = "position-LatLon", isOptional = false, hasTag = false, hasDefaultValue = false)
    private Position_LLmD_64b position_LatLon = null;


    public Position_LL_24B getPosition_LL1() {
        return this.position_LL1;
    }

    private void setPosition_LL1(Position_LL_24B value) {
        this.position_LL1 = value;
    }

    public boolean isPosition_LL1Selected() {
        return this.position_LL1 != null;
    }

    public void selectPosition_LL1(Position_LL_24B value) {
        this.position_LL1 = value;

        setPosition_LL2(null);

        setPosition_LL3(null);

        setPosition_LL4(null);

        setPosition_LL5(null);

        setPosition_LL6(null);

        setPosition_LatLon(null);

    }


    public Position_LL_28B getPosition_LL2() {
        return this.position_LL2;
    }

    private void setPosition_LL2(Position_LL_28B value) {
        this.position_LL2 = value;
    }

    public boolean isPosition_LL2Selected() {
        return this.position_LL2 != null;
    }

    public void selectPosition_LL2(Position_LL_28B value) {
        this.position_LL2 = value;

        setPosition_LL1(null);

        setPosition_LL3(null);

        setPosition_LL4(null);

        setPosition_LL5(null);

        setPosition_LL6(null);

        setPosition_LatLon(null);

    }


    public Position_LL_32B getPosition_LL3() {
        return this.position_LL3;
    }

    private void setPosition_LL3(Position_LL_32B value) {
        this.position_LL3 = value;
    }

    public boolean isPosition_LL3Selected() {
        return this.position_LL3 != null;
    }

    public void selectPosition_LL3(Position_LL_32B value) {
        this.position_LL3 = value;

        setPosition_LL1(null);

        setPosition_LL2(null);

        setPosition_LL4(null);

        setPosition_LL5(null);

        setPosition_LL6(null);

        setPosition_LatLon(null);

    }


    public Position_LL_36B getPosition_LL4() {
        return this.position_LL4;
    }

    private void setPosition_LL4(Position_LL_36B value) {
        this.position_LL4 = value;
    }

    public boolean isPosition_LL4Selected() {
        return this.position_LL4 != null;
    }

    public void selectPosition_LL4(Position_LL_36B value) {
        this.position_LL4 = value;

        setPosition_LL1(null);

        setPosition_LL2(null);

        setPosition_LL3(null);

        setPosition_LL5(null);

        setPosition_LL6(null);

        setPosition_LatLon(null);

    }


    public Position_LL_44B getPosition_LL5() {
        return this.position_LL5;
    }

    private void setPosition_LL5(Position_LL_44B value) {
        this.position_LL5 = value;
    }

    public boolean isPosition_LL5Selected() {
        return this.position_LL5 != null;
    }

    public void selectPosition_LL5(Position_LL_44B value) {
        this.position_LL5 = value;

        setPosition_LL1(null);

        setPosition_LL2(null);

        setPosition_LL3(null);

        setPosition_LL4(null);

        setPosition_LL6(null);

        setPosition_LatLon(null);

    }


    public Position_LL_48B getPosition_LL6() {
        return this.position_LL6;
    }

    private void setPosition_LL6(Position_LL_48B value) {
        this.position_LL6 = value;
    }

    public boolean isPosition_LL6Selected() {
        return this.position_LL6 != null;
    }

    public void selectPosition_LL6(Position_LL_48B value) {
        this.position_LL6 = value;

        setPosition_LL1(null);

        setPosition_LL2(null);

        setPosition_LL3(null);

        setPosition_LL4(null);

        setPosition_LL5(null);

        setPosition_LatLon(null);

    }


    public Position_LLmD_64b getPosition_LatLon() {
        return this.position_LatLon;
    }

    private void setPosition_LatLon(Position_LLmD_64b value) {
        this.position_LatLon = value;
    }

    public boolean isPosition_LatLonSelected() {
        return this.position_LatLon != null;
    }

    public void selectPosition_LatLon(Position_LLmD_64b value) {
        this.position_LatLon = value;

        setPosition_LL1(null);

        setPosition_LL2(null);

        setPosition_LL3(null);

        setPosition_LL4(null);

        setPosition_LL5(null);

        setPosition_LL6(null);

    }

}
            