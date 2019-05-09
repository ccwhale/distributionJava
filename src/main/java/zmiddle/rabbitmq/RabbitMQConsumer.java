package zmiddle.rabbitmq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author xingxi
 * @date 2019-05-09 16:28:45 星期四
 */
@Slf4j
public class RabbitMQConsumer {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setHost("");
        connectionFactory.setVirtualHost("/");

        Connection connection = connectionFactory.newConnection();

        final Channel channel = connection.createChannel();

        String exchangeName = "hello-exchange";

        channel.exchangeDeclare(exchangeName, "direct", true);

        String queueName = channel.queueDeclare().getQueue();

        String routingKey = "testRoutingKey";

        channel.queueBind(queueName, exchangeName, routingKey);

        while (true) {
            boolean autoAck = false;
            String consumerTag = "";
            channel.basicConsume(queueName, autoAck, consumerTag, new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String routingKey = envelope.getRoutingKey();
                    String contentType = properties.getContentType();
                    log.info("消费的路由键：{}", routingKey);
                    log.info("消费内容类型：{}", contentType);
                    long deliveryTag = envelope.getDeliveryTag();

                    // 确认消息
                    channel.basicAck(deliveryTag, false);
                    log.info("消费的消息体内容：{}", new String(body, "UTF-8"));
                }
            });
        }
    }
}
