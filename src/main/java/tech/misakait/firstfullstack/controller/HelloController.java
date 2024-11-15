package tech.misakait.firstfullstack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author misakait
 */
@Controller
public class HelloController {
    @RequestMapping("/")
    public String rootWeb() {
        return "/index.html";
    }
}
