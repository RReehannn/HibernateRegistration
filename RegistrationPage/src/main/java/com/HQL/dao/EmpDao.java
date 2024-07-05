package com.HQL.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.HQL.entity.Emp;

public class EmpDao {
	
	private SessionFactory sessionFactory;

	
	
	public EmpDao(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
	public boolean saveEmp(Emp emp) {
		
		boolean f = false;
		
		Session session = sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		int i = (Integer) session.save(emp);
		
		if(i>0) {
			f = true;
		}
		
		
		
		
		tx.commit();
		
		session.close();
		
		return f;
		
		
	}
	
	
	
	

}
