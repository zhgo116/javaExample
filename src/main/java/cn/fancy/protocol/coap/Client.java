package cn.fancy.protocol.coap;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapHandler;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.Utils;
import org.eclipse.californium.core.coap.MediaTypeRegistry;

import java.time.Clock;
import java.util.concurrent.CountDownLatch;

public class Client {
    public static void main(String[] args) throws InterruptedException {

        int count = 2;
        CountDownLatch countDown = new CountDownLatch(count);
        long start = Clock.systemUTC().millis();
        CoapClient client = new CoapClient("coap://127.0.0.1:5883/tuyou/lenovo?p1=v1");
        for (int i = 0; i < 2; i++) {

            client.post(new CoapHandler() {

                @Override
                public void onLoad(CoapResponse response) {
                    System.out.println("onload:"+Utils.prettyPrint(response));
                    countDown.countDown();
                }

                @Override
                public void onError() {
                    System.out.println("error");
                }
            }, "payload message", MediaTypeRegistry.TEXT_PLAIN);
        }
        countDown.await();
        long end = Clock.systemUTC().millis();
        System.out.println("end"+(end - start));
    }
}
