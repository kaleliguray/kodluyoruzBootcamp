package com.lessons.lessons.student;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lessons.lessons.exception.NotFoundException;


@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<StudentViewDTO> getLessons() {
		
//		List<StudentViewDTO> studentViewDTOs = new ArrayList<StudentViewDTO>();
//		
//		studentViewDTOs.add(StudentViewDTO.viewDTO(StudentViewDTO.getList(studentRepository.findAll())));
		
//		return studentViewDTOs;
		
		return studentRepository.findAll().stream().map(StudentViewDTO::viewDTO).collect(Collectors.toList());
	}

	@Override
	public StudentViewDTO createLesson(StudentCreateDTO studentCreatDTO) {
		
//		Student student = new Student();
//		
//		student.setFirstName(studentCreatDTO.getFirstName());
//		student.setLastName(studentCreatDTO.getLastName());
//		student.setAge(studentCreatDTO.getAge());
//		student.setDepartment(studentCreatDTO.getDepartment());
//		
//		studentRepository.save(StudentCreateDTO.create(studentCreatDTO));
		
		return StudentViewDTO.viewDTO(studentRepository.save(StudentCreateDTO.create(studentCreatDTO)));
	}

	@Override
	public StudentViewDTO getStudentById(int id) {
		
		Student student = studentRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
		
		return StudentViewDTO.viewDTO(student);
	}

	@Override
	public StudentViewDTO updateService(int id, StudentUpdateDTO studentUpdateDTO) {
		
//		Student student = studentRepository.findById(id).get();
//		
//		student.setFirstName(studentUpdateDTO.getFirstName());
//		student.setLastName(studentUpdateDTO.getLastName());
//		student.setAge(studentUpdateDTO.getAge());
//		student.setDepartment(student.getDepartment());
		
//		Student updatingStudent = studentRepository.save(student);
		
		return StudentViewDTO.viewDTO(studentRepository.save(StudentUpdateDTO.update(studentRepository.findById(id).get(), studentUpdateDTO)));
	}

	@Override
	public void deleteStudent(int id) {
		Student student = studentRepository.findById(id).get();
		
		studentRepository.delete(student);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
