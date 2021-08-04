package com.lessons.lessons.student;

import java.util.List;

import lombok.Data;

@Data
public class StudentViewDTO {
	
	private int id;

	private String firstName;
	
	private String lastName;
	
	private byte age;
	
	private String department;
	
	public static StudentViewDTO viewDTO(Student student) {
		
		StudentViewDTO studentViewDTO = new StudentViewDTO();
		
		studentViewDTO.setId(student.getId());
		studentViewDTO.setFirstName(student.getFirstName());
		studentViewDTO.setLastName(student.getLastName());
		studentViewDTO.setAge(student.getAge());
		studentViewDTO.setDepartment(student.getDepartment());
		
		return studentViewDTO;
	}
	
	public static Student getList(List<Student> students) {
		
		Student tempStudent = new Student();
		
		for (Student student : students) {
			tempStudent.setFirstName(student.getFirstName());
			tempStudent.setLastName(student.getLastName());
			tempStudent.setAge(student.getAge());
			tempStudent.setDepartment(student.getDepartment());
		}
		
		return tempStudent;
	}
	
}
