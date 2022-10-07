package com.aurionpro.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="student")
public class Student {
	@Id													// primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)   // auto increment
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")// table column name	
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;

	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable(name = "student_courses", 
	joinColumns = @JoinColumn(name="student_id"), 
	inverseJoinColumns = @JoinColumn(name = "course_id"))
	private List<Course> courses;
	
	public Student(int id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	
	public List<Course> getCourses() {
		return courses;
	}


	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}


	public Student() {
		super();
		
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}

	public Student( String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public void addCourse(Course course) {
		if (courses == null) {
			courses = new ArrayList();
		}
		courses.add(course);

	}


}
