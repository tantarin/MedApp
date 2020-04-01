package medapp.controller;

import medapp.dto.PatientDto;
import medapp.model.Assignment;
import medapp.model.Patient;
import medapp.service.api.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/patients")
public class PatientController {

    private PatientService patientService;

    @Autowired(required=true)
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    /**
     * 
     * @return
     */
    @GetMapping(value = "/add")
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView("addPatient");
        modelAndView.addObject("patient", new Patient());
        return modelAndView;
    }

    @PostMapping(value = "/add")
    public ModelAndView add(@ModelAttribute("patient") Patient patient) {
        ModelAndView modelAndView = new ModelAndView("redirect:/patients/getAll");
        patientService.add(patient);
        return modelAndView;
    }

    @GetMapping(value = "/update")
    public ModelAndView update() {
        ModelAndView modelAndView = new ModelAndView("editPatient");
        modelAndView.addObject("patient", new Patient());
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute("patient") PatientDto patientDto) {
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        patientService.update(patientDto);
        return modelAndView;
    }

    @GetMapping(value = "/delete")
    public ModelAndView delete() {
        ModelAndView modelAndView = new ModelAndView("redirect:/patients/getAll");
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView delete(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("redirect:userList");
        Long id = Long.parseLong(request.getParameter("id"));
        patientService.delete(id);
        return modelAndView;
    }

    @GetMapping("/getAll")
    public ModelAndView getAll() {
        List<PatientDto> listPatients = patientService.getAll();
        for(PatientDto d: listPatients) System.out.println("array patient status "+d.getStatus()+" ");
        List<Patient> patients = new ArrayList<>();
        for(PatientDto patientDto:listPatients) {
            Patient patient = new Patient();
            patient.setId(patientDto.getId());
            patient.setFirstName(patientDto.getFirstName());
            patient.setLastName(patientDto.getLastName());
            patient.setStatus(patientDto.getStatus());
            patients.add(patient);
        }
        ModelAndView modelAndView = new ModelAndView("userList");
        modelAndView.addObject("patients", patients);
        return modelAndView;
    }



    @GetMapping("/assignments")
    public ModelAndView postAssignments(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        List<Assignment> listAssignments = patientService.getAssignments(id);
        ModelAndView modelAndView = new ModelAndView("assignments");
        modelAndView.addObject("assignments", listAssignments);
        modelAndView.addObject("id",id);
        return modelAndView;
    }
}

