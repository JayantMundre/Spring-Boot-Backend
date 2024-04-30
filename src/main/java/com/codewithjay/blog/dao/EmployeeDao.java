package com.codewithjay.blog.dao;

import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.codewithjay.blog.entity.Emploe;
import com.codewithjay.blog.entity.Employee;

@Repository
public class EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Employee> findAll() {
		List<Employee> list = null;
		try (Session session = sessionFactory.openSession()) {
			Criteria criteria = session.createCriteria(Employee.class);
			list = criteria.list();
		} 
	
		
		catch (PersistenceException e) {
			e.printStackTrace();
		}
		
		 catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Emploe> getEmploeById() {
		List<Emploe> list = null;
		try (Session session = sessionFactory.openSession()) {
			Criteria criteria = session.createCriteria(Emploe.class);
			list = criteria.list();
		} 
	
		
		catch (PersistenceException e) {
			e.printStackTrace();
		}
		
		 catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public String addEmployee(Employee employee) {
		int status = 0;
		try (Session session = sessionFactory.openSession()) {
			session.save(employee);
		
			session.beginTransaction().commit();
			System.out.println(session);
			status = 1;
		} catch (Exception e) {
			e.printStackTrace();
			status = 3;
		}
		return "Added";
	}
	public String addEmployee(Emploe employee) {
		int status = 0;
		try (Session session = sessionFactory.openSession()) {
			session.save(employee);
		
			session.beginTransaction().commit();
			System.out.println(session);
			status = 1;
		} catch (Exception e) {
			e.printStackTrace();
			status = 3;
		}
		return "Added";
	}

	public Employee updateSupplier(Employee employee) {
		try (Session session = sessionFactory.openSession()) {
			Employee dbSupplier = getEmployeeById(employee.getId());

			if (dbSupplier != null) {
				session.update(employee);
				session.beginTransaction().commit();
				return employee;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public Emploe updateEmploe(Emploe emploe) {
		try (Session session = sessionFactory.openSession()) {
			Emploe dbSupplier = getEmploeById(emploe.getId());

			if (dbSupplier != null) {
				session.update(emploe);
				session.beginTransaction().commit();
				return emploe;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	


		public Employee getEmployeeById(int employeeId) {
			Employee employee=null;
			try (Session session = sessionFactory.openSession()) {
				employee = session.get(Employee.class, employeeId);

			}

			catch (Exception e) {
				e.printStackTrace();
			}
			return employee;
		}

		public Emploe getEmploeById(int emploeId) {
			Emploe emploe=null;
			try (Session session = sessionFactory.openSession()) {
				emploe = session.get(Emploe.class, emploeId);

			}

			catch (Exception e) {
				e.printStackTrace();
			}
			return emploe;
		}

	


	
}
