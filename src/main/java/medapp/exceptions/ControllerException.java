package medapp.exceptions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;


public class ControllerException extends Exception {

    private final ErrorController error;

    public ControllerException(ErrorController error, Throwable cause) {
        super(error.getMessage(), cause);
        this.error = error;
    }

    public ControllerException(ErrorController error) {
        this.error = error;
    }

    public ErrorController getError() {
        return error;

    }
}