package com.codewithjay.blog.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithjay.blog.dao.RegistrationDao;
import com.codewithjay.blog.entity.Employee;
import com.codewithjay.blog.entity.Registration;

@Service
public class RegistrationService {

	@Autowired
	RegistrationDao rd;

	public List<Registration> getUserByemailAndPassword(String email, String password) {
		List<Registration> list = null;
		return list = rd.getUserByemailAndPassword(email, password);

	}

	public List<Registration> findAll() {
		// TODO Auto-generated method stub
		return rd.findAll();
	}

	public List<Registration> login(String email, String password) {
		List<Registration> list = null;
		return list = rd.login(email, password);

	}

	public HashMap loginpost(Registration reg) {

		Registration user = rd.loginpost(reg);
		HashMap map = new HashMap();
		if (user != null && user == user) {
			map.put("msg", "Valid User");
			user.setPassword("***");
		} else {
			map.put("msg", "Invalid User");
		}
		map.put("user", user);
		return map;
	}

	public Registration addUser(Registration reg) {
		// TODO Auto-generated method stub
		return rd.addUser(reg);
	}
	public Registration getUserById(int userId) {
		
		return rd.getUserById(userId);
	}

	public Registration updateUser(Registration reg) {
		
		return rd.updateUser(reg);
	}

	public List<Registration> deleteUser(int userId) {
		
		return rd.deleteUser(userId);
	}

}
