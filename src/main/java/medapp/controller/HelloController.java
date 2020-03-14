package medapp.controller;

import medapp.model.Patient;
import medapp.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;


@RestController
@RequestMapping("/")
public class HelloController {

    private PatientService patientService;

    @Autowired(required=true)
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
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

    @GetMapping("/patients")
    public List<Patient> getCustomers() {
        return patientService.getPatients();
    }
}
