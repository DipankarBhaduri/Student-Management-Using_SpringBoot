package com.avengers.studentManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository ;

    public String addStudent ( Student student ){
        return studentRepository.addStudent(student) ;
    }

    public Student getStudent ( int id ){
       return  studentRepository.getStudent(id) ;
    }

    public Student getStudent (String name ){
        return studentRepository.getStudent(name) ;
    }

    public String deleteStudent ( int admnNo ){
        return studentRepository.deleteStudent(admnNo) ;
    }

    public String updateStudent ( int admnNo , int age ){
        return studentRepository.updateStudent(admnNo,age) ;
    }
}
