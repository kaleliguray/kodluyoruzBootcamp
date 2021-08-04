package com.lessons.lessons.lesson;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.lessons.lessons.exception.NotFoundException;
import com.lessons.lessons.instructor.InstructorRepository;
import com.lessons.lessons.student.StudentRepository;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService{
	
	@Autowired
	private LessonRepository lessonRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private InstructorRepository instructorRepository;

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<LessonViewDTO> getLessons() {
		
		return lessonRepository.findAll().stream().map(LessonViewDTO::viewDTO).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public LessonViewDTO getLessonById(int id) {
		
		Lesson lesson = lessonRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
		
		return LessonViewDTO.viewDTO(lesson);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public LessonViewDTO createLesson(LessonCreateDTO lessonCreateDTO) {
		
		Lesson lesson = new Lesson();
		
		lesson.setLessonCode(lessonCreateDTO.getLessonCode());
		lesson.setLessonName(lessonCreateDTO.getLessonName());
		
		lessonRepository.save(lesson);
		
		return LessonViewDTO.viewDTO(lesson);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public LessonViewDTO updateLesson(int id, LessonUpdateDTO lessonUpdateDTO) {
		
		Lesson lesson = lessonRepository.findById(id).get();
		
		lesson.setLessonCode(lessonUpdateDTO.getLessonCode());
		lesson.setLessonName(lessonUpdateDTO.getLessonName());
		
		Lesson updatingLesson = lessonRepository.save(lesson);
		
		return LessonViewDTO.viewDTO(updatingLesson);
	}
	
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public LessonViewDTO enrolledLessonToStudent(int lessonId, int studentId) {
		
//		Lesson lesson = lessonRepository.findById(lessonId).get();
//		Student student = studentRepository.findById(studentId).get();
//		lessonViewDTO = LessonViewDTO.deneme(lessonRepository.findById(lessonId).get(),studentRepository.findById(studentId).get());
		
//		lesson.save(student);
		
//		lessonRepository.save(lesson);
		
		lessonRepository.save(LessonViewDTO.enrolled(lessonRepository.findById(lessonId).get(),studentRepository.findById(studentId).get()));
		
		return LessonViewDTO.viewDTO(LessonViewDTO.enrolled(lessonRepository.findById(lessonId).get(),studentRepository.findById(studentId).get()));
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public void deleteLesson(int id) {
		
		Lesson lesson = lessonRepository.findById(id).get();
		
		lessonRepository.delete(lesson);
	}
	
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public LessonViewDTO assignInstructorToLesson(int lessonId, int instructorId) {
		
		lessonRepository.save(LessonViewDTO.assign(lessonRepository.findById(lessonId).get(), instructorRepository.findById(instructorId).get()));
		
//		Lesson lesson = lessonRepository.findById(lessonId).get();
//		Instructor instructor = instructorRepository.findById(instructorId).get();
//		
//		lesson.assignInstructor(instructor);
//		
//		lessonRepository.save(lesson);
		
		return LessonViewDTO.viewDTO(LessonViewDTO.assign(lessonRepository.findById(lessonId).get(), instructorRepository.findById(instructorId).get()));
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<LessonViewDTO> slice(Pageable pageable) {
		
		return lessonRepository.findAll(pageable).stream().map(LessonViewDTO::viewDTO).collect(Collectors.toList());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
