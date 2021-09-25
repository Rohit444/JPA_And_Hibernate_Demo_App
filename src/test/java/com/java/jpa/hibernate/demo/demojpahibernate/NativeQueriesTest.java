package com.java.jpa.hibernate.demo.demojpahibernate;

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

@RunWith(SpringRunner.class)
@SpringBootTest
class NativeQueriesTest {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager entityManger;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void native_quries_basics_Test() {
		log.info("Executing native_quries_basics ===============================");
		 Query createNativeQuery = entityManger.createNativeQuery("select * from course_details", Course.class);
		 List resultList = createNativeQuery.getResultList();
		log.info("Select * from course_details c -> {}"+resultList);
	}
	
	@Test
	public void native_quries_with_Parameters_Test() {
		log.info("Executing Navite native_quries_with_Parameters ===============================");
		 Query createNativeQuery = entityManger.createNativeQuery("select * from course_details where id = ?", Course.class);
		 createNativeQuery.setParameter(1, 10001L);
		 List resultList = createNativeQuery.getResultList();
		log.info("Select * from course_details c -> {}"+resultList);
	}
	
	@Test
	public void native_quries_named_Parameters_Test() {
		log.info("Executing Navite native_quries_named_Parameters ===============================");
		 Query createNativeQuery = entityManger.createNativeQuery("select * from course_details where id =:id", Course.class);
		 createNativeQuery.setParameter("id", 10001L);
		 List resultList = createNativeQuery.getResultList();
		log.info("Select * from course_details c -> {}"+resultList);
	}
	
	@Test
	@Transactional
	public void native_quries_to_update_Test() {
		log.info("Executing native_quries_to_update_Test ===============================");
		 Query createNativeQuery = entityManger.createNativeQuery("update course_details set last_updated_date= sysdate()-4", Course.class);
		 int noOfRowsUpdated = createNativeQuery.executeUpdate();
		log.info("Number of rows updated "+noOfRowsUpdated);
	}
	

}
