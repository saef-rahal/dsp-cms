package com.dsp.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Saef Rahal on 5/25/2021.
 */
@Controller
public class AuthController {

    @GetMapping("/login")
    public String getLogin(){
        return "Login";
    }

}
