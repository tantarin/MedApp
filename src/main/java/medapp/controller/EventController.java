package medapp.controller;

import lombok.extern.slf4j.Slf4j;
import medapp.activemq.JmsClient;
import medapp.dto.EventDto;
import medapp.dto.FilterDto;
import medapp.model.Event;
import medapp.service.api.EventService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jms.JMSException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/events")
public class EventController {

    private static final Logger LOGGER = Logger.getLogger(EventController.class);

    private EventService eventService;

    @Autowired
    JmsClient jsmClient;

    @Autowired()
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/getAll")
    public ModelAndView getAll() throws JMSException {
        return commonCode(new FilterDto(), new EventDto());
    }


    @PostMapping("/getAll")
    public ModelAndView filter(@ModelAttribute("filter") FilterDto filterDto,@ModelAttribute("eventDto") EventDto eventDto) throws JMSException {
        return commonCode(filterDto, eventDto);
    }

    @PostMapping("/comments")
    public ModelAndView getComments(@ModelAttribute("filter") FilterDto filterDto,@ModelAttribute("eventDto") EventDto eventDto, HttpServletRequest request) throws JMSException {
        Long id = Long.parseLong(request.getParameter("id"));
        eventDto.setId(id);
        eventService.update(eventDto);
        return commonCode(filterDto, eventDto);
    }

    private ModelAndView commonCode(FilterDto filterDto, EventDto eventDto) throws JMSException {
        ModelAndView model = new ModelAndView("events");
        model.addObject("listEvents", eventService.filter(filterDto));
        model.addObject("filterDto", filterDto);
        model.addObject("eventDto",eventDto);
        return model;
    }
}
