package medapp.mapper;

import medapp.dto.EventDto;
import medapp.model.Event;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class EventMapper {

    @Autowired
    private ModelMapper mapper;

    public Event toEntity(EventDto dto) {
        return Objects.isNull(dto)? null : mapper.map(dto, Event.class);
    }

    public EventDto toDto(Event entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, EventDto.class);
    }
}
