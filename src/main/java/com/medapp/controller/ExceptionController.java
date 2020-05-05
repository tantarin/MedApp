package com.medapp.controller;

import com.medapp.exceptions.ControllerException;
import com.medapp.exceptions.DaoException;
import com.medapp.exceptions.EntityNotFoundException;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.events.EventException;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@ControllerAdvice
public class ExceptionController {

    private static final Logger LOG = Logger.getLogger(ExceptionController.class);

    public static final String DEFAULT_ERROR_VIEW = "error";

    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Entity Not Found!")
    @ExceptionHandler(EntityNotFoundException.class)
    public ModelAndView handleEntityNotFoundException(HttpServletRequest request, Exception ex){
        LOG.error(ex.getMessage()+Arrays.toString(ex.getStackTrace()));
        ModelAndView modelAndView = new ModelAndView(DEFAULT_ERROR_VIEW);
        modelAndView.addObject("url", request.getRequestURL());
        return modelAndView;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView defaultErrorHandler(Exception e) {
        LOG.error(e.getMessage()+ Arrays.toString(e.getStackTrace()));
        ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW);
        return mav;
    }

    @ExceptionHandler(ControllerException.class)
    public ModelAndView controllerErrorHandler(ControllerException e) {
        LOG.error(e.getMessage()+ Arrays.toString(e.getStackTrace()));
        ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW);
        return mav;
    }

    @ExceptionHandler(EventException.class)
    public ModelAndView eventErrorHandler(EventException e) {
        LOG.error(e.getMessage()+ Arrays.toString(e.getStackTrace()));
        ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW);
        return mav;
    }

    @ExceptionHandler(DaoException.class)
    public ModelAndView daoErrorHandler(DaoException e) {
        LOG.error(e.getMessage()+ Arrays.toString(e.getStackTrace()));
        ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW);
        return mav;
    }

}