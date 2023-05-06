package com.employee.buttons;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.employee.controller.EmployeeController;
import com.employee.entity.EmpDetails;
import com.employee.management.system.Home;

public class RemoveEmployee extends JFrame implements ActionListener {

	private Choice cEmpId;
	private JButton delete, back;
	private EmployeeController ec;
	private List<EmpDetails> list;

	public RemoveEmployee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		JLabel lblEmpId = new JLabel("Employee Id");
		lblEmpId.setBounds(50, 50, 100, 30);
		add(lblEmpId);

		cEmpId = new Choice();
		cEmpId.setBounds(200, 50, 150, 30);
		add(cEmpId);

		ec = new EmployeeController();
		list = ec.getData();

		for (EmpDetails emp : list) {
			cEmpId.add(emp.getEmpId());
		}

		JLabel labelname = new JLabel("Name");
		labelname.setBounds(50, 100, 100, 30);
		add(labelname);

		JLabel lblname = new JLabel();
		lblname.setBounds(200, 100, 100, 30);
		add(lblname);

		JLabel labelphone = new JLabel("Phone");
		labelphone.setBounds(50, 150, 100, 30);
		add(labelphone);

		JLabel lblphone = new JLabel();
		lblphone.setBounds(200, 150, 100, 30);
		add(lblphone);

		JLabel labelemail = new JLabel("Email");
		labelemail.setBounds(50, 200, 100, 30);
		add(labelemail);

		JLabel lblemail = new JLabel();
		lblemail.setBounds(200, 200, 100, 30);
		add(lblemail);

		List<EmpDetails> list1 = new ArrayList<>();
		for (EmpDetails emp : list) {
			if (emp.getEmpId().equals(cEmpId.getSelectedItem())) {
				list1.add(emp);
			}
		}

		EmpDetails emp = list1.get(0);
		lblname.setText(emp.getName());
		lblphone.setText(emp.getPhone());
		lblemail.setText(emp.getEmail());

		cEmpId.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {

				List<EmpDetails> list1 = new ArrayList<>();
				for (EmpDetails emp : list) {
					if (emp.getEmpId().equals(cEmpId.getSelectedItem())) {
						list1.add(emp);
					}
				}

				EmpDetails emp = list1.get(0);
				lblname.setText(emp.getName());
				lblphone.setText(emp.getPhone());
				lblemail.setText(emp.getEmail());

			}
		});

		delete = new JButton("Delete");
		delete.setBounds(80, 300, 100, 30);
		delete.setBackground(Color.BLACK);
		delete.setForeground(Color.WHITE);
		delete.addActionListener(this);
		add(delete);

		back = new JButton("Back");
		back.setBounds(200, 300, 100, 30);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
		Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(350, 0, 600, 400);
		add(image);

		setSize(1000, 400);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == delete) {

			List<EmpDetails> list1 = new ArrayList<>();
			for (EmpDetails emp : list) {
				if (emp.getEmpId().equals(cEmpId.getSelectedItem())) {
					list1.add(emp);
				}
			}

			EmpDetails emp = list1.get(0);
			ec = new EmployeeController();
			ec.deleteData(emp);

			setVisible(false);
			new Home();
		}
		if (e.getSource() == back) {
			setVisible(false);
			new Home();
		}
	}

}
