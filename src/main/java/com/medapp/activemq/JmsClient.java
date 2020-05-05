package com.medapp.activemq;

import com.medapp.dto.EventDto;

import javax.jms.JMSException;
import java.util.List;

public interface JmsClient {
    public void sendListEvents(List<EventDto> msg) throws JMSException;
}
