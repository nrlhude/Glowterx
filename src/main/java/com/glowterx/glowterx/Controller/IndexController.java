package com.glowterx.glowterx.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping(value = "/")
    public String firstpage() {
        return "index";
    }

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }
}
