package ua.edu.nuos.lecture5jsf.repository;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;
import ua.edu.nuos.lecture5jsf.data.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
}
