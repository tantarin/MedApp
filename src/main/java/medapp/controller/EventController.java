package medapp.controller;

import medapp.dto.PatientDto;
import medapp.model.Event;
import medapp.model.Patient;
import medapp.service.api.EventService;
import medapp.service.api.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private EventService eventService;

    @Autowired(required=true)
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }


    @GetMapping("/getAll")
    public ModelAndView getAll() {
        List<Event> listEvents = eventService.getAll();
        for(Event e:listEvents){
            System.out.println(e);
        }
        ModelAndView modelAndView = new ModelAndView("events");
        modelAndView.addObject("listEvents", listEvents);
        return modelAndView;
    }


}
