package com.lessons.lessons.instructor;

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
@RequestMapping("/instructors")
@RequiredArgsConstructor
public class InstructorController {

	@Autowired
	private InstructorService instructorService;
	
	@GetMapping("v1/instructors")
	public ResponseEntity<List<InstructorViewDTO>> getInstructor(){
		
		List<InstructorViewDTO> instructorViewDTOs = instructorService.getInstructor();
		
		return ResponseEntity.ok(instructorViewDTOs);
	}
	
	@GetMapping("v1/instructor/{id}")
	public ResponseEntity<InstructorViewDTO> getInstructorById(@PathVariable int id){
		InstructorViewDTO instructorViewDTO = instructorService.getInstructorById(id);
		return ResponseEntity.ok(instructorViewDTO);
	}
	
	@PostMapping("v1/instructor")
	public ResponseEntity<?> createInstructor(@RequestBody InstructorCreateDTO instructorCreateDTO){
		instructorService.createInstructor(instructorCreateDTO);
		return ResponseEntity.ok(new GenericResponse("Instructor Created!", LocalTime.now(), LocalDate.now()));
	}
	
	@PutMapping("v1/instructor/{id}")
	public ResponseEntity<?> updateInstructor(@PathVariable("id") int id, @RequestBody InstructorUpdateDTO instructorUpdateDTO){
		InstructorViewDTO instructor = instructorService.updateInstructor(id, instructorUpdateDTO);
		return ResponseEntity.ok(instructor);
	}
	
	@DeleteMapping("v1/instructor/{id}")
	public ResponseEntity<?> deleteInstructor(@PathVariable("id") int id){
		instructorService.deleteInstructor(id);
		return ResponseEntity.ok(new GenericResponse("Instructor Deleted!", LocalTime.now(), LocalDate.now()));
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
