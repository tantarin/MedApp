package medapp.converter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import medapp.dto.EventDto;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;


@Component
public class EventConverter implements MessageConverter {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(EventConverter.class);

    ObjectMapper mapper;

    public EventConverter() {
        mapper = new ObjectMapper();
    }

    @NotNull
    @Override
    public Message toMessage(@NotNull Object object, @NotNull Session session)
            throws JMSException {
        List<EventDto> eventDtoList = (List<EventDto>) object;
        String payload = null;
        try {
            payload = mapper.writeValueAsString(eventDtoList);
            LOGGER.info("outbound json='{}'", payload);
        } catch (JsonProcessingException e) {
            LOGGER.error("error converting form person", e);
        }
        TextMessage message = session.createTextMessage();
        message.setText(payload);
        return message;
    }


    @Override
    public Object fromMessage(Message message) throws JMSException {
        TextMessage textMessage = (TextMessage) message;
        String payload = textMessage.getText();
        LOGGER.info("inbound json='{}'", payload);

        EventDto eventDto = null;
        try {
            eventDto = mapper.readValue(payload, EventDto.class);
        } catch (Exception e) {
            LOGGER.error("error converting to person", e);
        }

        return eventDto;
    }
}
