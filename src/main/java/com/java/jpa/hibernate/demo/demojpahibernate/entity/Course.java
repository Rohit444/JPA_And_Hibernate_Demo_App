package com.java.jpa.hibernate.demo.demojpahibernate.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "CourseDetails")
@NamedQueries(value = { @NamedQuery(name = "query_get_all_cources", query = "Select c from Course c"),
@NamedQuery(name = "query_get_100_steps_cources", query = "Select c from Course c where name like '%in 28 minuts'") })
@Cacheable
public class Course {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@OneToMany(mappedBy = "course")
	List<Review> reviews = new ArrayList<>();
	
	@ManyToMany(mappedBy = "courses")
	@JsonIgnore
	List<Student> students = new ArrayList<>();

	public Course() {
		super();
	}

	public Course(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public List<Review> getReviews() {
		return reviews;
	}

	public void addReview(Review reviews) {
		this.reviews.add(reviews);
	}
	
	public void deleteReview(Review reviews) {
		this.reviews.remove(reviews);
	}
	
	

	public List<Student> getStudents() {
		return students;
	}

	public void addStudents(Student students) {
		this.students.add(students);
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}

}
