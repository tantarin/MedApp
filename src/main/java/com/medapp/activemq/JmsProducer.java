package com.medapp.activemq;

import com.medapp.converter.EventConverter;
import com.medapp.dto.EventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.ejb.Schedule;
import javax.jms.*;
import java.util.List;


@Component

public class JmsProducer {
    @Autowired
    JmsMessagingTemplate jmsTemplate;

    @Autowired
    ConnectionFactory connectionFactory;

    @Autowired
    EventConverter eventConverter;

    @Value("superqueue")
    String destinationQueue;

    @Schedule(hour = "*", minute = "*", second = "*/1", persistent = false)
    public void sendListEvents(final List<EventDto> msg) throws JMSException {
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        Message message = eventConverter.toMessage(msg, session);
        jmsTemplate.convertAndSend(destinationQueue, message);
    }
}
