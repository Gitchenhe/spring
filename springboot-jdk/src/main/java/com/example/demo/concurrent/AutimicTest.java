package com.example.demo.concurrent;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by chenhe on 2018/4/6.
 */
public class AutimicTest {

    @Test
    public void  test() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(10);
        AtomicReference reference = new AtomicReference();

        System.out.println("**********AtomicInteger 测试***************");
        executorService.execute(new AtomicIntegerTask(atomicInteger));
        executorService.execute(new AtomicIntegerTask(atomicInteger));

        System.out.println("********AtomicIntegerArray 测试************");

    }



    class AtomicIntegerTask implements Runnable{
        private AtomicInteger atomicInteger;
        public AtomicIntegerTask(AtomicInteger atomicInteger){
            this.atomicInteger = atomicInteger;
        }
        @Override
        public void run() {
            int cnt =10;
            while (cnt-- >0){
               int a =  atomicInteger.incrementAndGet();
                System.out.println(a);
            }
        }
    }
    
    class AtomicIntegerArrayTask implements Runnable{

        private AtomicIntegerArray atomicIntegerArray;
        public AtomicIntegerArrayTask(AtomicIntegerArray atomicIntegerArray){
            this.atomicIntegerArray = atomicIntegerArray;
        }
        @Override
        public void run() {
            int cnt = 10;
            while (cnt-->0){
                for(int i = 0;i<10;i++){
                    atomicIntegerArray.getAndAdd(i,1);
                }
            }

        }
    }
}
