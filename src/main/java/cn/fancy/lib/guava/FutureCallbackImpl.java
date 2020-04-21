package cn.fancy.lib.guava;

import com.google.common.util.concurrent.*;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FutureCallbackImpl implements FutureCallback<Person> {
    private StringBuilder builder = new StringBuilder();

    @Override
    public void onSuccess(Person result) {
        builder.append(result).append(" successfully");
    }

    @Override
    public void onFailure(Throwable t) {
        builder.append(t.toString());
    }

    public String getCallbackResult() {
        return builder.toString();
    }


    @Test

    public void testFutureCallback() throws ExecutionException, InterruptedException {
// 创建一个线程缓冲池Service
        ExecutorService executor = Executors.newCachedThreadPool();
// 创建一个ListeningExecutorService实例
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(executor);
// 提交一个可监听的线程(可以返回自定义对象，也可直接返回String)
        ListenableFuture<Person> futureTask = executorService.submit(new Callable<Person>() {
            Person p = new Person();

            @Override
            public Person call() throws Exception {
// return "Task completed";
                System.out.println("等待开始");
                Thread.sleep(2000);
                System.out.println("等待接数");

                p.setName("gogo");
                return p;
            }
        });


        FutureCallbackImpl callback = new FutureCallbackImpl();
// 线程结果处理回调函数
        Futures.addCallback(futureTask, callback);
// 如果callback中执行的是比较费时的操作，Guava建议使用以下方法。
// Futures.addCallback(futureTask,callback,executorService);
// 处理后的线程执行结果："Task completed successfully"
        futureTask.get();
        System.out.println(callback.getCallbackResult());
// assertThat(callback.getCallbackResult(), is("Task completed successfully"));
    }

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        new FutureCallback<Person>() {

            @Override
            public void onSuccess(Person result) {
                builder.append(result).append(" successfully");
            }

            @Override
            public void onFailure(Throwable t) {
                builder.append(t.toString());
            }
        };

// 创建一个线程缓冲池Service
        ExecutorService executor = Executors.newCachedThreadPool();
// 创建一个ListeningExecutorService实例
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(executor);
        ListenableFuture<Person> futureTask = executorService.submit(new Callable<Person>() {
            Person p = new Person();

            @Override
            public Person call() throws InterruptedException {
                Thread.sleep(3000);
// return "Task completed";
                p.setName("gogo");
                return p;
            }
        });
        FutureCallbackImpl callback = new FutureCallbackImpl();
        Futures.addCallback(futureTask, callback);
        System.out.println("===============" + callback.getCallbackResult());
    }

}


