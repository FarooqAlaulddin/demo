package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class studentService {

    private final studentRepository studentRepository;

    @Autowired
    public studentService(studentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<student> getStudent(){
        return studentRepository.findAll();
    }


    public void addNewStudent(student student) {
        Optional<student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("EMAIL TAKEN");
        }
        studentRepository.save(student);
        System.out.println(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists =  studentRepository.existsById(studentId);
        if(!exists) { throw new IllegalStateException("student with id " + studentId + " does not exists"); }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        student student =  studentRepository.findById(studentId)
                .orElseThrow(()-> new IllegalStateException("student with id " + studentId + " does not exists"));

        if(name!=null && name.length() > 0 && !Objects.equals(student.getName(),name)){
            student.setName(name);
        }

        if(email!=null && email.length() > 0 && !Objects.equals(student.getEmail(),email)){
            Optional<student> studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("EMAIL TAKEN");
            }
            student.setEmail(email);
        }

    }
}
