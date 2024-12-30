package io.dbeauregard.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = RabbitApplication.queueName)
public class RMQReceiver {

    private static Logger log = LoggerFactory.getLogger(RMQReceiver.class);

    @RabbitHandler
    public void receiveMessage(String message) {
        log.info("Received <" + message + ">");
    }
}
