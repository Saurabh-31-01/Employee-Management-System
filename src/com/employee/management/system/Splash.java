package com.employee.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Splash extends JFrame implements ActionListener {
	private JLabel heading;
	private JButton button;
	private ImageIcon i1;

	public Splash() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		// telling swing we are creating our own layout
		// for that we have to set it to null
		setLayout(null);

		heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
		// setting own layout using JLable
		heading.setBounds(155, 30, 1200, 60);
		// setFont parameters
		// 1) font family
		// 2) bold or fir italic or fir plain
		// 3) font size
		heading.setFont(new Font("serif", Font.PLAIN, 50));
		heading.setForeground(Color.BLACK);
		add(heading);

		i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		// yaha pr image class ka object jlabel ke andar pass nahi kr sakte
		// so we have to create another imageicon i3 to pass into jlabel
		JLabel image = new JLabel(i3);
		image.setBounds(50, 100, 1050, 500);
		add(image);

		button = new JButton("Continue");
		button.setBackground(Color.BLACK);
		button.setForeground(Color.WHITE);
		button.setBounds(400, 430, 215, 30);
		button.addActionListener(this);
		// image.add kiya kyu ke button ko image ke respect mai add karna hai
		image.add(button);

		setSize(1170, 650);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);

		while (true) {
			heading.setVisible(false);
			try {
				Thread.sleep(450);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			heading.setVisible(true);
			try {
				Thread.sleep(450);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new Login();

	}

}
