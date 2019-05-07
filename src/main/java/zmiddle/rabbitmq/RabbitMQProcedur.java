package zmiddle.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author xingxi
 * @date 2019-05-05 22:09:05 星期日
 */
public class RabbitMQProcedur {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("guest");
        factory.setPassword("guest");

        factory.setHost("192.168.21.129");
        factory.setVirtualHost("/");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        String exchangeName = "hello-exchange";
        channel.exchangeDeclare(exchangeName,"direct",true);

        String routingKey = "testRoutingKey";

        byte[] messageBodyBytes = "quit".getBytes();

        channel.basicPublish(exchangeName,routingKey,null,messageBodyBytes);

        channel.close();
        connection.close();
    }
}
