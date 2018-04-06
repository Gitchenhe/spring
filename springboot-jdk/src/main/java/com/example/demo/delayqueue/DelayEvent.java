package com.example.demo.delayqueue;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by chenhe on 2018/3/15.
 */
public class DelayEvent implements Delayed {
    private Date startDate;

    public DelayEvent(Date startDate) {
        super();
        this.startDate = startDate;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        Date now = new Date();
        long diff = startDate.getTime() - now.getTime();
        return unit.convert(diff,TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        long result = getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS);
        if (result < 0)
            return -1;
        if (result < 0)
            return 1;
        return 0;
    }
}
