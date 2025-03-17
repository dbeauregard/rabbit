package io.dbeauregard.rabbit.consumer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.RabbitMQContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

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
