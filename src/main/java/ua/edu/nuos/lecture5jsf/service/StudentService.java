package ua.edu.nuos.lecture5jsf.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import ua.edu.nuos.lecture5jsf.data.Student;
import ua.edu.nuos.lecture5jsf.repository.StudentRepository;

import java.util.List;

@Named
@ApplicationScoped
public class StudentService {

    @Inject
    private StudentRepository studentRepository;

    @Getter
    @Setter
    private Student student = new Student();

    public List<Student> getStudents() {
        return studentRepository.findAll().toList();
    }

    public void addStudent() {
        if (student.getAge() < 18) return;
        studentRepository.save(student);
        student = new Student();
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
