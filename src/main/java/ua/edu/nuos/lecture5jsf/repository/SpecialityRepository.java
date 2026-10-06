package ua.edu.nuos.lecture5jsf.repository;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;
import ua.edu.nuos.lecture5jsf.data.Specialty;

@Repository
public interface SpecialityRepository extends CrudRepository<Specialty, Integer> {
}
