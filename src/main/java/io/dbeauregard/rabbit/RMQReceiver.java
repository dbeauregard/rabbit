package io.dbeauregard.rabbit;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RMQReceiver {

    private CountDownLatch latch = new CountDownLatch(1);
    private static Logger log = LoggerFactory.getLogger(RMQReceiver.class);

    public void receiveMessage(String message) {
        log.info("Received <" + message + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}
