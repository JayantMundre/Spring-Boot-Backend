package com.codewithjay.blog.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codewithjay.blog.entity.Registration;
import com.codewithjay.blog.service.RegistrationService;

@RestController
@RequestMapping("/")
@CrossOrigin
public class RegistrationController {
	@Autowired
	RegistrationService rs;
	
	   @PostMapping("/add-user")
		public Registration addUser(@RequestBody Registration reg) {
	    	System.out.println(reg);
	    	return rs.addUser(reg);
	    	
	    }
	   	@GetMapping("/getUserById/{userId}")
	   	public Registration getUserById(@PathVariable int userId) {

	   		Registration reg = rs.getUserById(userId);
	   		System.out.println(reg);
	   		return reg;
	   	}
	  	@PutMapping("/update-user")
	   	public Registration updateUser(@RequestBody Registration reg)
	   	{
	  		Registration updateUser = rs.updateUser(reg);

			return updateUser;
	   	}
	
	
	@PostMapping("/login")
	public List<Registration> login(@RequestParam String email, @RequestParam String password) {
		System.out.println("emails = " + email + " password= " + password);

		List<Registration> list = rs.login(email, password);
		if (email == "mundre@gmail.com" || password == "123") {
			System.out.println(list);
		}
		return list;
	}

	@GetMapping("/getAllUser")
	public List<Registration> findAll() {
		return rs.findAll();
	}

	@GetMapping("/users/{email}/{password}")
	public List<Registration> getUserByemailAndPassword(@PathVariable String email, @PathVariable String password) {
		System.out.println("emails = " + email + " password= " + password);

		List<Registration> list = rs.getUserByemailAndPassword(email, password);
		if (email == "mundre@gmail.com" || password == "123") {
			System.out.println(list);
		}
		return list;
	}

	@PostMapping("/loginpost")
	public HashMap loginpost(@RequestBody Registration reg) {
		//System.out.println("emails = " + email + " password= " + password);	// This API is required for Angular
		HashMap map = rs.loginpost(reg);
		
		 
		 return map;
	
	}
	@DeleteMapping("/delete-user/{userId}")
	public List<Registration> deleteUser(@PathVariable int userId){
		List<Registration> reg = rs.deleteUser(userId);
		 
				return reg;
			
		
	}
}
