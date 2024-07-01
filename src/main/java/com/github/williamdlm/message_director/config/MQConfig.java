package com.github.williamdlm.message_director.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {
    @Value("${mq.queues.http-outbound}")
    private String httpOutboundQueue;

    @Bean
    public Queue queueHttpOutbound() {
        return new Queue(httpOutboundQueue, true);
    }
}
