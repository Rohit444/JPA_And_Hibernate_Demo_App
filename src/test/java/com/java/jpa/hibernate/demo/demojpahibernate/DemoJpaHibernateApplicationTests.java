package com.java.jpa.hibernate.demo.demojpahibernate;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.java.jpa.hibernate.demo.demojpahibernate.entity.Course;
import com.java.jpa.hibernate.demo.demojpahibernate.entity.Review;
import com.java.jpa.hibernate.demo.demojpahibernate.entity.Student;
import com.java.jpa.hibernate.demo.demojpahibernate.repository.CourseRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoJpaHibernateApplicationTests {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	EntityManager entityManager;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void basicTest() {
		Course course = courseRepository.findById(10001L);
		assertEquals("in 28 minuts", course.getName());
		log.info("Junit Executed =====>");	
	}

	@Test
	@DirtiesContext // with this annotation spring would reset the data which got deleted so that
					// other tests wont affect
	public void deleteTest() {
		courseRepository.deleteCourseById(10002L);
		assertNull(courseRepository.findById(10002L));
	}
	
	@Test
	@DirtiesContext
	public void saveTest() {
		Course course = courseRepository.findById(10001L);
		assertEquals("in 28 minuts", course.getName());
		
		course.setName("In 100 steps");
		
		courseRepository.saveCourse(course);
		
		Course course1 = courseRepository.findById(10001L);
		assertEquals("In 100 steps", course1.getName());
		
	}
	
	@Test
	@DirtiesContext
	public void play_With_EntiryManger_test() {
		courseRepository.playWithEntityManager();
		
		
	}
	
	@Test
	@Transactional
	public void play_With_OneToMany_test() {
		// By default at oneToMany side we are doing lazy fetching
		Course course = courseRepository.findById(10001L);
		log.info("Review Details are "+course.getReviews());
		
	}
	
	@Test
	@Transactional
	public void play_With_ManyToOne_test() {
		// By default at manyToOne side we are doing eager fetching
		Review review = entityManager.find(Review.class, 50001L);
		log.info("Course Details are "+review.getCourse());
		
	}
	
	@Test
	@Transactional
	public void play_With_ManyToMany_Getting_Course_From_Student_test() {
		//By default ManyToMany is doing lazy fetching
		Student student = entityManager.find(Student.class, 20001L);
		log.info("Course Details are "+student.getCourses());
		
	}
	
	@Test
	@Transactional
	public void play_With_ManyToMany_Getting_Student_From_Course_test() {
		//By default ManyToMany is doing lazy fetching
		Course course = entityManager.find(Course.class, 10001L);
		log.info("Course Details are "+course.getStudents());
		
	}
	

}
