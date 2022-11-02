package com.xd.config;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {


	/**
    * 注册一个 MessageConverter, 发送消息时可以直接发送一个POJO
    **/
	@Bean
	public MessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	/**
	 * 新建一个队列, 队列名为 yogurt
	 * **/
	@Bean
	public Queue yogurt() {
		return new Queue("yogurt");
	}

    /**
    * 配置consumer工厂
    * **/
	@Bean
	public SimpleRabbitListenerContainerFactory consumerFactory(SimpleRabbitListenerContainerFactoryConfigurer configurer,
	                                                            ConnectionFactory connectionFactory) {
		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		// consumer 的 prefetch 设置
        factory.setPrefetchCount(30);
		// 并发配置 - 同时开启5个消费者(5个线程)
		factory.setConcurrentConsumers(5);
        // 最大并发配置 (当消息堆积时, 会新开线程来处理, 最大能到20个)
        // 有点类似jdk的线程池
		factory.setMaxConcurrentConsumers(20);
        // 消费者开启 手动ack 机制
		factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        // 接收消息时, 可以直接将消息反序列化为 POJO
		factory.setMessageConverter(new Jackson2JsonMessageConverter());
		configurer.configure(factory, connectionFactory);
		return factory;
	}
}
