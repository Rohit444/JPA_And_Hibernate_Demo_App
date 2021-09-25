package com.java.jpa.hibernate.demo.demojpahibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.java.jpa.hibernate.demo.demojpahibernate.repository.StudentRepository;


@SpringBootApplication
public class DemoJpaHibernateApplication implements CommandLineRunner{
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	StudentRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(DemoJpaHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		Course cource = repository.findById(10004L);
//		log.info("Course ====> {}"+cource);	
//		
//		repository.deleteCourseById(10003L);
//		log.info("Course has been deleted");	
//		
//		repository.saveCourse(new Course("Microservices in Spring"));
//		log.info("New Course inserted succesfully");
//		
//		repository.playWithEntityManager();
		
		repository.saveStudentWithPassport();

		
	}

}
