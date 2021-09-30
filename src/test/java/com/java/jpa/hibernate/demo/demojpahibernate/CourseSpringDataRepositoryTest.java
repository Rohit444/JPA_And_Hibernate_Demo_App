package com.java.jpa.hibernate.demo.demojpahibernate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import com.java.jpa.hibernate.demo.demojpahibernate.entity.Course;
import com.java.jpa.hibernate.demo.demojpahibernate.repository.CourseSpringDataRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class CourseSpringDataRepositoryTest {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseSpringDataRepository courseRepository;
	
	@Test
	public void findById_Course_Present() {
		Optional<Course> course = courseRepository.findById(10001L);
		 assertTrue(course.isPresent());
	     log.info("Course present {}"+course.isPresent());
	}
	
	@Test
	public void findById_Course_Not_Present() {
		Optional<Course> course = courseRepository.findById(20001L);
		 assertFalse(course.isPresent());
	     log.info("Course Not Present {}"+course.isPresent());
	}
	
	@Test
	public void playing_around_with_Spring_Data_Jpa_Repository() {
		Course course = new Course("Spring data Jpa New Course");
		courseRepository.save(course);
		
		
		course.setName("Spring data Jpa Updated Course");
		courseRepository.save(course);
		
		log.info("All Courses =================> "+courseRepository.findAll());
		log.info("Count number of Courses =================> "+courseRepository.count());
		
		
		
	}
	
	
	@Test
	public void pagination_test() {
		PageRequest pageRequest = PageRequest.of(0,3);
		
		Page<Course> firstPage = courseRepository.findAll(pageRequest);
		log.info("All Courses Using Pagination first Page =================> "+firstPage.getContent());
		
		Pageable secondPageable = firstPage.nextPageable();
		Page<Course> secondPage = courseRepository.findAll(secondPageable);
		log.info("All Courses Using Pagination Second Page =================> "+secondPage.getContent());
		
		Pageable thirdPageable = secondPage.nextPageable();
		Page<Course> thirdPage = courseRepository.findAll(thirdPageable);
		log.info("All Courses Using Pagination Third Page =================> "+thirdPage.getContent());
	}
	
	@Test
	public void custome_Queries_Using_Spring_Data_JPA_Test() {

		log.info("custome_Queries_Using_Spring_Data_JPA =================> "
				+ courseRepository.findByName("in 28 minuts"));
		log.info("custome_Queries_Using_Spring_Data_JPA =================> "
				+ courseRepository.findByIdAndName(10001L, "in 28 minuts"));
		log.info("custome_Queries_Using_Spring_Data_JPAe =================> "
				+ courseRepository.findByNameOrderByIdDesc("in 28 minuts"));
		log.info("custome_Queries_Using_Spring_Data_JPA_Using_JPQL =================> "
				+ courseRepository.CourseByLike100Minuts());
		log.info("custome_Queries_Using_Spring_Data_JPA_Using_Native_Query =================> "
				+ courseRepository.CourseByLike100MinutsNativeQuery());
		log.info("custome_Queries_Using_Spring_Data_JPA_Using_Named_Query =================> "
				+ courseRepository.CourseByLike100MinutsNamedQuery());

	}
	

}
