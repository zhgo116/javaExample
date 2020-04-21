package cn.fancy.lib.guava;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallBackTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(10);
        Future<Integer> f = es.submit(() -> {
            Thread.sleep(1000);
            // 结果
            return 100;
        });

        // do something

        Integer result = f.get();
        System.out.println(result);

//        while (f.isDone()) {
//            System.out.println(result);
//        }
    }
}
