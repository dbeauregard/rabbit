package io.dbeauregard.rabbit.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
// @RabbitListener(queues = RabbitApplication.queueName)
public class RMQConsumer {

    private static Logger log = LoggerFactory.getLogger(RMQConsumer.class);

    // @RabbitHandler
    @RabbitListener(queues = RabbitConsumerApp.queueName)
    public void receiveMessage(String message) {
        log.info("Received <" + message + ">");
    }

    // @RabbitHandler
    @RabbitListener(queues = RabbitConsumerApp.quorum_queue_name)
    public void receiveMessage2(String message) {
        log.info("Received QQ <" + message + ">");
    }
}
