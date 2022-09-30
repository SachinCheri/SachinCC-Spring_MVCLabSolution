package collegefest.service;

import java.util.List;

import collegefest.entity.Student;


public interface StudentService {
	
	
	public List<Student> findAll();

	public Student findById(int theId);

	public void save(Student thestudent);

	public void deleteById(int theId);

	

}