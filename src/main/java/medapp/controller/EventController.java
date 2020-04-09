package medapp.controller;

import lombok.extern.slf4j.Slf4j;
import medapp.dto.EventDto;
import medapp.dto.FilterDto;
import medapp.model.Event;
import medapp.service.api.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/events")
public class EventController {

    private EventService eventService;

    @Autowired()
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/getAll")
    public ModelAndView getAll() {
        return commonCode(new FilterDto(), new EventDto());
    }


    @PostMapping("/getAll")
    public ModelAndView filter(@ModelAttribute("filter") FilterDto filterDto,@ModelAttribute("eventDto") EventDto eventDto) {
        return commonCode(filterDto, eventDto);
    }

    @PostMapping("/comments")
    public ModelAndView getComments(@ModelAttribute("filter") FilterDto filterDto,@ModelAttribute("eventDto") EventDto eventDto, HttpServletRequest request){
        Long id = Long.parseLong(request.getParameter("id"));
        eventDto.setId(id);
        eventService.update(eventDto);
        return commonCode(filterDto, eventDto);
    }

    private ModelAndView commonCode(FilterDto filterDto, EventDto eventDto) {
        ModelAndView model = new ModelAndView("events");
        model.addObject("listEvents", eventService.filter(filterDto));
        model.addObject("filterDto", filterDto);
        model.addObject("eventDto",eventDto);
        return model;
    }
}
