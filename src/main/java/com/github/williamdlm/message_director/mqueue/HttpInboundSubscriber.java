package com.github.williamdlm.message_director.mqueue;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import com.github.williamdlm.message_director.hl7.hl7v2.ParserHL7v2;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HttpInboundSubscriber {

    private final HttpOutboundPublisher httpOutboundPublisher;

    @RabbitListener(queues = "${mq.queues.http-inbound}")
    public void requestMessage(@Payload String payload) throws HL7Exception {
        System.out.println("Payload: " + payload);
        String newMessage = payload.replace("\n", "\r\n");
        try {
            Message parsedMessage = ParserHL7v2.toParser(newMessage);
            httpOutboundPublisher.publishMessage("Its works!!!!");
        } catch (Exception e) {
            httpOutboundPublisher.publishMessage(e.getMessage());
        }
    }

}
