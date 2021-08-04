package com.lessons.lessons.lesson;

import java.util.HashSet;
import java.util.Set;

import com.lessons.lessons.instructor.Instructor;
import com.lessons.lessons.student.Student;

public class LessonViewDTO {

	private int id;
	
	private String lessonCode;
	
	private String lessonName;
	
	private Set<Student> students = new HashSet<>();
	
	private Instructor instructor;
	
	public static LessonViewDTO viewDTO(Lesson lesson) {
		
		LessonViewDTO view = new LessonViewDTO();
		
		view.setId(lesson.getId());
		view.setLessonCode(lesson.getLessonCode());
		view.setLessonName(lesson.getLessonName());
		view.setStudents(lesson.getStudents());
		view.setInstructor(lesson.getInstructor());

		return view;
	}
	
	public static Lesson enrolled(Lesson lesson, Student student) {
		lesson.save(student);
		return lesson;
	}
	
//	public void save(Student student) {
//		
//		this.students.add(student);
//		Lesson lesson = new Lesson();
//		
//		lesson.save(student);
//	}

	public static Lesson assign(Lesson lesson, Instructor instructor) {
		lesson.assignInstructor(instructor);
		return lesson;
	}
	
	
	public void assignInstructor(Instructor instructor) {
		
		this.instructor = instructor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLessonCode() {
		return lessonCode;
	}

	public void setLessonCode(String lessonCode) {
		this.lessonCode = lessonCode;
	}

	public String getLessonName() {
		return lessonName;
	}

	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	
	
}
