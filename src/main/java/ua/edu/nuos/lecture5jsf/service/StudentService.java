package ua.edu.nuos.lecture5jsf.service;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import ua.edu.nuos.lecture5jsf.data.Student;
import ua.edu.nuos.lecture5jsf.repository.SpecialityRepository;
import ua.edu.nuos.lecture5jsf.repository.StudentRepository;

import java.util.List;

@Named
@RequestScoped
public class StudentService {

    @Inject
    private StudentRepository studentRepository;

    @Inject
    private SpecialityRepository specialityRepository;

    @Getter
    @Setter
    private Student student = new Student();

    @Getter
    @Setter
    private Integer selectedSpecialityId;

    public List<Student> getStudents() {
        return studentRepository.findAll().toList();
    }

    public void addStudent() {
        if (student.getAge() < 18) return;
        if (selectedSpecialityId != null) {
            specialityRepository.findById(selectedSpecialityId)
                    .ifPresent(student::setSpecialty);
        }
        studentRepository.save(student);
        student = new Student();
        selectedSpecialityId = null;
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
