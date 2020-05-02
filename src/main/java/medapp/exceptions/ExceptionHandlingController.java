package medapp.exceptions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler({HttpClientErrorException.class})
    public String forbidden(HttpClientErrorException e) {
        return "accessDenied";
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest req, Exception ex) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", ex);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error");
        return mav;
    }
}