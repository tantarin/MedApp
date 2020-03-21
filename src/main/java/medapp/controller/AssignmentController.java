package medapp.controller;

import medapp.dto.AssignmentDto;
import medapp.model.Assignment;
import medapp.service.api.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {

    private AssignmentService assignmentService;

    @Autowired(required=true)
    public void setAssignmentService(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @GetMapping(value = "/add")
    public ModelAndView add() {
        ModelAndView model = new ModelAndView("addAssignment");
        model.addObject("assignment",new AssignmentDto());
        return model;
    }

    @PostMapping(value = "/add")
    public ModelAndView add(@ModelAttribute("assignmentDto") AssignmentDto assignmentDto) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        assignmentService.add(assignmentDto);
        return modelAndView;
    }

    @GetMapping(value = "/update")
    public ModelAndView edit() {
        ModelAndView model = new ModelAndView("editAssignment");
        model.addObject("assignment",new Assignment());
        return model;
    }

    @PostMapping(value = "/update")
    public ModelAndView edit(@ModelAttribute("assignment") Assignment assignment) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("from controller"+assignment.getName());
        modelAndView.setViewName("redirect:/");
        assignmentService.update(assignment);
        return modelAndView;
    }

    @GetMapping(value = "/delete")
    public ModelAndView delete() {
        ModelAndView model = new ModelAndView("editAssignment");
        model.addObject("assignment",new Assignment());
        return model;
    }

    @PostMapping(value = "/delete")
    public ModelAndView delete(@ModelAttribute("assignment") Assignment assignment) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        assignmentService.delete(assignment);
        return modelAndView;
    }
}
