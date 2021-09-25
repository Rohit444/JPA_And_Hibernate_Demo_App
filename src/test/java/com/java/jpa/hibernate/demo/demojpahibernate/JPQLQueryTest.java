package com.java.jpa.hibernate.demo.demojpahibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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
class JPQLQueryTest {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager entityManger;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void basicTest() {
		log.info("Executing Named query ===============================");
		List resultList = entityManger.createNamedQuery("query_get_all_cources").getResultList();
		log.info("Select c from Course c -> {}"+resultList);
	}
	
//	@Test
//	public void basicTest_Type() {
//		TypedQuery<Course> createQuery = entityManger.createQuery("Select c from Course c",Course.class);
//		List<Course> resultList = createQuery.getResultList();
//		log.info("Select c from Course c -> {}"+resultList);
//	}

	@Test
	public void basicTest_Where() {
		log.info("Executing 2nd Named query ===============================");
		TypedQuery<Course> createQuery = entityManger.createNamedQuery("query_get_100_steps_cources",Course.class);
		List<Course> resultList = createQuery.getResultList();
		log.info("Select c from Course c -> {}"+resultList);
	}
	
}
