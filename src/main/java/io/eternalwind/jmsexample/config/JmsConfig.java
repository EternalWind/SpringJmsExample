package io.eternalwind.jmsexample.config;

import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import io.eternalwind.jmsexample.Consumer;
import io.eternalwind.jmsexample.Producer;
import lombok.SneakyThrows;

@Configuration
public class JmsConfig {
    @Value("${activemq.broker.url}")
    private String brokerUrl;

    @Value("${activemq.queue.name}")
    private String destination;

    @Bean
    @SneakyThrows
    public BrokerService broker() {
        final BrokerService broker = new BrokerService();
        broker.setPersistent(false);
        broker.addConnector(brokerUrl);

        return broker;
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        return new JmsTemplate(new PooledConnectionFactory(brokerUrl));
    }

    @Bean
    public Producer producer(JmsTemplate jmsTemplate) {
        return new Producer(jmsTemplate, destination);
    }

    @Bean
    public Consumer consumer() {
        return new Consumer();
    }
}
