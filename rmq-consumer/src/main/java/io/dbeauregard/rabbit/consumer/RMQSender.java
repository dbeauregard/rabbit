package io.dbeauregard.rabbit.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RMQSender implements CommandLineRunner {
    private final RabbitTemplate rabbitTemplate;
    private static Logger log = LoggerFactory.getLogger(RMQSender.class);
    private static String msg_base = "Hello from RabbitMQ!";

  public RMQSender(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

    @Override
    public void run(String... args) throws Exception {
        for(int x = 0; x < 1000000; x++) {
            String msg = msg_base + " " + x;
            log.info("Sending message...{}", msg);
            rabbitTemplate.convertAndSend(RabbitApplication.topicExchangeName, "foo.bar.baz", msg);
            rabbitTemplate.convertAndSend(RabbitApplication.quorum_queue_name, msg);
        }
    }
}
