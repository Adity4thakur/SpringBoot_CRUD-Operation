package com.codemyth.EmployesAPICRUD.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codemyth.EmployesAPICRUD.model.Employee;
import com.codemyth.EmployesAPICRUD.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@RestController   // is se pata chalega application.properties ko ki ye controller hai
@RequestMapping("/api") // is path provide karega ..... like jb hum api hit kare ge 
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;  // ye object hai jiska use kena hai apn ko save kerene k liye 
	
	
	@PostMapping("/employees")
	public String createNewEmployee( @RequestBody Employee employee)
	{
		employeeRepository.save(employee);
		
		return "the data we have created priviously has been store successfully in the databases ////  Employee Created in Database ";
		
		// employee ka object ko apn ko database me save/store  krna hai using jpa apn isko store karege is ks use kt k apn ko insert ka ya or koi bhi querry nhi likh na padta hai   
	}
	
	@GetMapping("/employees")
	public ResponseEntity<?> getAllemployees()
	
	{
		List<Employee> empList = new ArrayList<>();
		employeeRepository.findAll().forEach(empList::add);
		return new ResponseEntity<List<Employee>>(empList,HttpStatus.OK);
		
//		List<Employee> all = employeeRepository.findAll(); // compiler ko boal ki list of employee bana de 
//		
//		return ResponseEntity.ok(all);
		
	}
	
	@GetMapping("/employees/{empid}")
	public ResponseEntity<?> getEmployeeById(@PathVariable long empid) {
		Optional<Employee> emp = employeeRepository.findById(empid);
		 
		    if(emp.isPresent()) {
		         return	ResponseEntity.status(HttpStatus.NOT_FOUND).body(emp.get());
		    	
		    	//return new ResponseEntity<Employee> (emp.get(),HttpStatus.FOUND);
		    }
		    
		    else 
		    {
		    	//return new ResponseEntity<Employee> (HttpStatus.NOT_FOUND);
		    	
		    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("employee ID is not found ");
		    	
		    }
		   
	}
	
	@PutMapping("/updateemployee/{empid}")
	public String updateEmployeeByid(@PathVariable long empid, @RequestBody Employee employee) {
		Optional<Employee> emp = employeeRepository.findById(empid);
		
		if (emp.isPresent()) {
			
			Employee existEmp = emp.get();
			
			existEmp.setAge(employee.getAge());
			existEmp.setEmp_city(employee.getEmp_city());
			existEmp.setEmp_name(employee.getEmp_name());
			existEmp.setEmp_salary(employee.getEmp_salary());
			
			employeeRepository.save(existEmp);
			return "Employees details aginst Id" +empid+"update";
		}
			else 
			{
			   return "Employee Detais against Id" +empid;	
			}
//			employee.getAge();
			
//			existEmp.setAge(0);

		
	}
	
	@DeleteMapping("/deleteemployee/{empid}")
	public String deleteEmployeeEmpId(@PathVariable Long empid) 
	{
		
		employeeRepository.deleteById(empid);
		return "Employee Deleted Successsfully :)";
		
	}
	
	
	
}
