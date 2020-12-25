package com.hisense.hiatmp.asn.v2x.basic;

import com.hisense.hiatmp.asn.v2x.basic.DDateTime.TimeMark;
import com.hisense.hiatmp.asn.v2x.basic.PathPrediction.Confidence;
import lombok.Getter;
import lombok.Setter;
import net.gcdc.asn1.datatypes.Asn1Optional;
import net.gcdc.asn1.datatypes.Sequence;

/**
 * TimeCountingDown ::= SEQUENCE {<br/>
 * startTime TimeMark,<br/>
 * -- When this phase state started,<br/>
 * -- if already started, the value is 0<br/>
 * minEndTime TimeMark OPTIONAL,<br/>
 * -- Expected shortest end time<br/>
 * -- the value is the min left time from now<br/>
 * maxEndTime TimeMark OPTIONAL,<br/>
 * -- Expected longest end time<br/>
 * -- the value is the max left time from now<br/>
 * likelyEndTime TimeMark,<br/>
 * -- Best predicted value based on other data<br/>
 * -- the value is the likely left time from now<br/>
 * timeConfidence Confidence OPTIONAL,<br/>
 * -- Confidence of likelyTime<br/>
 * nextStartTime TimeMark OPTIONAL,<br/>
 * -- A rough estimate of time from now when this phase state may next occur again<br/>
 * -- used to support various ECO driving power management needs.<br/>
 * -- If already started, this value is recommended to be delivered.<br/>
 * nextDuration TimeMark OPTIONAL<br/>
 * -- A rough estimate of the time length of this phase state<br/>
 * -- when it may next occur again.<br/>
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
public class TimeCountingDown {
    public TimeMark startTime;
    @Asn1Optional
    public TimeMark minEndTime;
    @Asn1Optional
    public TimeMark maxEndTime;
    public TimeMark likelyEndTime;
    @Asn1Optional
    public Confidence timeConfidence;
    @Asn1Optional
    public TimeMark nextStartTime;
    @Asn1Optional
    TimeMark nextDuration;

    public TimeCountingDown() {
    }

    public TimeCountingDown(TimeMark startTime, TimeMark likelyEndTime) {
        this.startTime = startTime;
        this.likelyEndTime = likelyEndTime;
    }

    public TimeCountingDown(TimeMark startTime,
                            TimeMark minEndTime,
                            TimeMark maxEndTime,
                            TimeMark likelyEndTime,
                            Confidence timeConfidence,
                            TimeMark nextStartTime,
                            TimeMark nextDuration) {
        this.startTime = startTime;
        this.minEndTime = minEndTime;
        this.maxEndTime = maxEndTime;
        this.likelyEndTime = likelyEndTime;
        this.timeConfidence = timeConfidence;
        this.nextStartTime = nextStartTime;
        this.nextDuration = nextDuration;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"startTime\":")
                .append(startTime);
        sb.append(",\"minEndTime\":")
                .append(minEndTime);
        sb.append(",\"maxEndTime\":")
                .append(maxEndTime);
        sb.append(",\"likelyEndTime\":")
                .append(likelyEndTime);
        sb.append(",\"timeConfidence\":")
                .append(timeConfidence);
        sb.append(",\"nextStartTime\":")
                .append(nextStartTime);
        sb.append(",\"nextDuration\":")
                .append(nextDuration);
        sb.append('}');
        return sb.toString();
    }
}
