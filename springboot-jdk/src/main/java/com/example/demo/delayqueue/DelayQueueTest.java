package com.example.demo.delayqueue;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by chenhe on 2018/3/15.
 */
public class DelayQueueTest {

    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayEvent> queue = new DelayQueue<>();
        Thread[] threads = new Thread[5];

        for (int i = 0; i < threads.length; i++) {
            DelayTask task = new DelayTask(i+1,queue);
            threads[i] = new Thread(task);
        }

        Arrays.asList(threads).forEach(thread -> thread.start());

        Arrays.asList(threads).forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        do {
            int count = 0;
            DelayEvent delayEvent;
            do {
                delayEvent =queue.poll();
                if (delayEvent!=null){
                    count++;
                }
            }while (delayEvent!=null);
            System.out.println("时间 " + LocalDateTime.now() + " 存在 "+ count +" 事件");
            TimeUnit.MILLISECONDS.sleep(500);
        }while (queue.size()>0);

    }
}
