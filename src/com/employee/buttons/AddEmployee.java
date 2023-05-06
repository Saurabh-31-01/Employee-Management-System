package com.employee.buttons;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

import com.employee.controller.EmployeeController;
import com.employee.entity.EmpDetails;
import com.employee.management.system.Home;
import com.toedter.calendar.JDateChooser;

public class AddEmployee extends JFrame implements ActionListener {

	private Random ran = new Random();
	int number = ran.nextInt(999999);

	private JButton addButton, backButton;
	private JTextField tfSalary, tfname, tffname, tfAddress, tfAdhar, tfPhone, tfemail, tfdesignation;
	private JDateChooser dcDOB;
	private JComboBox cbEducation;
	private JLabel lblEmpID;

	public AddEmployee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);

		setLayout(null);

		JLabel heading = new JLabel("Add Employee Detail");
		heading.setBounds(320, 30, 500, 50);
		heading.setFont(new Font("Serif", Font.BOLD, 25));
		add(heading);

		JLabel labelname = new JLabel("Name");
		labelname.setBounds(50, 150, 150, 30);
		labelname.setFont(new Font("Serif", Font.BOLD, 20));
		add(labelname);

		tfname = new JTextField();
		tfname.setBounds(200, 150, 150, 30);
		add(tfname);

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

		dcDOB = new JDateChooser();
		dcDOB.setBounds(200, 200, 150, 30);
		add(dcDOB);

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

		String courses[] = { "BBA", "BCA", "BSC", "B.COM", "BE", "BTECH", "MBA", "MA", "MTECH", "MSC", "PHD" };
		cbEducation = new JComboBox(courses);
		cbEducation.setBackground(Color.WHITE);
		cbEducation.setBounds(600, 300, 150, 30);
		add(cbEducation);

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

		tfAdhar = new JTextField();
		tfAdhar.setBounds(600, 350, 150, 30);
		add(tfAdhar);

		JLabel labelEmpID = new JLabel("Employee Id");
		labelEmpID.setBounds(50, 400, 150, 30);
		labelEmpID.setFont(new Font("Serif", Font.BOLD, 20));
		add(labelEmpID);

		lblEmpID = new JLabel("" + number);
		lblEmpID.setBounds(200, 400, 150, 30);
		lblEmpID.setFont(new Font("Serif", Font.BOLD, 20));
		add(lblEmpID);

		addButton = new JButton("Add Details");
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
			String name = tfname.getText();
			String fname = tffname.getText();
			String dob = ((JTextField) dcDOB.getDateEditor().getUiComponent()).getText();

			String salary = tfSalary.getText();
			String address = tfAddress.getText();
			String phone = tfPhone.getText();
			String email = tfemail.getText();
			String education = (String) cbEducation.getSelectedItem();
			String designation = tfdesignation.getText();
			String adhar = tfAdhar.getText();
			String empId = lblEmpID.getText();


			EmpDetails em = new EmpDetails();

			em.setName(name);
			em.setFatherName(fname);
			em.setDateOfBirth(dob);
			em.setSalary(salary);
			em.setAddress(address);
			em.setPhone(phone);
			em.setEmail(email);
			em.setEducation(education);
			em.setDesignation(designation);
			em.setAdhar(adhar);
			em.setEmpId(empId);
			
			EmployeeController emp = new EmployeeController();
			emp.setData(em);
			
			setVisible(false);
			new Home();
		}

		if (ae.getSource() == backButton) {
			setVisible(false);
			new Home();
		}
	}


}
