package com.medapp.controller;

import com.medapp.dto.AssignmentDto;
import com.medapp.dto.PatientDto;
import com.medapp.exceptions.ControllerException;
import com.medapp.model.Patient;
import com.medapp.service.api.EventService;
import com.medapp.service.api.PatientService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jms.JMSException;
import javax.servlet.http.HttpServletRequest;
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

    @PostMapping(value = "/add")
    public ModelAndView add(@ModelAttribute("patient") Patient patient) throws ControllerException {
        LOGGER.info("Post patients/add "+patient);
        if(patient == null) throw new ControllerException("patient null");
        ModelAndView modelAndView = new ModelAndView("redirect: getAll");
        patientService.add(patient);
        return modelAndView;
    }

    @GetMapping(value = "/disharge")
    public ModelAndView disharge(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        patientService.disharge(id);
        return new ModelAndView("redirect:getAll");
    }

    @GetMapping("/getAll")
    public ModelAndView getAll() {
        List<PatientDto> listPatients = patientService.getAll();
        ModelAndView modelAndView = new ModelAndView("patients");
        modelAndView.addObject("patients", listPatients);
        modelAndView.addObject("patient", new Patient());
        return modelAndView;
    }

    @PostMapping("/getAll")
    public ModelAndView update(@ModelAttribute("patient") PatientDto patientDto, HttpServletRequest request) throws JMSException {
        Long patientId = Long.parseLong(request.getParameter("id"));
        patientDto.setId(patientId);
        ModelAndView modelAndView = new ModelAndView("redirect: getAll");
        patientService.update(patientDto);
        eventService.updateLastNameEvent(patientId);
        return modelAndView;
    }

    /**
     * Get assignments of patient.
     *
     * @param request
     * @return
     */
    @GetMapping("/assignments")
    public ModelAndView getAssignments(HttpServletRequest request) throws Exception {
        Long id = Long.valueOf(request.getParameter("id"));
        LOGGER.info("Get patients/assignments?id="+id);
        List<AssignmentDto> listAssignments = patientService.getAssignments(id);
        eventService.sendUpdatedEvents();
        ModelAndView modelAndView = new ModelAndView("assignments");
        modelAndView.addObject("assignments", listAssignments);
        modelAndView.addObject("id", id);
        return modelAndView;
    }

    /**
     * Change patient status and delete all assignments
     * of this patient.
     *
     * @param request
     * @return ModelAndView
     */
    @GetMapping("/discharged")
    public ModelAndView dischargePatient(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        List<AssignmentDto> listAssignments = patientService.getAssignments(id);
        ModelAndView modelAndView = new ModelAndView("assignments");
        modelAndView.addObject("assignments", listAssignments);
        modelAndView.addObject("id", id);
        return modelAndView;
    }

    /**
     * Delete patient from database.
     * @param request
     * @return ModelAndView
     */
    @GetMapping(value = "/clear")
    public ModelAndView clear(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        patientService.clear(id);
        return new ModelAndView("redirect: getAll");
    }
}

