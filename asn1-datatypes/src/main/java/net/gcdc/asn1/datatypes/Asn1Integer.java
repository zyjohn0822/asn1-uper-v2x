package net.gcdc.asn1.datatypes;

import java.util.Objects;

/**
 * @author zhangyong
 */
public abstract class Asn1Integer {

    public long value;

    public Asn1Integer() {
    }

    public Asn1Integer(long value) {
        this.value = value;
    }

    public long value() {
        return value;
    }

    @Override
    public String toString() {
        return "" + value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Asn1Integer that = (Asn1Integer) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
