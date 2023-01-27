package com.avengers.studentManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.* ;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService ;

    // get information using admission Id :-->>
    @GetMapping("/get_student_byId")
    public ResponseEntity getStudent (@RequestParam("q") int admnNo ){
        Student student =  studentService.getStudent(admnNo);
        return new ResponseEntity<>( student , HttpStatus.FOUND) ;
    }

    // add information :-->>
    @PostMapping("/add_student")
    public ResponseEntity addStudent (@RequestBody Student student ){
        String response = studentService.addStudent(student);
        return new ResponseEntity<>( response , HttpStatus.CREATED) ;
    }

    // get information using Name:-->>
    @GetMapping("/get_student_byName")
    public ResponseEntity getStudent (@RequestParam("q") String name ){
        Student student = studentService.getStudent(name);
        return new ResponseEntity<>( student , HttpStatus.FOUND) ;
    }

    //Delete information using Id :-->>
    @DeleteMapping("/delete_student/{id}")
    public ResponseEntity deleteStudent ( @PathVariable("id") int admnNo ){
        String response =  studentService.deleteStudent(admnNo) ;
        if ( response.equals("Admission number is invalid!!")){
            return new ResponseEntity<>( response , HttpStatus.NOT_FOUND) ;
        } else {
            return new ResponseEntity<>( response , HttpStatus.FOUND) ;
        }
    }

    // Update the Information :-->>
    @PutMapping("/update_student")
    public ResponseEntity updateStudent (@RequestParam("q") int admnNo , @RequestParam("a") int age ){
        String response = studentService.updateStudent(admnNo,age);
        if ( response.equals(null)){
            return new ResponseEntity<>("Invalid id number" , HttpStatus.BAD_REQUEST) ;
        } else {
            return new ResponseEntity<>( response , HttpStatus.ACCEPTED);
        }
    }
}
