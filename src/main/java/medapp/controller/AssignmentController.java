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

    @GetMapping(value = "/add")
    public ModelAndView add(HttpServletRequest request) {
        id = Long.parseLong(request.getParameter("id"));
        ModelAndView model = new ModelAndView("addAssignment");
        AssignmentDto assignmentDto = new AssignmentDto();
        model.addObject("assignmentDto",assignmentDto);
        return model;
    }

    @PostMapping(value = "/add")
    public ModelAndView add(@ModelAttribute("assignmentDto") AssignmentDto assignmentDto) {
        ModelAndView modelAndView = new ModelAndView("redirect:/patients/getAll");
        assignmentDto.setPatientId(id);
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
    public ModelAndView edit(@ModelAttribute("assignment") AssignmentDto assignmentDto) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("from controller"+assignmentDto.getName());
        modelAndView.setViewName("redirect:/");
        assignmentService.update(assignmentDto);
        return modelAndView;
    }

    @GetMapping(value = "/delete")
    public ModelAndView delete(HttpServletRequest request) {
        id = Long.parseLong(request.getParameter("id"));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/patients/getAll");
        assignmentService.deleteById(id);
        return modelAndView;
    }
}
