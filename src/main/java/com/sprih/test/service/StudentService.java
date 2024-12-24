package com.sprih.test.service;

import com.sprih.test.entity.Student;
import com.sprih.test.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> filterByGenderAndNationality(String gender, String nationality) {
        return studentRepository.findByGenderAndNationality(gender, nationality);
    }

    public List<Student> filterByLanguages(List<String> languages) {
        return studentRepository.findByLanguagesIn(languages);
    }

    public List<Student> filterByDob(String date) {
        return studentRepository.findByDobGreaterThan(date);
    }


    public List<Student> getStudentsByHouse(String house) {
        return studentRepository.findByHouse(house);
    }

    public List<Student> getStudentsByNationality(String nationality) {
        return studentRepository.findByNationality(nationality);
    }
    public Map<String, List<Student>> groupByHouse(List<Student> students) {
        return students.stream().collect(Collectors.groupingBy(Student::getHouse));
    }

    public Map<String, List<Student>> groupByNationality(List<Student> students) {
        return students.stream().collect(Collectors.groupingBy(Student::getNationality));
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

}
