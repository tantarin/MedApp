package medapp;


import medapp.controller.EventController;
import static org.junit.Assert.assertEquals;
import medapp.dao.api.EventDAO;
import medapp.model.Event;
import medapp.service.impl.EventServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import javax.inject.Inject;
import javax.jms.JMSException;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EventServiceTest {

    private static Event event;

    @Inject
    EventDAO eventDAO;

    @InjectMocks
    EventServiceImpl eventService;

    @Before
    public void init(){
        event = new Event(1L, "Ivanov");
    }

    @Test
    public void addEventTest(){
        eventService.addEvent(event);
        verify(eventDAO, times(1)).addEvent(event);
    }

    @Test
    public void getEventTest(){
        eventService.getById(1L);
        assertEquals("Ivanov", event.getPatientName());
    }

    @Test
    public void deleteEventTest(){
        eventDAO.deleteByAssignmentId(1L);
        when(eventDAO.getByAssignmentId(1L)).thenReturn(null);
    }

    @Test
    public void updateEventTest(){
        //assertNotNull();
        //assertEquals();
    }

    public void getAllEventsTest() throws JMSException {
        when(eventDAO.getAll()).thenReturn(new ArrayList<>());
        eventService.getAll();
        verify(eventDAO).getAll();
    }
}
