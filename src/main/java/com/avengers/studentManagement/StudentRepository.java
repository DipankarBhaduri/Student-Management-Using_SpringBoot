package com.avengers.studentManagement;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {

    // Using map to store the data ;
    Map< Integer , Student > db = new HashMap<>() ;

    // get information using admission Id :-->>
    public Student getStudent ( int id ){
        if ( ! db.containsKey(id)){
            System.out.println(id+" Admission number is invalid!!");
            return null ;
        }
        return db.get(id) ;
    }

    // get information using admission Name :-->>
    public Student getStudent (String name ){
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

    // add information :-->>
    public String addStudent ( Student student ){
        int admnNo = student.getAdminNumber() ;
        db.put(admnNo , student );
        System.out.println("Student added successfully into your Database");
        return "Student added successfully into your Database" ;
    }

    // Delete information using Id :-->>
    public String deleteStudent ( int admnNo ){
        if ( ! db.containsKey(admnNo)){
            return "Admission number is invalid!!" ;
        } else {
            db.remove(admnNo) ;
            return "Successfully remove from HashMap " ;
        }
    }

    // Update the Information :-->>
    public String updateStudent ( int admnNo , int age ){
        if ( !db.containsKey(admnNo)){
            System.out.println("The admission Number that you have entered does not exist") ;
            return null ;
        } else {
            Student student = db.get(admnNo) ;
            student.setAge(age);
            db.put(admnNo , student) ;
            return "Your Name updated successfully" ;
        }
    }
}
