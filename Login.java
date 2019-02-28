package stusys;

import java.awt.GridLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.*;

import javax.swing.*;

public class Login extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JButton jb1, jb2, jb3; // 按钮
	JPanel jp1, jp2, jp3, jp4; // 面板
	JTextField jtf; // 文本框
	JLabel jlb1, jlb2, jlb3; // 标签
	JPasswordField jpf; // 密码框

	public static JPanel GImage = null;

	public Login() {
		GImage = new JPanel() {

			protected void paintComponent(Graphics g) {
				ImageIcon icon = new ImageIcon("D:\\bg.jpg");
				Image img = icon.getImage();
				g.drawImage(img, 0, 0, icon.getIconWidth(), icon.getIconHeight(), icon.getImageObserver());

			}

		};

		this.add(GImage);
		// TODO Auto-generated constructor stub
		jb1 = new JButton("登录");
		jb2 = new JButton("重置");
		// 设置按钮监听
		jb1.addActionListener(this);
		jb2.addActionListener(this);

		jp1 = new JPanel(); // 创建面板
		jp2 = new JPanel();
		jp3 = new JPanel();

		jlb1 = new JLabel("用户"); // 添加标签
		jlb2 = new JLabel("密 码");
		jlb3 = new JLabel("欢迎使用本系统");
		jlb3.setHorizontalAlignment(SwingConstants.CENTER);

		jtf = new JTextField(10); // 创建文本框和密码框
		jpf = new JPasswordField(10);

		// 加入面板中
		jp1.add(jlb1);
		jp1.add(jtf);

		jp2.add(jlb2);
		jp2.add(jpf);

		jp3.add(jb1);
		jp3.add(jb2);

		// 将JPane加入JFrame中
		this.add(jlb3);
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);

		// 设置布局

		this.setTitle("管理员登录");
		this.setLayout(new GridLayout(5, 1));
		this.setSize(400, 250); // 设置窗体大小
		this.setLocationRelativeTo(null);// 在屏幕中间显示(居中显示)
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); // 设置仅关闭当前窗口

		this.setVisible(true); // 设置可见
		this.setResizable(false); // 设置不可拉伸大小

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand() == "登录") {
			try {
				login();
			} catch (HeadlessException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getActionCommand() == "重置") {
			clear();
		}
	}

	// 清空账号和密码框
	private void clear() {
		// TODO Auto-generated method stub
		jtf.setText(""); // 设置为空
		jpf.setText("");

	}

	// 验证登录信息，并做处理
	public void login() throws HeadlessException, IOException, ClassNotFoundException, SQLException {
		String ss = jtf.getText().toString();

		String nn = jpf.getText().toString();
		int res = chaxun_yonghumima(ss, nn);
		if (res == 1) {
			JOptionPane.showMessageDialog(null, "登录成功！", "提示消息", JOptionPane.WARNING_MESSAGE);
			// dispose(); //使文原窗体消失
			dispose();
			Win a = new Win();
			a.init();
		} else {
			JOptionPane.showMessageDialog(null, "密码错误请重新输入！", "消息提示", JOptionPane.ERROR_MESSAGE);
			clear(); // 调用清除函数
		}
	}

	public int chaxun_yonghumima(String uu, String pp) throws ClassNotFoundException, SQLException {

		String url = "jdbc:mysql://localhost:3306/student?useSSL=false&serverTimezone=UTC";
		String user = "root";
		String password = "toor";
		String sql = null;

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = (Connection) DriverManager.getConnection(url, user, password);
		int f = 0;
		sql = "select * from usersinformation";
		System.out.println("链接成功");
		Statement state = (Statement) con.createStatement();
		ResultSet res = state.executeQuery(sql);
		while (res.next()) {
			if (uu.equals(res.getString(1)) && pp.equals(res.getString(2))) {
				f = 1;
				break;
			}
		}

		if (f == 1) {
			return 1;
		} else {
			return 0;
		}

	}

}
