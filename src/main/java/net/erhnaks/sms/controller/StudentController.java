package net.erhnaks.sms.controller;

import net.erhnaks.sms.entity.Student;
import net.erhnaks.sms.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    private StudentService service;

    public StudentController(StudentService service) {
        super();
        this.service = service;
    }

    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", service.getAllStudents());
        return "students";
    }

    @GetMapping("students/new")
    public String newStudent(Model model) {
        // Create a student object to hold student form data.
        Student student = new Student();

        model.addAttribute("student", student);

        return "created";
    }


}
