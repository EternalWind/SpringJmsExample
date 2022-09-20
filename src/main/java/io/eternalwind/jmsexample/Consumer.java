package io.eternalwind.jmsexample;

import javax.jms.TextMessage;

import org.springframework.jms.annotation.JmsListener;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Consumer {
    @JmsListener(destination = "${activemq.queue.name}")
    @SneakyThrows
    public void receiveMessage(TextMessage message) {
        log.info("Received message ID: {}, payload: {}", message.getJMSCorrelationID(), message.getText());
    }
}
