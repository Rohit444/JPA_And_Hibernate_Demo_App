package com.java.jpa.hibernate.demo.demojpahibernate;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.java.jpa.hibernate.demo.demojpahibernate.entity.Passport;
import com.java.jpa.hibernate.demo.demojpahibernate.entity.Student;
import com.java.jpa.hibernate.demo.demojpahibernate.repository.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class studentReposioryTest {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	StudentRepository courseRepository;
	
	@Autowired
	EntityManager entityManager;

	@Test
	void contextLoads() {
	}
	
//	@Test
//	@Transactional
//	public void basicTest() {
//		Student student = entityManager.find(Student.class, 20001L);
//		log.info("Student Name is ====> "+student.getName());
//		log.info("PassPort info : ====> "+student.getPassport());
//	}
	
	@Test
	@Transactional
	public void uderstandPersistenceContextTest() {
		// Operation1: Retrieve Student
		Student student = entityManager.find(Student.class, 20001L);
		// Operation2: Retrieve PassPort
		Passport passport = student.getPassport();
		// Operation3: Update Passport
		passport.setNumber("EMJPS654");
		// Operation4: Update Student
		student.setName("Rohit Sharma");
		
		
	}


}
