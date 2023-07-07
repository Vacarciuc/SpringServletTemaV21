package com.example.SpringServletTemaV21.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GeneralController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        System.out.println("hello index");
        return "index";
    }
}
