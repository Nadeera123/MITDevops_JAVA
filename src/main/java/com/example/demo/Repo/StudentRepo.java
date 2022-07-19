package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

	public Student findById(int id);

	@Query(value = "select max(id) from students",nativeQuery = true)
	public int getMaxStudentId();
	
	@Query(value = "select * from students order by id",nativeQuery = true)
	public List<Student> findAllStudents(); 
}
