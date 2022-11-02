package com.xd.rabbitmq;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author zxd
 * 生产者
 **/
@Profile("sender")
@Component
public class RabbitMqSender {

	private int cnt = 0;

    // 由 rabbitmq-starter 自动注册进来的, 其实现目前只有1个  RabbitTemplate
    // 但为了依赖于接口, 最好用 AmqpTemplate 来接收
	@Autowired
	private AmqpTemplate template;

    // 这里的 Queue 就是前面配置的名称为 yogurt 的队列
	@Autowired
	private Queue queue;


	/**
	 * 每4秒发送一条消息
	 * */
	@Scheduled(fixedRate = 5000, initialDelay = 2000)
	public void send() {
		cnt++;
		// 发送一个 UserInfo 对象到 rabbitmq
        template.convertAndSend(queue.getName(), "股份收到货输入法通过黑人抬棺和季节");
		System.out.println("[x] Sent");
	}
}

