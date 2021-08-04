package com.lessons.lessons.lesson;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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


@RestController
@RequestMapping("/lessons")
public class LessonController {

//	@Autowired
//	private LessonRepository lessonRepository;
//	
//	@Autowired
//	private StudentRepository studentRepository;
//	
//	@Autowired
//	private InstructorRepository instructorRepository;
	
	@Autowired
	private LessonService lessonService;
	

	@GetMapping("v1/lesson")
	public ResponseEntity<List<LessonViewDTO>> getLessons(){
		
		List<LessonViewDTO> lessonViewDTOs = lessonService.getLessons();
		
		return ResponseEntity.ok(lessonViewDTOs);
	}
	
	@GetMapping("v1/lesson/{id}")
	public ResponseEntity<LessonViewDTO> getLessonById(@PathVariable int id){
		LessonViewDTO lesson = lessonService.getLessonById(id);
		return ResponseEntity.ok(lesson);
	}
	
	
//	
//	@GetMapping()
//	public List<Lesson> getLessons(){
//		return lessonRepository.findAll();
//	}
	
	
	@PostMapping("v1/lesson")
	public ResponseEntity<?> createLesson(@RequestBody LessonCreateDTO lessonCreateDTO){
		lessonService.createLesson(lessonCreateDTO);
		return ResponseEntity.ok(new GenericResponse("Lesson Created!", LocalTime.now(), LocalDate.now()));
	}
	
//	@PostMapping()
//	public Lesson createLesson(@RequestBody Lesson lesson) {
//		return lessonRepository.save(lesson);
//	}
	
	
	@PutMapping("v1/lesson/{id}")
	public ResponseEntity<?> updateLesson(@PathVariable("id") int id, @RequestBody LessonUpdateDTO lessonUpdateDTO){
		LessonViewDTO lesson = lessonService.updateLesson(id, lessonUpdateDTO);
		return ResponseEntity.ok(lesson);
	}
	
	@PutMapping("/{lessonId}/students/{studentId}")
	public ResponseEntity<LessonViewDTO> enrolledLessonToStudent(@PathVariable int lessonId, @PathVariable int studentId) {
		
		LessonViewDTO lesson = lessonService.enrolledLessonToStudent(lessonId, studentId);
		
		return ResponseEntity.ok(lesson);
	}
	
//	@PutMapping("/{lessonId}/students/{studentId}")
//	public Lesson enrolledLessonToStudent(@PathVariable int lessonId, @PathVariable int studentId) {
//		
//		
//		Lesson lesson = lessonRepository.findById(lessonId).get();
//		Student student = studentRepository.findById(studentId).get();
//		
//		lesson.save(student);
//		
//		return lessonRepository.save(lesson);
//	}
	
	@DeleteMapping("v1/lesson/{id}")
	public ResponseEntity<?> deleteLesson(@PathVariable("id") int id){
		lessonService.deleteLesson(id);
		return ResponseEntity.ok(new GenericResponse("Lesson Deleted!", LocalTime.now(), LocalDate.now()));
	}
	
	@PutMapping("/{lessonId}/instructors/{instructorId}")
	public ResponseEntity<LessonViewDTO> assignInstructorToLesson(@PathVariable int lessonId, @PathVariable int instructorId) {
		
		LessonViewDTO lesson = lessonService.assignInstructorToLesson(lessonId, instructorId); 
		
		return ResponseEntity.ok(lesson);
	}
	
//	@PutMapping("/{lessonId}/instructors/{instructorId}")
//	public Lesson assignInstructorToLesson(@PathVariable int lessonId, @PathVariable int instructorId) {
//		
//		Lesson lesson = lessonRepository.findById(lessonId).get();
//		Instructor instructor = instructorRepository.findById(instructorId).get();
//		
//		lesson.assignInstructor(instructor);
//		
//		return lessonRepository.save(lesson);
//	}
	
	
	@GetMapping("v1/lesson/slice")
	public ResponseEntity<List<LessonViewDTO>> slice(Pageable pageable){
		List<LessonViewDTO> lessons = lessonService.slice(pageable);
		return ResponseEntity.ok(lessons);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
