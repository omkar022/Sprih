package com.sprih.test.repo;

import com.sprih.test.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByGenderAndNationality(String gender, String nationality);

    List<Student> findByLanguagesIn(List<String> languages);

    List<Student> findByDobGreaterThan(String date);

    List<Student> findByHouse(String house);

    List<Student> findByNationality(String nationality);

    List<Student> findByGradeLevelAndEducationBoard(String gradeLevel, String educationBoard);

    List<Student> findByFeeStatusOrParentQualificationGreaterThan(String feeStatus, String parentQualification);

}
