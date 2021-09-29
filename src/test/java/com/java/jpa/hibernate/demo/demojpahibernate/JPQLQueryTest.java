package com.java.jpa.hibernate.demo.demojpahibernate;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.java.jpa.hibernate.demo.demojpahibernate.entity.Course;
import com.java.jpa.hibernate.demo.demojpahibernate.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
class JPQLQueryTest {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager entityManger;

	@Test
	void contextLoads() {
	}
	
//	@Test
//	public void basicTest() {
//		log.info("Executing Named query ===============================");
//		List resultList = entityManger.createNamedQuery("query_get_all_cources").getResultList();
//		log.info("Select c from Course c -> {}"+resultList);
//	}
	
//	@Test
//	public void basicTest_Type() {
//		TypedQuery<Course> createQuery = entityManger.createQuery("Select c from Course c",Course.class);
//		List<Course> resultList = createQuery.getResultList();
//		log.info("Select c from Course c -> {}"+resultList);
//	}

//	@Test
//	public void basicTest_Where() {
//		log.info("Executing 2nd Named query ===============================");
//		TypedQuery<Course> createQuery = entityManger.createNamedQuery("query_get_100_steps_cources",Course.class);
//		List<Course> resultList = createQuery.getResultList();
//		log.info("Select c from Course c -> {}"+resultList);
//	}
	
	@Test
	public void basicTest_GetCourse_Without_Studnet() {
		log.info("Courses without Student ===============================");
		TypedQuery<Course> createQuery = entityManger.createQuery("select c from Course c where c.students is empty",Course.class);
		List<Course> resultList = createQuery.getResultList();
		log.info("select c from Course c where c.students is empty -> {}"+resultList);
	}
	
	@Test
	public void basicTest_GetCourses_With_atleast2_Studnet() {
		log.info("Courses with at least 2 Student ===============================");
		TypedQuery<Course> createQuery = entityManger.createQuery("select c from Course c where size(c.students) >= 2",Course.class);
		List<Course> resultList = createQuery.getResultList();
		log.info("select c from Course c where size(c.students) >= 2"+resultList);
	}
	
	@Test
	public void basicTest_GetCourses_Ordered_By_Studnet() {
		log.info("Courses with at Order By Student ===============================");
		TypedQuery<Course> createQuery = entityManger.createQuery("select c from Course c order by size(c.students)",Course.class);
		List<Course> resultList = createQuery.getResultList();
		log.info("select c from Course c order by size(c.students) -> {}"+resultList);
	}
	
	@Test
	@Transactional
	public void basicTest_GetStudnet_With_Passport_Like_in_a_certain_Pattern() {
		log.info("Get Passport Like===============================");
		TypedQuery<Student> createQuery = entityManger.createQuery("select s from Student s where s.passport.number like 'V1%'",Student.class);
		List<Student> resultList = createQuery.getResultList();
		log.info("select s from Student s where s.passport.number like 'V1%'-> {}"+resultList);
	}
	
	
	// Join with JPQL
	//Join ==> Select c , s from Course c JOIN Student s
	//Left Join ==> Select c , s from Course c  LEFT JOIN Student s
	// Cross Join
	
	@Test
	@Transactional
	public void JoinTest() {
		log.info("Join Test===============================");
		Query createQuery = entityManger.createQuery("Select c, s from Course c JOIN c.students s");
		List<Object[]> resultList = createQuery.getResultList();
		log.info("select s from Student s where s.passport.number like 'V1%'-> {}"+resultList.size());
		for(Object[] obj : resultList) {
			log.info("Course{} Student{}->"+obj[1], obj[0]);
		}
	}
	
	
	
	
	
	
}
