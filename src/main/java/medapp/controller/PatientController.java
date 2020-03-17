package medapp.controller;

import medapp.dto.PatientDto;
import medapp.model.Assignment;
import medapp.model.Patient;
import medapp.service.api.AssignmentService;
import medapp.service.api.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/")
public class PatientController {

    private PatientService patientService;
    private AssignmentService assignmentService;

    @Autowired(required=true)
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    @Autowired(required=true)
    public void setAssignmentService(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @GetMapping("/p")
    public String userForm(Model model) {
        return "input";
    }

    @GetMapping(value = "/")
    public ModelAndView hello()
    {
        ModelAndView model = new ModelAndView("hello");
        model.setViewName("hello");
        model.addObject("message", "Spring 3 MVC - Hello World");
        return model;
    }

    @GetMapping(value = "/addPatient")
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addPatient");
        modelAndView.addObject("patient", new Patient());
        return modelAndView;
    }

    @PostMapping(value = "/addPatient")
    public ModelAndView addPatient(@ModelAttribute("patient") Patient patient) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        patientService.addPatient(patient);
        return modelAndView;
    }

    @GetMapping(value = "/addAssignment")
    public ModelAndView addAssignment(@RequestParam("id") int id) {
        ModelAndView model = new ModelAndView();
        model.setViewName("addAssignment");
        PatientDto p = patientService.getPatient(id);
        model.addObject("assignment", p.getAssignments());
        return model;
    }

    @RequestMapping(value = "/addAssignment", method = RequestMethod.POST)
        public ModelAndView getRecords(@ModelAttribute("assignment") Assignment assignment) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        assignmentService.addAssignment(assignment);
        return modelAndView;
    }

    @GetMapping("/patients")
    public List<PatientDto> getCustomers() {
        return patientService.getPatients();
    }
    }

