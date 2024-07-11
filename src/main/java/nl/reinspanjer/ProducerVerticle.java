package nl.reinspanjer;

import io.vertx.core.AbstractVerticle;
import io.vertx.kafka.client.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class ProducerVerticle extends AbstractVerticle {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProducerVerticle.class);
  private static final Map<String, String> kafkaproperties = Map.of(
    "value.serializer", "org.apache.kafka.common.serialization.StringSerializer",
    "key.serializer", "org.apache.kafka.common.serialization.StringSerializer",
    "bootstrap.servers", "localhost:9092",
    "acks", "one"
  );

  private KafkaProducer<String, String> producer;

  @Override
  public void start() {
    System.out.print("Starting producer verticle");
    producer = KafkaProducer.create(vertx, kafkaproperties);
    System.out.print("Producer is created");
  }

}
