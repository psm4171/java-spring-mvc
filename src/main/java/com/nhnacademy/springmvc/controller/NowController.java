package com.nhnacademy.springmvc.controller;

import java.util.Date;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NowController {
    @GetMapping("/now")
   //  Map 형태로
    public String now(Map<String, String> model) {
        model.put("time", String.valueOf(new Date()));
        return "now";
    }

    // 모델로 변경
//    public String now(Model model){
//         model.addAttribute("time", String.valueOf(new Date()));
//         return "now";
//    }

    @GetMapping("/now/{nick}")
    public String now(@RequestParam(name="name") String name,
                      @PathVariable(name="nick") String nick,
                      Model model){

        model.addAttribute("time", String.valueOf(new Date()));
        model.addAttribute("name", name);
        model.addAttribute("nick", nick);

        return "now";
    }
}


