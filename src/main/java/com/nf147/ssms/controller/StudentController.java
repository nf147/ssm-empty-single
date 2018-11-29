package com.nf147.ssms.controller;


import com.nf147.ssms.mapper.StudentMapper;
import com.nf147.ssms.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/stu")
public class StudentController {

    @Autowired
    StudentMapper studentMapper;

    @RequestMapping(method = RequestMethod.GET)
    public String home (Model model) {
        List<Student> students = studentMapper.selectAll();
        model.addAttribute("students", students);
        return "home";
    }
}
