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
	JButton jb1, jb2, jb3; // ��ť
	JPanel jp1, jp2, jp3, jp4; // ���
	JTextField jtf; // �ı���
	JLabel jlb1, jlb2, jlb3; // ��ǩ
	JPasswordField jpf; // �����

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
		jb1 = new JButton("��¼");
		jb2 = new JButton("����");
		// ���ð�ť����
		jb1.addActionListener(this);
		jb2.addActionListener(this);

		jp1 = new JPanel(); // �������
		jp2 = new JPanel();
		jp3 = new JPanel();

		jlb1 = new JLabel("�û�"); // ��ӱ�ǩ
		jlb2 = new JLabel("�� ��");
		jlb3 = new JLabel("��ӭʹ�ñ�ϵͳ");
		jlb3.setHorizontalAlignment(SwingConstants.CENTER);

		jtf = new JTextField(10); // �����ı���������
		jpf = new JPasswordField(10);

		// ���������
		jp1.add(jlb1);
		jp1.add(jtf);

		jp2.add(jlb2);
		jp2.add(jpf);

		jp3.add(jb1);
		jp3.add(jb2);

		// ��JPane����JFrame��
		this.add(jlb3);
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);

		// ���ò���

		this.setTitle("����Ա��¼");
		this.setLayout(new GridLayout(5, 1));
		this.setSize(400, 250); // ���ô����С
		this.setLocationRelativeTo(null);// ����Ļ�м���ʾ(������ʾ)
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); // ���ý��رյ�ǰ����

		this.setVisible(true); // ���ÿɼ�
		this.setResizable(false); // ���ò��������С

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand() == "��¼") {
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
		} else if (e.getActionCommand() == "����") {
			clear();
		}
	}

	// ����˺ź������
	private void clear() {
		// TODO Auto-generated method stub
		jtf.setText(""); // ����Ϊ��
		jpf.setText("");

	}

	// ��֤��¼��Ϣ����������
	public void login() throws HeadlessException, IOException, ClassNotFoundException, SQLException {
		String ss = jtf.getText().toString();

		String nn = jpf.getText().toString();
		int res = chaxun_yonghumima(ss, nn);
		if (res == 1) {
			JOptionPane.showMessageDialog(null, "��¼�ɹ���", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
			// dispose(); //ʹ��ԭ������ʧ
			dispose();
			Win a = new Win();
			a.init();
		} else {
			JOptionPane.showMessageDialog(null, "����������������룡", "��Ϣ��ʾ", JOptionPane.ERROR_MESSAGE);
			clear(); // �����������
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
		System.out.println("���ӳɹ�");
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
