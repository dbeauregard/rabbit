package io.dbeauregard.rabbit.producer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.rabbitmq.RabbitMQContainer;

@SpringBootTest
@Testcontainers
class RabbitApplicationTests {

	@Container
	@ServiceConnection

	private static final RabbitMQContainer rabbitMQContainer = new RabbitMQContainer("rabbitmq");

	@Test
	void contextLoads() {
	}

}
