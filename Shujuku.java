package stusys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Shujuku {
	// JDBC �����������ݿ� URL
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/student?useSSL=false&serverTimezone=UTC";

	// ���ݿ���û��������룬��Ҫ�����Լ�������
	static final String USER = "root";
	static final String PASS = "toor";
	Connection conn;

	void init() {
		conn = null;
		Statement stmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("���ݿ⿪ʼ����>>>");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("���ӳɹ�");
		} catch (Exception e) {
			System.out.println("����ʧ��");
		}

	}
	// ��������
		void addMajorInfo(String strclass, String table, String score) throws ClassNotFoundException {
			// String insert = "INSERT INTO " + table + " VALUES (?,?,?,?,?)";
			if(table.equals("�������ѧ�뼼��רҵ")){
				String insert = "INSERT INTO " + table + "("+strclass+") VALUES (?)";
			//�ʺŵĸ�����������ݿ��еĸ���һ��
			try {
				Class.forName(JDBC_DRIVER);
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
				System.out.println("���ӳɹ�");
				PreparedStatement sql = conn.prepareStatement(insert);
				/*sql.setString(1, student.getName());
				sql.setString(2, student.getId());
				sql.setString(3, student.getSex());
				sql.setString(4, student.getBanji());
				sql.setString(5, student.getMajor());*/
				sql.setString(1, "1654");
				int m = sql.executeUpdate();
				
				if (m != 0) {
					System.out.println("�����" + m + "����¼");
					JOptionPane.showMessageDialog(null, "��ӳɹ�", "��ʾ��Ϣ",
							JOptionPane.WARNING_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "���ʧ��", "��ʾ��Ϣ",
							JOptionPane.WARNING_MESSAGE);
					System.out.println("���ʧ��");
				}
				sql.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("����ʧ��");
			}
			}
			
		}
	// ��������
	void addInfo(Student student, String table) throws ClassNotFoundException {
		/*
		 * û�б���������һ����
		 * String insert = "INSERT INTO " + table + " VALUES (?,?,?,?,?,?)";
		 * û�б���ʱ�����ݿ����ж����У��͵��ж����ʺ�
		 */
		//��������Ĳ��ֵ�����
		String insert = "INSERT INTO " + table + "(����,ѧ��) VALUES (?,?)";
		//�ʺŵĸ�����������ݿ��еĸ���һ��
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("���ӳɹ�");
			PreparedStatement sql = conn.prepareStatement(insert);
			sql.setString(1, student.getName());
			sql.setString(2, student.getId());
			//sql.setString(3, student.getSex());
			//sql.setString(4, student.getBanji());
			//sql.setString(5, student.getMajor());
			//sql.setString(6, "5");
			int m = sql.executeUpdate();
			
			if (m != 0) {
				System.out.println("�����" + m + "����¼");
				JOptionPane.showMessageDialog(null, "��ӳɹ�", "��ʾ��Ϣ",
						JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "���ʧ��", "��ʾ��Ϣ",
						JOptionPane.WARNING_MESSAGE);
				System.out.println("���ʧ��");
			}
			sql.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("����ʧ��");
		}
	}

	// �h������
	void delInfo(Student student, String table) {
		String sql = "DELETE from " + table + " where id=?";
		try {
			System.out.println(student.getId().trim());
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, student.getId().trim());
			boolean re = ps.execute();
			if (!re) {
				JOptionPane.showMessageDialog(null, "ɾ���ɹ�", "��ʾ��Ϣ",
						JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "ɾ��ʧ��", "��ʾ��Ϣ",
						JOptionPane.WARNING_MESSAGE);
				System.out.println("ɾ��ʧ��");
			}
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// ��ѯ����
	Student cheInfo(Student student, String table) throws ClassNotFoundException {
		String sql = "select * from " + table + " where ѧ�� = ?";
		System.out.println(student.getId());
		Student per = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("���ӳɹ�");
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, student.getId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				per = new Student();
				per.setName(rs.getString(1));
				per.setSex(rs.getString(2));
				per.setId(rs.getString(3));
				per.setBanji(rs.getString(4));
				per.setMajor(rs.getString(5));
				System.out.println("jfldj");
				System.out.println(rs.getString(4));
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("��ѯ����");
			e.printStackTrace();
		}
		System.out.println("jdfjljd");
		return per;
	}

	// �޸�����
	void changeInfo(Student student, String table, String change) {
		String sql = "update " + table + " set " + change + "=? where id=?";
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "xiaoming");
			ps.setString(2, student.getId());
			int m = ps.executeUpdate();

			ps.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("����ʧ��");
		}
	}
}
