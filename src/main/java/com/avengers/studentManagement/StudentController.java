package com.avengers.studentManagement;
import org.springframework.web.bind.annotation.*;
import java.util.* ;

@RestController
public class StudentController {

    // Using map to store the data ;
    Map < Integer , Student > db = new HashMap<>() ;

    // get information using admission Id :-->>
    @GetMapping("/get_student_byId")
    public Student getStudent (@RequestParam("q") int admnNo ){
        if ( ! db.containsKey(admnNo)){
            System.out.println(admnNo+" Admission number is invalid!!");
            return null ;
        }
        return db.get(admnNo) ;
    }

    // add information :-->>
    @PostMapping("/add_student")
    public String addStudent (@RequestBody Student student ){
        int admnNo = student.getAdminNumber() ;
        db.put(admnNo , student );
        System.out.println("Student added successfully into your Database");
        return "Student added successfully into your Database" ;
    }

    // get information using Name:-->>
    @GetMapping("/get_student_byName")
    public Student getStudent (@RequestParam("q") String name ){
        int adminId = 0 ;
        for ( Map.Entry < Integer , Student > e : db.entrySet()){
            Student std = e.getValue() ;
            String sName = std.getName() ;
            if( sName.equals(name)){
                adminId = e.getKey() ;
            }
        }
        if ( adminId == 0 ){
            System.out.println(name+ " The Name you have entered does not exist");
            return null ;
        } else {
            return db.get(adminId) ;
        }
    }

    //Delete information using Id :-->>
    @DeleteMapping("/delete_student")
    public String deleteStudent ( @RequestParam("q") int admnNo ){
        if ( ! db.containsKey(admnNo)){
            return "Admission number is invalid!!" ;
        } else {
            db.remove(admnNo) ;
            return "Successfully remove from HashMap " ;
        }
    }

    // Update the Information :-->>
    @PutMapping("/update_student")
    public String updateStudent (@RequestParam("q") int admnNo , @RequestBody Student student ){
        if ( !db.containsKey(admnNo)){
            System.out.println("The admission Number that you have entered does not exist");
            return "does not exist" ;
        } else {
            db.put(admnNo , student) ;
            return "Your Name updated successfully" ;
        }
    }
}
