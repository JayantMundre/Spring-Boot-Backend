package com.codewithjay.blog.dao;

import java.util.HashMap;
import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.codewithjay.blog.entity.Employee;
import com.codewithjay.blog.entity.Registration;

@Repository
public class RegistrationDao {

	@Autowired
	SessionFactory sf;

	public List<Registration> getUserByemailAndPassword(String email, String password) {
		// List<Registration> list = null;
		try (Session session = sf.openSession()) {
			Criteria criteria = session.createCriteria(Registration.class);
			criteria.add(Restrictions.eq("password", password));
			criteria.add(Restrictions.eq("email", email));
			List<Registration> list = criteria.list();
			list.forEach(s -> System.out.println(s));
			return list;
		}
	}

	public List<Registration> findAll() {
		List<Registration> list = null;
		try (Session session = sf.openSession()) {
			Criteria criteria = session.createCriteria(Registration.class);
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

	public List<Registration> login(String email, String password) {
		try (Session session = sf.openSession()) {
			Criteria criteria = session.createCriteria(Registration.class);
			criteria.add(Restrictions.eq("password", password));
			criteria.add(Restrictions.eq("email", email));
			List<Registration> list = criteria.list();
			list.forEach(s -> System.out.println(s));
			return list;
		}
	}

	public Registration loginpost1(Registration reg) {

		try (Session session = sf.openSession()) {
			Criteria criteria = session.createCriteria(Registration.class);
			criteria.add(Restrictions.eq("email", reg.getEmail()));
			List<Registration> list = criteria.list();
			System.out.println(list);
			return reg;
		}
	}

	public Registration loginpost(Registration reg) {
		try (Session session = sf.openSession()) {
			Criteria criteria = session.createCriteria(Registration.class);
			criteria.add(Restrictions.eq("email", reg.getEmail()));
			List<Registration> list = criteria.list();
			System.out.println(list);

			for (Registration dbSupplier : list) {
				Registration isExists;
				if (reg.getEmail().equalsIgnoreCase(dbSupplier.getEmail())
						|| reg.getPassword().equals(dbSupplier.getPassword())) {
					return isExists = dbSupplier;

				} else {
					isExists = null;
				}
			}
		}
		return reg;
	}

	public Registration addUser(Registration reg) {

			int status = 0;
			try (Session session = sf.openSession()) {
				session.save(reg);
			
				session.beginTransaction().commit();
				System.out.println(session);
			
			} catch (Exception e) {
				e.printStackTrace();
			
			}
			return reg;
		}
	public Registration getUserById(int userId) {
		Registration reg=null;
		try (Session session = sf.openSession()) {
			reg = session.get(Registration.class, userId);

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return reg;
	}


	public Registration updateUser(Registration reg) {
	
			try (Session session = sf.openSession()) {
				Registration dbSupplier = getUserById(reg.getId());

				if (dbSupplier != null) {
					session.update(reg);
					session.beginTransaction().commit();
					return reg;
				}
}
			return reg;}

	public List<Registration> deleteUser(int userId) {
		
			try (Session session = sf.openSession()) {
				Registration reg = session.get(Registration.class, userId);
				if (reg != null) {
					session.delete(reg);
					session.beginTransaction().commit();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return findAll();
		
		}
}
