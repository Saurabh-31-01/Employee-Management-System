package com.employee.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.employee.entity.AdminLogin;
import com.employee.entity.EmpDetails;

public class Config {
	
	public static SessionFactory getConfig() {
		Configuration cfg = new Configuration().configure();
		cfg.addAnnotatedClass(AdminLogin.class);
		SessionFactory sf = cfg.buildSessionFactory();
		return sf;
	}
	
	public static SessionFactory getConfig2() {
		Configuration cfg = new Configuration().configure();
		cfg.addAnnotatedClass(EmpDetails.class);
		SessionFactory sf = cfg.buildSessionFactory();
		return sf;
	}

	
}
