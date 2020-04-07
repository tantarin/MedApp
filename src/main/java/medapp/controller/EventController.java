package medapp.controller;

import lombok.extern.slf4j.Slf4j;
import medapp.dto.FilterDto;
import medapp.service.api.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
        return commonCode(new FilterDto());
    }


    @PostMapping("/getAll")
    public ModelAndView filter(@ModelAttribute("filter") FilterDto filterDto) {
        return commonCode(filterDto);
    }

    private ModelAndView commonCode(FilterDto filterDto) {
        ModelAndView model = new ModelAndView("events");
        model.addObject("listEvents", eventService.filter(filterDto));
        model.addObject("filterDto", filterDto);
        return model;
    }
}
