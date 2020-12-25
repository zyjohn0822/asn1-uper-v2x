package com.hisense.hiatmp.asn.v2x.basic;

import com.hisense.hiatmp.asn.v2x.basic.DDateTime.TimeMark;
import com.hisense.hiatmp.asn.v2x.basic.PathPrediction.Confidence;
import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.Asn1Optional;
import net.gcdc.asn1.datatypes.Component;
import net.gcdc.asn1.datatypes.Sequence;

/**
 * UTCTiming ::= SEQUENCE {<br/>
 * startUTCTime TimeMark,<br/>
 * -- If already started, the value represents <br/>
 * -- the time stamp when this phase state started.<br/>
 * -- If not, the value represents<br/>
 * -- the time stamp when this phase state starts.<br/>
 * minEndUTCTime TimeMark OPTIONAL,<br/>
 * -- The time stamp when this state 1st ends in shortest time<br/>
 * maxEndUTCTime TimeMark OPTIONAL,<br/>
 * -- The time stamp when this state 1st ends in longest time<br/>
 * likelyEndUTCTime TimeMark,<br/>
 * -- The time stamp when this state 1st ends in best predicted time<br/>
 * timeConfidence Confidence OPTIONAL,<br/>
 * -- Confidence of likelyEndUTCTime<br/>
 * nextStartUTCTime TimeMark OPTIONAL,<br/>
 * -- A rough estimate of UTC time stamp when this phase state may next occur again<br/>
 * -- used to support various ECO driving power management needs.<br/>
 * -- If already started, this value is recommended to be delivered.<br/>
 * nextEndUTCTime TimeMark OPTIONAL<br/>
 * -- A rough estimate of UTC time stamp when this phase state ends again<br/>
 * -- used to support various ECO driving power management needs.<br/>
 * -- If already started, this value is recommended to be delivered.<br/>
 * }<br/>
 *
 * @author zhangyong
 * @date 2020/12/21  14:42
 */
@Setter
@Getter
@Sequence
public class UTCTiming {
    @Component(0)
    public TimeMark startUTCTime;
    @Component(1)
    @Asn1Optional
    public TimeMark minEndUTCTime;
    @Component(2)
    @Asn1Optional
    public TimeMark maxEndUTCTime;
    @Component(3)
    public TimeMark likelyEndUTCTime;
    @Component(4)
    @Asn1Optional
    public Confidence timeConfidence;
    @Component(5)
    @Asn1Optional
    public TimeMark nextStartUTCTime;
    @Component(6)
    @Asn1Optional
    public TimeMark nextEndUTCTime;

    public UTCTiming() {
    }

    public UTCTiming(TimeMark startUTCTime, TimeMark likelyEndUTCTime) {
        this.startUTCTime = startUTCTime;
        this.likelyEndUTCTime = likelyEndUTCTime;
    }

    public UTCTiming(
            TimeMark startUTCTime,
            TimeMark minEndUTCTime,
            TimeMark maxEndUTCTime,
            TimeMark likelyEndUTCTime,
            Confidence timeConfidence,
            TimeMark nextStartUTCTime,
            TimeMark nextEndUTCTime) {
        this.startUTCTime = startUTCTime;
        this.minEndUTCTime = minEndUTCTime;
        this.maxEndUTCTime = maxEndUTCTime;
        this.likelyEndUTCTime = likelyEndUTCTime;
        this.timeConfidence = timeConfidence;
        this.nextStartUTCTime = nextStartUTCTime;
        this.nextEndUTCTime = nextEndUTCTime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"startUTCTime\":")
                .append(startUTCTime);
        sb.append(",\"minEndUTCTime\":")
                .append(minEndUTCTime);
        sb.append(",\"maxEndUTCTime\":")
                .append(maxEndUTCTime);
        sb.append(",\"likelyEndUTCTime\":")
                .append(likelyEndUTCTime);
        sb.append(",\"timeConfidence\":")
                .append(timeConfidence);
        sb.append(",\"nextStartUTCTime\":")
                .append(nextStartUTCTime);
        sb.append(",\"nextEndUTCTime\":")
                .append(nextEndUTCTime);
        sb.append('}');
        return sb.toString();
    }
}
