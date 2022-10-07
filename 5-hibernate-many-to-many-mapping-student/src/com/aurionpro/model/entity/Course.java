package com.aurionpro.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "course_name")
	private String courseName;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "inst_id")
	private Instructor instructor;
	
	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable(name = "student_courses", 
	joinColumns = @JoinColumn(name="course_id"), 
	inverseJoinColumns = @JoinColumn(name = "student_id"))
	private List<Student> students;
	

		
	public Course() {
		super();
	}
	
	public List<Student> getStudent() {
		return students;
	}

	public void setStudent(Course course) {
		this.students = (List<Student>) course;
	}

	public Course(String courseName) {
		this.courseName = courseName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + "]";
	}

	public void addStudent(Student student) {
		if(students==null)
			students = new ArrayList<Student>();
		students.add(student);
	}

}