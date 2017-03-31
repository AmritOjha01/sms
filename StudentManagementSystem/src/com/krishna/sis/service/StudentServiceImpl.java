package com.krishna.sis.service;

import java.util.List;

import com.krishna.sis.dao.StudentDao;
import com.krishna.sis.dao.StudentDaoImpl;
import com.krishna.sis.dto.StudentDto;

public class StudentServiceImpl implements StudentService {
	private StudentDao studentDao;

	public StudentServiceImpl() {
		studentDao = new StudentDaoImpl();
	}

	public void saveStudentInfo(StudentDto studentDto) {
		studentDao.saveStudentInfo(studentDto);

	}

	public List<StudentDto> getAllStudentInfo() {
		return studentDao.getAllStudentInfo();
	}

	public void deleteStudentInfo(int id) {
		studentDao.deleteStudentInfo(id);
	}

	public void updateStudentInfo(StudentDto studentDto) {
		studentDao.updateStudentInfo(studentDto);
	}

	public StudentDto getStudentInfoById(int id) {
		return studentDao.getStudentInfoById(id);
	}

	@Override
	public String getImageUrlById(int id) {
		return studentDao.getImageUrlById(id);
	}

}
