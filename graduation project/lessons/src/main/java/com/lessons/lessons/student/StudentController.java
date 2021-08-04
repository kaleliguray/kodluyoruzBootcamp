package com.lessons.lessons.student;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lessons.lessons.shared.GenericResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("v1/students/{id}")
	public ResponseEntity<StudentViewDTO> getStudentById(@PathVariable int id){
		StudentViewDTO student = studentService.getStudentById(id);
		return ResponseEntity.ok(student);
	}
	
	@GetMapping("v1/students")
	public ResponseEntity<List<StudentViewDTO>> getStudent(){
		
		List<StudentViewDTO> studentViewDTOs = studentService.getLessons();
		
		return ResponseEntity.ok(studentViewDTOs);
	}
	
	@PostMapping("v1/student")
	public ResponseEntity<?> createStudent(@RequestBody StudentCreateDTO studentCreatDTO){
		studentService.createLesson(studentCreatDTO);
		return ResponseEntity.ok(new GenericResponse("Student Created!", LocalTime.now(), LocalDate.now()));
	}
	
	@PutMapping("v1/student/{id}")
	public ResponseEntity<?> updateStudent(@PathVariable("id") int id, @RequestBody StudentUpdateDTO studentUpdateDTO){
		StudentViewDTO student = studentService.updateService(id, studentUpdateDTO);
		return ResponseEntity.ok(student);
	}
	
	@DeleteMapping("v1/student/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable("id") int id){
		studentService.deleteStudent(id);
		return ResponseEntity.ok(new GenericResponse("Student Deleted!", LocalTime.now(), LocalDate.now()));
	}
	
//	@GetMapping()
//	public List<Student> getStudents(){
//		return studentRepository.findAll();
//	}
//	
//	
//	@PostMapping
//	public Student createStudent(@RequestBody Student student) {
//		return studentRepository.save(student);
//	}
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
