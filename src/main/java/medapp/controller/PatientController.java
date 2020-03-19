package medapp.controller;

import medapp.dto.PatientDto;
import medapp.model.Patient;
import medapp.service.api.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
@RequestMapping("/patients")
public class PatientController {

    private PatientService patientService;

    @Autowired(required=true)
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping(value = "/add")
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView("patient");
        modelAndView.addObject("patient", new Patient());
        return modelAndView;
    }

    @PostMapping(value = "/add")
    public ModelAndView add(@ModelAttribute("patient") Patient patient) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        patientService.add(patient);
        return modelAndView;
    }

    @GetMapping("/getAll")
    public List<PatientDto> getAll() {
        return patientService.getAll();
    }

    @GetMapping(value = "/delete")
    public ModelAndView delete() {
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("patient", new Patient());
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView delete(@ModelAttribute("patient") Patient patient) {
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        patientService.delete(patient.getId());
        return modelAndView;
    }

    @GetMapping(value = "/update")
    public ModelAndView update() {
        ModelAndView modelAndView = new ModelAndView("patient");
        modelAndView.addObject("patient", new Patient());
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute("patient") Patient patient) {
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        patientService.update(patient);
        return modelAndView;
    }
}

