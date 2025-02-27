package io.dbeauregard.rabbit.producer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RabbitProducerApp {

	static final String queueName = "spring-boot-queue";
	static final String quorum_queue_name = "quorum.queue";
	private static final String directExchangeName = "spring-boot-directExchange";
	private static final String fanoutExchangeName = "spring-boot-fanoutExchange";
	static final String topicExchangeName = "spring-boot-topticExchange";
	private static final String headerExchangeName = "spring-boot-headerExchange";

	public static void main(String[] args) {
		SpringApplication.run(RabbitProducerApp.class, args);
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

	// Direct Exchange
	@Bean
	DirectExchange directExchange() {
		return new DirectExchange(directExchangeName, false, false);
	}

	// Topic Exchange
	@Bean
	TopicExchange topicExchange() {
		return new TopicExchange(topicExchangeName, false, false);
	}

	// Fanout Exchange
	@Bean
	FanoutExchange fanoutExchange() {
		return new FanoutExchange(fanoutExchangeName, false, false);
	}

	// Header Exchange
	@Bean
	HeadersExchange headerExchange() {
		return new HeadersExchange(headerExchangeName, false, false);
	}

	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("foo.bar.#");
	}

	@Bean
	Binding binding2(Queue quorumQueue, DirectExchange directExchange) {
		return BindingBuilder.bind(quorumQueue).to(directExchange).withQueueName();
	}

}
