package medapp.controller;

import medapp.activemq.JmsClient;
import medapp.dto.AssignmentDto;
import medapp.dto.EventDto;
import medapp.model.Assignment;
import medapp.model.Event;
import medapp.service.api.AssignmentService;
import medapp.service.api.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jms.JMSException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {

    Long id;

    @Autowired(required=true)
    private AssignmentService assignmentService;

    @Autowired(required=true)
    private EventService eventService;

    @Autowired
    JmsClient jsmClient;

    @GetMapping(value = "/add")
    public ModelAndView add(HttpServletRequest request) {
        id = Long.parseLong(request.getParameter("id"));
        ModelAndView model = new ModelAndView("addAssignment");
        model.addObject("assignmentDto", new AssignmentDto());
        return model;
    }

    @PostMapping(value = "/add")
    public ModelAndView add(@ModelAttribute("assignmentDto") AssignmentDto assignmentDto) throws JMSException {
        assignmentDto.setPatientId(id);
        assignmentService.add(assignmentDto);
        List<Event> events = eventService.getAll();
        List<EventDto> eventDtoList = new ArrayList<>();
        for(Event e:events){
            EventDto eventDto = new EventDto();
            eventDto.setId(e.getId());
            eventDto.setAssignmentName(e.getAssignment().getName());
            eventDto.setDate(e.getDate());
            eventDto.setTime(e.getTime());
            eventDto.setPatientName(e.getPatientName());
            eventDto.setStatus(e.getStatus());
            eventDto.setComments(e.getComments());
            eventDtoList.add(eventDto);
        }
        jsmClient.sendListEvents(eventDtoList);
        return new ModelAndView("redirect:/patients/assignments?id="+id);
    }

    /**
     *
     * @return
     */
    @GetMapping(value = "/edit")
    public ModelAndView edit(HttpServletRequest request) {
        id = Long.parseLong(request.getParameter("id"));
        AssignmentDto ass = assignmentService.getById(id);
        ModelAndView model = new ModelAndView("editAssignment");
        model.addObject("assignmentDto",ass);
        return model;
    }

    @PostMapping(value = "/edit")
    public ModelAndView edit(@ModelAttribute("assignment") AssignmentDto assignmentDto,HttpServletRequest request) {
        assignmentDto.setId(id);
        Long patientId = assignmentService.getPatientId(id);
        assignmentService.update(assignmentDto);
        return new ModelAndView("redirect:/patients/assignments?id="+patientId);
    }

    @GetMapping(value = "/delete")
    public ModelAndView delete(HttpServletRequest request) throws JMSException {
        id = Long.parseLong(request.getParameter("id"));
        Long patientId = assignmentService.getPatientId(id);
        assignmentService.deleteById(id);
        List<Event> events = eventService.getAll();
        List<EventDto> eventDtoList = new ArrayList<>();
        for(Event e:events){
            EventDto eventDto = new EventDto();
            eventDto.setId(e.getId());
            eventDto.setAssignmentName(e.getAssignment().getName());
            eventDto.setDate(e.getDate());
            eventDto.setTime(e.getTime());
            eventDto.setPatientName(e.getPatientName());
            eventDto.setStatus(e.getStatus());
            eventDto.setComments(e.getComments());
            eventDtoList.add(eventDto);
        }
        jsmClient.sendListEvents(eventDtoList);
        return new ModelAndView("redirect:/patients/assignments?id="+patientId);
    }
}
