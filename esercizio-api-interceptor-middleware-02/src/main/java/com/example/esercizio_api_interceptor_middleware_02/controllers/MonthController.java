package com.example.esercizio_api_interceptor_middleware_02.controllers;

import com.example.esercizio_api_interceptor_middleware_02.entities.Month;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/months")
public class MonthController {


    @GetMapping
    public Month getmonth(@RequestAttribute("month")Month month){
        return month;
    }

}
