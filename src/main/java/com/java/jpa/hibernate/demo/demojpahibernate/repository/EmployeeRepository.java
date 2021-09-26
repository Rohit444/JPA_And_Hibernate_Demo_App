package com.java.jpa.hibernate.demo.demojpahibernate.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.jpa.hibernate.demo.demojpahibernate.entity.Course;
import com.java.jpa.hibernate.demo.demojpahibernate.entity.Employee;
import com.java.jpa.hibernate.demo.demojpahibernate.entity.FullTimeEmployee;
import com.java.jpa.hibernate.demo.demojpahibernate.entity.PartTimeEmployee;

@Repository
@Transactional
public class EmployeeRepository {
	
	@Autowired
	EntityManager entityManager;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	//Insert an Employee
	public void insertEmployee(Employee employee) {
		entityManager.persist(employee);
	}
	
	//Retrieve all Employee when using @MappedSuperclass
	public List<FullTimeEmployee> retrieveAllFullTimeEmployee() {
		return entityManager.createQuery("select e from FullTimeEmployee e", FullTimeEmployee.class).getResultList();
	}
	
	public List<PartTimeEmployee> retrieveAllPartTimeEmployee() {
		return entityManager.createQuery("select e from PartTimeEmployee e", PartTimeEmployee.class).getResultList();
	}
	
	
	
	
}
