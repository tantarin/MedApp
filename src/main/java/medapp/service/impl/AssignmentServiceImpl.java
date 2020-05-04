package medapp.service.impl;

import medapp.constants.Constants;
import medapp.dao.api.AssignmentDAO;
import medapp.dao.api.EventDAO;
import medapp.dao.api.PatientDAO;
import medapp.dto.AssignmentDto;
import medapp.exceptions.DaoException;
import medapp.exceptions.ErrorService;
import medapp.exceptions.ServiceException;
import medapp.model.Assignment;
import medapp.model.Event;
import medapp.model.Patient;
import medapp.service.api.AssignmentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AssignmentServiceImpl implements AssignmentService {

    private static final Logger LOGGER = Logger.getLogger(AssignmentService.class);
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

    /**
     * convert AssignmentDto to Assignment and
     * transfer Assignment to dao.add().
     * Then generate Events by this Assignment.
     *
     * @param assignmentDto
     * @throws ServiceException
     */
    @Override
    @Transactional
    public boolean add(AssignmentDto assignmentDto) throws ServiceException {
        try {
            Patient patient = patientDAO.getById(assignmentDto.getPatientId());
            Assignment assignment = convertDtoToAssignment(new Assignment(), assignmentDto);
            assignment.setPatient(patientDAO.getById(assignmentDto.getPatientId()));
            Assignment a = assignmentDAO.add(assignment);
            generateEventsByAssId(a.getId());
            return true;
        } catch (DaoException e) {
            throw new ServiceException(ErrorService.DATABASE_EXCEPTION, e);
        }
    }

    /**
     * Convert AssignmentDto to Assignment
     * and transfer Assignment to dao.update().
     * Then generate events by this Assignment.
     *
     * @param assignmentDto
     */
    @Override
    @Transactional
    public void update(AssignmentDto assignmentDto) {
        Assignment assignment = assignmentDAO.getById(assignmentDto.getId());
        assignmentDAO.update(convertDtoToAssignment(assignment, assignmentDto));
        deleteEventsByAssId(assignment.getId());
        generateEventsByAssId(assignment.getId());
    }

    /**
     * Delete Assignment through dao and
     * delete all Events generated by this assignment.
     *
     * @param assignmentId
     */
    @Override
    @Transactional
    public void deleteById(Long assignmentId) {
        eventDAO.deleteByAssignmentId(assignmentId);
        assignmentDAO.delete(assignmentId);
    }

    /**
     * Return patient's id
     * of assignment id.
     *
     * @param assId
     * @return id
     */
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
     *get All assignments by Assignment id
     *
     */
    public List<AssignmentDto> getAll(Long id) {
        List<Assignment> assignmentList = assignmentDAO.getAll(id);
        List<AssignmentDto> assignmentDtos = new ArrayList<>();
        for(Assignment assignment : assignmentList){
            AssignmentDto assignmentDto = convertAssignmentToDto(assignment);
            assignmentDtos.add(assignmentDto);
        }
        return assignmentDtos;
    }

    @Override
    @Transactional
    /**
     * Get Assignment from dao and
     * convert AssignmentDto to Assignment
     *
     */
    public AssignmentDto getById(Long id) {
        Assignment ass = assignmentDAO.getById(id);
        return convertAssignmentToDto(ass);
    }

    /**
     * Delete Assignment by Id
     *
     * @param assId
     */
    @Override
    public void deleteEventsByAssId(Long assId) {
        eventDAO.deleteByAssignmentId(assId);
    }

    /**
     * Generate events by Assignment id.
     *
     * @param assId
     */
    @Transactional
    @Override
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
                if (a.getTime1() != null) {
                    Event event = new Event();
                    event.setAssignment(a);
                    event.setPatientName(patient.getLastName());
                    event.setStatus(Constants.EVENT_STATUS_SHEDULED);
                    event.setComments(Constants.DEFAULT_COMMENTS);
                    event.setDate(date.toString());
                    event.setTime(a.getTime1());
                    eventDAO.addEvent(event);
                }
                if (a.getTime2() != null) {
                    Event event = new Event();
                    event.setAssignment(a);
                    event.setPatientName(patient.getLastName());
                    event.setStatus(Constants.EVENT_STATUS_SHEDULED);
                    event.setComments(Constants.DEFAULT_COMMENTS);
                    event.setDate(date.toString());
                    event.setTime(a.getTime2());
                    eventDAO.addEvent(event);
                }
                if (a.getTime3() != null) {
                    Event event = new Event();
                    event.setAssignment(a);
                    event.setPatientName(patient.getLastName());
                    event.setStatus(Constants.EVENT_STATUS_SHEDULED);
                    event.setComments(Constants.DEFAULT_COMMENTS);
                    event.setDate(date.toString());
                    event.setTime(a.getTime3());
                    eventDAO.addEvent(event);
                }
            }
        }
    }

    public AssignmentDto convertAssignmentToDto(Assignment assignment){
        AssignmentDto assignmentDto = new AssignmentDto();
        assignmentDto.setId(assignment.getId());
        assignmentDto.setName(assignment.getName());
        assignmentDto.setType(assignment.getType());
        assignmentDto.setTimePattern(assignment.getTimePattern());
        assignmentDto.setWeeks(assignment.getTimePattern().split("  "));
        assignmentDto.setTime1(assignment.getTime1());
        assignmentDto.setTime2(assignment.getTime2());
        assignmentDto.setTime3(assignment.getTime3());
        assignmentDto.setDateFrom(assignment.getDateFrom());
        assignmentDto.setDateTo(assignment.getDateTo());
        assignmentDto.setDoze(assignment.getDoze());
        assignmentDto.setPeriod(assignment.getPeriod());
        return assignmentDto;
    }

    public Assignment convertDtoToAssignment(Assignment assignment, AssignmentDto assignmentDto){
        assignment.setType(assignmentDto.getType());
        assignment.setName(assignmentDto.getName());
        assignment.setPeriod(assignmentDto.getDateFrom() + " - " + assignmentDto.getDateTo());
        assignment.setDateFrom(assignmentDto.getDateFrom());
        assignment.setDateTo(assignmentDto.getDateTo());
        assignment.setDoze(assignmentDto.getDoze());
        assignment.setTime1(assignmentDto.getTime1());
        assignment.setTime2(assignmentDto.getTime2());
        assignment.setTime3(assignmentDto.getTime3());
        StringBuilder tp = new StringBuilder();
        for (String s : assignmentDto.getWeeks()) {
            tp.append(s);
            tp.append(" ");
        }
        assignment.setTimePattern(tp.toString());
        return assignment;
    }
}



