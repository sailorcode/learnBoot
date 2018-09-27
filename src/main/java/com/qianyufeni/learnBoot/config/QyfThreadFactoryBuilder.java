package com.qianyufeni.learnBoot.config;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/**
 * qyf 20180920
 * 返回自定义的ThreadLocal实现类
 * ScheduledThreadPoolExecutor/ThreadPoolExecutor构造函数如果不传threadFactory就会用Executors.defaultThreadFactory()
 * 意义在于可以设置线程的名字,类型,优先级
 */
public class QyfThreadFactoryBuilder {
    private String namePrefix = null;
    private boolean daemon = false;
    //默认优先级为5,即线程默认优先级
    private int priority = Thread.NORM_PRIORITY;

    public QyfThreadFactoryBuilder setNamePrefix(String namePrefix) {
        if (namePrefix == null) {
            throw new NullPointerException();
        }
        this.namePrefix = namePrefix;
        return this;
    }

    public QyfThreadFactoryBuilder setDaemon(boolean daemon) {
        this.daemon = daemon;
        return this;
    }

    public QyfThreadFactoryBuilder setPriority(int priority) {
        if (priority < Thread.MIN_PRIORITY){
            throw new IllegalArgumentException(String.format(
                    "Thread priority (%s) must be >= %s", priority, Thread.MIN_PRIORITY));
        }

        if (priority > Thread.MAX_PRIORITY) {
            throw new IllegalArgumentException(String.format(
                    "Thread priority (%s) must be <= %s", priority, Thread.MAX_PRIORITY));
        }

        this.priority = priority;
        return this;
    }

    public ThreadFactory build() {
        return build(this);
    }

    private static ThreadFactory build(QyfThreadFactoryBuilder builder) {
        final String namePrefix = builder.namePrefix;
        final Boolean daemon = builder.daemon;
        final Integer priority = builder.priority;
        final AtomicLong count = new AtomicLong(0);
         /*
        return new ThreadFactory() {
            @Override
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                if (namePrefix != null) {
                    thread.setName(namePrefix + "-" + count.getAndIncrement());
                }
                if (daemon != null) {
                    thread.setDaemon(daemon);
                }
                if (priority != null) {
                    thread.setPriority(priority);
                }
                return thread;
            }
        };*/
        //jdk8中还是优先使用lamb表达式
        return (Runnable runnable) -> {
            Thread thread = new Thread(runnable);
            if (namePrefix != null) {
                thread.setName(namePrefix + "-" + count.getAndIncrement());
            }
            if (daemon != null) {
                thread.setDaemon(daemon);
            }
                    thread.setPriority(priority);
            return thread;
        };
    }
}
