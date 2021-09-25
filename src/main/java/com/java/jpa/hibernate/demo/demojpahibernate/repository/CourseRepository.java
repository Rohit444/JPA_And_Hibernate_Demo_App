package com.java.jpa.hibernate.demo.demojpahibernate.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.jpa.hibernate.demo.demojpahibernate.entity.Course;

@Repository
@Transactional
public class CourseRepository {
	
	@Autowired
	EntityManager entityManager;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	public Course findById(Long id ) {
		return entityManager.find(Course.class, id);
	}
	
	public void deleteCourseById(Long Id) {
		Course course = findById(Id);
		entityManager.remove(course);
	}

	public Course saveCourse(Course course) {
		if(course.getId() == null) {
			entityManager.persist(course);
		}
		else {
			entityManager.merge(course);
		}
		return course;
	}
	
	public void playWithEntityManager() {
		log.info("Playing with entity manager ");
		
		//Entity manager is an interface to persistent context

		Course course1 = new Course("in 10000 Steps");
		entityManager.persist(course1);
		
		Course course2 = findById(10001L);
		course2.setName("in 50000 steps");
		
		
		
		
//	entityManager.persist(course1);
//		entityManager.flush();

//		Course course2 = new Course(" Angular js in 10000 Steps");
//		entityManager.persist(course2);
//
//		entityManager.flush();
		// entityManager.clear();// this will clear everything from the entity manager
		// just like detach

		// entityManager.detach(course2); // it detached the entity from the persistence context adding detach makes the entity manager no
		// longer track the changes after this
		// point, so course2 will not be persisted in the database.
//		course1.setName("in 10000 Steps-> Updated");
//		course2.setName("Angular js in 10000 Steps-> Updated");
//		entityManager.refresh(course1); // by using refresh all the changes that has been made on course1 are lost and
//										// it will be refreshed with the content that comes from the database.
//		entityManager.flush();
	}
	
}
