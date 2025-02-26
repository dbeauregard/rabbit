package io.dbeauregard.rabbit.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RMQPublisher implements CommandLineRunner {
    private final RabbitTemplate rabbitTemplate;
    private static Logger log = LoggerFactory.getLogger(RMQPublisher.class);
    private static String msg_base = "Hello from RabbitMQ!";

  public RMQPublisher(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

    @Override
    public void run(String... args) throws Exception {
        for(int x = 0; x < 100; x++) {
            String msg = msg_base + " " + x;
            log.info("Sending message...{}", msg);
            rabbitTemplate.convertAndSend(RabbitApplication.topicExchangeName, "foo.bar.baz", msg);
            rabbitTemplate.convertAndSend(RabbitApplication.quorum_queue_name, msg);
        }
    }
}
