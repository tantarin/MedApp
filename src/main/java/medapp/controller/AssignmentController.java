package medapp.controller;

import medapp.dto.AssignmentDto;
import medapp.service.api.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @PostMapping(value = "/addAssignment")
    public ModelAndView add(@ModelAttribute("assignmentDto") AssignmentDto assignmentDto) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        assignmentService.add(assignmentDto);
        return modelAndView;
    }
}