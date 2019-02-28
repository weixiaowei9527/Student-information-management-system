package stusys;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class Win extends JFrame{

	JPanel top, bottom;
	static JPanel right;
	JPanel left;
	JTree tree;
	static JSplitPane jsp;
	static JTabbedPane tabbedPane;
	JMenuBar menubar;
	Win() {
		menubar = new JMenuBar();
		JMenu menu1 = new JMenu("菜单");
		JMenu menu2 = new JMenu("帮助");
		menubar.add(menu1);
		menubar.add(menu2);
		JMenuItem item = new JMenuItem("退出");
		item.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		menu1.add(item);
		this.setJMenuBar(menubar);
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		tabbedPane.addTab("欢迎使用", new JPanel());
		//tabbedPane.setSelectedIndex(1);
		this.setBounds(60, 60, 600, 400);
		this.setTitle("学生信息管理系统");
		JLabel title = new JLabel("成绩管理系统");
		top = new JPanel();
		// top.setLayout(null);
		// top.setBounds(300,20,300,60);
		// title.setBounds(300,20,300,60);
		top.add(title);
		this.addComponentListener(new ComponentListener(){

			@Override
			public void componentHidden(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentMoved(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentResized(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				jsp.setDividerLocation(0.2);
				
			}

			@Override
			public void componentShown(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		this.add(top, BorderLayout.NORTH);
		// this.add(top,BorderLayout.NORTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		// 去边框
		//this.setUndecorated(true);
		this.setVisible(true);
	}

	void init() {
		
		left = new JPanel();
		right = new JPanel();
		tabbedPane.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("当前选中了" + tabbedPane.getSelectedIndex());
			}
			
		});
		
		left.add(Tree.mytree());
		right.setLayout(null);
		left.setLayout(null);
		JScrollPane tabbedpanesp = new  JScrollPane(tabbedPane);
		tabbedpanesp.setBounds(10, 10, 1000, 700);
		right.add(tabbedpanesp);
		tabbedPane.setBounds(10, 10, 1000, 700);
		
		jsp.setLeftComponent(left);
		jsp.setRightComponent(right);
		
	
		jsp.setDividerSize(1);
		this.add(jsp);
		//底部
		bottom = new JPanel();
		this.add(bottom, BorderLayout.SOUTH);
		JButton tuichu = new JButton("退出");
		bottom.add(tuichu);
		tuichu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);

			}
		});
		this.validate();
	}
}
