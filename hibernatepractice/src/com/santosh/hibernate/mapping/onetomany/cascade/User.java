package com.santosh.hibernate.mapping.onetomany.cascade;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "college_id")
	private int collegeId;
	@Column(name = "college_name")
	private String collegeName;
	@OneToMany(cascade=CascadeType.ALL)
	private Collection<Vehicle> studentList = new ArrayList<>();

	public int getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public Collection<Vehicle> getStudentList() {
		return studentList;
	}

	public void setStudentList(Collection<Vehicle> studentList) {
		this.studentList = studentList;
	}
}
