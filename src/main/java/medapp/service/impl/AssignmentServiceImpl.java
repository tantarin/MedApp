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
import java.util.Arrays;
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
        StringBuilder tp = new StringBuilder();
        for(String s:assignmentDto.getWeeks()){
            tp.append(s);
            tp.append(" ");
        }
        a.setTimePattern(tp.toString());
        assignmentDAO.add(a);
        //add event TODO
        List<String> weeks = Arrays.asList(assignmentDto.getWeeks());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        LocalDate startDate = LocalDate.parse(assignmentDto.getDateFrom(), formatter);
        LocalDate endDate = LocalDate.parse(assignmentDto.getDateTo(), formatter);
        Event event = new Event();
        for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1)) {
            if (weeks.contains(String.valueOf(date.getDayOfWeek().getValue()))) {
                if (assignmentDto.getTime1() != null) {
                    event.setDate(date.toString());
                    event.setTime(assignmentDto.getTime1());
                    event.setPatient(p);
                }
                if (assignmentDto.getTime2() != null) {
                    event.setDate(date.toString());
                    event.setTime(assignmentDto.getTime1());
                    event.setPatient(p);
                }
                if (assignmentDto.getTime3() != null) {
                    event.setDate(date.toString());
                    event.setTime(assignmentDto.getTime1());
                    event.setPatient(p);
                }
            }
        }
        event.setAssignment(assignmentDto.getName());
        eventDAO.addEvent(event);
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
    public void deleteById(Long id) {
        assignmentDAO.delete(id);
    }

    @Override
    @Transactional
    public Long getPatientId(Long assId) {
        Assignment assignment = assignmentDAO.getById(assId);
        Patient patient = assignment.getPatient();
        return patient.getId();
    }

    @Override
    @Transactional
    /**
     *
     */
    public List<Assignment> getAll(Long id) {
        return assignmentDAO.getAll(id);
    }

    @Override
    @Transactional
    /**
     *
     */
    public AssignmentDto getById(Long id) {
        Assignment ass = assignmentDAO.getById(id);
        AssignmentDto assignmentDto = new AssignmentDto();
        assignmentDto.setId(ass.getId());
        assignmentDto.setName(ass.getName());
        assignmentDto.setType(ass.getType());
        assignmentDto.setWeeks(ass.getTimePattern().split("  "));
        assignmentDto.setTime1(ass.getTime());
        assignmentDto.setDateFrom(ass.getDateFrom());
        assignmentDto.setDateTo(ass.getDateTo());
        return assignmentDto;
    }
}


