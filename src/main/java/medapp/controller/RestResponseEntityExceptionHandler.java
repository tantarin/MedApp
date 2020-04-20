//package medapp.controller;
//
//import javassist.NotFoundException;
//import lombok.extern.slf4j.Slf4j;
//import medapp.MyException;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//import java.io.IOException;
//
//
//// TODO: 09.04.2020 annotation
//@Slf4j
//@ControllerAdvice
//public class RestResponseEntityExceptionHandler  extends ResponseEntityExceptionHandler {
//
//    @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
//    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
//        String bodyOfResponse = "This should be application specific";
//        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
//    }
//
//    @RequestMapping(value= "/exception/{type}", method= RequestMethod.GET)
//    public String exception(@PathVariable(name="type") String exception) throws IOException {
//
//        if (exception.equalsIgnoreCase("error")) {
//            throw new MyException("A1001", "This is a custom exception message.");
//        } else if (exception.equalsIgnoreCase("io-error")) {
//            throw new IOException();
//        } else {
//            return "patients";
//        }
//    }
//
//    @ExceptionHandler(MyException.class)
//    public ModelAndView handleMyException(MyException mex) {
//
//        ModelAndView model = new ModelAndView();
//        model.addObject("errCode", mex.getErrCode());
//        model.addObject("errMsg", mex.getErrMsg());
//        model.setViewName("generic_error");
//        return model;
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ModelAndView handleException(Exception ex) {
//
//        ModelAndView model = new ModelAndView();
//        model.addObject("errMsg", "This is a 'Exception.class' message.");
//        model.setViewName("generic_error");
//        return model;
//
//    }
//}
