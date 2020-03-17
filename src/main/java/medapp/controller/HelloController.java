package medapp.controller;

import medapp.dto.PatientDto;
import medapp.model.Assignment;
import medapp.model.Patient;
import medapp.service.AssignmentService;
import medapp.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/")
public class HelloController {

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
    public ModelAndView addAssignment() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addAssignment");
        modelAndView.addObject("assignment", new Assignment());
        return modelAndView;
    }

//        @PostMapping(value = "/addAssignment")
//        public ModelAndView assignment (@ModelAttribute("assignment") Assignment assignment){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("redirect:/");
//        assignmentService.addAssignment(assignment);
//        return modelAndView;
//    }


    @GetMapping("/patients")
    public List<Patient> getCustomers() {
        return patientService.getPatients();

    }

    @RequestMapping(value = "/addAssignment", method = RequestMethod.POST)
        public String getRecords(Model model) {
        List<Patient> patients = patientService.getPatients();
        List<PatientDto> patientsDTO = new ArrayList<>();
        for (Patient patient: patients) {
            PatientDto dto = new PatientDto();
            dto.setFirst_name(patient.getFirstName());
            dto.setLast_name(patient.getLastName());
            dto.setAssignments(assignmentService.getAll(patient.getId()));
            patientsDTO.add(dto);
            }
            model.addAttribute("patients", patientsDTO);
            return "assignment";
        }
    }

