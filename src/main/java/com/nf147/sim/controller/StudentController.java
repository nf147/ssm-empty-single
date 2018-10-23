package com.nf147.sim.controller;


import com.nf147.sim.mapper.StudentMapper;
import com.nf147.sim.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class StudentController {

    @Autowired
    StudentMapper studentMapper;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home (Model model) {
        List<Student> students = studentMapper.selectAll();
        model.addAttribute("students", students);
        return "home";
    }
}
