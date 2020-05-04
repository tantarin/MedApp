package medapp.controller;

import medapp.dto.AssignmentDto;
import medapp.service.api.AssignmentService;
import medapp.service.api.EventService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jms.JMSException;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {

    private static final Logger LOGGER = Logger.getLogger(AssignmentController.class);

    Long id;

    @Autowired
    private AssignmentService assignmentService;

    @Autowired
    private EventService eventService;

    /**
     * Displaying the jsp page "addAssignment"
     * at the url address http://localhost:8080/add?id=?
     * and passing the object new AssignmentDto() there
     *
     * @param request
     * @return model
     */
    @GetMapping(value = "/add")
    public ModelAndView add(HttpServletRequest request) {
        id = Long.parseLong(request.getParameter("id"));
        ModelAndView model = new ModelAndView("addAssignment");
        model.addObject("assignmentDto", new AssignmentDto());
        return model;
    }

    /**
     * send assignmentDto data from client
     * to the server and send
     * it to the assignmentService.
     * Then update the list of events.
     *
     * @param assignmentDto
     * @return ModelandView
     * @throws JMSException
     */
    @PostMapping(value = "/add")
    public ModelAndView add(@ModelAttribute("assignmentDto") AssignmentDto assignmentDto) throws JMSException {
        assignmentDto.setPatientId(id);
        assignmentService.add(assignmentDto);
        eventService.sendUpdatedEvents();
        return new ModelAndView("redirect:/patients/assignments?id=" + id);
    }

    /**
     * Displaying the jsp page "editAssignment"
     * at the url address http://localhost:8080/edit?id=?
     * and passing the object AssignmentDto
     * from database there
     *
     * @return
     */
    @GetMapping(value = "/edit")
    public ModelAndView edit(HttpServletRequest request) throws Exception {
        id = Long.parseLong(request.getParameter("id"));
        AssignmentDto assignmentDto = assignmentService.getById(id);
        ModelAndView model = new ModelAndView("editAssignment");
        model.addObject("assignmentDto", assignmentDto);
        return model;
    }

    /**
     * update AsssignmentDto
     *
     * @param assignmentDto
     * @return ModelAndView
     */
    @PostMapping(value = "/edit")
    public ModelAndView edit(@ModelAttribute("assignment") AssignmentDto assignmentDto) {
        assignmentDto.setId(id);
        assignmentService.update(assignmentDto);
        Long patientId = assignmentService.getPatientId(id);
        return new ModelAndView("redirect:/patients/assignments?id=" + patientId);
    }

    /**
     * delete Assignment and update table of Events
     *
     * @param request
     * @return
     * @throws JMSException
     */
    @GetMapping(value = "/delete")
    public ModelAndView delete(HttpServletRequest request) throws JMSException {
        id = Long.parseLong(request.getParameter("id"));
        Long patientId = assignmentService.getPatientId(id);
        assignmentService.deleteById(id);
        eventService.sendUpdatedEvents();
        return new ModelAndView("redirect:/patients/assignments?id=" + patientId);
    }
}
