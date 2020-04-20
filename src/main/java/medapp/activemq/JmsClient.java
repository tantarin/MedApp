package medapp.activemq;

import medapp.dto.EventDto;
import medapp.model.Event;

import javax.jms.JMSException;
import java.util.List;

public interface JmsClient {
    public void sendListEvents(List<EventDto> msg) throws JMSException;
}
