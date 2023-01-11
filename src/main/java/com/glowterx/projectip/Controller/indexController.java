package com.glowterx.projectip.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {

    @RequestMapping(value = "/")
    public String firstpage() {
        return "fitnesslogin";
    }

    @RequestMapping(value = "/index")
    public String index() {
        return "fitnesslogin";
    }
}
