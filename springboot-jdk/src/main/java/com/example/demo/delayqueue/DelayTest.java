package com.example.demo.delayqueue;

import org.junit.Test;

import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by chenhe on 2018/3/15.
 */
public class DelayTest {

    DelayQueue<DelayTask> delayTasks = new DelayQueue<>();

    @Test
    public void testTake() throws InterruptedException {

        for (int i = 0; i < 100; i++) {
            DelayTask delayTask = new DelayTask("延迟队列" + (i + 1), new Date(System.currentTimeMillis() + (i * 1000)));
            delayTasks.add(delayTask);
        }

        while (delayTasks.size() > 0) {
            DelayTask delayTask = delayTasks.take();
            System.out.println(String.format("时间[%s],任务[%s]开始执行,预计执行时间[%s]",new Date(),delayTask.taskName,delayTask.addTime));
            TimeUnit.MILLISECONDS.sleep(1000);
        }

    }


    private class DelayTask implements Delayed {
        private String taskName;
        private Date addTime;

        public DelayTask(String taskName, Date addTime) {
            this.taskName = taskName;
            this.addTime = addTime;
            System.out.println(String.format("创建任务[%s],执行时间[%s]",taskName,addTime));
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return addTime.getTime()-System.currentTimeMillis();
        }

        @Override
        public int compareTo(Delayed o) {
            long l = this.getDelay(TimeUnit.MILLISECONDS)-o.getDelay(TimeUnit.MILLISECONDS);
            if (l > 0) return 1;
            if (l < 0) return -1;
            return 0;
        }
    }
}
