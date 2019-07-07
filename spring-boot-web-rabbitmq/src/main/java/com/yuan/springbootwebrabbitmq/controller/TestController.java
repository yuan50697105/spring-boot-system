package com.yuan.springbootwebrabbitmq.controller;

import com.yuan.springbootwebrabbitmq.rabbitmq.config.binding.RabbitmqBindingConstants;
import com.yuan.springbootwebrabbitmq.rabbitmq.config.exchange.RabbitmqExchangeContants;
import com.yuan.springbootwebrabbitmq.rabbitmq.config.queue.RabbitMqQueueConstants;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuane
 * @date 2019/7/7 16:07
 **/
@RestController
public class TestController {
    private final AmqpTemplate amqpTemplate;

    public TestController(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    @RequestMapping("send")
    public String send(String msg) {
        amqpTemplate.convertAndSend(RabbitMqQueueConstants.QUEUE1, msg);
        amqpTemplate.convertAndSend(RabbitMqQueueConstants.QUEUE2, msg);
        return msg;
    }

    @RequestMapping("exchange")
    public String exchange(String msg) {
//        amqpTemplate.convertAndSend(RabbitmqExchangeContants.EXCHANGE1, RabbitmqBindingConstants.BINDING1, msg);
//        amqpTemplate.convertAndSend(RabbitmqExchangeContants.EXCHANGE2, RabbitmqBindingConstants.BINDING2, msg);
        amqpTemplate.convertAndSend(RabbitmqExchangeContants.EXCHANGE2, RabbitmqBindingConstants.BINDING_ALL, msg);
        amqpTemplate.convertAndSend(RabbitmqExchangeContants.EXCHANGE1, RabbitmqBindingConstants.BINDING_ALL, msg);
        return msg;
    }
}
