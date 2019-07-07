package com.yuan.springbootwebrabbitmq.rabbitmq.config.exchange;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yuane
 * @date 2019/7/7 15:55
 **/
@Configuration
public class RabbitmqExchangeConfig {

    @Bean
    public TopicExchange exchange1() {
        return new TopicExchange(RabbitmqExchangeContants.EXCHANGE1);
    }

    @Bean
    public TopicExchange exchange2() {
        return new TopicExchange(RabbitmqExchangeContants.EXCHANGE2);
    }
}
