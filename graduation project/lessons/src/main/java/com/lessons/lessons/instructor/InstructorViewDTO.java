package com.lessons.lessons.instructor;

import lombok.Data;

@Data
public class InstructorViewDTO {

	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String title;
	
	private String mainArea;
	
	public static InstructorViewDTO viewDTO(Instructor instructor) {
		
		InstructorViewDTO view = new InstructorViewDTO();
		
		view.setId(instructor.getId());
		view.setFirstName(instructor.getFirstName());
		view.setLastName(instructor.getLastName());
		view.setTitle(instructor.getTitle());
		view.setMainArea(instructor.getMainArea());

		return view;
	}
	
	
}
