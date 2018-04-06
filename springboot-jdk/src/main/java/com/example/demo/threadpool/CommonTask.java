package com.example.demo.threadpool;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Created by chenhe on 2018/3/29.
 */
public class CommonTask implements Runnable {

    private String name;
    private int times = 1;
    ScheduledExecutorService executorService;

    Logger logger = Logger.getGlobal();

    public CommonTask(String name){
        this.name = name;
        executorService = new ScheduledThreadPoolExecutor(1);
    }
    private CommonTask(String name,int times){
        this.name = name;
        this.times = times;
    }

    @Override
    public void run() {
        logger.info("第"+times+"次执行,time:"+ LocalTime.now());
        executorService.schedule(this,2*times-1, TimeUnit.SECONDS);
        times++;
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new CommonTask("测试任务"));
        thread.start();
    }
}
