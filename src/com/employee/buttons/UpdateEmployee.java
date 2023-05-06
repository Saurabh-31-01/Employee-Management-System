package com.employee.buttons;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JTextField;

import com.employee.controller.EmployeeController;
import com.employee.entity.EmpDetails;


public class UpdateEmployee extends JFrame implements ActionListener {

	private JButton addButton, backButton;
	private JTextField tfSalary, tfEducation, tffname, tfAddress, tfPhone, tfemail, tfdesignation;

	private JLabel lblEmpID;
	private String empID;
	private EmployeeController ec;
	private List<EmpDetails> list;

	UpdateEmployee(String empID) {
		this.empID = empID;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);

		setLayout(null);

		JLabel heading = new JLabel("Update Employee Detail");
		heading.setBounds(320, 30, 500, 50);
		heading.setFont(new Font("Serif", Font.BOLD, 25));
		add(heading);

		JLabel labelname = new JLabel("Name");
		labelname.setBounds(50, 150, 150, 30);
		labelname.setFont(new Font("Serif", Font.BOLD, 20));
		add(labelname);

		JLabel lblname = new JLabel();
		lblname.setBounds(200, 150, 150, 30);
		add(lblname);

		JLabel labelfname = new JLabel("Father's Name");
		labelfname.setBounds(400, 150, 150, 30);
		labelfname.setFont(new Font("Serif", Font.BOLD, 20));
		add(labelfname);

		tffname = new JTextField();
		tffname.setBounds(600, 150, 150, 30);
		add(tffname);

		JLabel labelDOB = new JLabel("Date of Birth");
		labelDOB.setBounds(50, 200, 150, 30);
		labelDOB.setFont(new Font("Serif", Font.BOLD, 20));
		add(labelDOB);

		JLabel lblDob = new JLabel();
		lblDob.setBounds(200, 200, 150, 30);
		add(lblDob);

		JLabel labelSalary = new JLabel("Salary");
		labelSalary.setBounds(400, 200, 150, 30);
		labelSalary.setFont(new Font("Serif", Font.BOLD, 20));
		add(labelSalary);

		tfSalary = new JTextField();
		tfSalary.setBounds(600, 200, 150, 30);
		add(tfSalary);

		JLabel labelAddress = new JLabel("Address");
		labelAddress.setBounds(50, 250, 150, 30);
		labelAddress.setFont(new Font("Serif", Font.BOLD, 20));
		add(labelAddress);

		tfAddress = new JTextField();
		tfAddress.setBounds(200, 250, 150, 30);
		add(tfAddress);

		JLabel labelPhone = new JLabel("Phone");
		labelPhone.setBounds(400, 250, 150, 30);
		labelPhone.setFont(new Font("Serif", Font.BOLD, 20));
		add(labelPhone);

		tfPhone = new JTextField();
		tfPhone.setBounds(600, 250, 150, 30);
		add(tfPhone);

		JLabel labelemail = new JLabel("Email");
		labelemail.setBounds(50, 300, 150, 30);
		labelemail.setFont(new Font("Serif", Font.BOLD, 20));
		add(labelemail);

		tfemail = new JTextField();
		tfemail.setBounds(200, 300, 150, 30);
		add(tfemail);

		JLabel labelEducation = new JLabel("Highest Education");
		labelEducation.setBounds(400, 300, 150, 30);
		labelEducation.setFont(new Font("Serif", Font.BOLD, 20));
		add(labelEducation);

		tfEducation = new JTextField();
		tfEducation.setBounds(600, 300, 150, 30);
		add(tfEducation);

		JLabel labeldesignation = new JLabel("Designation");
		labeldesignation.setBounds(50, 350, 150, 30);
		labeldesignation.setFont(new Font("Serif", Font.BOLD, 20));
		add(labeldesignation);

		tfdesignation = new JTextField();
		tfdesignation.setBounds(200, 350, 150, 30);
		add(tfdesignation);

		JLabel labelAdhar = new JLabel("Adhar Number");
		labelAdhar.setBounds(400, 350, 150, 30);
		labelAdhar.setFont(new Font("Serif", Font.BOLD, 20));
		add(labelAdhar);

		JLabel lblAdhar = new JLabel();
		lblAdhar.setBounds(600, 350, 150, 30);
		add(lblAdhar);

		JLabel labelEmpID = new JLabel("Employee Id");
		labelEmpID.setBounds(50, 400, 150, 30);
		labelEmpID.setFont(new Font("Serif", Font.BOLD, 20));
		add(labelEmpID);

		lblEmpID = new JLabel();
		lblEmpID.setBounds(200, 400, 150, 30);
		lblEmpID.setFont(new Font("Serif", Font.BOLD, 20));
		add(lblEmpID);

		ec = new EmployeeController();
		List<EmpDetails> list1 = ec.getData();
		list = new ArrayList<>();
		for (EmpDetails emp : list1) {
			if (emp.getEmpId().equals(empID)) {
				list.add(emp);
			}
		}
		
		EmpDetails emp = list.get(0);
		lblname.setText(emp.getName());
		tffname.setText(emp.getFatherName());
		lblDob.setText(emp.getDateOfBirth());
		tfAddress.setText(emp.getAddress());
		tfSalary.setText(emp.getSalary());
		tfPhone.setText(emp.getPhone());
		tfemail.setText(emp.getEmail());
		tfEducation.setText(emp.getEducation());
		tfdesignation.setText(emp.getDesignation());
		lblAdhar.setText(emp.getAdhar());
		lblEmpID.setText(emp.getEmpId());


		addButton = new JButton("Update Details");
		addButton.setBounds(250, 550, 150, 40);
		addButton.setBackground(Color.BLACK);
		addButton.setForeground(Color.WHITE);
		addButton.addActionListener(this);
		add(addButton);

		backButton = new JButton("Back");
		backButton.setBounds(450, 550, 150, 40);
		backButton.setBackground(Color.BLACK);
		backButton.setForeground(Color.WHITE);
		backButton.addActionListener(this);
		add(backButton);

		setSize(900, 700);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == addButton) {
			String fname = tffname.getText();
			String salary = tfSalary.getText();
			String address = tfAddress.getText();
			String phone = tfPhone.getText();
			String email = tfemail.getText();
			String education = tfEducation.getText();
			String designation = tfdesignation.getText();
			
			EmpDetails emp = list.get(0);
			
			emp.setFatherName(fname);
			emp.setSalary(salary);
			emp.setAddress(address);
			emp.setPhone(phone);
			emp.setEmail(email);
			emp.setEducation(education);
			emp.setDesignation(designation);
			
			ec.updateData(emp);
		}

		if (ae.getSource() == backButton) {
			setVisible(false);
			new ViewEmployee();
		}
	}

}
