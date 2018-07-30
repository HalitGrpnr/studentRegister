package com.ukid.studentRegister.controller;

import com.ukid.studentRegister.domain.Student;
import com.ukid.studentRegister.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/students")
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    // add page
    @GetMapping("/add")
    public String studentForm(Model model){
        model.addAttribute("student", new Student());
        return "student";
    }

    // formu post ederken
    @PostMapping
    public String studentSubmit(@ModelAttribute Student student){

        Student std;
        if (student.getId() != null){
            std = studentService.update(student.getId(), student);
        }
        else{
            student.setId(UUID.randomUUID().toString());
            std = studentService.add(student);
        }

        if (std != null)
            return "show";
        else
            return null;
    }
    // list page
    @GetMapping
    public String showAllUsers(Model model) {
        model.addAttribute("students", studentService.getAll());
        return "list";

    }

    //@RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    @GetMapping(value = "/{id}")
    public String showUser(@PathVariable("id") String id, Model model) {

        Student student = studentService.get(id);//retrieveStudent(id);
        if (student == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "User not found");
        }
        model.addAttribute("student", student);

        return "show";

    }

    @GetMapping("/edit/{id}")
    String editStudent(@PathVariable("id") String id, @ModelAttribute("student") Student std, Model model) {
        Student student = retrieveStudent(id);
        if (student == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "User not found");
        }
        model.addAttribute("student", student);
        return "edit";
    }

    @DeleteMapping("/delete/{id}")
    String deleteRegister(@PathVariable("id") String id, Model model){
        studentService.delete(id);
        return showAllUsers(model);
    }

    @PutMapping("/update")
    public String updateStudent1(@ModelAttribute("student") Student student){
        Student std = studentService.update(student.getId(), student);
        return "show";
    }

    private Student retrieveStudent(String studentKey) {
        Student student;
        try {
            student = studentService.get(studentKey);
        }
        catch (IllegalArgumentException e){
            student = studentService.getByStudentName(studentKey);
        }
        if (student == null) {
            //throw new NotFound("Student Not Found");
        }
        return student;
    }
}
