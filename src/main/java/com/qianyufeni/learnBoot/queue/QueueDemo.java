package com.qianyufeni.learnBoot.queue;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class QueueDemo {
    public static void main(String[] args) {
            Queue<String> queue = new LinkedBlockingQueue<String>(3);
            queue.offer("第1个");
            queue.offer("第2个");
            queue.offer("第3个");
            String a = queue.poll();
            String b = queue.poll();
    }
}
