package com.yuan.springbootwebrabbitmq.rabbitmq.config.binding;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yuane
 * @date 2019/7/7 16:00
 **/
@Configuration
public class RabbitmqBindingConfig {
    @Bean
    public Binding binding1(@Qualifier("exchangeQueue1") Queue queue, @Qualifier("exchange1") TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(RabbitmqBindingConstants.BINDING1);
    }

    @Bean
    public Binding binding2(@Qualifier("exchangeQueue1") Queue queue, @Qualifier("exchange1") TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(RabbitmqBindingConstants.BINDING2);
    }
}
