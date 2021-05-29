package com.ritesh.consumer.config.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessConfig {

    @Value("${spring.process.routing-key}")
    private String routing;
    @Value("${spring.process.exchange-key}")
    private String exchange;
    @Value("${spring.process.queue}")
    private String queue;

    @Bean
    Queue processQueue(){
        return QueueBuilder.durable(queue)
                .build();
    }

    @Bean
    TopicExchange processExchange(){
        return new TopicExchange(exchange, true, false);
    }

    @Bean
    Binding bindingProcess(Queue processQueue, TopicExchange processExchange){
        return BindingBuilder.bind(processQueue).to(processExchange).with(routing);
    }
}
