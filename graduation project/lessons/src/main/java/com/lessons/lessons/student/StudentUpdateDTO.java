package com.lessons.lessons.student;

import lombok.Data;

@Data
public class StudentUpdateDTO {

	private String firstName;

	private String lastName;

	private byte age;

	private String department;

	public static Student update(Student tempStudent, StudentUpdateDTO studentUpdateDTO) {
		
		Student student = new Student();
		
		student = tempStudent;
		
		student.setFirstName(studentUpdateDTO.getFirstName());
		student.setLastName(studentUpdateDTO.getLastName());
		student.setAge(studentUpdateDTO.getAge());
		student.setDepartment(studentUpdateDTO.getDepartment());
		
		return student;
	}
	
}
