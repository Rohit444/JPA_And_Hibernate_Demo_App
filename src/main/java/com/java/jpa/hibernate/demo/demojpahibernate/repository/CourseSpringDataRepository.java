package com.java.jpa.hibernate.demo.demojpahibernate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.java.jpa.hibernate.demo.demojpahibernate.entity.Course;

@RepositoryRestResource(path = "Courses")
public interface CourseSpringDataRepository extends JpaRepository<Course, Long>{
	      
	List<Course> findByName(String name);
	List<Course> findByIdAndName(Long id, String name);
	List<Course> findByNameOrderByIdDesc(String name);
	
	//using JPQL
	@Query("Select c from Course c where name like '%in 28 minuts'")
	List<Course> CourseByLike100Minuts();
	
	//using Native query
	@Query(value = "Select * from Course_Details c where name like '%in 28 minuts'",nativeQuery = true)
	List<Course> CourseByLike100MinutsNativeQuery();
	
	//using Named query
	@Query(name = "query_get_100_steps_cources")
	List<Course> CourseByLike100MinutsNamedQuery();
	

}
