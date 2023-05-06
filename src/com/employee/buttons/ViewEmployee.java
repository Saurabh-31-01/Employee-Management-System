package com.employee.buttons;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.employee.configuration.JdbcConnection;
import com.employee.controller.EmployeeController;
import com.employee.entity.EmpDetails;
import com.employee.management.system.Home;

import net.proteanit.sql.DbUtils;

public class ViewEmployee extends JFrame implements ActionListener {

	private JTable table;
	private Choice cEmployeeId;
	private JButton search, print, update, back;
	private EmployeeController ec;

	public ViewEmployee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		JLabel searchlbl = new JLabel("Search by Employee ID");
		searchlbl.setBounds(20, 20, 150, 20);
		add(searchlbl);

		cEmployeeId = new Choice();
		cEmployeeId.setBounds(180, 20, 150, 20);
		add(cEmployeeId);

		ec = new EmployeeController();
		List<EmpDetails> list = ec.getData();

		String[] columnNames = { "id", "name", "fathername", "dateofbirth", "salary", "address", "phone", "email",
				"education", "designation", "adhar", "empid" };

		table = new JTable();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(columnNames);

		for (EmpDetails emp : list) {

			cEmployeeId.add(emp.getEmpId());

			String[] data = { emp.getId() + "", emp.getName(), emp.getFatherName(), emp.getDateOfBirth(),
					emp.getSalary(), emp.getAddress(), emp.getPhone(), emp.getEmail(), emp.getEducation(),
					emp.getDesignation(), emp.getAdhar(), emp.getEmpId() };

			model.addRow(data);
		}

		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(0, 100, 900, 600);
		add(jsp);

		search = new JButton("Search");
		search.setBounds(20, 70, 80, 20);
		search.addActionListener(this);
		add(search);

		print = new JButton("Print");
		print.setBounds(120, 70, 80, 20);
		print.addActionListener(this);
		add(print);

		update = new JButton("Update");
		update.setBounds(220, 70, 80, 20);
		update.addActionListener(this);
		add(update);

		back = new JButton("Back");
		back.setBounds(320, 70, 80, 20);
		back.addActionListener(this);
		add(back);

		setSize(900, 700);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == search) {
			String query = "Select * from empdetails where empId = '" + cEmployeeId.getSelectedItem() + "'";
			try {
				JdbcConnection c = new JdbcConnection();
				ResultSet rs = c.s.executeQuery(query);
				table.setModel(DbUtils.resultSetToTableModel(rs));
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if (e.getSource() == print) {
			try {
				table.print();
			} catch (PrinterException e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource() == update) {
			setVisible(false);
			new UpdateEmployee(cEmployeeId.getSelectedItem());

		} else if (e.getSource() == back) {
			setVisible(false);
			new Home();
		}
	}

}
