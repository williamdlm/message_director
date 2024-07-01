package com.github.williamdlm.message_director.mqueue;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HttpOutboundPublisher {
    private final RabbitTemplate rabbitTemplate;

    private final Queue queueHttpOutbound;

    public void publishMessage(String message) {
        rabbitTemplate.convertAndSend(queueHttpOutbound.getName(), message);
    }

}
