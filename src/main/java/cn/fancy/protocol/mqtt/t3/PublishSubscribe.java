package cn.fancy.protocol.mqtt.t3;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.util.UUID;

/**
 * mqtt的发布和订阅
 *
 * @author wzq
 */
public class PublishSubscribe {


    private static String serviceURI = "tcp://127.0.0.1:61613";
    private static String clientID = UUID.randomUUID().toString();
    private static MqttClientPersistence persistence = new MemoryPersistence();
    //如果mqtt服务配置了匿名访问，则不需要使用用户名和密码就可以实现消息的订阅和发布
   private static String username = "admin";
    private static String password = "password";
    private static String topic = "cebPark";
    /*
        消息服务质量，一共有三个：
        0：尽力而为。消息可能会丢，但绝不会重复传输
        1：消息绝不会丢，但可能会重复传输
        2：恰好一次。每条消息肯定会被传输一次且仅传输一次
     */
    private static int qos = 0;

    /**
     * 消息发布
     *
     * @author wzq
     **/
    public static void publish() {
        try {
            MqttClient client = new MqttClient(serviceURI, clientID, persistence);
            MqttConnectOptions connectOptions = new MqttConnectOptions();
            connectOptions.setUserName("admin");
            connectOptions.setPassword("password".toCharArray());
            connectOptions.setCleanSession(false);
            //发布者连接服务
            client.connect(connectOptions);
            System.out.println("发布者连接状态： " + client.isConnected());
            MqttTopic mqttTopic = client.getTopic(topic);
            //MqttMessage mqttMessage = new MqttMessage(message.getBytes());
            MqttMessage mqttMessage = new MqttMessage();
            mqttMessage.setQos(qos);
            int i = 1;
            String message = "hello，智能公厕-";
            while (true) {
                String payLoad = message + i++;
                mqttMessage.setPayload(payLoad.getBytes());
                MqttDeliveryToken deliveryToken = mqttTopic.publish(mqttMessage);
                if (!deliveryToken.isComplete()) {
                    System.out.println("发布者发布消息： " + payLoad + " 失败");
                    deliveryToken.waitForCompletion();
                } else {
                    System.out.println("发布者发布消息： " + payLoad + " 成功");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 消息订阅
     *
     * @author wzq
     **/
    public static void subscribe() {
        try {
            MqttClient client = new MqttClient(serviceURI, clientID, persistence);
            client.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable cause) {
                    System.out.println("订阅者连接丢失...");
                    System.out.println(cause.getMessage());
                }

                @Override
                public void messageArrived(String topic, MqttMessage message) {
                    System.out.println("订阅者接收到消息： " + message.toString());
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {
                }
            });
            MqttConnectOptions connectOptions = new MqttConnectOptions();
           connectOptions.setUserName(username);
           connectOptions.setPassword(password.toCharArray());
            connectOptions.setCleanSession(false);
            //订阅者连接订阅主题
            client.connect(connectOptions);
            client.subscribe(topic, qos);
            System.out.println("订阅者连接状态： " + client.isConnected());
        } catch (MqttException e) {
            e.printStackTrace();
        }

    }


}