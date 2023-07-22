package net.erhnaks.sms.service.impl;

import net.erhnaks.sms.entity.Student;
import net.erhnaks.sms.repository.StudentRepository;
import net.erhnaks.sms.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        super();
        this.repository = repository;
    }

    @Override
    public List<Student> getAllStudents() {
        return repository.findAll();
    }
}
