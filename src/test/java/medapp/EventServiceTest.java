package medapp;


import medapp.controller.EventController;
import medapp.converter.EventConverter;
import medapp.dao.api.EventDAO;
import medapp.model.Event;
import medapp.service.impl.EventServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import javax.inject.Inject;

@RunWith(MockitoJUnitRunner.class)
public class EventServiceTest {

    private static Event event;

    @Inject
    EventDAO eventDAO;

    @InjectMocks
    EventServiceImpl eventService;

    @Before
    public void init(){
        event = new Event();

    }

    @Test
    public void addEventTest(){
        //assertNotNull();
        //assertEquals();
    }

    @Test
    public void getEventTest(){
        //assertNotNull();
        //assertEquals();
    }

    @Test
    public void deleteEventTest(){
        //assertNotNull();
        //assertEquals();
    }

    @Test
    public void updateEventTest(){
        //assertNotNull();
        //assertEquals();
    }
}
