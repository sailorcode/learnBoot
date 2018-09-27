package com.qianyufeni.learnBoot.job;

import com.qianyufeni.learnBoot.config.QyfThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * ScheduledExecutorService做定时任务的示例,Timer的替代品
 */
public class ScheduledExecutorServiceJob {
    private  ScheduledExecutorService scheduExec;
    public long start;

    ScheduledExecutorServiceJob(){
        ThreadFactory threadFactory = new QyfThreadFactoryBuilder().setDaemon(false).setNamePrefix("飞哥牌线程").build();
        this.scheduExec = new ScheduledThreadPoolExecutor(2,threadFactory);
        this.start = System.currentTimeMillis();
    }

    public void timerOne(){
        scheduExec.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("timerOne,the time:" + (System.currentTimeMillis() - start));
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },1000,TimeUnit.MILLISECONDS);
    }

    public void timerTwo(){
        //方法被调用2000ms后,每1000ms执行一次
        scheduExec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("timerTwo,the time:" + (System.currentTimeMillis() - start));
            }
        },2000,1000,TimeUnit.MILLISECONDS);
    }

    public void timerThree(){
        //方法被调用2000ms后执行第一次,之后每次任务结束后1000ms再次执行
        scheduExec.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                }catch (InterruptedException e){

                }
                System.out.println("timerThree,the time:" + (System.currentTimeMillis() - start));
            }
        },2000,1000,TimeUnit.MILLISECONDS);
    }



    public static void main(String[] args) {
        ScheduledExecutorServiceJob test = new ScheduledExecutorServiceJob();
        test.timerOne();
        test.timerTwo();
        test.timerThree();
    }
}

