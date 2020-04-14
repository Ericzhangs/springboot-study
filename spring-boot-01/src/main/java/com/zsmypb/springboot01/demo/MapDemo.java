package com.zsmypb.springboot01.demo;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.HashMap;
import java.util.concurrent.*;

/**
 * @author zhangs.
 * HashMap  无序的原因：HashMap在put的时候执行了putVal(hash(key), key, value, false, true)方法，
 * 在putVal()方法里面会有tab[i = (n - 1) & hash]和 tab[i] = newNode(hash, key, value, null)这两段逻辑
 * 而tab[i = (n - 1) & hash] 中因为hash是不确定的所以HashMap的内容是无序的
 * <p>
 * <p>
 * AtomicInteger是通过CAS机制实现自增
 */
public class MapDemo {


    public static void main(String[] args) {
//        testMapPut();
//        testConcurrentHashMapPut();
        testHashMapThread();
    }

    public static void testConcurrentHashMapPut() {
        ConcurrentHashMap hashMap = new ConcurrentHashMap(16);
        int v1 = 126;
        int v2 = 140;
        for (int i = v1; i < v2; i++) {
            hashMap.put(i, i);
        }
        System.out.println(hashMap);
    }

    public static void testHashMapThread() {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        ExecutorService executorService = new ThreadPoolExecutor(5, 200,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
//        ExecutorService executorService = ThreadPoolExecutor(100);
//        HashMap map = new HashMap(2 ^ 14);
        ConcurrentHashMap map = new ConcurrentHashMap(2 ^ 14);
        CountDownLatch count = new CountDownLatch(10000);
        int size = 1000;
        for (int i = 0; i < size; i++) {
            int temp = i;
            executorService.submit(() -> {
                count.countDown();
                map.put(temp, temp);
                System.out.println(Thread.currentThread().getName() + " map: " + map.size());
            });
        }
        System.out.println("------ " + count.getCount());
        System.out.println("++++++ " + map.size());
    }

    public static void testMapPut() {
        HashMap hashMap = new HashMap(16);
        int v1 = 126;
        int v2 = 140;
        for (int i = v1; i < v2; i++) {
            if (i >= 132) {
                hashMap.put(i, i);
            } else {
                hashMap.put(i, i);
            }
        }

        System.out.println(hashMap);
    }

}
