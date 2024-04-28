package com.ktech.a2zschool.controller;

import com.ktech.a2zschool.model.Holiday;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HolidayController {
    @GetMapping("/holidays")
    public String displayHolidays(@RequestParam(required = false)boolean festival,
                                  @RequestParam(required=false) boolean federal,
                                  Model model) {
        model.addAttribute("festival",festival);
        model.addAttribute("federal",federal);
        List<com.ktech.a2zschool.model.Holiday> holidays = Arrays.asList(
                new com.ktech.a2zschool.model.Holiday(" Jan 1 ","New Year's Day", com.ktech.a2zschool.model.Holiday.Type.FESTIVAL),
                new com.ktech.a2zschool.model.Holiday(" Nov 24 ","Thanksgiving Day", com.ktech.a2zschool.model.Holiday.Type.FESTIVAL),
                new com.ktech.a2zschool.model.Holiday(" Dec 25 ","Christmas", com.ktech.a2zschool.model.Holiday.Type.FESTIVAL),
                new com.ktech.a2zschool.model.Holiday(" Jan 17 ","Martin Luther King Jr. Day", com.ktech.a2zschool.model.Holiday.Type.FEDERAL),
                new com.ktech.a2zschool.model.Holiday(" July 4 ","Independence Day", com.ktech.a2zschool.model.Holiday.Type.FEDERAL),
                new com.ktech.a2zschool.model.Holiday(" Oct 31 ","Halloween", com.ktech.a2zschool.model.Holiday.Type.FESTIVAL),
                new com.ktech.a2zschool.model.Holiday(" Sep 5 ","Labor Day", com.ktech.a2zschool.model.Holiday.Type.FEDERAL),
                new com.ktech.a2zschool.model.Holiday(" Nov 11 ","Veterans Day", com.ktech.a2zschool.model.Holiday.Type.FEDERAL)
        );
        Holiday.Type[] types = Holiday.Type.values();
        for(Holiday.Type type:types){
            model.addAttribute(type.toString(), (holidays.stream().filter(holiday -> holiday.getType().equals(type)).collect(Collectors.toList())));
        }
        return "holidays.html";
    }
}
