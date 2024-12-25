package com.sprih.test.controller;


import com.sprih.test.entity.Student;
import com.sprih.test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping("/filter/gender-and-nationality")
    public List<Student> filterByGenderAndNationality(@RequestParam String gender, @RequestParam String nationality) {
        return studentService.filterByGenderAndNationality(gender, nationality);
    }


    @GetMapping("/filter/languages")
    public List<Student> filterByLanguages(@RequestParam List<String> languages) {
        return studentService.filterByLanguages(languages);
    }


    @GetMapping("/filter/dob")
    public List<Student> filterByDob(@RequestParam String dob) {
        return studentService.filterByDob(dob);
    }



    @GetMapping("/group/house")
    public Map<String, List<Student>> groupByHouse(@RequestParam String house) {
        List<Student> students = studentService.getStudentsByHouse(house);
        return studentService.groupByHouse(students);
    }



    @GetMapping("/group/nationality")
    public Map<String, List<Student>> groupByNationality(@RequestParam String nationality) {
        List<Student> students = studentService.getStudentsByNationality(nationality);
        return studentService.groupByNationality(students);
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student savedStudent = studentService.saveStudent(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @GetMapping("/students/secondary/icse")
    public List<Student> getSecondaryStudentsByICSEBoard() {
        return studentService.filterSecondaryStudentsByBoard("ICSE");
    }

    @GetMapping("/students/filter")
    public List<Student> getStudentsByFeeStatusOrParentQualification(
            @RequestParam String feeStatus,
            @RequestParam String minParentQualification
    ) {
        return studentService.filterByFeeStatusOrParentQualification(feeStatus, minParentQualification);
    }
}
