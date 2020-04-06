package medapp.service.impl;

import medapp.dao.api.AssignmentDAO;
import medapp.dao.api.EventDAO;
import medapp.dao.api.PatientDAO;
import medapp.dto.AssignmentDto;
import medapp.model.Assignment;
import medapp.model.Event;
import medapp.model.Patient;
import medapp.service.api.AssignmentService;
import medapp.service.api.EventService;
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
        //get Patient by Dto id
        Patient p = patientDAO.getById(assignmentDto.getPatientId());
        //dto to ass
        Assignment a = new Assignment();
        a.setPatient(p);
        //a.setId(assignmentDto.getId());
        a.setName(assignmentDto.getName());
        a.setType(assignmentDto.getType());
        //create period
        a.setPeriod(assignmentDto.getDateFrom()+" - "+assignmentDto.getDateTo());
        a.setDoze(assignmentDto.getDoze());
        StringBuilder tp = new StringBuilder();
        for(String s:assignmentDto.getWeeks()){
            tp.append(s);
            tp.append(" ");
        }
        a.setTimePattern(tp.toString());
        a.setTime1(assignmentDto.getTime1());
        a.setTime2(assignmentDto.getTime2());
        a.setTime3(assignmentDto.getTime3());
        a.setDateFrom(assignmentDto.getDateFrom());
        a.setDateTo(assignmentDto.getDateTo());
        assignmentDAO.add(a);
        generateEventsByAssId(a.getId());
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
    public void deleteById(Long assignmentId) {
        eventDAO.deleteByAssignmentId(assignmentId);
        assignmentDAO.delete(assignmentId);
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
        assignmentDto.setTime1(ass.getTime1());
        assignmentDto.setTime2(ass.getTime2());
        assignmentDto.setTime3(ass.getTime3());
        assignmentDto.setDateFrom(ass.getDateFrom());
        assignmentDto.setDateTo(ass.getDateTo());
        return assignmentDto;
    }

    @Transactional
    public void generateEventsByAssId(Long assId) {
        Assignment a = assignmentDAO.getById(assId);
        Patient patient = a.getPatient();
        List<String> weeks = Arrays.asList(a.getTimePattern().split(" "));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        LocalDate startDate = LocalDate.parse(a.getDateFrom(), formatter);
        LocalDate endDate = LocalDate.parse(a.getDateTo(), formatter);
        //идем по всем дням от и до
        for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1)) {
            //если в этом периоде день недели совпадает с нужным
            if (weeks.contains(String.valueOf(date.getDayOfWeek().getValue()))) {
                Event event = new Event();
                //если время было выбрано
                if (a.getTime1() != null) {
                    event.setDate(date.toString());
                    event.setTime(a.getTime1());
                }
                if (a.getTime2() != null) {
                    event.setDate(date.toString());
                    event.setTime(a.getTime2());
                }
                if (a.getTime3() != null) {
                    event.setDate(date.toString());
                    event.setTime(a.getTime3());
                }
                event.setAssignment(a);
                event.setPatientName(patient.getLastName());
                eventDAO.addEvent(event);
            }
        }
    }
}



