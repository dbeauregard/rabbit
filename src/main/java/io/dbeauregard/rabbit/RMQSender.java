package io.dbeauregard.rabbit;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RMQSender implements CommandLineRunner {
    private final RabbitTemplate rabbitTemplate;
    private final RMQReceiver receiver;
    private static Logger log = LoggerFactory.getLogger(RMQSender.class);

  public RMQSender(RMQReceiver receiver, RabbitTemplate rabbitTemplate) {
    this.receiver = receiver;
    this.rabbitTemplate = rabbitTemplate;
  }

    @Override
    public void run(String... args) throws Exception {
        log.info("Sending message...");
        rabbitTemplate.convertAndSend(RabbitApplication.topicExchangeName, "foo.bar.baz",
                "Hello from RabbitMQ!");
        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
    }
}
