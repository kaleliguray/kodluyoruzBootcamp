package com.lessons.lessons.student;

import lombok.Data;

@Data
public class StudentCreateDTO {
	
	private String firstName;
	
	private String lastName;
	
	private byte age;
	
	private String department;
	
	public static Student create(StudentCreateDTO tempCreateDTO) {
		Student student = new Student();
		
		student.setFirstName(tempCreateDTO.getFirstName());
		student.setLastName(tempCreateDTO.getLastName());
		student.setAge(tempCreateDTO.getAge());
		student.setDepartment(tempCreateDTO.getDepartment());
		
		return student;
	}

}
