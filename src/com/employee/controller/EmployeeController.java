package com.employee.controller;

import java.util.List;

import com.employee.entity.AdminLogin;
import com.employee.entity.EmpDetails;
import com.employee.service.EmployeeService;

public class EmployeeController {
	
	private EmployeeService es = new EmployeeService();

	public void setData(EmpDetails emp) {
		es.setData(emp);
	}
	
	public List<EmpDetails> getData(){
		return es.getData();
	}
	
	public void deleteData(EmpDetails emp) {
		es.deleteData(emp);
	}

	public void updateData(EmpDetails emp) {
		es.updateData(emp);
	}
	
	public List<AdminLogin> getDataAdmin(){
		return es.getDataAdmin();
	}
	
}
