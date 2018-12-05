package com.nf147.ssms.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nf147.ssms.demo_formatter.Person;
import com.nf147.ssms.demo_formatter.PersonFromId;
import com.nf147.ssms.entity.Student;
import com.nf147.ssms.exception.ConnException;
import com.nf147.ssms.service.DemoService;
import com.nf147.ssms.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/ddd")
@RestController
@CrossOrigin
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping(method = RequestMethod.GET)
    public Person home(@RequestParam(value = "id", required = false)
                       @PersonFromId("en") Person person) {
        return person;
    }

    @GetMapping("/code")
    public Result<Student> code() {
        Result<Student> result = new Result<>();
        try {
            Student student = demoService.getStudent();
            Page<Student> pager = PageHelper.startPage(3, 10);
            return result.setCode(200).setData(student).setPager(pager);
        } catch (ConnException e) {
            return result.setCode(402).setErrMsg(e.getMessage() + " 其他的东西");
        } catch (Exception e) {
            return result.setCode(407).setError(e);
        }
    }
    @GetMapping("/code2")
    public Result<Student> code2() {
        try {
            Student student = demoService.getStudent();
            Page<Student> pager = PageHelper.startPage(3, 10);
            return new Result<>(200, student, pager);
        } catch (ConnException e) {
            return new Result<>(402, e.getMessage());
        } catch (Exception e) {
            return new Result<>(407, e);
        }
    }
}
