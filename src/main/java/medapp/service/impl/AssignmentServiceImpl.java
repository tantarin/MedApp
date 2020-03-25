package medapp.service.impl;

import medapp.dao.api.AssignmentDAO;
import medapp.dao.api.EventDAO;
import medapp.dao.api.PatientDAO;
import medapp.dto.AssignmentDto;
import medapp.model.Assignment;
import medapp.model.Event;
import medapp.model.Patient;
import medapp.service.api.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class AssignmentServiceImpl implements AssignmentService {

    private AssignmentDAO assignmentDAO;
    private PatientDAO patientDAO;
    private EventDAO eventDAO;

    @Autowired
    public void setEventDAO(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }

    @Autowired
    public void setAssignmentDAO(AssignmentDAO assignmentDAO) {
        this.assignmentDAO = assignmentDAO;
    }

    @Autowired
    public void setPatientDAO(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }

    @Override
    @Transactional
    public void add(AssignmentDto assignmentDto) {
        Patient p = patientDAO.getById(assignmentDto.getPatientId());
        Assignment a = new Assignment();
        a.setPatient(p);
        a.setId(assignmentDto.getId());
        a.setName(assignmentDto.getName());
        a.setType(assignmentDto.getType());
        assignmentDAO.add(a);
        for (String s : assignmentDto.getWeeks()) {
            if (s.equals("Monday")) assignmentDto.getWeeksInt().add(1);
            if (s.equals("Thuesday")) assignmentDto.getWeeksInt().add(2);
            if (s.equals("Wednesday")) assignmentDto.getWeeksInt().add(3);
            if (s.equals("Thursday")) assignmentDto.getWeeksInt().add(4);
            if (s.equals("Friday")) assignmentDto.getWeeksInt().add(5);
            if (s.equals("Saturday")) assignmentDto.getWeeksInt().add(6);
            if (s.equals("Sunday")) assignmentDto.getWeeksInt().add(7);
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        LocalDate startDate = LocalDate.parse(assignmentDto.getDateFrom(), formatter);
        LocalDate endDate = LocalDate.parse(assignmentDto.getDateTo(), formatter);
        for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1)) {
            if (assignmentDto.getWeeksInt().contains(date.getDayOfWeek().getValue())) {
                if (assignmentDto.getTime1() != null) {
                    Event event = new Event();
                    event.setDate(date.toString());
                    event.setTime(assignmentDto.getTime1());
                    event.setAssignmentId(assignmentDto.getId());
                    eventDAO.addEvent(event);
                }
                if (assignmentDto.getTime2() != null) {
                    Event event = new Event();
                    event.setDate(date.toString());
                    event.setTime(assignmentDto.getTime1());
                    event.setAssignmentId(assignmentDto.getId());
                    eventDAO.addEvent(event);
                }
                if (assignmentDto.getTime3() != null) {
                    Event event = new Event();
                    event.setDate(date.toString());
                    event.setTime(assignmentDto.getTime1());
                    event.setAssignmentId(assignmentDto.getId());
                    eventDAO.addEvent(event);
                }
            }
        }
    }

    @Override
    @Transactional
    public void update(AssignmentDto assignmentDto) {
       Assignment a = assignmentDAO.getById(assignmentDto.getId());
        a.setName(assignmentDto.getName());
        a.setType(assignmentDto.getType());
        assignmentDAO.update(a);
    }

    @Override
    @Transactional
    public void delete(Assignment assignment) {
        assignmentDAO.delete(assignment.getId());
    }

    @Override
    @Transactional
    public List<Assignment> getAll(Integer id) {
        return assignmentDAO.getAll(id);
    }

    @Override
    @Transactional
    public AssignmentDto getById(Long id) {
        AssignmentDto ad = new AssignmentDto();
        return ad;
    }
}


