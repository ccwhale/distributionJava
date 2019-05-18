package zmiddle.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xingxi
 * @date 2019-05-09 15:55:04 星期四
 */
public class KafkaSampleProducer {

    public static void main(String[] args) {
        Map<String, Object> props = new HashMap<>();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.Serializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.Serializer");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.Deserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.Deserializer");
        props.put("zk.connect", "127.0.0.1:2181");

        String topic = "test-topic";
        Producer<String, String> producer = new KafkaProducer<>(props);
        producer.send(new ProducerRecord<>(topic, "idea-key2", "java-message-1"));
        producer.send(new ProducerRecord<>(topic, "idea-key2", "java-message-2"));
        producer.send(new ProducerRecord<>(topic, "idea-key2", "java-message-3"));

        producer.close();
    }
}
