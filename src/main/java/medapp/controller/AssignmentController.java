package medapp.controller;

import medapp.activemq.JmsClient;
import medapp.dto.AssignmentDto;
import medapp.dto.EventDto;
import medapp.model.Event;
import medapp.service.api.AssignmentService;
import medapp.service.api.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.jms.JMSException;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {

    private static final Logger LOGGER = Logger.getLogger(AssignmentController.class);

    Long id;

    @Autowired
    private AssignmentService assignmentService;

    @Autowired
    private EventService eventService;

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
        eventService.sendUpdatedEvents();
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
    public ModelAndView edit(@ModelAttribute("assignment") AssignmentDto assignmentDto) {
        assignmentDto.setId(id);
        assignmentService.update(assignmentDto);
        Long patientId = assignmentService.getPatientId(id);
        return new ModelAndView("redirect:/patients/assignments?id="+patientId);
    }

    @GetMapping(value = "/delete")
    public ModelAndView delete(HttpServletRequest request) throws JMSException {
        id = Long.parseLong(request.getParameter("id"));
        Long patientId = assignmentService.getPatientId(id);
        assignmentService.deleteById(id);
        eventService.sendUpdatedEvents();
        return new ModelAndView("redirect:/patients/assignments?id="+patientId);
    }
}
