package medapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/r")
public class MainController {
    @GetMapping
    public ModelAndView hello()
    {
        return new ModelAndView("welcomePage");
    }
}
