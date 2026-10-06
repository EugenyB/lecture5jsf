package ua.edu.nuos.lecture5jsf.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import ua.edu.nuos.lecture5jsf.data.Specialty;
import ua.edu.nuos.lecture5jsf.data.Student;
import ua.edu.nuos.lecture5jsf.repository.SpecialityRepository;

import java.util.Collections;
import java.util.List;

@Named
@ApplicationScoped
public class SpecialityService {

    @Inject
    private SpecialityRepository specialityRepository;

    @Getter
    @Setter
    private Specialty specialty = new Specialty();

    @Getter
    @Setter
    private Integer selectedSpecialityId;

    public List<Specialty> getSpecialities() {
        return specialityRepository.findAll().toList();
    }

    public void addSpeciality() {
        if (specialty.getTitle() == null || specialty.getTitle().isBlank()) return;
        specialityRepository.save(specialty);
        specialty = new Specialty();
    }

    public void delete(Integer id) {
        specialityRepository.deleteById(id);
        if (id.equals(selectedSpecialityId)) {
            selectedSpecialityId = null;
        }
    }

    public List<Student> getStudentsOfSelected() {
        if (selectedSpecialityId == null) return Collections.emptyList();
        return specialityRepository.findById(selectedSpecialityId)
                .map(Specialty::getStudents)
                .orElse(Collections.emptyList());
    }
}
