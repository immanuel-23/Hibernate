package com.aurionpro.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="student_details")
public class StudentDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="linkedin")
	private String linkedin;
	
	@Column(name="github")
	private String github;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="student_id")
	private Student student;
	

	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLinkedin() {
		return linkedin;
	}
	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}
	public String getGithub() {
		return github;
	}
	public void setGithub(String github) {
		this.github = github;
	}
	public StudentDetails() {
		super();
	}
	public StudentDetails(String linkedin, String github) {
		super();
		this.linkedin = linkedin;
		this.github = github;
	}
	
	

}
