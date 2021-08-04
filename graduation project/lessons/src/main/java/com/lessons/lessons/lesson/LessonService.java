package com.lessons.lessons.lesson;

import java.util.List;

import org.springframework.data.domain.Pageable;

public interface LessonService {

	List<LessonViewDTO> getLessons();

	LessonViewDTO getLessonById(int id);

	LessonViewDTO createLesson(LessonCreateDTO lessonCreateDTO);

	LessonViewDTO updateLesson(int id, LessonUpdateDTO lessonUpdateDTO);
	
	LessonViewDTO enrolledLessonToStudent(int lessonId, int studentId);

	void deleteLesson(int id);
	
	LessonViewDTO assignInstructorToLesson(int lessonId, int instructorId);

	List<LessonViewDTO> slice(Pageable pageable);
	
}
