package cn.fancy.lib.guava;

import com.google.common.util.concurrent.*;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test1 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(executor);

        FutureCallback<Person> callback = new FutureCallback<Person>() {

            @Override
            public void onSuccess(Person result) {
                System.out.println("success" + result.getName());
                System.exit(1);
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("onfailure");
            }
        };
        ListenableFuture<Person> task = executorService.submit(new Callable<Person>() {
            Person p = new Person();

            @Override
            public Person call() throws InterruptedException {
                System.out.println("=====开始");
                Thread.sleep(3000);
                System.out.println("接数");
                p.setName("gogo");
                return p;
            }
        });
        Futures.addCallback(task, callback);
    }
}
