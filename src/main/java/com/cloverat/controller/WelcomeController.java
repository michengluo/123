package com.cloverat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cloverat 2019/6/11
 */
@Controller
public class WelcomeController extends AbstractController {

    @RequestMapping("/*")
    public String home() {
        return "index";
    }
}
