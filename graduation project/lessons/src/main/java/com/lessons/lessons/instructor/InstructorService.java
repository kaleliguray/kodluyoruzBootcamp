package com.lessons.lessons.instructor;

import java.util.List;

public interface InstructorService {

	List<InstructorViewDTO> getInstructor();

	InstructorViewDTO getInstructorById(int id);

	InstructorViewDTO createInstructor(InstructorCreateDTO instructorCreateDTO);

	InstructorViewDTO updateInstructor(int id, InstructorUpdateDTO instructorUpdateDTO);

	void deleteInstructor(int id);

}
