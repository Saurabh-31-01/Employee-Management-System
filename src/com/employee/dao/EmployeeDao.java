package com.employee.dao;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.employee.configuration.Config;
import com.employee.entity.AdminLogin;
import com.employee.entity.EmpDetails;

public class EmployeeDao {
	private SessionFactory sf = Config.getConfig2();
	private SessionFactory sf1 = Config.getConfig();
	

	public void setData(EmpDetails emp) {

		Session session = sf.openSession();
		session.beginTransaction();

		session.save(emp);
		JOptionPane.showMessageDialog(null, "Data add successful");

		session.getTransaction().commit();
		session.close();

	}

	public List<EmpDetails> getData() {

		Session session = sf.openSession();
		session.beginTransaction();

		Criteria cr = session.createCriteria(EmpDetails.class);
		List<EmpDetails> list = cr.list();

		session.getTransaction().commit();
		session.close();

		return list;
	}

	public void deleteData(EmpDetails emp) {
		Session session = sf.openSession();
		session.beginTransaction();

		session.delete(emp);
		JOptionPane.showMessageDialog(null, "Employee removed successful");
		session.getTransaction().commit();
		session.close();
	}

	public void updateData(EmpDetails emp) {
		Session session = sf.openSession();
		session.beginTransaction();

		session.saveOrUpdate(emp);
		JOptionPane.showMessageDialog(null, "Details updated successful");
		session.getTransaction().commit();
		session.close();

	}
	
	public List<AdminLogin> getDataAdmin(){
		Session session = sf1.openSession();
		session.beginTransaction();

		Criteria cr = session.createCriteria(AdminLogin.class);
		List<AdminLogin> list = cr.list();

		session.getTransaction().commit();
		session.close();
		
		return list;
	}

}
