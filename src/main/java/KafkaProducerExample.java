/**
 * Created by thatq on 7/28/2017.
 */
import org.apache.kafka.clients.producer.*;

import java.util.Properties;

public class KafkaProducerExample {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "10.0.0.62:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
        for(int i = 0; i < 100; i++)
            producer.send(new ProducerRecord<>("parser", Integer.toString(i), Integer.toString(i)),new Callback(){

                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    System.out.println("recordMetadata = [" + recordMetadata + "], e = [" + e + "]");
                    System.out.println("recordMetadata = [" + recordMetadata + "], e = [" + e + "]");
                }
            });

        producer.close();
    }
}