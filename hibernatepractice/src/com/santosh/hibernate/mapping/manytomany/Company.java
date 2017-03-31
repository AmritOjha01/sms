package com.santosh.hibernate.mapping.manytomany;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "comp_id")
	private int compId;
	@Column(name = "comp_name")
	private String compName;
	@ManyToMany
	private Collection<Employee> empList = new ArrayList<>();

	public int getCompId() {
		return compId;
	}

	public void setCompId(int compId) {
		this.compId = compId;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public Collection<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(Collection<Employee> empList) {
		this.empList = empList;
	}
}
