package medapp.controller;

import medapp.dto.PatientDto;
import medapp.model.Event;
import medapp.model.Patient;
import medapp.service.api.EventService;
import medapp.service.api.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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

    @PostMapping("/filter")
    public ModelAndView filter(@ModelAttribute("date") String date, @ModelAttribute("hour") String hour, @ModelAttribute("patient") String patient) {
        ModelAndView modelAndView = new ModelAndView("events");
        List<Event> listEvents = new ArrayList<>();
        if(date.equals("1")) {
            listEvents = eventService.filterByDate();
        }
        if(hour.equals("2")) listEvents = eventService.filterByHour();
        if(patient.equals("3")) {
            listEvents = eventService.filterByPatient(2);
        }
        modelAndView.addObject("listEvents", listEvents);
        return modelAndView;
    }

    //TODO delete events
    @PostMapping("/delete")
    public ModelAndView delete(HttpServletRequest request) {
        System.out.println("from event delete controller");
        ModelAndView modelAndView = new ModelAndView("redirect:userList");
        Long id = Long.parseLong(request.getParameter("id"));
        eventService.deleteFromToday(id);
        return modelAndView;
    }
}
