package com.medapp.activemq;

import com.medapp.dto.EventDto;

import javax.jms.JMSException;
import java.util.List;

public interface JmsClient {
    void sendListEvents(List<EventDto> msg) throws JMSException;
}
