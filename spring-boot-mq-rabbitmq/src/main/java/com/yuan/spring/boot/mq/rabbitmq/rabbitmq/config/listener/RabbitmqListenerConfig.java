package com.yuan.spring.boot.mq.rabbitmq.rabbitmq.config.listener;

import com.yuan.spring.boot.mq.rabbitmq.rabbitmq.config.queue.RabbitMqQueueConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

/**
 * @author yuane
 * @date 2019/7/7 16:01
 **/
@Configuration
@Slf4j
public class RabbitmqListenerConfig {

    @RabbitListener(queues = RabbitMqQueueConstants.QUEUE1)
    public void testQueue1(String msg) {
        log.info("testQueue1:" + msg);
    }

    @RabbitListener(queues = RabbitMqQueueConstants.QUEUE2)
    public void testQueue2(String msg) {
        log.info("testQueue2:" + msg);
    }

    @RabbitListener(queues = RabbitMqQueueConstants.EXCHANGE_QUEUE1)
    public void testExchane1(String msg) {
        log.info("testExchane1:" + msg);
    }

    @RabbitListener(queues = RabbitMqQueueConstants.EXCHANGE_QUEUE2)
    public void testExchane2(String msg) {
        log.info("testExchane2:" + msg);
    }
}
