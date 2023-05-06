package com.employee.management.system;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.employee.buttons.AddEmployee;
import com.employee.buttons.RemoveEmployee;
import com.employee.buttons.ViewEmployee;

public class Home extends JFrame implements ActionListener {

	private JButton addButton, viewButton, updateButton, deleteButton;

	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 1120, 630);
		add(image);

		JLabel heading = new JLabel("Employee Management System");
		heading.setBounds(620, 20, 400, 40);
		heading.setFont(new Font("TAHOMA", Font.BOLD, 25));
		image.add(heading);

		addButton = new JButton("Add Employee");
		addButton.setBounds(650, 80, 150, 40);
		addButton.addActionListener(this);
		image.add(addButton);

		viewButton = new JButton("View Employees");
		viewButton.setBounds(830, 80, 150, 40);
		viewButton.addActionListener(this);
		image.add(viewButton);

		updateButton = new JButton("Update Employee");
		updateButton.setBounds(650, 140, 150, 40);
		updateButton.addActionListener(this);
		image.add(updateButton);

		deleteButton = new JButton("Remove Employee");
		deleteButton.setBounds(830, 140, 150, 40);
		deleteButton.addActionListener(this);
		image.add(deleteButton);

		setSize(1120, 630);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// jo click event hai uska source kya hai
		// wo hame getSource method deta hai

		if (e.getSource() == addButton) {
			setVisible(false);
			new AddEmployee();

		}
		if (e.getSource() == viewButton) {
			setVisible(false);
			new ViewEmployee();

		} 
		if (e.getSource() == updateButton) {
			setVisible(false);
			new ViewEmployee();
			
		} 
		if(e.getSource() == deleteButton){
			setVisible(false);
			new RemoveEmployee();
		}

	}

}
