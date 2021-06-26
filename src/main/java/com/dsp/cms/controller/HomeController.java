package com.dsp.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Saef Rahal on 5/27/2021.
 */
@Controller
@RequestMapping("/enthaply")
public class HomeController {

    @GetMapping("/home")
    public String getHomne() {
        return "Home";
    }

    @GetMapping("/index")
    public String getHomeDesign(){
        return "Index";
    }

}
