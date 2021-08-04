package com.lessons.lessons.instructor;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lessons.lessons.exception.NotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {

	@Autowired
	private InstructorRepository instructorRepository;

	@Override
	public List<InstructorViewDTO> getInstructor() {
		
		return instructorRepository.findAll().stream().map(InstructorViewDTO::viewDTO).collect(Collectors.toList());
	}

	@Override
	public InstructorViewDTO getInstructorById(int id) {
		
		Instructor instructor = instructorRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
		
		return InstructorViewDTO.viewDTO(instructor);
	}

	@Override
	public InstructorViewDTO createInstructor(InstructorCreateDTO instructorCreateDTO) {
		
		Instructor instructor = new Instructor();
		
		instructor.setFirstName(instructorCreateDTO.getFirstName());
		instructor.setLastName(instructorCreateDTO.getLastName());
		instructor.setTitle(instructorCreateDTO.getTitle());
		instructor.setMainArea(instructorCreateDTO.getMainArea());
		
		instructorRepository.save(instructor);
		
		return InstructorViewDTO.viewDTO(instructor);
	}

	@Override
	public InstructorViewDTO updateInstructor(int id, InstructorUpdateDTO instructorUpdateDTO) {
		
		Instructor instructor = instructorRepository.findById(id).get();
		
		instructor.setFirstName(instructorUpdateDTO.getFirstName());
		instructor.setLastName(instructorUpdateDTO.getLastName());
		instructor.setTitle(instructorUpdateDTO.getTitle());
		instructor.setMainArea(instructorUpdateDTO.getMainArea());
		
		Instructor updatingInstructor = instructorRepository.save(instructor);
		
		return InstructorViewDTO.viewDTO(updatingInstructor);
	}

	@Override
	public void deleteInstructor(int id) {
		
		Instructor instructor = instructorRepository.findById(id).get();
		
		instructorRepository.delete(instructor);
		
	}
	
	
	
	
}
