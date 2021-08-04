package com.lessons.lessons.lesson;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.lessons.lessons.instructor.Instructor;
import com.lessons.lessons.student.Student;

import lombok.Data;

@Entity
@Data
public class Lesson implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lesson_id")
	private int id;
	
	@Column(name = "lesson_code")
	private String lessonCode;
	
	@Column(name = "lesson_name")
	private String lessonName;
	
	@ManyToMany
	@JoinTable(
				name = "student_lesson",
				joinColumns = @JoinColumn(name = "lesson_id"),
				inverseJoinColumns = @JoinColumn(name = "student_id")
			)
	private Set<Student> students = new HashSet<>();
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "instructor_id", referencedColumnName = "instructor_id")
	private Instructor instructor;

	
	public void save(Student student) {

		students.add(student);
	}

	public void assignInstructor(Instructor instructor) {
		
		this.instructor = instructor;
	}
	

}
