package net.erhnaks.sms.controller;

import net.erhnaks.sms.entity.Student;
import net.erhnaks.sms.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    private final StudentService service;

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

    @PostMapping("/students")
    public String createStudent(@ModelAttribute("student") Student student) {
        service.saveStudent(student);

        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", service.getStudentById(id));
        return "edit_student";
    }

    @PostMapping({"/students/{id}"})
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {

        // First get the student from the database by id:

        Student existingStudent = service.getStudentById(id);

        existingStudent.setId(student.getId());
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setAge(student.getAge());
        existingStudent.setEmail(student.getEmail());

        // updated student;
        service.updateStudent(existingStudent);

        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id) {

        service.deleteStudent(id);

        return "redirect:/students";

    }


}
