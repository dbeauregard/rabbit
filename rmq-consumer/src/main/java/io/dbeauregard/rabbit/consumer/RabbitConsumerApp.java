package io.dbeauregard.rabbit.consumer;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RabbitConsumerApp {

	static final String queueName = "spring-boot-queue";
	static final String quorum_queue_name = "quorum.queue";

	public static void main(String[] args) {
		SpringApplication.run(RabbitConsumerApp.class, args);
	}

	//Classic Queue
	@Bean
	Queue queue() {
		return new Queue(queueName, false, true, false);
	}

	//Quorum Queue
	@Bean
	public Queue quorumQueue() {
		return QueueBuilder.durable(quorum_queue_name)
				.withArgument("x-queue-type", "quorum") // Specify quorum queue
				.build();
	}

	//Stream 'Queue'

}
