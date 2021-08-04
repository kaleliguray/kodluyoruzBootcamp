package com.lessons.lessons.exception;

import java.text.MessageFormat;

public class LessonIsAlreadyAssignedException extends RuntimeException {

	public LessonIsAlreadyAssignedException(int lessonId, int studentId) {
		super(MessageFormat.format("Lesson : {0} is already assigned to student : {1}", lessonId, studentId));
	}
	
}
