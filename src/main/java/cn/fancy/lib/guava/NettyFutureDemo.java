package cn.fancy.lib.guava;

import cn.fancy.util.DateUtils;
import com.google.common.util.concurrent.*;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;

public class NettyFutureDemo {

    public static void main(String[] args) throws InterruptedException {
        EventExecutorGroup group = new DefaultEventExecutorGroup(4);
        System.out.println("开始:" + DateUtils.getNow());

        Future<Integer> f = group.submit(() -> {
            System.out.println("开始耗时计算:" + DateUtils.getNow());
            Thread.sleep(10000);
            System.out.println("结束耗时计算:" + DateUtils.getNow());
            return 100;
        });

        f.addListener((FutureListener<Object>) objectFuture -> System.out.println("计算结果:" + objectFuture.get()));

        System.out.println("结束:" + DateUtils.getNow());
        // 不让守护线程退出
        new CountDownLatch(1).await();
    }

    @Test
    public void should_test_furture() throws Exception {
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));

        ListenableFuture future1 = service.submit(new Callable<Integer>() {
            public Integer call() throws InterruptedException {
                Thread.sleep(1000);
                System.out.println("call future 1.");
                return 1;
            }
        });

        ListenableFuture future2 = service.submit(new Callable<Integer>() {
            public Integer call() throws InterruptedException {
                Thread.sleep(1000);
                System.out.println("call future 2.");
                //       throw new RuntimeException("----call future 2.");
                return 2;
            }
        });

        final ListenableFuture allFutures = Futures.allAsList(future1, future2);

        final ListenableFuture transform = Futures.transform(allFutures, new AsyncFunction<List<Integer>, Boolean>() {
            @Override
            public ListenableFuture apply(List<Integer> results) throws Exception {
                return Futures.immediateFuture(String.format("success future:%d", results.size()));
            }
        });

        Futures.addCallback(transform, new FutureCallback<Object>() {

            public void onSuccess(Object result) {
                System.out.println(result.getClass());
                System.out.printf("success with: %s%n", result);
            }

            public void onFailure(Throwable thrown) {
                System.out.printf("onFailure%s%n", thrown.getMessage());
            }
        });

        System.out.println(transform.get());
    }
}