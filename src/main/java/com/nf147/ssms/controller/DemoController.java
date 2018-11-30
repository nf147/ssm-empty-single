package com.nf147.ssms.controller;


import com.nf147.ssms.demo_formatter.Person;
import com.nf147.ssms.demo_formatter.PersonFromId;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/ddd")
@RestController
public class DemoController {
    @RequestMapping(method = RequestMethod.GET)
    public Person home (@RequestParam(value = "id", required = false)
                            @PersonFromId("en") Person person) {
        return person;
    }
}
