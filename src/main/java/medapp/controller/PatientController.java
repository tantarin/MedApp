package medapp.controller;

import medapp.dto.PatientDto;
import medapp.model.Assignment;
import medapp.model.Patient;
import medapp.service.api.EventService;
import medapp.service.api.PatientService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/patients")
public class PatientController {

    private static final Logger LOGGER = Logger.getLogger(PatientController.class);

    @Autowired
    private PatientService patientService;

    @Autowired
    private EventService eventService;

    @GetMapping(value = "/add")
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView("addPatient");
        modelAndView.addObject("patient", new Patient());
        return modelAndView;
    }

    /**
     *
     * @param patient
     * @return
     */
    @PostMapping(value = "/add")
    public ModelAndView add(@ModelAttribute("patient") Patient patient) {
        ModelAndView modelAndView = new ModelAndView("redirect: getAll");
        patientService.add(patient);
        return modelAndView;
    }

    @GetMapping(value = "/delete")
    public ModelAndView delete(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        patientService.delete(id);
        return new ModelAndView("redirect:getAll");
    }

    @GetMapping("/getAll")
    public ModelAndView getAll() {
        List<PatientDto> listPatients = patientService.getAll();
        List<Patient> patients = new ArrayList<>();
        for(PatientDto patientDto:listPatients) {
            Patient patient = new Patient();
            patient.setId(patientDto.getId());
            patient.setFirstName(patientDto.getFirstName());
            patient.setDoctor(patientDto.getDoctor());
            patient.setEnsNumber(patientDto.getEnsNumber());
            patient.setLastName(patientDto.getLastName());
            patient.setStatus(patientDto.getStatus());
            patients.add(patient);
        }
        ModelAndView modelAndView = new ModelAndView("patients");
        modelAndView.addObject("patients", patients);
        modelAndView.addObject("patient", new Patient());
        return modelAndView;
    }

    @PostMapping("/getAll")
    public ModelAndView update(@ModelAttribute("patient") PatientDto patientDto, HttpServletRequest request) {
        Long patientId = Long.parseLong(request.getParameter("id"));
        patientDto.setId(patientId);
        ModelAndView modelAndView = new ModelAndView("redirect: getAll");
        patientService.update(patientDto);
        eventService.updateLastNameEvent(patientId);
        return modelAndView;
    }

    /**
     *
     * @param request
     * @return
     */
    @GetMapping("/assignments")
    public ModelAndView getAssignments(HttpServletRequest request) {
        Long id = Long.valueOf(request.getParameter("id"));
        List<Assignment> listAssignments = patientService.getAssignments(id);
        ModelAndView modelAndView = new ModelAndView("assignments");
        modelAndView.addObject("assignments", listAssignments);
        modelAndView.addObject("id",id);
        return modelAndView;
    }

    //TODO
    @GetMapping("/discharged")
    public ModelAndView dischargePatient(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        List<Assignment> listAssignments = patientService.getAssignments(id);
        ModelAndView modelAndView = new ModelAndView("assignments");
        modelAndView.addObject("assignments", listAssignments);
        modelAndView.addObject("id",id);
        return modelAndView;
    }

    @GetMapping(value = "/clear")
    public ModelAndView clear(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        patientService.clear(id);
        return new ModelAndView("redirect: getAll");
    }
}

