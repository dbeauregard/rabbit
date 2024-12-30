package io.dbeauregard.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RabbitApplication {

	static final String topicExchangeName = "spring-boot-exchange";
	static final String queueName = "spring-boot";

	public static void main(String[] args) {
		SpringApplication.run(RabbitApplication.class, args);
	}

	@Bean
	Queue queue() {
		return new Queue(queueName, false, true, false);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(topicExchangeName);
	}

	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("foo.bar.#");
	}

}
