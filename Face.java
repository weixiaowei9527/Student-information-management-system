package stusys;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

class addClassListener implements ActionListener {

	public void check() throws ClassNotFoundException, SQLException {
		String strmajor, strbanji;
		strmajor = Face.combox1.getSelectedItem().toString();
		strmajor = Face.combox2.getSelectedItem().toString();
		// 查询学生是否存在
		Shujuku ku = new Shujuku();
		ku.init();
		System.out.println("jfldj");

		Student per = new Student(Face.tfnameclass.getText(), Face.tfidclass.getText());

		Student tpper = null;
		tpper = ku.cheInfo(per, "basicinformation");
		if (tpper == null) {
			System.out.println("数据库不存在此人");
			ku.addInfo(per, "basicinformation");
		} else {
			// 把这个学生加入到里面
			System.out.println("此学生基础信息已存在");

		}
		// 存在就添加到课程，不存在就添加到基本信息目录

		if (strmajor.equals("计算机科学与技术专业")) {

		} else if (strmajor.equals("通信专业")) {

		} else if (strmajor.equals("纺织工程专业")) {

		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		try {

			check();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class delClassListener implements ActionListener {

	public void check() throws ClassNotFoundException, SQLException {
		String strmajor, strbanji;
		strmajor = Face.combox1.getSelectedItem().toString();
		strmajor = Face.combox2.getSelectedItem().toString();

		String url = "jdbc:mysql://localhost:3306/student";
		String user = "root";
		String password = "";
		String sql = null;

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);

		if (strmajor.equals("计算机科学与技术专业")) {

		} else if (strmajor.equals("通信专业")) {

		} else if (strmajor.equals("纺织工程专业")) {

		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		try {
			check();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class findClassListener implements ActionListener {

	public void check() throws ClassNotFoundException, SQLException {
		String strmajor, strmajor2;
		strmajor = Face.combox1.getSelectedItem().toString();
		strmajor2 = Face.combox2.getSelectedItem().toString();

		String url = "jdbc:mysql://localhost:3306/student";
		String user = "root";
		String password = "";
		String sql = null;

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("数据库链接成功");
		if (strmajor.equals("计算机科学与技术专业")) {
			sql = "select * from computer";
			System.out.println("链接成功");
			Statement state = (Statement) con.createStatement();
			ResultSet res = state.executeQuery(sql);
			if (strmajor2.equals("C语言程序设计")) {
				Object name[] = { "C语言程序设计", "成绩", "合格" };
				Object a[][] = new Object[20][3];
				int num = 0;
				while (res.next()) {
					a[num][0] = res.getString(1);
					a[num][1] = res.getString(4);
					if (Double.parseDouble(res.getString(4)) >= 60) {
						a[num][2] = "及格";
					} else {
						a[num][2] = "不及格";
					}
					num++;
				}
				DefaultTableModel table2;
				table2 = new DefaultTableModel(a, name);
				Face.table.setModel(table2);
				table2.setDataVector(a, name);
			}
			if (strmajor2.equals("JAVA语言程序设计")) {
				Object name[] = { "JAVA语言程序设计", "成绩", "合格" };
				Object a[][] = new Object[20][3];
				int num = 0;
				while (res.next()) {
					a[num][0] = res.getString(1);
					a[num][1] = res.getString(5);
					if (Double.parseDouble(res.getString(5)) >= 60) {
						a[num][2] = "及格";
					} else {
						a[num][2] = "不及格";
					}
					num++;
				}
				DefaultTableModel table2;
				table2 = new DefaultTableModel(a, name);
				Face.table.setModel(table2);
				table2.setDataVector(a, name);
			}
			if (strmajor2.equals("数据结构")) {
				Object name[] = { "数据结构", "成绩", "合格" };
				Object a[][] = new Object[20][3];
				int num = 0;
				while (res.next()) {
					a[num][0] = res.getString(1);
					a[num][1] = res.getString(6);
					if (Double.parseDouble(res.getString(6)) >= 60) {
						a[num][2] = "及格";
					} else {
						a[num][2] = "不及格";
					}
					num++;
				}
				DefaultTableModel table2;
				table2 = new DefaultTableModel(a, name);
				Face.table.setModel(table2);
				table2.setDataVector(a, name);
			}
			if (strmajor2.equals("计算机组成原理")) {
				Object name[] = { "计算机组成原理", "成绩", "合格" };
				Object a[][] = new Object[20][3];
				int num = 0;
				while (res.next()) {
					a[num][0] = res.getString(1);
					a[num][1] = res.getString(7);
					if (Double.parseDouble(res.getString(7)) >= 60) {
						a[num][2] = "及格";
					} else {
						a[num][2] = "不及格";
					}
					num++;
				}
				DefaultTableModel table2;
				table2 = new DefaultTableModel(a, name);
				Face.table.setModel(table2);
				table2.setDataVector(a, name);
			}
			if (strmajor2.equals("操作系统")) {
				Object name[] = { "操作系统", "成绩", "合格" };
				Object a[][] = new Object[20][3];
				int num = 0;
				while (res.next()) {
					a[num][0] = res.getString(1);
					a[num][1] = res.getString(8);
					if (Double.parseDouble(res.getString(8)) >= 60) {
						a[num][2] = "及格";
					} else {
						a[num][2] = "不及格";
					}
					num++;
				}
				DefaultTableModel table2;
				table2 = new DefaultTableModel(a, name);
				Face.table.setModel(table2);
				table2.setDataVector(a, name);
			}

		} else if (strmajor.equals("通信专业")) {
			sql = "select * from tongxin";
			System.out.println("链接成功");
			Statement state = (Statement) con.createStatement();
			ResultSet res = state.executeQuery(sql);
			if (strmajor2.equals("信号与系统")) {
				Object name[] = { "信号与系统", "成绩", "合格" };
				Object a[][] = new Object[20][3];
				System.out.println("1155");
				int num = 0;
				while (res.next()) {
					a[num][0] = res.getString(1);
					a[num][1] = res.getString(4);
					if (Double.parseDouble(res.getString(4)) >= 60) {
						a[num][2] = "及格";
					} else {
						a[num][2] = "不及格";
					}
					num++;
				}
				DefaultTableModel table2;
				table2 = new DefaultTableModel(a, name);
				Face.table.setModel(table2);
				table2.setDataVector(a, name);
			}
			if (strmajor2.equals("模拟电路")) {
				Object name[] = { "模拟电路", "成绩", "合格" };
				Object a[][] = new Object[20][3];
				int num = 0;
				while (res.next()) {
					a[num][0] = res.getString(1);
					a[num][1] = res.getString(5);
					if (Double.parseDouble(res.getString(5)) >= 60) {
						a[num][2] = "及格";
					} else {
						a[num][2] = "不及格";
					}
					num++;
				}
				DefaultTableModel table2;
				table2 = new DefaultTableModel(a, name);
				Face.table.setModel(table2);
				table2.setDataVector(a, name);
			}
			if (strmajor2.equals("数字电路")) {
				Object name[] = { "数字电路", "成绩", "合格" };
				Object a[][] = new Object[20][3];
				int num = 0;
				while (res.next()) {
					a[num][0] = res.getString(1);
					a[num][1] = res.getString(6);
					if (Double.parseDouble(res.getString(6)) >= 60) {
						a[num][2] = "及格";
					} else {
						a[num][2] = "不及格";
					}
					num++;
				}
				DefaultTableModel table2;
				table2 = new DefaultTableModel(a, name);
				Face.table.setModel(table2);
				table2.setDataVector(a, name);
			}
			if (strmajor2.equals("通信原理")) {
				Object name[] = { "通信原理", "成绩", "合格" };
				Object a[][] = new Object[20][3];
				int num = 0;
				while (res.next()) {
					a[num][0] = res.getString(1);
					a[num][1] = res.getString(7);
					if (Double.parseDouble(res.getString(7)) >= 60) {
						a[num][2] = "及格";
					} else {
						a[num][2] = "不及格";
					}
					num++;
				}
				DefaultTableModel table2;
				table2 = new DefaultTableModel(a, name);
				Face.table.setModel(table2);
				table2.setDataVector(a, name);
			}
		} else if (strmajor.equals("纺织工程专业")) {
			sql = "select * from fangzhigongcheng";
			System.out.println("链接成功");
			Statement state = (Statement) con.createStatement();
			ResultSet res = state.executeQuery(sql);
			if (strmajor2.equals("纺织品设计学")) {
				Object name[] = { "纺织品设计学", "成绩", "合格" };
				Object a[][] = new Object[20][3];
				int num = 0;
				while (res.next()) {
					a[num][0] = res.getString(1);
					a[num][1] = res.getString(4);
					if (Double.parseDouble(res.getString(4)) >= 60) {
						a[num][2] = "及格";
					} else {
						a[num][2] = "不及格";
					}
					num++;
				}
				DefaultTableModel table2;
				table2 = new DefaultTableModel(a, name);
				Face.table.setModel(table2);
				table2.setDataVector(a, name);
			}
			if (strmajor2.equals("纺织材料学")) {
				Object name[] = { "纺织材料学", "成绩", "合格" };
				Object a[][] = new Object[20][3];
				int num = 0;
				while (res.next()) {
					a[num][0] = res.getString(1);
					a[num][1] = res.getString(5);
					if (Double.parseDouble(res.getString(5)) >= 60) {
						a[num][2] = "及格";
					} else {
						a[num][2] = "不及格";
					}
					num++;
				}
				DefaultTableModel table2;
				table2 = new DefaultTableModel(a, name);
				Face.table.setModel(table2);
				table2.setDataVector(a, name);
			}
			if (strmajor2.equals("机械设计基础")) {
				Object name[] = { "机械设计基础", "成绩", "合格" };
				Object a[][] = new Object[20][3];
				int num = 0;
				while (res.next()) {
					a[num][0] = res.getString(1);
					a[num][1] = res.getString(6);
					if (Double.parseDouble(res.getString(6)) >= 60) {
						a[num][2] = "及格";
					} else {
						a[num][2] = "不及格";
					}
					num++;
				}
				DefaultTableModel table2;
				table2 = new DefaultTableModel(a, name);
				Face.table.setModel(table2);
				table2.setDataVector(a, name);
			}
			if (strmajor2.equals("纺织加工化")) {
				Object name[] = { "纺织加工化", "成绩", "合格" };
				Object a[][] = new Object[20][3];
				int num = 0;
				while (res.next()) {
					a[num][0] = res.getString(1);
					a[num][1] = res.getString(7);
					if (Double.parseDouble(res.getString(7)) >= 60) {
						a[num][2] = "及格";
					} else {
						a[num][2] = "不及格";
					}
					num++;
				}
				DefaultTableModel table2;
				table2 = new DefaultTableModel(a, name);
				Face.table.setModel(table2);
				table2.setDataVector(a, name);
			}
			if (strmajor2.equals("纺纱学")) {
				Object name[] = { "纺纱学", "成绩", "合格" };
				Object a[][] = new Object[20][3];
				int num = 0;
				while (res.next()) {
					a[num][0] = res.getString(1);
					a[num][1] = res.getString(8);
					if (Double.parseDouble(res.getString(8)) >= 60) {
						a[num][2] = "及格";
					} else {
						a[num][2] = "不及格";
					}
					num++;
				}
				DefaultTableModel table2;
				table2 = new DefaultTableModel(a, name);
				Face.table.setModel(table2);
				table2.setDataVector(a, name);
			}

		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		try {
			check();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class findActionListener implements ActionListener {
	public void check() throws ClassNotFoundException, SQLException {
		String message[] = new String[3];
		message[0] = Face.combox1.getSelectedItem().toString();
		message[1] = Face.combox2.getSelectedItem().toString();

		String url = "jdbc:mysql://localhost:3306/student";
		String user = "root";
		String password = "";
		String sql = null;

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);

		if (message[0].equals("计算机科学与技术专业")) {
			sql = sql = "select * from computer";
			Statement state = con.createStatement();
			ResultSet res = state.executeQuery(sql);
			Object data[][];
			Object colums[] = { "姓名", "学号", "班级", "C语言程序设计", "JAVA程序设计", "数据结构", "计算机组成原理", "操作系统" };
			data = new Object[20][10];
			int num = 0;
			DefaultTableModel table2;

			while (res.next()) {
				int sum = 0;
				if (message[1].equals(res.getString(3))) {
					// 输出
					data[num][sum++] = res.getString(1);
					data[num][sum++] = res.getString(2);
					data[num][sum++] = res.getString(3);

					data[num][sum++] = res.getString(4);
					data[num][sum++] = res.getString(5);
					data[num][sum++] = res.getString(6);
					data[num][sum++] = res.getString(7);
					data[num][sum++] = res.getString(8);
					// System.out.println("");
					num++;
				}
			}

			table2 = new DefaultTableModel(data, colums);
			Face.table.setModel(table2);
			table2.setDataVector(data, colums);
		} else if (message[0].equals("通信专业")) {
			sql = sql = "select * from tongxin";
			Statement state = con.createStatement();
			ResultSet res = state.executeQuery(sql);
			Object data[][];
			Object colums[] = { "姓名", "学号", "班级", "信号与系统", "模拟电路", "数字电路", "通信原理" };
			data = new Object[20][10];
			int num = 0;
			DefaultTableModel table2;
			while (res.next()) {
				int sum = 0;
				if (message[1].equals(res.getString(3))) {
					// 输出
					data[num][sum++] = res.getString(1);
					data[num][sum++] = res.getString(2);
					data[num][sum++] = res.getString(3);

					data[num][sum++] = res.getString(4);
					data[num][sum++] = res.getString(5);
					data[num][sum++] = res.getString(6);
					data[num][sum++] = res.getString(7);
					num++;
				}
			}
			table2 = new DefaultTableModel(data, colums);
			Face.table.setModel(table2);
			table2.setDataVector(data, colums);
		} else if (message[0].equals("纺织工程专业")) {
			sql = sql = "select * from fangzhigongcheng";
			Statement state = con.createStatement();
			ResultSet res = state.executeQuery(sql);
			Object data[][];
			Object colums[] = { "姓名", "学号", "班级", "纺织品设计学", "纺织材料学", "机械设计基础", "纺织加工化", "纺纱学" };
			data = new Object[20][10];
			int num = 0;
			DefaultTableModel table2;
			while (res.next()) {
				int sum = 0;
				if (message[1].equals(res.getString(3))) {
					// 输出
					data[num][sum++] = res.getString(1);
					data[num][sum++] = res.getString(2);
					data[num][sum++] = res.getString(3);

					data[num][sum++] = res.getString(4);
					data[num][sum++] = res.getString(5);
					data[num][sum++] = res.getString(6);
					data[num][sum++] = res.getString(7);
					data[num][sum++] = res.getString(8);
					num++;
				}
			}
			table2 = new DefaultTableModel(data, colums);
			Face.table.setModel(table2);
			table2.setDataVector(data, colums);
		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		try {
			check();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

public class Face {
	static JTable mytable;
	static JTable table;
	static JButton controlButton;
	static JComboBox<String> combox1 = null;
	static JComboBox<String> combox2 = null;
	static String[] ttp = { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" };
	static Object datattp[][] = null;
	static JTextField tfidclass;
	static JTextField tfnameclass;

	static JPanel delClass() {
		int h, w, g;
		int x, y;
		x = 30;
		y = 30;
		h = 30;
		w = 120;
		g = 10;
		int x2 = x + w + g;
		JPanel tp = new JPanel();
		tp.setLayout(null);
		JLabel lname = new JLabel("姓名");
		lname.setBounds(x, y, w, h);
		tp.add(lname);
		JLabel lid = new JLabel("学号");
		lid.setBounds(x, y + h + g, w, h);
		tp.add(lid);
		JTextField tfname = new JTextField(10);
		tfname.setBounds(x2, y, w, h);
		tp.add(tfname);
		tp.add(tfname);
		JTextField tfid = new JTextField(10);
		tfid.setBounds(x2, y + h + g, w, h);
		tp.add(tfid);
		int boxw = 120;
		combox1 = new JComboBox<String>();
		combox1.addItem("计算机科学与技术专业");
		combox1.setBounds(x2, y + (g + h) * 2, boxw, h);
		tp.add(combox1);
		combox1.addItem("纺织工程专业");
		combox1.addItem("通信专业");
		combox2 = new JComboBox<String>();
		combox2.setBounds(x2 + (boxw + g) * 2, y + (h + g) * 2, boxw, h);
		tp.add(combox2);
		combox2.addItem("C语言程序设计");
		combox1.setBounds(x2, y + (g + h) * 2, 100, 30);
		controlButton = new JButton("删除");
		controlButton.setBounds(x, y + (g + h) * 3, w, h);
		tp.add(controlButton);
		JLabel lmajor = new JLabel("专业");
		lmajor.setBounds(x, y + (h + g) * 2, w, h);
		tp.add(lmajor);
		JLabel lbanji = new JLabel("班级");
		lbanji.setBounds(x2 + boxw + g, y + (h + g) * 2, w, h);
		tp.add(lbanji);
		combox1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				try {
					String zy = combox1.getSelectedItem().toString();
					if (zy.equals("通信专业")) {
						combox2.removeAllItems();
						combox2.addItem("信号与系统");
						combox2.addItem("模拟电路");
						combox2.addItem("数字电路");
						combox2.addItem("通信原理");
					} else if (zy.equals("纺织工程专业")) {
						combox2.removeAllItems();
						combox2.addItem("纺织品设计学");
						combox2.addItem("组织材料学");
						combox2.addItem("机械设计基础");
						combox2.addItem("纺织加工化");
						combox2.addItem("纺纱学");

					} else if (zy.equals("计算机科学与技术专业")) {
						combox2.removeAllItems();
						combox2.addItem("C语言程序设计");
						combox2.addItem("JAVA语言程序设计");
						combox2.addItem("数据结构");
						combox2.addItem("计算机组成原理");
						combox2.addItem("操作系统");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

		});
		controlButton.addActionListener(new delClassListener());
		return tp;
	}

	static JPanel addClass() {
		int h, w, g;
		int x, y;
		x = 30;
		y = 30;
		h = 30;
		w = 120;
		g = 10;
		int x2 = x + w + g;
		JPanel tp = new JPanel();
		tp.setLayout(null);
		JLabel lname = new JLabel("姓名");
		lname.setBounds(x, y, w, h);
		tp.add(lname);
		JLabel lid = new JLabel("学号");
		lid.setBounds(x, y + h + g, w, h);
		tp.add(lid);
		tfnameclass = new JTextField(10);
		tfnameclass.setBounds(x2, y, w, h);
		tp.add(tfnameclass);
		tp.add(tfnameclass);
		tfidclass = new JTextField(10);
		tfidclass.setBounds(x2, y + h + g, w, h);
		tp.add(tfidclass);
		int boxw = 120;
		combox1 = new JComboBox<String>();
		combox1.addItem("计算机科学与技术专业");
		combox1.setBounds(x2, y + (g + h) * 2, boxw, h);
		tp.add(combox1);
		combox1.addItem("纺织工程专业");
		combox1.addItem("通信专业");
		combox2 = new JComboBox<String>();
		combox2.setBounds(x2 + (boxw + g) * 2, y + (h + g) * 2, boxw, h);
		tp.add(combox2);
		combox2.addItem("C语言程序设计");
		combox1.setBounds(x2, y + (g + h) * 2, 100, 30);
		controlButton = new JButton("添加");
		controlButton.setBounds(x, y + (g + h) * 3 + 60, w, h);
		tp.add(controlButton);
		JLabel lmajor = new JLabel("专业");
		lmajor.setBounds(x, y + (h + g) * 2, w, h);
		tp.add(lmajor);
		JLabel lbanji = new JLabel("课程");
		lbanji.setBounds(x2 + boxw + g, y + (h + g) * 2, w, h);
		tp.add(lbanji);
		combox1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				try {
					String zy = combox1.getSelectedItem().toString();
					if (zy.equals("通信专业")) {
						combox2.removeAllItems();
						combox2.addItem("信号与系统");
						combox2.addItem("模拟电路");
						combox2.addItem("数字电路");
						combox2.addItem("通信原理");
					} else if (zy.equals("纺织工程专业")) {
						combox2.removeAllItems();
						combox2.addItem("纺织品设计学");
						combox2.addItem("组织材料学");
						combox2.addItem("机械设计基础");
						combox2.addItem("纺织加工化");
						combox2.addItem("纺纱学");

					} else if (zy.equals("计算机科学与技术专业")) {
						combox2.removeAllItems();
						combox2.addItem("C语言程序设计");
						combox2.addItem("JAVA语言程序设计");
						combox2.addItem("数据结构");
						combox2.addItem("计算机组成原理");
						combox2.addItem("操作系统");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

		});
		controlButton.addActionListener(new addClassListener());
		return tp;
	}

	static JPanel findClass() {

		JPanel tp = new JPanel();
		tp.setLayout(new BorderLayout());
		combox1 = new JComboBox<String>();
		combox1.addItem("计算机科学与技术专业");
		combox1.addItem("纺织工程专业");
		combox1.addItem("通信专业");
		combox2 = new JComboBox<String>();

		combox2.addItem("C语言程序设计");
		Object a[][];
		a = new Object[20][10];
		Object name[] = { "" };
		table = new JTable(a, name);
		controlButton = new JButton("查询");
		JPanel p = new JPanel();
		p.add(new JLabel("专业"));
		p.add(combox1);
		p.add(new JLabel("课程"));
		p.add(combox2);
		p.add(controlButton);
		combox1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				try {
					String zy = combox1.getSelectedItem().toString();
					if (zy.equals("通信专业")) {
						combox2.removeAllItems();
						combox2.addItem("信号与系统");
						combox2.addItem("模拟电路");
						combox2.addItem("数字电路");
						combox2.addItem("通信原理");
					} else if (zy.equals("纺织工程专业")) {
						combox2.removeAllItems();
						combox2.addItem("纺织品设计学");
						combox2.addItem("纺织材料学");
						combox2.addItem("机械设计基础");
						combox2.addItem("纺织加工化");
						combox2.addItem("纺纱学");

					} else if (zy.equals("计算机科学与技术专业")) {
						combox2.removeAllItems();
						combox2.addItem("C语言程序设计");
						combox2.addItem("JAVA语言程序设计");
						combox2.addItem("数据结构");
						combox2.addItem("计算机组成原理");
						combox2.addItem("操作系统");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

		});
		controlButton.addActionListener(new findClassListener());
		tp.add(p, BorderLayout.NORTH);
		tp.add(new JScrollPane(table), BorderLayout.CENTER);

		return tp;
	}

	static JPanel findMajor() {

		JPanel tp = new JPanel();
		tp.setLayout(new BorderLayout());
		combox1 = new JComboBox<String>();
		combox1.addItem("计算机科学与技术专业");
		combox1.addItem("纺织工程专业");
		combox1.addItem("通信专业");
		combox2 = new JComboBox<String>();

		combox2.addItem("计科1605");
		Object a[][];
		a = new Object[20][10];
		Object name[] = { "" };
		table = new JTable(a, name);
		controlButton = new JButton("查询");
		JPanel p = new JPanel();
		p.add(new JLabel("专业"));
		p.add(combox1);
		p.add(new JLabel("班级"));
		p.add(combox2);
		p.add(controlButton);
		combox1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				try {
					String zy = combox1.getSelectedItem().toString();
					if (zy.equals("通信专业")) {
						combox2.removeAllItems();
						combox2.addItem("通信1603");

					} else if (zy.equals("纺织工程专业")) {
						combox2.removeAllItems();
						combox2.addItem("纺织1601");

					} else if (zy.equals("计算机科学与技术专业")) {
						combox2.removeAllItems();
						combox2.addItem("计科1605");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

		});
		controlButton.addActionListener(new findActionListener());
		tp.add(p, BorderLayout.NORTH);
		tp.add(new JScrollPane(table), BorderLayout.CENTER);

		return tp;
	}

	static JPanel studentSelect() {
		int h, w, g;
		int x, y;
		x = 30;
		y = 30;
		h = 30;
		w = 120;
		g = 10;
		JPanel m = new JPanel();
		m.setLayout(null);
		JLabel lname, lsex, lid, lmajor, lbanji;
		final JTextField tname;
		final JTextField tsex;
		final JTextField tid;
		final JTextField tmajor;
		final JTextField tbanji;
		lname = new JLabel("姓名");
		lname.setBounds(x, y, w, h);
		lname.setBackground(Color.RED);
		lsex = new JLabel("性别");
		lsex.setBounds(x, y + g + h, w, h);
		lid = new JLabel("学号");
		lid.setBounds(x, y + (g + h) * 2, w, h);
		lmajor = new JLabel("专业");
		lmajor.setBounds(x, y + (g + h) * 3, w, h);
		lbanji = new JLabel("班级");
		lbanji.setBounds(x, y + (g + h) * 4, w, h);
		m.add(lname);
		m.add(lsex);
		m.add(lid);
		m.add(lmajor);
		m.add(lbanji);
		tname = new JTextField(10);
		int x2 = x + w + g;
		tname.setBounds(x2, y, w, h);
		m.add(tname);

		tsex = new JTextField(10);
		tsex.setBounds(x2, y + g + h, w, h);
		m.add(tsex);

		tid = new JTextField(10);
		tid.setBounds(x2, y + (g + h) * 2, w, h);
		m.add(tid);

		tmajor = new JTextField(10);
		tmajor.setBounds(x2, y + (g + h) * 3, w, h);
		m.add(tmajor);

		tbanji = new JTextField(10);

		tbanji.setBounds(x2, y + (g + h) * 4, w, h);
		m.add(tbanji);

		JButton bconfirm = new JButton("提交");
		bconfirm.setBounds(x, y + (g + h) * 5 + 60, 60, 30);
		m.add(bconfirm);
		bconfirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				// 把信息添加到数据库

				String name, sex, id, major, banji;
				name = tname.getText();
				sex = tsex.getText();
				id = tid.getText();
				major = tmajor.getText();
				banji = tbanji.getText();

				String url = "jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf8";/*
																											 * 解决中文输入到数据库是乱码的问题
																											 */
				String user = "root";
				String password = "";
				String sql = null;

				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = (Connection) DriverManager.getConnection(url, user, password);
					sql = "insert into basicinformation values('" + name + "', '" + sex + "', '" + id + "','" + banji
							+ "', '" + major + "', 5)";

					Statement state = con.createStatement();
					state.executeUpdate(sql);
					con.close();
					JOptionPane.showMessageDialog(null, "添加成功！", "提示消息", JOptionPane.WARNING_MESSAGE);

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
		return m;
	}

	static JPanel studentDelete() {
		JPanel m = null;
		int h, w, g;
		int x, y;
		x = 30;
		y = 30;
		h = 30;
		w = 120;
		g = 10;
		m = new JPanel();
		m.setLayout(null);
		JLabel lname, lid;
		final JTextField tname;

		final JTextField tid;

		lname = new JLabel("姓名");
		lname.setBounds(x, y, w, h);

		lid = new JLabel("学号");
		lid.setBounds(x, y + g + h, w, h);

		m.add(lname);
		m.add(lid);

		tname = new JTextField(10);
		int x2 = x + w + g;
		tname.setBounds(x2, y, w, h);
		m.add(tname);

		tid = new JTextField(10);
		tid.setBounds(x2, y + g + h, w, h);
		m.add(tid);

		JButton bconfirm = new JButton("删除");
		bconfirm.setBounds(x, y + (g + h) * 2 + 60, 60, 30);
		m.add(bconfirm);
		bconfirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				// 把信息添加到数据库

				String name, id;

				name = tname.getText();

				id = tid.getText();

				String url = "jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf8";
				String user = "root";
				String password = "";
				String sql = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = (Connection) DriverManager.getConnection(url, user, password);
					sql = "delete from basicinformation where 学号 = '" + id + "'";

					Statement state = con.createStatement();
					state.executeUpdate(sql);
					con.close();

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch bloc
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "删除成功！", "提示消息", JOptionPane.WARNING_MESSAGE);

			}

		});
		return m;
	}

	static JPanel studentChange() {
		int h, w, g;
		int x, y;
		x = 30;
		y = 30;
		h = 30;
		w = 120;
		g = 10;
		int x2 = x + w + g;
		final JTextField tzhuanye = new JTextField(10);
		tzhuanye.setEditable(false);
		tzhuanye.setBounds(x2, y + (g + h) * 3, w, h);
		JPanel m = new JPanel();
		m.setLayout(null);
		JLabel lname, lid;
		final JTextField tname;

		final JTextField tid;

		lname = new JLabel("姓名");
		lname.setBounds(x, y + (g + h) * 2, w, h);
		m.add(lname);

		lid = new JLabel("学号");
		lid.setBounds(x, y, w, h);
		m.add(lid);

		tname = new JTextField(10);
		tname.setEnabled(false);
		tname.setBounds(x2, y + (g + h) * 2, w, h);
		// tname.setText("jfldk");
		m.add(tname);

		tid = new JTextField(10);
		tid.setBounds(x2, y, w, h);
		m.add(tid);

		JButton queren = new JButton("确认");
		queren.setBounds(x, y + g + h, 60, 30);
		m.add(queren);

		datattp = new Object[3][10];

		mytable = new JTable(datattp, ttp);
		mytable.setBounds(x, y + (g + h) * 5, 800, 100);

		m.add(mytable);

		queren.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				String id = tid.getText().trim();
				String url = "jdbc:mysql://localhost:3306/student";
				String user = "root";
				String password = "";
				String sql = null;
				String major = null, ttname = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection(url, user, password);
					sql = "select * from basicinformation";
					System.out.println("链接成功");
					Statement state = (Statement) con.createStatement();
					ResultSet res = state.executeQuery(sql);
					while (res.next()) {
						if (id.equals(res.getString(3))) {
							System.out.println(res.getString(1) + res.getString(5));
							// 变量 专业 学号 姓名zhuanye id xingming
							ttname = res.getString(1);
							major = res.getString(5);

							break;
						}
					}
					tname.setText(ttname);
					tzhuanye.setText(major);
					System.out.println("ldsjflsk");
					/*
					 * if (res.getString(5).equals("计算机科学与技术专业")) {
					 * 
					 * String cl[] = { "姓名", "学号", "班级", "C语言程序设计", "JAVA程序设计", "数据结构", "计算机组成原理",
					 * "操作系统" }; ttp = cl; for (int i = 0; i < cl.length; i++) { datattp[0][i] =
					 * cl[i];
					 * 
					 * } // table.repaint(); sql = "select * from computer"; Statement state1 =
					 * (Statement) con.createStatement(); ResultSet res1 = state.executeQuery(sql);
					 * 
					 * while (res1.next()) { int num = 0; if (id.equals(res1.getString(2))) { for
					 * (int i = 0; i < 8; i++) { datattp[1][num++] = res1.getString(num);
					 * System.out.println(res1.getString(num)); } }
					 * 
					 * } // System.out.print("112233");
					 */
					if (res.getString(5).equals("计算机科学与技术专业")) {

						String colums[] = { "姓名", "学号", "班级", "C语言程序设计", "JAVA程序设计", "数据结构", "计算机组成原理", "操作系统","y/n" };
						// table.repaint();
						String data[][] = new String[20][10];
						sql = "select * from computer";
						Statement state1 = (Statement) con.createStatement();
						ResultSet res1 = state.executeQuery(sql);
						for (int i = 0; i < 9; i++) {
							data[0][i] = colums[i];
						}
						DefaultTableModel table2;
						while (res1.next()) {
							int num = 0;
							if (id.equals(res1.getString(2))) {
								for (int i = 0; i < 8; i++) {
									data[1][num++] = res1.getString(num);
									System.out.println(res1.getString(num));
								}
							}

						}
						table2 = new DefaultTableModel(data, colums);
						Face.mytable.setModel(table2);
						table2.setDataVector(data, colums);
					}  else if (res.getString(5).equals("通信专业")) {
						String colums[] = { "姓名", "学号", "班级", "信号与系统",
								"模拟电路", "数字电路", "通信原理","y/n" };
						// table.repaint();
						String data[][] = new String[20][10];
						sql = "select * from tongxin";
						Statement state1 = (Statement) con.createStatement();
						ResultSet res1 = state.executeQuery(sql);
						for (int i = 0; i < 8; i++) {
							data[0][i] = colums[i];
						}
						DefaultTableModel table2;
						while (res1.next()) {
							int num=0;
							if (id.equals(res1.getString(2))) {
								for (int i = 0; i < 7; i++) {
									data[1][num++] = res1.getString(num);
							}
							}

						}
						table2 = new DefaultTableModel(data, colums);
						Face.mytable.setModel(table2);
						table2.setDataVector(data, colums);
					} else if (res.getString(5).equals("纺织工程专业")) {
						String colums[] = { "姓名", "学号", "班级", "纺织品设计学",
								"纺织材料学", "机械设计基础", "纺织加工化","纺纱学","y/n" };
						// table.repaint();
						String data[][] = new String[20][10];
						sql = "select * from fangzhigongcheng";
						Statement state1 = (Statement) con.createStatement();
						ResultSet res1 = state.executeQuery(sql);
						for (int i = 0; i < 9; i++) {
							data[0][i] = colums[i];
						}
						DefaultTableModel table2;
						while (res1.next()) {
							int num = 0 ;
							if (id.equals(res1.getString(2))) {
								for (int i = 0; i < 7; i++) {
									data[1][num++] = res1.getString(num);
							}
								System.out.println(res1.getString(2));
							}

						}
						table2 = new DefaultTableModel(data, colums);
						Face.mytable.setModel(table2);
						table2.setDataVector(data, colums);
					}

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
		JLabel lzhuangye = new JLabel("专业");
		lzhuangye.setBounds(x, y + (g + h) * 3, w, h);
		m.add(lzhuangye);
		m.add(tzhuanye);

		JButton bconfirm = new JButton("提交");
		bconfirm.setBounds(x, y + (g + h) * 6 + 100, 60, 30);
		m.add(bconfirm);
		bconfirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String a[] = new String[10];
				System.out.println(mytable.getColumnCount() + "KLFK");
				for (int i = 0; i < mytable.getColumnCount(); i++) {
					a[i] = (String) mytable.getValueAt(2, i);
					System.out.println(a[i]);
				}
				
				String ttmajor = tzhuanye.getText();
				String ttid = tid.getText();
				String url = "jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf8";/*
																											 * 解决中文输入到数据库是乱码的问题
																											 */
				String user = "root";
				String password = "";
				String sql = null;

				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = (Connection) DriverManager.getConnection(url, user, password);
					if (ttmajor.equals("计算机科学与技术专业")) {
						System.out.println(a[5] + a[6] + a[7]);
						sql = "update computer set C语言程序设计  = '" + a[3] + "', JAVA程序设计  = '" + a[4] + "', 数据结构  = '"
								+ a[5] + "', 计算机组成原理 = '" + a[6] + "', 操作系统  = '" + a[7] + "' where 学号 = '" + ttid
								+ "'";
						Statement state = con.createStatement();
						state.executeUpdate(sql);
						con.close();
					} else if (ttmajor.equals("通信专业")) {
						System.out.println("5");
						sql = "update tongxin set 信号与系统  = '" + a[3] + "', 模拟电路  = '" + a[4] + "', 数字电路  = '" + a[5]
								+ "', 通信原理 = '" + a[6] + "' where 学号 = '" + ttid + "'";
						Statement state = con.createStatement();
						state.executeUpdate(sql);
						con.close();
					} else if (ttmajor.equals("纺织工程专业")) {
						sql = "update fangzhigongcheng set 纺织品设计学  = '" + a[3] + "', 纺织材料学  = '" + a[4] + "', 机械设计基础  = '"
								+ a[5] + "', 纺织加工化 = '" + a[6] + "', 纺纱学 = '" + a[7] + "' where 学号 = '" + ttid + "'";
						Statement state = con.createStatement();
						state.executeUpdate(sql);
						con.close();

					}
					JOptionPane.showMessageDialog(null, "修改成功！", "提示消息", JOptionPane.WARNING_MESSAGE);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// 加入数据库
			}

		});
		return m;
	}

	static JPanel user() {
		JPanel m = null;
		int h, w, g;
		int x, y;
		x = 30;
		y = 30;
		h = 30;
		w = 120;
		g = 10;
		m = new JPanel();
		m.setLayout(null);
		JLabel lname, lid, liid;
		final JTextField tname;

		final JTextField tid;

		final JTextField tiid;

		lname = new JLabel("用户姓名");
		lname.setBounds(x, y, w, h);

		lid = new JLabel("用户密码");
		lid.setBounds(x, y + g + h, w, h);

		liid = new JLabel("修改后密码");
		liid.setBounds(x, y + g + h + g + h, w, h);

		m.add(lname);
		m.add(lid);
		m.add(liid);

		tname = new JTextField(10);
		int x2 = x + w + g;
		tname.setBounds(x2, y, w, h);
		m.add(tname);

		tid = new JTextField(10);
		tid.setBounds(x2, y + g + h, w, h);
		m.add(tid);

		tiid = new JTextField(10);
		tiid.setBounds(x2, y + g + h + g + h, w, h);
		m.add(tiid);

		JButton bconfirm = new JButton("修改");
		bconfirm.setBounds(x, y + (g + h) * 2 + 60, 60, 30);
		m.add(bconfirm);
		bconfirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				// 把信息添加到数据库

				String name, password, password2;

				name = tname.getText();

				password = tid.getText();

				password2 = tiid.getText();
				// 数据库查询函数;
				String url = "jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf8";/*
																											 * 解决中文输入到数据库是乱码的问题
																											 */
				String user = "root";
				String pass = "";
				String sql = null;

				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = (Connection) DriverManager.getConnection(url, user, pass);
					sql = "select * from usersinformation";
					Statement state = con.createStatement();
					ResultSet res = state.executeQuery(sql);
					int f = 0;
					while (res.next()) {
						if (name.equals(res.getString(1)) && password.equals(res.getString(2))) {
							f = 1;
							break;
						}
					}
					con.close();
					
					
					if (f == 1) {
						String url1 = "jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf8";/*
						 * 解决中文输入到数据库是乱码的问题
						 */
							String user1 = "root";
							String pass1 = "";
							String sql1 = null;
						Class.forName("com.mysql.jdbc.Driver");
				
						Connection con1 = (Connection) DriverManager.getConnection(url1, user1, pass1);
						Statement state1 = con1.createStatement();

						sql1 = "update usersinformation set 密码 = '"+password2+"' where 账号 = '"+name+"' ";
						// sql = "updata userinformation set 密码 = '"+password2+"' where 账号 = '"+name+"'
						// ";
					
						state1.executeUpdate(sql1);
						
						con1.close();
						// 提示修改密码成功成功
						JOptionPane.showMessageDialog(null, "修改成功！", "提示消息", JOptionPane.WARNING_MESSAGE);
					} else {
						// 提示账号或密码错误
					}

					con.close();

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
		return m;
	}

	static JPanel findstudent() {
		JPanel m = null;
		int h, w, g;
		int x, y;
		x = 30;
		y = 30;
		h = 30;
		w = 120;
		g = 10;
		m = new JPanel();
		m.setLayout(null);
		JLabel lname, lid;
		Object name[] = { "" };
		Object a[][] = new Object[20][3];
		table = new JTable(a, name);
		final JTextField tname;

		final JTextField tid;

		lname = new JLabel("姓名");
		lname.setBounds(x, y, w, h);

		lid = new JLabel("学号");
		lid.setBounds(x, y + g + h, w, h);

		m.add(lname);
		m.add(lid);

		tname = new JTextField(10);
		int x2 = x + w + g;
		tname.setBounds(x2, y, w, h);
		m.add(tname);

		tid = new JTextField(10);
		tid.setBounds(x2, y + g + h, w, h);
		m.add(tid);

		JButton bconfirm = new JButton("查询");
		bconfirm.setBounds(x, y + (g + h) * 2 + 60, 60, 30);
		m.add(bconfirm);
		table.setBounds(x, y + (g + h) * 5, 800, 100);
		m.add(table);
		bconfirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				// 把信息添加到数据库

				String name, id;

				name = tname.getText();

				id = tid.getText();

				String url = "jdbc:mysql://localhost:3306/student";
				String user = "root";
				String password = "";
				String sql = null;
				String major = null, ttname = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection(url, user, password);
					sql = "select * from basicinformation";
					System.out.println("链接成功");
					Statement state = (Statement) con.createStatement();
					ResultSet res = state.executeQuery(sql);
					while (res.next()) {
						if (id.equals(res.getString(3))) {
							System.out.println(res.getString(1) + res.getString(5));
							// 变量 专业 学号 姓名zhuanye id xingming
							ttname = res.getString(1);
							major = res.getString(5);

							break;
						}
					}
					if (res.getString(5).equals("计算机科学与技术专业")) {

						String colums[] = { "姓名", "学号", "班级", "C语言程序设计", "JAVA程序设计", "数据结构", "计算机组成原理", "操作系统" };
						// table.repaint();
						String data[][] = new String[20][10];
						sql = "select * from computer";
						Statement state1 = (Statement) con.createStatement();
						ResultSet res1 = state.executeQuery(sql);
						for (int i = 0; i < 8; i++) {
							data[0][i] = colums[i];
						}
						DefaultTableModel table2;
						while (res1.next()) {
							int num = 0;
							if (id.equals(res1.getString(2))) {
								for (int i = 0; i < 8; i++) {
									data[1][num++] = res1.getString(num);
									System.out.println(res1.getString(num));
								}
							}

						}
						table2 = new DefaultTableModel(data, colums);
						Face.table.setModel(table2);
						table2.setDataVector(data, colums);
					} else if (res.getString(5).equals("通信专业")) {
						String colums[] = { "姓名", "学号", "班级", "信号与系统", "模拟电路", "数字电路", "通信原理" };
						// table.repaint();
						String data[][] = new String[20][10];
						sql = "select * from tongxin";
						Statement state1 = (Statement) con.createStatement();
						ResultSet res1 = state.executeQuery(sql);
						for (int i = 0; i < 7; i++) {
							data[0][i] = colums[i];
						}
						DefaultTableModel table2;
						while (res1.next()) {
							int num = 0;
							if (id.equals(res1.getString(2))) {
								for (int i = 0; i < 7; i++) {
									data[1][num++] = res1.getString(num);
								}
							}

						}
						table2 = new DefaultTableModel(data, colums);
						Face.table.setModel(table2);
						table2.setDataVector(data, colums);
					} else if (res.getString(5).equals("纺织工程专业")) {
						String colums[] = { "姓名", "学号", "班级", "纺织品设计学", "纺织材料学", "机械设计基础", "纺织加工化", "纺纱学" };
						// table.repaint();
						String data[][] = new String[20][10];
						sql = "select * from fangzhigongcheng";
						Statement state1 = (Statement) con.createStatement();
						ResultSet res1 = state.executeQuery(sql);
						for (int i = 0; i < 8; i++) {
							data[0][i] = colums[i];
						}
						DefaultTableModel table2;
						while (res1.next()) {
							int num = 0;
							if (id.equals(res1.getString(2))) {
								for (int i = 0; i < 8; i++) {
									data[1][num++] = res1.getString(num);
								}
								System.out.println(res1.getString(2));
							}

						}
						table2 = new DefaultTableModel(data, colums);
						Face.table.setModel(table2);
						table2.setDataVector(data, colums);
					}

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});

		return m;

	}

}
