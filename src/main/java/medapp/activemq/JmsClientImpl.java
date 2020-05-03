package medapp.activemq;

import medapp.dto.EventDto;
import medapp.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import java.util.List;

@Service
public class JmsClientImpl implements JmsClient {

    @Autowired
    JmsProducer jmsProducer;

    @Override
    public void sendListEvents(List<EventDto> msg) throws JMSException {
        jmsProducer.sendListEvents(msg);
    }
}