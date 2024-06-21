package com.codewithjay.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.codewithjay.blog.entity.Emploe;
import com.codewithjay.blog.entity.Employee;
import com.codewithjay.blog.service.EmployeeService;
@CrossOrigin
@RestController
@RequestMapping("/")
public class employeeController {

    @Autowired
    EmployeeService es;
    
    @PostMapping("/add-employee")
	public String addEmployee(@RequestBody Employee employee) {
    	System.out.println(employee);
    	return es.addEmployee(employee);
    	
    }
    @PostMapping("/upload-sheet")
	public String uploadSheet(@RequestParam MultipartFile myFile) {
    	System.out.println(myFile);
    	return es.uploadSheet(myFile);
    	
    }
    @PostMapping("/add-emploe")
	public String addEmployee(@RequestBody Emploe employee) {
    	System.out.println(employee);
    	return es.addEmployee(employee);
    	
    }
       @GetMapping("/getAll")
	public List<Employee>findAll(){
		return es.findAll();
	}
       @GetMapping("/getAllempl")
   	public List<Emploe>findAllemp(){
   		return es.findAllemp();
   	}
       
   	@GetMapping("/get-employee-by-id/{employeeId}")
   	public Employee getEmployeeById(@PathVariable int employeeId) {

   		Employee employee = es.getEmployeeById(employeeId);
   		System.out.println(employee);
   		return employee;
   	}
    
	@GetMapping("/get-emploe-by-id/{emploeId}")
	public Emploe getEmploeById(@PathVariable int emploeId) {

		Emploe emploe = es.getEmploeById(emploeId);
		System.out.println(emploe);
		return emploe;
	}
   	
   	@PutMapping("/update-employee")
   	public Employee updateSupplier(@RequestBody Employee employee)
   	{
   		Employee updatedEmployee = es.updateSupplier(employee);

		return updatedEmployee;
   	}
 	@PutMapping("/update-emploe")
   	public Emploe updateEmploye(@RequestBody Emploe emploe)
   	{
 		Emploe updatedEmploe = es.updateProduct(emploe);

		return updatedEmploe;
   	}
}
