package com.krishna.sis.dao;

import java.util.List;

import com.krishna.sis.dto.StudentDto;

public interface StudentDao {

	public void saveStudentInfo(StudentDto studentDto);

	public List<StudentDto> getAllStudentInfo();
	
	public void deleteStudentInfo(int id);
	
	public void updateStudentInfo(StudentDto studentDto);
	
	public StudentDto getStudentInfoById(int id);
	
	public String getImageUrlById(int id);
}
