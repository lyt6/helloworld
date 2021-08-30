package com.helloworld.demo.javase.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

class MyRunable implements Runnable {
    @Override
    public void run() {
        System.out.println("excute runable ... ");
    }
}

/**
 * 自己创建线程池
 */
public class ThreadPoolExcutorDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        try {
            threadPoolExecutor.execute(new MyRunable());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPoolExecutor.shutdown();
        }

        // new ThreadPoolExecutor(3,5,2L,TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>(3){},Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
    }

    public int[] twoSum(int[] nums, int target) {
        // target 5
        // nums 1 2 3 4 5
        HashMap<Integer,Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }

}
