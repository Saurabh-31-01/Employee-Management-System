package com.employee.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import com.employee.controller.EmployeeController;
import com.employee.entity.*;

public class Login extends JFrame implements ActionListener {

	private JTextField tfusername;
	private JTextField tfpassword;
	private EmployeeController ec;

	Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		tfusername = new JTextField();
		tfusername.setBounds(150, 30, 150, 30);
		add(tfusername);

		tfpassword = new JTextField();
		tfpassword.setBounds(150, 80, 150, 30);
		add(tfpassword);

		JLabel username = new JLabel("Username");
		username.setBounds(40, 30, 100, 30);
		add(username);

		JLabel password = new JLabel("Password");
		password.setBounds(40, 80, 100, 30);
		add(password);

		JButton button = new JButton("Login");
		button.setBackground(Color.BLACK);
		button.setForeground(Color.WHITE);
		button.setBounds(150, 140, 150, 30);
		button.addActionListener(this);
		add(button);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(350, 0, 200, 200);
		add(image);

		setSize(600, 300);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String username = tfusername.getText();
		String password = tfpassword.getText();

		ec = new EmployeeController();
		List<AdminLogin> list = ec.getDataAdmin();

		boolean flag = false;
		for (AdminLogin emp : list) {

			if (emp.getUsername().equals(username) && emp.getPassword().equals(password)) {
				setVisible(false);
				flag = true;
				new Home();
				break;
			}

		}
		if(flag == false) {
			JOptionPane.showMessageDialog(null, "Invalid Username or Password");
			setVisible(false);
		}

	}
}
