package com.shop.shop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/")
public class ViewController {

    @GetMapping()
    public String homePage() {
        return "index";
    }

    @GetMapping("/user")
    public String userPage() {
        return "user_page";
    }

    @GetMapping("/manager")
    public String managerPage() {
        return "manager_page";
    }


}
