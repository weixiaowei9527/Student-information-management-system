package stusys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Shujuku {
	// JDBC 驱动名及数据库 URL
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/student?useSSL=false&serverTimezone=UTC";

	// 数据库的用户名与密码，需要根据自己的设置
	static final String USER = "root";
	static final String PASS = "toor";
	Connection conn;

	void init() {
		conn = null;
		Statement stmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("数据库开始连接>>>");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("连接成功");
		} catch (Exception e) {
			System.out.println("连接失败");
		}

	}
	// 增加数据
		void addMajorInfo(String strclass, String table, String score) throws ClassNotFoundException {
			// String insert = "INSERT INTO " + table + " VALUES (?,?,?,?,?)";
			if(table.equals("计算机科学与技术专业")){
				String insert = "INSERT INTO " + table + "("+strclass+") VALUES (?)";
			//问号的个数必须和数据库中的个数一样
			try {
				Class.forName(JDBC_DRIVER);
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
				System.out.println("连接成功");
				PreparedStatement sql = conn.prepareStatement(insert);
				/*sql.setString(1, student.getName());
				sql.setString(2, student.getId());
				sql.setString(3, student.getSex());
				sql.setString(4, student.getBanji());
				sql.setString(5, student.getMajor());*/
				sql.setString(1, "1654");
				int m = sql.executeUpdate();
				
				if (m != 0) {
					System.out.println("添加了" + m + "条记录");
					JOptionPane.showMessageDialog(null, "添加成功", "提示消息",
							JOptionPane.WARNING_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "添加失败", "提示消息",
							JOptionPane.WARNING_MESSAGE);
					System.out.println("添加失败");
				}
				sql.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("插入失败");
			}
			}
			
		}
	// 增加数据
	void addInfo(Student student, String table) throws ClassNotFoundException {
		/*
		 * 没有表明插入那一部分
		 * String insert = "INSERT INTO " + table + " VALUES (?,?,?,?,?,?)";
		 * 没有表明时，数据库里有多少列，就得有多少问号
		 */
		//表明插入的部分的内容
		String insert = "INSERT INTO " + table + "(姓名,学号) VALUES (?,?)";
		//问号的个数必须和数据库中的个数一样
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("连接成功");
			PreparedStatement sql = conn.prepareStatement(insert);
			sql.setString(1, student.getName());
			sql.setString(2, student.getId());
			//sql.setString(3, student.getSex());
			//sql.setString(4, student.getBanji());
			//sql.setString(5, student.getMajor());
			//sql.setString(6, "5");
			int m = sql.executeUpdate();
			
			if (m != 0) {
				System.out.println("添加了" + m + "条记录");
				JOptionPane.showMessageDialog(null, "添加成功", "提示消息",
						JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "添加失败", "提示消息",
						JOptionPane.WARNING_MESSAGE);
				System.out.println("添加失败");
			}
			sql.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("插入失败");
		}
	}

	// 刪除数据
	void delInfo(Student student, String table) {
		String sql = "DELETE from " + table + " where id=?";
		try {
			System.out.println(student.getId().trim());
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, student.getId().trim());
			boolean re = ps.execute();
			if (!re) {
				JOptionPane.showMessageDialog(null, "删除成功", "提示消息",
						JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "删除失败", "提示消息",
						JOptionPane.WARNING_MESSAGE);
				System.out.println("删除失败");
			}
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 查询数据
	Student cheInfo(Student student, String table) throws ClassNotFoundException {
		String sql = "select * from " + table + " where 学号 = ?";
		System.out.println(student.getId());
		Student per = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("链接成功");
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
			System.out.println("查询出错");
			e.printStackTrace();
		}
		System.out.println("jdfjljd");
		return per;
	}

	// 修改数据
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
			System.out.println("插入失败");
		}
	}
}
