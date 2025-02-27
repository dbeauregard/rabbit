package io.dbeauregard.rabbit.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RMQProducer implements CommandLineRunner {
    private final RabbitTemplate rabbitTemplate;
    private static Logger log = LoggerFactory.getLogger(RMQProducer.class);
    private static String msg_base = "Hello from RabbitMQ!";

  public RMQProducer(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

    @Override
    public void run(String... args) throws Exception {
        for(int x = 0; x < 100; x++) {
            String msg = msg_base + " " + x;
            log.info("Sending message...{}", msg);
            rabbitTemplate.convertAndSend(RabbitProducerApp.topicExchangeName, "foo.bar.baz", msg);
            rabbitTemplate.convertAndSend(RabbitProducerApp.quorum_queue_name, msg);
        }

        log.info("Producer... and Done!  Exiting.");
        // System.exit(0);
    }
}
