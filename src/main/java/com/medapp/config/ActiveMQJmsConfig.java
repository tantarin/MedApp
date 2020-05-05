package com.medapp.config;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.SimpleMessageConverter;


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
    public JmsTemplate jmsTemplate() {
        JmsTemplate messagingTemplate = new JmsTemplate();
        messagingTemplate.setConnectionFactory(connectionFactory());
        messagingTemplate.setDefaultDestinationName("superqueue");
        return messagingTemplate;
    }

    @Bean
    MessageConverter converter(){
        return new SimpleMessageConverter();

    }
}