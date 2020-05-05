package com.medapp.config;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsMessagingTemplate;


@Configuration
@ComponentScan("com.medapp")
public class ActiveMQJmsConfig {

    private AnnotationConfigApplicationContext context;

    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        connectionFactory.setTrustAllPackages(true);
        return connectionFactory;
    }


    @Bean
    public JmsMessagingTemplate jmsTemplate() {
        JmsMessagingTemplate messagingTemplate = new JmsMessagingTemplate();
        messagingTemplate.setConnectionFactory(connectionFactory());
        messagingTemplate.setDefaultDestinationName("superqueue");
        return messagingTemplate;
    }
}