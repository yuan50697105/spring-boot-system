package com.yuan.springbootwebrabbitmq.rabbitmq.config.queue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yuane
 * @date 2019/7/7 15:54
 **/
@Configuration
@Slf4j
public class RabbimqQueueConfig {
    @Bean
    public Queue queue1() {
        return new Queue(RabbitMqQueueConstants.QUEUE1);
    }

    @Bean
    public Queue queue2() {
        return new Queue(RabbitMqQueueConstants.QUEUE2);
    }


    @Bean
    public Queue exchangeQueue1() {
        return new Queue(RabbitMqQueueConstants.EXCHANGE_QUEUE1);
    }

    @Bean
    public Queue exchangeQueue2() {
        return new Queue(RabbitMqQueueConstants.EXCHANGE_QUEUE2);
    }
}
