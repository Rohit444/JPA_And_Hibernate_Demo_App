package com.java.jpa.hibernate.demo.demojpahibernate.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.jpa.hibernate.demo.demojpahibernate.entity.Passport;
import com.java.jpa.hibernate.demo.demojpahibernate.entity.Student;

@Repository
@Transactional
public class StudentRepository {
	
	@Autowired
	EntityManager entityManager;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
//	public Student findById(Long id ) {
//		return entityManager.find(Student.class, id);
//	}
//	
//	public void deleteStudentById(Long Id) {
//		Student student = findById(Id);
//		entityManager.remove(student);
//	}
//
//	public Student saveStudent(Student student) {
//		if(student.getId() == null) {
//			entityManager.persist(student);
//		}
//		else {
//			entityManager.merge(student);
//		}
//		return student;
//	}
	
	public void saveStudentWithPassport() {
		log.info("Playing with entity manager ");
		
		//Entity manager is an interface to persistent context
		
		Passport passport = new Passport("VGH4542");
		entityManager.persist(passport);
		Student student = new Student("Rohit Sharma");
		student.setPassport(passport);
		entityManager.persist(student);
		
//	entityManager.persist(student1);
//		entityManager.flush();

//		Student student2 = new Student(" Angular js in 10000 Steps");
//		entityManager.persist(student2);
//
//		entityManager.flush();
		// entityManager.clear();// this will clear everything from the entity manager
		// just like detach

		// entityManager.detach(student2); // it detached the entity from the persistence context adding detach makes the entity manager no
		// longer track the changes after this
		// point, so student2 will not be persisted in the database.
//		student1.setName("in 10000 Steps-> Updated");
//		student2.setName("Angular js in 10000 Steps-> Updated");
//		entityManager.refresh(student1); // by using refresh all the changes that has been made on student1 are lost and
//										// it will be refreshed with the content that comes from the database.
//		entityManager.flush();
	}
	
}
