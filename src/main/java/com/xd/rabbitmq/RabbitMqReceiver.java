package com.xd.rabbitmq;


import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.context.annotation.Profile;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author zxd
 * 消费者
 */
@Component
@Profile("receiver")
public class RabbitMqReceiver {

    // 指定要监听的队列名称, 以及消费者的 factory
	@RabbitListener(queues = "yogurt", containerFactory = "consumerFactory")
	@RabbitHandler
	public void receive(@Payload String info, @Headers Map<String, Object> headers, Channel channel) throws InterruptedException, IOException {
		long id = Thread.currentThread().getId();
		System.out.println("Consumer " + id + " has received message : " + info + "");
		System.out.println("handling...");
		// 模拟处理...
        TimeUnit.SECONDS.sleep(5);
        // 获取消息的 deliveryTag
		Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        // 手动ack
		channel.basicAck(deliveryTag, false);
		System.out.println("Consumer " + id + " finished handle");
	}
}
