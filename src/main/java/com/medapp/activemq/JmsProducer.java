package com.medapp.activemq;

import com.medapp.converter.EventConverter;
import com.medapp.dto.EventDto;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.*;
import java.util.List;


@Component
public class JmsProducer {

    private static final Logger LOGGER = Logger.getLogger(JmsProducer.class);

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    ConnectionFactory connectionFactory;

    @Autowired
    EventConverter eventConverter;

    @Value("superqueue")
    String destinationQueue;

   // @Schedule(hour = "*", minute = "*", second = "*/1", persistent = false)
    public void sendListEvents(final List<EventDto> msg) throws JMSException {
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        Message message = eventConverter.toMessage(msg, session);
        LOGGER.info("jms convert and send");
     //   jmsTemplate.setTimeToLive(180000);
        jmsTemplate.convertAndSend(destinationQueue, message);
    }

//    public void sendMessage(final List<EventDto> msg) throws JMSException {
//        jmsTemplate.setTimeToLive(180000);
//        Connection connection = connectionFactory.createConnection();
//        Session sessions = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
//        Message message = eventConverter.toMessage(msg, sessions);
//        jmsTemplate.send(session -> session.createTextMessage(message));
//    }
}
