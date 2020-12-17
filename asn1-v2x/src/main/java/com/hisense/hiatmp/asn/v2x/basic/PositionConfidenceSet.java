package com.hisense.hiatmp.asn.v2x.basic;

import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.Asn1Optional;
import net.gcdc.asn1.datatypes.Component;
import net.gcdc.asn1.datatypes.Sequence;

/**
 * @author zhangyong
 * @date 2020/11/4  19:13
 */
@Sequence
@Setter
@Getter
public class PositionConfidenceSet {
    @Component(0)
    PositionConfidence pos;
    @Component(1)
    @Asn1Optional
    ElevationConfidence elevation;

    public PositionConfidenceSet() {
    }

    public PositionConfidenceSet(PositionConfidence pos, ElevationConfidence elevation) {
        this.pos = pos;
        this.elevation = elevation;
    }

    public enum PositionConfidence {
        /**
         * -- Not Equipped or unavailable
         */
        unavailable(0),
        /**
         * -- 500m or about 5 * 10 ^ -3 decimal degrees
         */
        a500m(1),
        /**
         * -- 200m or about 2 * 10 ^ -3 decimal degrees
         */
        a200m(2),
        /**
         * -- 100m or about 1 * 10 ^ -3 decimal degrees
         */
        a100m(3),
        /**
         * -- 50m or about 5 * 10 ^ -4 decimal degrees
         */
        a50m(4),
        /**
         * -- 20m or about 2 * 10 ^ -4 decimal degrees
         */
        a20m(5),
        /**
         * -- 10m or about 1 * 10 ^ -4 decimal degrees
         */
        a10m(6),
        /**
         * -- 5m or about 5 * 10 ^ -5 decimal degrees
         */
        a5m(7),
        /**
         * -- 2m or about 2 * 10 ^ -5 decimal degrees
         */
        a2m(8),
        /**
         * -- 1m or about 1 * 10 ^ -5 decimal degrees
         */
        a1m(9),
        /**
         * -- 0.50m or about 5 * 10 ^ -6 decimal degrees
         */
        a50cm(10),
        /**
         * -- 0.20m or about 2 * 10 ^ -6 decimal degrees
         */
        a20cm(11),
        /**
         * -- 0.10m or about 1 * 10 ^ -6 decimal degrees
         */
        a10cm(12),
        /**
         * -- 0.05m or about 5 * 10 ^ -7 decimal degrees
         */
        a5cm(13),
        /**
         * -- 0.02m or about 2 * 10 ^ -7 decimal degrees
         */
        a2cm(14),
        /**
         * -- 0.01m or about 1 * 10 ^ -7 decimal degrees
         */
        a1cm(15);
        private final int value;

        PositionConfidence(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum ElevationConfidence {
        /**
         * -- Not Equipped or unavailable
         */
        unavailable(0),
        /**
         * -- (500 m)
         */
        elev_500_00(1),
        /**
         * -- (200 m)
         */
        elev_200_00(2),
        /**
         * -- (100 m)
         */
        elev_100_00(3),
        /**
         * -- (50 m)
         */
        elev_050_00(4),
        /**
         * -- (20 m)
         */
        elev_020_00(5),
        /**
         * -- (10 m)
         */
        elev_010_00(6),
        /**
         * -- (5 m)
         */
        elev_005_00(7),
        /**
         * -- B(2 m)
         */
        elev_002_00(8),
        /**
         * -- (1 m)
         */
        elev_001_00(9),
        /**
         * -- (50 cm)
         */
        elev_000_50(10),
        /**
         * -- (20 cm)
         */
        elev_000_20(11),
        /**
         * -- (10 cm)
         */
        elev_000_10(12),
        /**
         * -- (5 cm)
         */
        elev_000_05(13),
        /**
         * -- B(2 cm)
         */
        elev_000_02(14),
        /**
         * -- (1 cm)
         */
        elev_000_01(15);

        private final int value;

        ElevationConfidence(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
