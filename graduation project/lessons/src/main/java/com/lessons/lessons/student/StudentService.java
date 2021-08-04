package com.lessons.lessons.student;

import java.util.List;

public interface StudentService {

	List<StudentViewDTO> getLessons();

	StudentViewDTO createLesson(StudentCreateDTO studentCreatDTO);

	StudentViewDTO getStudentById(int id);

	StudentViewDTO updateService(int id, StudentUpdateDTO studentUpdateDTO);

	void deleteStudent(int id);

}
