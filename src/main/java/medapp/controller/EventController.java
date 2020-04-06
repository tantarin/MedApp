package medapp.controller;

import medapp.model.Event;
import medapp.service.api.EventService;
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

    /**
     *
     * @return
     */
    @GetMapping("/getAll")
    public ModelAndView getAll() {
       // System.out.println("from controller events");
        List<Event> listEvents = eventService.getAll();
        ModelAndView modelAndView = new ModelAndView("events");
        modelAndView.addObject("listEvents", listEvents);
        return modelAndView;
    }

    /**
     *
     * @param date
     * @param hour
     * @param patient
     * @return
     */
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

    /**
     * delete events by patient id when button discharge submitted
     * and change status of patient on disharged
     * @param request
     * @return
     */
    @GetMapping("/delete")
    public ModelAndView deleteGet(HttpServletRequest request) {
        Long patientId = Long.parseLong(request.getParameter("id"));
        eventService.deleteFromToday(patientId);
        return new ModelAndView("redirect:/patients/getAll");
    }
}
