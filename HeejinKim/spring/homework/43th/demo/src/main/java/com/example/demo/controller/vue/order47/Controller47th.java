package com.example.demo.controller.vue.order47;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/47th/rpgPlay")
public class Controller47th {

    @GetMapping("/tactics")
    public String getSecondTactics(){

        log.info("getSecondTactics()");

        return "/vue/47th/tactics";

    }



}
