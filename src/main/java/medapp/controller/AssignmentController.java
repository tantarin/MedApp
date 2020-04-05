package medapp.controller;

import medapp.dto.AssignmentDto;
import medapp.model.Assignment;
import medapp.service.api.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {

    Long id;

    private AssignmentService assignmentService;

    @Autowired(required=true)
    public void setAssignmentService(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    /**
     *
     * @param request
     * @return
     */
    @GetMapping(value = "/add")
    public ModelAndView add(HttpServletRequest request) {
        id = Long.parseLong(request.getParameter("id"));
        ModelAndView model = new ModelAndView("addAssignment");
        model.addObject("assignmentDto", new AssignmentDto());
        return model;
    }

    /**
     *
     * @param assignmentDto
     * @return
     */
    @PostMapping(value = "/add")
    public ModelAndView add(@ModelAttribute("assignmentDto") AssignmentDto assignmentDto) {
        assignmentDto.setPatientId(id);
        assignmentService.add(assignmentDto);
        return new ModelAndView("redirect:/patients/assignments");
    }

    /**
     *
     * @return
     */
    @GetMapping(value = "/edit")
    public ModelAndView edit() {
        ModelAndView model = new ModelAndView("editAssignment");
        model.addObject("assignment",new Assignment());
        return model;
    }

    /**
     *
     * @param assignmentDto
     * @return
     */
    @PostMapping(value = "/edit")
    public ModelAndView edit(@ModelAttribute("assignment") AssignmentDto assignmentDto) {
        assignmentService.update(assignmentDto);
        return new ModelAndView("redirect:/");
    }

    /**
     *
     * @param request
     * @return
     */
    @GetMapping(value = "/delete")
    public ModelAndView delete(HttpServletRequest request) {
        id = Long.parseLong(request.getParameter("id"));
        assignmentService.deleteById(id);
        return new ModelAndView("redirect:/patients/getAll");
    }
}
