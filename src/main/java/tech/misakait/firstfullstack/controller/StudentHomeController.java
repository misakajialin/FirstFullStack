package tech.misakait.firstfullstack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author misakait
 */
@Controller
public class StudentHomeController {

    @RequestMapping("/student-home")
    public String studentHome() {
        return "/test.html";
    }
}
