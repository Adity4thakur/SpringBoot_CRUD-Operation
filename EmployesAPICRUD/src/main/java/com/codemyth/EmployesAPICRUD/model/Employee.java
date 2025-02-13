package com.codemyth.EmployesAPICRUD.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name =  "Employee")
public class Employee {

	
//    empid BIGINT NOT NULL AUTO_INCREMENT,
//    ->     emp_name VARCHAR(255),
//    ->     emp_salary DECIMAL(10, 2),
//    ->     emp_age INT,
//    ->     emp_city VARCHAR(255),
//    ->     PRIMARY KEY (empid)
//	
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) // logic hai taki koi or dusri value phle value se semiler na rhe 
	private long empid ;
	
	@Column(name = "emp_name")
	private String emp_name;
	
	@Column(name = "emp_salary")
	private float emp_salary;
	
	@Column(name = "emp_age")
	private int age;
	
	@Column(name = "emp_city")
	private String emp_city;

	
	public long getEmpid() {
		return empid;
	}

	public void setEmpid(long empid) {
		this.empid = empid;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public float getEmp_salary() {
		return emp_salary;
	}

	public void setEmp_salary(float emp_salary) {
		this.emp_salary = emp_salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmp_city() {
		return emp_city;
	}

	public void setEmp_city(String emp_city) {
		this.emp_city = emp_city;
	}

	public Employee(long empid, String emp_name, float emp_salary, int age, String emp_city) {
		super();
		this.empid = empid;
		this.emp_name = emp_name;
		this.emp_salary = emp_salary;
		this.age = age;
		this.emp_city = emp_city;
	}
	
	public Employee(){
		
		// constructor without args 
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", emp_name=" + emp_name + ", emp_salary=" + emp_salary + ", age=" + age
				+ ", emp_city=" + emp_city + "]";
	}
	
	
	
}
