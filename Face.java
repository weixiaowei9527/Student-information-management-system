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
		// ��ѯѧ���Ƿ����
		Shujuku ku = new Shujuku();
		ku.init();
		System.out.println("jfldj");

		Student per = new Student(Face.tfnameclass.getText(), Face.tfidclass.getText());

		Student tpper = null;
		tpper = ku.cheInfo(per, "basicinformation");
		if (tpper == null) {
			System.out.println("���ݿⲻ���ڴ���");
			ku.addInfo(per, "basicinformation");
		} else {
			// �����ѧ�����뵽����
			System.out.println("��ѧ��������Ϣ�Ѵ���");

		}
		// ���ھ���ӵ��γ̣������ھ���ӵ�������ϢĿ¼

		if (strmajor.equals("�������ѧ�뼼��רҵ")) {

		} else if (strmajor.equals("ͨ��רҵ")) {

		} else if (strmajor.equals("��֯����רҵ")) {

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

		if (strmajor.equals("�������ѧ�뼼��רҵ")) {

		} else if (strmajor.equals("ͨ��רҵ")) {

		} else if (strmajor.equals("��֯����רҵ")) {

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
		System.out.println("���ݿ����ӳɹ�");
		if (strmajor.equals("�������ѧ�뼼��רҵ")) {
			sql = "select * from computer";
			System.out.println("���ӳɹ�");
			Statement state = (Statement) con.createStatement();
			ResultSet res = state.executeQuery(sql);
			if (strmajor2.equals("C���Գ������")) {
				Object name[] = { "C���Գ������", "�ɼ�", "�ϸ�" };
				Object a[][] = new Object[20][3];
				int num = 0;
				while (res.next()) {
					a[num][0] = res.getString(1);
					a[num][1] = res.getString(4);
					if (Double.parseDouble(res.getString(4)) >= 60) {
						a[num][2] = "����";
					} else {
						a[num][2] = "������";
					}
					num++;
				}
				DefaultTableModel table2;
				table2 = new DefaultTableModel(a, name);
				Face.table.setModel(table2);
				table2.setDataVector(a, name);
			}
			if (strmajor2.equals("JAVA���Գ������")) {
				Object name[] = { "JAVA���Գ������", "�ɼ�", "�ϸ�" };
				Object a[][] = new Object[20][3];
				int num = 0;
				while (res.next()) {
					a[num][0] = res.getString(1);
					a[num][1] = res.getString(5);
					if (Double.parseDouble(res.getString(5)) >= 60) {
						a[num][2] = "����";
					} else {
						a[num][2] = "������";
					}
					num++;
				}
				DefaultTableModel table2;
				table2 = new DefaultTableModel(a, name);
				Face.table.setModel(table2);
				table2.setDataVector(a, name);
			}
			if (strmajor2.equals("���ݽṹ")) {
				Object name[] = { "���ݽṹ", "�ɼ�", "�ϸ�" };
				Object a[][] = new Object[20][3];
				int num = 0;
				while (res.next()) {
					a[num][0] = res.getString(1);
					a[num][1] = res.getString(6);
					if (Double.parseDouble(res.getString(6)) >= 60) {
						a[num][2] = "����";
					} else {
						a[num][2] = "������";
					}
					num++;
				}
				DefaultTableModel table2;
				table2 = new DefaultTableModel(a, name);
				Face.table.setModel(table2);
				table2.setDataVector(a, name);
			}
			if (strmajor2.equals("��������ԭ��")) {
				Object name[] = { "��������ԭ��", "�ɼ�", "�ϸ�" };
				Object a[][] = new Object[20][3];
				int num = 0;
				while (res.next()) {
					a[num][0] = res.getString(1);
					a[num][1] = res.getString(7);
					if (Double.parseDouble(res.getString(7)) >= 60) {
						a[num][2] = "����";
					} else {
						a[num][2] = "������";
					}
					num++;
				}
				DefaultTableModel table2;
				table2 = new DefaultTableModel(a, name);
				Face.table.setModel(table2);
				table2.setDataVector(a, name);
			}
			if (strmajor2.equals("����ϵͳ")) {
				Object name[] = { "����ϵͳ", "�ɼ�", "�ϸ�" };
				Object a[][] = new Object[20][3];
				int num = 0;
				while (res.next()) {
					a[num][0] = res.getString(1);
					a[num][1] = res.getString(8);
					if (Double.parseDouble(res.getString(8)) >= 60) {
						a[num][2] = "����";
					} else {
						a[num][2] = "������";
					}
					num++;
				}
				DefaultTableModel table2;
				table2 = new DefaultTableModel(a, name);
				Face.table.setModel(table2);
				table2.setDataVector(a, name);
			}

		} else if (strmajor.equals("ͨ��רҵ")) {
			sql = "select * from tongxin";
			System.out.println("���ӳɹ�");
			Statement state = (Statement) con.createStatement();
			ResultSet res = state.executeQuery(sql);
			if (strmajor2.equals("�ź���ϵͳ")) {
				Object name[] = { "�ź���ϵͳ", "�ɼ�", "�ϸ�" };
				Object a[][] = new Object[20][3];
				System.out.println("1155");
				int num = 0;
				while (res.next()) {
					a[num][0] = res.getString(1);
					a[num][1] = res.getString(4);
					if (Double.parseDouble(res.getString(4)) >= 60) {
						a[num][2] = "����";
					} else {
						a[num][2] = "������";
					}
					num++;
				}
				DefaultTableModel table2;
				table2 = new DefaultTableModel(a, name);
				Face.table.setModel(table2);
				table2.setDataVector(a, name);
			}
			if (strmajor2.equals("ģ���·")) {
				Object name[] = { "ģ���·", "�ɼ�", "�ϸ�" };
				Object a[][] = new Object[20][3];
				int num = 0;
				while (res.next()) {
					a[num][0] = res.getString(1);
					a[num][1] = res.getString(5);
					if (Double.parseDouble(res.getString(5)) >= 60) {
						a[num][2] = "����";
					} else {
						a[num][2] = "������";
					}
					num++;
				}
				DefaultTableModel table2;
				table2 = new DefaultTableModel(a, name);
				Face.table.setModel(table2);
				table2.setDataVector(a, name);
			}
			if (strmajor2.equals("���ֵ�·")) {
				Object name[] = { "���ֵ�·", "�ɼ�", "�ϸ�" };
				Object a[][] = new Object[20][3];
				int num = 0;
				while (res.next()) {
					a[num][0] = res.getString(1);
					a[num][1] = res.getString(6);
					if (Double.parseDouble(res.getString(6)) >= 60) {
						a[num][2] = "����";
					} else {
						a[num][2] = "������";
					}
					num++;
				}
				DefaultTableModel table2;
				table2 = new DefaultTableModel(a, name);
				Face.table.setModel(table2);
				table2.setDataVector(a, name);
			}
			if (strmajor2.equals("ͨ��ԭ��")) {
				Object name[] = { "ͨ��ԭ��", "�ɼ�", "�ϸ�" };
				Object a[][] = new Object[20][3];
				int num = 0;
				while (res.next()) {
					a[num][0] = res.getString(1);
					a[num][1] = res.getString(7);
					if (Double.parseDouble(res.getString(7)) >= 60) {
						a[num][2] = "����";
					} else {
						a[num][2] = "������";
					}
					num++;
				}
				DefaultTableModel table2;
				table2 = new DefaultTableModel(a, name);
				Face.table.setModel(table2);
				table2.setDataVector(a, name);
			}
		} else if (strmajor.equals("��֯����רҵ")) {
			sql = "select * from fangzhigongcheng";
			System.out.println("���ӳɹ�");
			Statement state = (Statement) con.createStatement();
			ResultSet res = state.executeQuery(sql);
			if (strmajor2.equals("��֯Ʒ���ѧ")) {
				Object name[] = { "��֯Ʒ���ѧ", "�ɼ�", "�ϸ�" };
				Object a[][] = new Object[20][3];
				int num = 0;
				while (res.next()) {
					a[num][0] = res.getString(1);
					a[num][1] = res.getString(4);
					if (Double.parseDouble(res.getString(4)) >= 60) {
						a[num][2] = "����";
					} else {
						a[num][2] = "������";
					}
					num++;
				}
				DefaultTableModel table2;
				table2 = new DefaultTableModel(a, name);
				Face.table.setModel(table2);
				table2.setDataVector(a, name);
			}
			if (strmajor2.equals("��֯����ѧ")) {
				Object name[] = { "��֯����ѧ", "�ɼ�", "�ϸ�" };
				Object a[][] = new Object[20][3];
				int num = 0;
				while (res.next()) {
					a[num][0] = res.getString(1);
					a[num][1] = res.getString(5);
					if (Double.parseDouble(res.getString(5)) >= 60) {
						a[num][2] = "����";
					} else {
						a[num][2] = "������";
					}
					num++;
				}
				DefaultTableModel table2;
				table2 = new DefaultTableModel(a, name);
				Face.table.setModel(table2);
				table2.setDataVector(a, name);
			}
			if (strmajor2.equals("��е��ƻ���")) {
				Object name[] = { "��е��ƻ���", "�ɼ�", "�ϸ�" };
				Object a[][] = new Object[20][3];
				int num = 0;
				while (res.next()) {
					a[num][0] = res.getString(1);
					a[num][1] = res.getString(6);
					if (Double.parseDouble(res.getString(6)) >= 60) {
						a[num][2] = "����";
					} else {
						a[num][2] = "������";
					}
					num++;
				}
				DefaultTableModel table2;
				table2 = new DefaultTableModel(a, name);
				Face.table.setModel(table2);
				table2.setDataVector(a, name);
			}
			if (strmajor2.equals("��֯�ӹ���")) {
				Object name[] = { "��֯�ӹ���", "�ɼ�", "�ϸ�" };
				Object a[][] = new Object[20][3];
				int num = 0;
				while (res.next()) {
					a[num][0] = res.getString(1);
					a[num][1] = res.getString(7);
					if (Double.parseDouble(res.getString(7)) >= 60) {
						a[num][2] = "����";
					} else {
						a[num][2] = "������";
					}
					num++;
				}
				DefaultTableModel table2;
				table2 = new DefaultTableModel(a, name);
				Face.table.setModel(table2);
				table2.setDataVector(a, name);
			}
			if (strmajor2.equals("��ɴѧ")) {
				Object name[] = { "��ɴѧ", "�ɼ�", "�ϸ�" };
				Object a[][] = new Object[20][3];
				int num = 0;
				while (res.next()) {
					a[num][0] = res.getString(1);
					a[num][1] = res.getString(8);
					if (Double.parseDouble(res.getString(8)) >= 60) {
						a[num][2] = "����";
					} else {
						a[num][2] = "������";
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

		if (message[0].equals("�������ѧ�뼼��רҵ")) {
			sql = sql = "select * from computer";
			Statement state = con.createStatement();
			ResultSet res = state.executeQuery(sql);
			Object data[][];
			Object colums[] = { "����", "ѧ��", "�༶", "C���Գ������", "JAVA�������", "���ݽṹ", "��������ԭ��", "����ϵͳ" };
			data = new Object[20][10];
			int num = 0;
			DefaultTableModel table2;

			while (res.next()) {
				int sum = 0;
				if (message[1].equals(res.getString(3))) {
					// ���
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
		} else if (message[0].equals("ͨ��רҵ")) {
			sql = sql = "select * from tongxin";
			Statement state = con.createStatement();
			ResultSet res = state.executeQuery(sql);
			Object data[][];
			Object colums[] = { "����", "ѧ��", "�༶", "�ź���ϵͳ", "ģ���·", "���ֵ�·", "ͨ��ԭ��" };
			data = new Object[20][10];
			int num = 0;
			DefaultTableModel table2;
			while (res.next()) {
				int sum = 0;
				if (message[1].equals(res.getString(3))) {
					// ���
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
		} else if (message[0].equals("��֯����רҵ")) {
			sql = sql = "select * from fangzhigongcheng";
			Statement state = con.createStatement();
			ResultSet res = state.executeQuery(sql);
			Object data[][];
			Object colums[] = { "����", "ѧ��", "�༶", "��֯Ʒ���ѧ", "��֯����ѧ", "��е��ƻ���", "��֯�ӹ���", "��ɴѧ" };
			data = new Object[20][10];
			int num = 0;
			DefaultTableModel table2;
			while (res.next()) {
				int sum = 0;
				if (message[1].equals(res.getString(3))) {
					// ���
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
		JLabel lname = new JLabel("����");
		lname.setBounds(x, y, w, h);
		tp.add(lname);
		JLabel lid = new JLabel("ѧ��");
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
		combox1.addItem("�������ѧ�뼼��רҵ");
		combox1.setBounds(x2, y + (g + h) * 2, boxw, h);
		tp.add(combox1);
		combox1.addItem("��֯����רҵ");
		combox1.addItem("ͨ��רҵ");
		combox2 = new JComboBox<String>();
		combox2.setBounds(x2 + (boxw + g) * 2, y + (h + g) * 2, boxw, h);
		tp.add(combox2);
		combox2.addItem("C���Գ������");
		combox1.setBounds(x2, y + (g + h) * 2, 100, 30);
		controlButton = new JButton("ɾ��");
		controlButton.setBounds(x, y + (g + h) * 3, w, h);
		tp.add(controlButton);
		JLabel lmajor = new JLabel("רҵ");
		lmajor.setBounds(x, y + (h + g) * 2, w, h);
		tp.add(lmajor);
		JLabel lbanji = new JLabel("�༶");
		lbanji.setBounds(x2 + boxw + g, y + (h + g) * 2, w, h);
		tp.add(lbanji);
		combox1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				try {
					String zy = combox1.getSelectedItem().toString();
					if (zy.equals("ͨ��רҵ")) {
						combox2.removeAllItems();
						combox2.addItem("�ź���ϵͳ");
						combox2.addItem("ģ���·");
						combox2.addItem("���ֵ�·");
						combox2.addItem("ͨ��ԭ��");
					} else if (zy.equals("��֯����רҵ")) {
						combox2.removeAllItems();
						combox2.addItem("��֯Ʒ���ѧ");
						combox2.addItem("��֯����ѧ");
						combox2.addItem("��е��ƻ���");
						combox2.addItem("��֯�ӹ���");
						combox2.addItem("��ɴѧ");

					} else if (zy.equals("�������ѧ�뼼��רҵ")) {
						combox2.removeAllItems();
						combox2.addItem("C���Գ������");
						combox2.addItem("JAVA���Գ������");
						combox2.addItem("���ݽṹ");
						combox2.addItem("��������ԭ��");
						combox2.addItem("����ϵͳ");
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
		JLabel lname = new JLabel("����");
		lname.setBounds(x, y, w, h);
		tp.add(lname);
		JLabel lid = new JLabel("ѧ��");
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
		combox1.addItem("�������ѧ�뼼��רҵ");
		combox1.setBounds(x2, y + (g + h) * 2, boxw, h);
		tp.add(combox1);
		combox1.addItem("��֯����רҵ");
		combox1.addItem("ͨ��רҵ");
		combox2 = new JComboBox<String>();
		combox2.setBounds(x2 + (boxw + g) * 2, y + (h + g) * 2, boxw, h);
		tp.add(combox2);
		combox2.addItem("C���Գ������");
		combox1.setBounds(x2, y + (g + h) * 2, 100, 30);
		controlButton = new JButton("���");
		controlButton.setBounds(x, y + (g + h) * 3 + 60, w, h);
		tp.add(controlButton);
		JLabel lmajor = new JLabel("רҵ");
		lmajor.setBounds(x, y + (h + g) * 2, w, h);
		tp.add(lmajor);
		JLabel lbanji = new JLabel("�γ�");
		lbanji.setBounds(x2 + boxw + g, y + (h + g) * 2, w, h);
		tp.add(lbanji);
		combox1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				try {
					String zy = combox1.getSelectedItem().toString();
					if (zy.equals("ͨ��רҵ")) {
						combox2.removeAllItems();
						combox2.addItem("�ź���ϵͳ");
						combox2.addItem("ģ���·");
						combox2.addItem("���ֵ�·");
						combox2.addItem("ͨ��ԭ��");
					} else if (zy.equals("��֯����רҵ")) {
						combox2.removeAllItems();
						combox2.addItem("��֯Ʒ���ѧ");
						combox2.addItem("��֯����ѧ");
						combox2.addItem("��е��ƻ���");
						combox2.addItem("��֯�ӹ���");
						combox2.addItem("��ɴѧ");

					} else if (zy.equals("�������ѧ�뼼��רҵ")) {
						combox2.removeAllItems();
						combox2.addItem("C���Գ������");
						combox2.addItem("JAVA���Գ������");
						combox2.addItem("���ݽṹ");
						combox2.addItem("��������ԭ��");
						combox2.addItem("����ϵͳ");
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
		combox1.addItem("�������ѧ�뼼��רҵ");
		combox1.addItem("��֯����רҵ");
		combox1.addItem("ͨ��רҵ");
		combox2 = new JComboBox<String>();

		combox2.addItem("C���Գ������");
		Object a[][];
		a = new Object[20][10];
		Object name[] = { "" };
		table = new JTable(a, name);
		controlButton = new JButton("��ѯ");
		JPanel p = new JPanel();
		p.add(new JLabel("רҵ"));
		p.add(combox1);
		p.add(new JLabel("�γ�"));
		p.add(combox2);
		p.add(controlButton);
		combox1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				try {
					String zy = combox1.getSelectedItem().toString();
					if (zy.equals("ͨ��רҵ")) {
						combox2.removeAllItems();
						combox2.addItem("�ź���ϵͳ");
						combox2.addItem("ģ���·");
						combox2.addItem("���ֵ�·");
						combox2.addItem("ͨ��ԭ��");
					} else if (zy.equals("��֯����רҵ")) {
						combox2.removeAllItems();
						combox2.addItem("��֯Ʒ���ѧ");
						combox2.addItem("��֯����ѧ");
						combox2.addItem("��е��ƻ���");
						combox2.addItem("��֯�ӹ���");
						combox2.addItem("��ɴѧ");

					} else if (zy.equals("�������ѧ�뼼��רҵ")) {
						combox2.removeAllItems();
						combox2.addItem("C���Գ������");
						combox2.addItem("JAVA���Գ������");
						combox2.addItem("���ݽṹ");
						combox2.addItem("��������ԭ��");
						combox2.addItem("����ϵͳ");
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
		combox1.addItem("�������ѧ�뼼��רҵ");
		combox1.addItem("��֯����רҵ");
		combox1.addItem("ͨ��רҵ");
		combox2 = new JComboBox<String>();

		combox2.addItem("�ƿ�1605");
		Object a[][];
		a = new Object[20][10];
		Object name[] = { "" };
		table = new JTable(a, name);
		controlButton = new JButton("��ѯ");
		JPanel p = new JPanel();
		p.add(new JLabel("רҵ"));
		p.add(combox1);
		p.add(new JLabel("�༶"));
		p.add(combox2);
		p.add(controlButton);
		combox1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				try {
					String zy = combox1.getSelectedItem().toString();
					if (zy.equals("ͨ��רҵ")) {
						combox2.removeAllItems();
						combox2.addItem("ͨ��1603");

					} else if (zy.equals("��֯����רҵ")) {
						combox2.removeAllItems();
						combox2.addItem("��֯1601");

					} else if (zy.equals("�������ѧ�뼼��רҵ")) {
						combox2.removeAllItems();
						combox2.addItem("�ƿ�1605");
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
		lname = new JLabel("����");
		lname.setBounds(x, y, w, h);
		lname.setBackground(Color.RED);
		lsex = new JLabel("�Ա�");
		lsex.setBounds(x, y + g + h, w, h);
		lid = new JLabel("ѧ��");
		lid.setBounds(x, y + (g + h) * 2, w, h);
		lmajor = new JLabel("רҵ");
		lmajor.setBounds(x, y + (g + h) * 3, w, h);
		lbanji = new JLabel("�༶");
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

		JButton bconfirm = new JButton("�ύ");
		bconfirm.setBounds(x, y + (g + h) * 5 + 60, 60, 30);
		m.add(bconfirm);
		bconfirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				// ����Ϣ��ӵ����ݿ�

				String name, sex, id, major, banji;
				name = tname.getText();
				sex = tsex.getText();
				id = tid.getText();
				major = tmajor.getText();
				banji = tbanji.getText();

				String url = "jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf8";/*
																											 * ����������뵽���ݿ������������
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
					JOptionPane.showMessageDialog(null, "��ӳɹ���", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);

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

		lname = new JLabel("����");
		lname.setBounds(x, y, w, h);

		lid = new JLabel("ѧ��");
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

		JButton bconfirm = new JButton("ɾ��");
		bconfirm.setBounds(x, y + (g + h) * 2 + 60, 60, 30);
		m.add(bconfirm);
		bconfirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				// ����Ϣ��ӵ����ݿ�

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
					sql = "delete from basicinformation where ѧ�� = '" + id + "'";

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
				JOptionPane.showMessageDialog(null, "ɾ���ɹ���", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);

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

		lname = new JLabel("����");
		lname.setBounds(x, y + (g + h) * 2, w, h);
		m.add(lname);

		lid = new JLabel("ѧ��");
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

		JButton queren = new JButton("ȷ��");
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
					System.out.println("���ӳɹ�");
					Statement state = (Statement) con.createStatement();
					ResultSet res = state.executeQuery(sql);
					while (res.next()) {
						if (id.equals(res.getString(3))) {
							System.out.println(res.getString(1) + res.getString(5));
							// ���� רҵ ѧ�� ����zhuanye id xingming
							ttname = res.getString(1);
							major = res.getString(5);

							break;
						}
					}
					tname.setText(ttname);
					tzhuanye.setText(major);
					System.out.println("ldsjflsk");
					/*
					 * if (res.getString(5).equals("�������ѧ�뼼��רҵ")) {
					 * 
					 * String cl[] = { "����", "ѧ��", "�༶", "C���Գ������", "JAVA�������", "���ݽṹ", "��������ԭ��",
					 * "����ϵͳ" }; ttp = cl; for (int i = 0; i < cl.length; i++) { datattp[0][i] =
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
					if (res.getString(5).equals("�������ѧ�뼼��רҵ")) {

						String colums[] = { "����", "ѧ��", "�༶", "C���Գ������", "JAVA�������", "���ݽṹ", "��������ԭ��", "����ϵͳ","y/n" };
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
					}  else if (res.getString(5).equals("ͨ��רҵ")) {
						String colums[] = { "����", "ѧ��", "�༶", "�ź���ϵͳ",
								"ģ���·", "���ֵ�·", "ͨ��ԭ��","y/n" };
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
					} else if (res.getString(5).equals("��֯����רҵ")) {
						String colums[] = { "����", "ѧ��", "�༶", "��֯Ʒ���ѧ",
								"��֯����ѧ", "��е��ƻ���", "��֯�ӹ���","��ɴѧ","y/n" };
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
		JLabel lzhuangye = new JLabel("רҵ");
		lzhuangye.setBounds(x, y + (g + h) * 3, w, h);
		m.add(lzhuangye);
		m.add(tzhuanye);

		JButton bconfirm = new JButton("�ύ");
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
																											 * ����������뵽���ݿ������������
																											 */
				String user = "root";
				String password = "";
				String sql = null;

				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = (Connection) DriverManager.getConnection(url, user, password);
					if (ttmajor.equals("�������ѧ�뼼��רҵ")) {
						System.out.println(a[5] + a[6] + a[7]);
						sql = "update computer set C���Գ������  = '" + a[3] + "', JAVA�������  = '" + a[4] + "', ���ݽṹ  = '"
								+ a[5] + "', ��������ԭ�� = '" + a[6] + "', ����ϵͳ  = '" + a[7] + "' where ѧ�� = '" + ttid
								+ "'";
						Statement state = con.createStatement();
						state.executeUpdate(sql);
						con.close();
					} else if (ttmajor.equals("ͨ��רҵ")) {
						System.out.println("5");
						sql = "update tongxin set �ź���ϵͳ  = '" + a[3] + "', ģ���·  = '" + a[4] + "', ���ֵ�·  = '" + a[5]
								+ "', ͨ��ԭ�� = '" + a[6] + "' where ѧ�� = '" + ttid + "'";
						Statement state = con.createStatement();
						state.executeUpdate(sql);
						con.close();
					} else if (ttmajor.equals("��֯����רҵ")) {
						sql = "update fangzhigongcheng set ��֯Ʒ���ѧ  = '" + a[3] + "', ��֯����ѧ  = '" + a[4] + "', ��е��ƻ���  = '"
								+ a[5] + "', ��֯�ӹ��� = '" + a[6] + "', ��ɴѧ = '" + a[7] + "' where ѧ�� = '" + ttid + "'";
						Statement state = con.createStatement();
						state.executeUpdate(sql);
						con.close();

					}
					JOptionPane.showMessageDialog(null, "�޸ĳɹ���", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// �������ݿ�
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

		lname = new JLabel("�û�����");
		lname.setBounds(x, y, w, h);

		lid = new JLabel("�û�����");
		lid.setBounds(x, y + g + h, w, h);

		liid = new JLabel("�޸ĺ�����");
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

		JButton bconfirm = new JButton("�޸�");
		bconfirm.setBounds(x, y + (g + h) * 2 + 60, 60, 30);
		m.add(bconfirm);
		bconfirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				// ����Ϣ��ӵ����ݿ�

				String name, password, password2;

				name = tname.getText();

				password = tid.getText();

				password2 = tiid.getText();
				// ���ݿ��ѯ����;
				String url = "jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf8";/*
																											 * ����������뵽���ݿ������������
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
						 * ����������뵽���ݿ������������
						 */
							String user1 = "root";
							String pass1 = "";
							String sql1 = null;
						Class.forName("com.mysql.jdbc.Driver");
				
						Connection con1 = (Connection) DriverManager.getConnection(url1, user1, pass1);
						Statement state1 = con1.createStatement();

						sql1 = "update usersinformation set ���� = '"+password2+"' where �˺� = '"+name+"' ";
						// sql = "updata userinformation set ���� = '"+password2+"' where �˺� = '"+name+"'
						// ";
					
						state1.executeUpdate(sql1);
						
						con1.close();
						// ��ʾ�޸�����ɹ��ɹ�
						JOptionPane.showMessageDialog(null, "�޸ĳɹ���", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
					} else {
						// ��ʾ�˺Ż��������
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

		lname = new JLabel("����");
		lname.setBounds(x, y, w, h);

		lid = new JLabel("ѧ��");
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

		JButton bconfirm = new JButton("��ѯ");
		bconfirm.setBounds(x, y + (g + h) * 2 + 60, 60, 30);
		m.add(bconfirm);
		table.setBounds(x, y + (g + h) * 5, 800, 100);
		m.add(table);
		bconfirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				// ����Ϣ��ӵ����ݿ�

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
					System.out.println("���ӳɹ�");
					Statement state = (Statement) con.createStatement();
					ResultSet res = state.executeQuery(sql);
					while (res.next()) {
						if (id.equals(res.getString(3))) {
							System.out.println(res.getString(1) + res.getString(5));
							// ���� רҵ ѧ�� ����zhuanye id xingming
							ttname = res.getString(1);
							major = res.getString(5);

							break;
						}
					}
					if (res.getString(5).equals("�������ѧ�뼼��רҵ")) {

						String colums[] = { "����", "ѧ��", "�༶", "C���Գ������", "JAVA�������", "���ݽṹ", "��������ԭ��", "����ϵͳ" };
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
					} else if (res.getString(5).equals("ͨ��רҵ")) {
						String colums[] = { "����", "ѧ��", "�༶", "�ź���ϵͳ", "ģ���·", "���ֵ�·", "ͨ��ԭ��" };
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
					} else if (res.getString(5).equals("��֯����רҵ")) {
						String colums[] = { "����", "ѧ��", "�༶", "��֯Ʒ���ѧ", "��֯����ѧ", "��е��ƻ���", "��֯�ӹ���", "��ɴѧ" };
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
