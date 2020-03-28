package medapp.controller;

import medapp.dto.PatientDto;
import medapp.model.Event;
import medapp.model.Patient;
import medapp.service.api.EventService;
import medapp.service.api.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

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
        List<Event> listEvents = eventService.getAll();
        ModelAndView modelAndView = new ModelAndView("events");
        modelAndView.addObject("listEvents", listEvents);
        return modelAndView;
    }

//    @GetMapping("/filter")
//    public ModelAndView filter() {
//        ModelAndView modelAndView = new ModelAndView("events");
//        return modelAndView;
//    }

    @PostMapping("/filter")
    public ModelAndView filter(@ModelAttribute("date") String date, @ModelAttribute("hour") String hour, @ModelAttribute("patient") String patient) {
        ModelAndView modelAndView = new ModelAndView("events");
        List<Event> listEvents = new ArrayList<>();
        if(date.equals("1")) {
            System.out.println("by date");
            listEvents = eventService.filterByDate();
        }
        if(hour.equals("2")) listEvents = eventService.filterByHour();
        if(patient.equals("3")) {
            System.out.println("by patient");
            listEvents = eventService.filterByPatient(2);
        }
        modelAndView.addObject("listEvents", listEvents);
        return modelAndView;
    }
}
