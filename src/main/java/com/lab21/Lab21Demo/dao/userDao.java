package com.lab21.Lab21Demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lab21.Lab21Demo.entity.Items;
import com.lab21.Lab21Demo.entity.Users;

@Repository
@Transactional
public class userDao {
	
//	@Autowired
//	Users p;
	

	@PersistenceContext
	EntityManager em;

	public List<Items> findAll() {
		TypedQuery<Items> namedQuery = em.createNamedQuery("find_all_items", Items.class);
		return namedQuery.getResultList();
	}
	
	// to update or insert, we will need to use merge. What it chooses to do is
	// determined by whether or not the primary key is being used
	public Users update(Users p) {
		return em.merge(p);
	}
	
	public Users findByUName(String uName) {
		return em.find(Users.class, uName);
	}
	
	public void deleteByName(String uName) {
		Users p = findByUName(uName);
		em.remove(p);
	}
	
	public boolean checkUser(String uname, String pass) {
		Users p = findByUName(uname);
		System.out.println("P is: " + p);
		if(p == null) {
			return false;
		}
		if (p.getPassword().equals(pass)) {
			return true;
		} else
			return false;	
	}
	
	public Items findByItem(String uName) {
		return em.find(Items.class, uName);
	}
	
	public void deleteByItem(String uName) {
		Items p = findByItem(uName);
		em.remove(p);
	}
	
	public void addItem(Items p) {
		em.merge(p);
	}



}
