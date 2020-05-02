package medapp;


import medapp.controller.EventController;
import medapp.converter.EventConverter;
import medapp.dao.api.EventDAO;
import medapp.service.impl.EventServiceImpl;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import javax.inject.Inject;

@RunWith(MockitoJUnitRunner.class)
public class EventServiceTest {

    @Inject
    EventDAO eventDAO;

    @InjectMocks
    EventServiceImpl eventService;
}
