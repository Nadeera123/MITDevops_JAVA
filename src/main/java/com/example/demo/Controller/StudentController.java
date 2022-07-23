package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Entity.Student;
import com.example.demo.Repo.StudentRepo;

@Controller
public class StudentController {
	
	@Autowired
	private StudentRepo repo;
	
	@GetMapping("/getAllStudents")
	@ResponseBody
	public List<Student> getAllStudents(){
		return repo.findAllStudents();
		
	}

	@PostMapping("/addStudent")
	@ResponseBody
	public String addStudent(@RequestBody Student student) {
		String status="success";
		
		try {
			
			System.out.println(student);
			int maxid=repo.getMaxStudentId();
			System.out.println("maxid="+maxid);
			student.setId(maxid+1);
			System.out.println(student);
			repo.save(student);
			
		} catch (Exception e) {
			status="failed";
		}
		
		return status;
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	@ResponseBody
	public String addStudent(@PathVariable int id) {
        String status="success";
		
		try {
			repo.deleteById(id);
		} catch (Exception e) {
			status="failed";
		}
		return status;
	}
	
	@PostMapping("/updateStudent")
	@ResponseBody
	public String updateStudent(@RequestBody Student student) {
        String status="success";
		try {
			repo.save(student);
		} catch (Exception e) {
			status="failed";
		}
		return status;
	}
	
}
