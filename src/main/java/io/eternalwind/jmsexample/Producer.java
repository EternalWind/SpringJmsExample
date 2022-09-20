package io.eternalwind.jmsexample;

import java.util.UUID;

import javax.jms.Message;

import org.springframework.jms.core.JmsTemplate;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Producer {
    private final JmsTemplate jmsTemplate;
    private final String destination;

    public void sendMessage(String payload) {
        jmsTemplate.send(destination, session -> {
            final Message message = session.createTextMessage(payload);
            message.setJMSCorrelationID(UUID.randomUUID().toString());

            return message;
        });
    }
}
