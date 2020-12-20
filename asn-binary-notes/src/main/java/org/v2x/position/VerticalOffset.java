package org.v2x.position;


import org.bn.annotations.ASN1Choice;
import org.bn.annotations.ASN1Element;


@ASN1Choice(name = "VerticalOffset")
public class VerticalOffset {

    @ASN1Element(name = "offset1", isOptional = false, hasTag = false, hasDefaultValue = false)
    private VertOffset_B07 offset1 = null;

    @ASN1Element(name = "offset2", isOptional = false, hasTag = false, hasDefaultValue = false)
    private VertOffset_B08 offset2 = null;

    @ASN1Element(name = "offset3", isOptional = false, hasTag = false, hasDefaultValue = false)
    private VertOffset_B09 offset3 = null;

    @ASN1Element(name = "offset4", isOptional = false, hasTag = false, hasDefaultValue = false)
    private VertOffset_B10 offset4 = null;

    @ASN1Element(name = "offset5", isOptional = false, hasTag = false, hasDefaultValue = false)
    private VertOffset_B11 offset5 = null;

    @ASN1Element(name = "offset6", isOptional = false, hasTag = false, hasDefaultValue = false)
    private VertOffset_B12 offset6 = null;

    @ASN1Element(name = "elevation", isOptional = false, hasTag = false, hasDefaultValue = false)
    private Elevation elevation = null;


    public VertOffset_B07 getOffset1() {
        return this.offset1;
    }

    private void setOffset1(VertOffset_B07 value) {
        this.offset1 = value;
    }

    public boolean isOffset1Selected() {
        return this.offset1 != null;
    }

    public void selectOffset1(VertOffset_B07 value) {
        this.offset1 = value;

        setOffset2(null);

        setOffset3(null);

        setOffset4(null);

        setOffset5(null);

        setOffset6(null);

        setElevation(null);

    }


    public VertOffset_B08 getOffset2() {
        return this.offset2;
    }

    private void setOffset2(VertOffset_B08 value) {
        this.offset2 = value;
    }

    public boolean isOffset2Selected() {
        return this.offset2 != null;
    }

    public void selectOffset2(VertOffset_B08 value) {
        this.offset2 = value;

        setOffset1(null);

        setOffset3(null);

        setOffset4(null);

        setOffset5(null);

        setOffset6(null);

        setElevation(null);

    }


    public VertOffset_B09 getOffset3() {
        return this.offset3;
    }

    private void setOffset3(VertOffset_B09 value) {
        this.offset3 = value;
    }

    public boolean isOffset3Selected() {
        return this.offset3 != null;
    }

    public void selectOffset3(VertOffset_B09 value) {
        this.offset3 = value;

        setOffset1(null);

        setOffset2(null);

        setOffset4(null);

        setOffset5(null);

        setOffset6(null);

        setElevation(null);

    }


    public VertOffset_B10 getOffset4() {
        return this.offset4;
    }

    private void setOffset4(VertOffset_B10 value) {
        this.offset4 = value;
    }

    public boolean isOffset4Selected() {
        return this.offset4 != null;
    }

    public void selectOffset4(VertOffset_B10 value) {
        this.offset4 = value;

        setOffset1(null);

        setOffset2(null);

        setOffset3(null);

        setOffset5(null);

        setOffset6(null);

        setElevation(null);

    }


    public VertOffset_B11 getOffset5() {
        return this.offset5;
    }

    private void setOffset5(VertOffset_B11 value) {
        this.offset5 = value;
    }

    public boolean isOffset5Selected() {
        return this.offset5 != null;
    }

    public void selectOffset5(VertOffset_B11 value) {
        this.offset5 = value;

        setOffset1(null);

        setOffset2(null);

        setOffset3(null);

        setOffset4(null);

        setOffset6(null);

        setElevation(null);

    }


    public VertOffset_B12 getOffset6() {
        return this.offset6;
    }

    private void setOffset6(VertOffset_B12 value) {
        this.offset6 = value;
    }

    public boolean isOffset6Selected() {
        return this.offset6 != null;
    }

    public void selectOffset6(VertOffset_B12 value) {
        this.offset6 = value;

        setOffset1(null);

        setOffset2(null);

        setOffset3(null);

        setOffset4(null);

        setOffset5(null);

        setElevation(null);

    }


    public Elevation getElevation() {
        return this.elevation;
    }

    private void setElevation(Elevation value) {
        this.elevation = value;
    }

    public boolean isElevationSelected() {
        return this.elevation != null;
    }

    public void selectElevation(Elevation value) {
        this.elevation = value;

        setOffset1(null);

        setOffset2(null);

        setOffset3(null);

        setOffset4(null);

        setOffset5(null);

        setOffset6(null);

    }


}
            