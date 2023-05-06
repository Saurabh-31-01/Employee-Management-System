package com.employee.service;

import java.util.List;

import com.employee.dao.EmployeeDao;
import com.employee.entity.AdminLogin;
import com.employee.entity.EmpDetails;

public class EmployeeService {

	private EmployeeDao ed = new EmployeeDao();

	public void setData(EmpDetails emp) {
		ed.setData(emp);
	}
	
	public List<EmpDetails> getData(){
		return ed.getData();
	}

	public void deleteData(EmpDetails emp) {
		ed.deleteData(emp);
	}

	public void updateData(EmpDetails emp) {
		ed.updateData(emp);
		
	}
	
	public List<AdminLogin> getDataAdmin(){
		return ed.getDataAdmin();
	}
}
