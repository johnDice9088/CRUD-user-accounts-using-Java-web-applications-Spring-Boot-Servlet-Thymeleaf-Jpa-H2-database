package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.h2.db.model.EmployeeEntity;

@Service
public class studentservice {
	
	@Autowired
	private Studentrepository repo;
	private Studentrepository newrepo;
	
	
	public List<student> getAllstudent(){
	return (List<student>) repo.findAll();
	}
	
	
    public student getone(Integer id) {
  //  	System.out.println(Id);
    	Optional<student> optional= repo.findById(id);
    	student stu = optional.get();
    	return stu;
    	
    
   // 	student stu = null;
    //	if (optional.isPresent()) {
    //		stu = optional.get();
    //		
    //	}
    //	else {
   	//	throw new RuntimeException("emplyee" + id);
    		
    //	}
    //	return stu;
    	
    }
    
    public void deletebyid(Integer id) {
    	Optional<student> optional = repo.findById(id);
    	if(optional.isPresent()) 
		{
			repo.deleteById(id);
		}
    	 
    }

} 




		
		// TODO Auto-generated method stub
		

	

