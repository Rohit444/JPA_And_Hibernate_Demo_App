package com.java.jpa.hibernate.demo.demojpahibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.java.jpa.hibernate.demo.demojpahibernate.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest
class CriteriaQueryTest {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager entityManger;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void all_courses() {
		log.info("Executing query ===============================");
		
		// "Select c from Course c"
		
		//1. Use the Criteria builder to create a Criteria Query returning the expected result object
		     CriteriaBuilder cb = entityManger.getCriteriaBuilder();
		     CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		
		//2. Define the root of the tables which are involved in the query
		     Root<Course> courseRoot = cq.from(Course.class);
		
		//3. Define Predicate etc using criteria builder
		
		//4. Add Predicate etc to the criteria query
		
		// 5. Build a Typed Query Using Entity manager and criteria query
		 TypedQuery<Course> query = entityManger.createQuery(cq.select(courseRoot));
		 List<Course> resultList = query.getResultList();
		log.info("Typed Query {}"+resultList);
	}
	
	@Test
	public void all_courses_Having_100Steps() {
		log.info("Executing query ===============================");
		
		// "Select c from Course c where name like '%100 Steps'"
		
		//1. Use the Criteria builder to create a Criteria Query returning the expected result object
		     CriteriaBuilder cb = entityManger.getCriteriaBuilder();
		     CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		
		//2. Define the root of the tables which are involved in the query
		     Root<Course> courseRoot = cq.from(Course.class);
		
		//3. Define Predicate etc using criteria builder
		     Predicate Jpa50Minuts = cb.like(courseRoot.get("name"), "%Jpa");
		     
		//4. Add Predicate etc to the criteria query
		     cq.where(Jpa50Minuts);
		// 5. Build a Typed Query Using Entity manager and criteria query
		 TypedQuery<Course> query = entityManger.createQuery(cq.select(courseRoot));
		 List<Course> resultList = query.getResultList();
		log.info("Typed Query {}"+resultList);
	}
	
	@Test
	public void all_courses_Without_Studnets() {
		log.info("Executing query ===============================");
		
		// "Select c from Course c where c.students is empty"
		
		//1. Use the Criteria builder to create a Criteria Query returning the expected result object
		     CriteriaBuilder cb = entityManger.getCriteriaBuilder();
		     CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		
		//2. Define the root of the tables which are involved in the query
		     Root<Course> courseRoot = cq.from(Course.class);
		
		//3. Define Predicate etc using criteria builder
		     Predicate studentsIsEmpty = cb.isEmpty(courseRoot.get("students"));
		     
		//4. Add Predicate etc to the criteria query
		     cq.where(studentsIsEmpty);
		// 5. Build a Typed Query Using Entity manager and criteria query
		 TypedQuery<Course> query = entityManger.createQuery(cq.select(courseRoot));
		 List<Course> resultList = query.getResultList();
		log.info("Typed Query {}"+resultList);
	}
	
	@Test
	public void Join() {
		log.info("Executing query ===============================");
		
		// "Select c from Course c join c.students s"
		
		//1. Use the Criteria builder to create a Criteria Query returning the expected result object
		     CriteriaBuilder cb = entityManger.getCriteriaBuilder();
		     CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		
		//2. Define the root of the tables which are involved in the query
		     Root<Course> courseRoot = cq.from(Course.class);
		
		//3. Define Predicate etc using criteria builder
		     javax.persistence.criteria.Join<Object, Object> join = courseRoot.join("students");
		     
		//4. Add Predicate etc to the criteria query
		     
		// 5. Build a Typed Query Using Entity manager and criteria query
		 TypedQuery<Course> query = entityManger.createQuery(cq.select(courseRoot));
		 List<Course> resultList = query.getResultList();
		log.info("Typed Query {}"+resultList);
	}
	
	@Test
	public void Left_Join() {
		log.info("Executing query ===============================");
		
		// "Select c from Course c left join c.students s"
		
		//1. Use the Criteria builder to create a Criteria Query returning the expected result object
		     CriteriaBuilder cb = entityManger.getCriteriaBuilder();
		     CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		
		//2. Define the root of the tables which are involved in the query
		     Root<Course> courseRoot = cq.from(Course.class);
		
		//3. Define Predicate etc using criteria builder
		     javax.persistence.criteria.Join<Object, Object> join = courseRoot.join("students", JoinType.LEFT);
		     
		//4. Add Predicate etc to the criteria query
		     
		// 5. Build a Typed Query Using Entity manager and criteria query
		 TypedQuery<Course> query = entityManger.createQuery(cq.select(courseRoot));
		 List<Course> resultList = query.getResultList();
		log.info("Typed Query {}"+resultList);
	}
	
}
