package stusys;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class Tree {
	static JScrollPane mytree() {
		JScrollPane tp;
		final JTree tree;

		// 学生信息管理
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("成绩管理系统");
		DefaultMutableTreeNode xuesheng = new DefaultMutableTreeNode("学生信息管理");
		DefaultMutableTreeNode kecheng = new DefaultMutableTreeNode("课程信息管理");
		DefaultMutableTreeNode zhuanye = new DefaultMutableTreeNode("专业信息管理");
		DefaultMutableTreeNode yonghu = new DefaultMutableTreeNode("用户信息管理");
		root.add(xuesheng);
		root.add(kecheng);
		root.add(zhuanye);
		root.add(yonghu);
		//
		DefaultMutableTreeNode xzeng = new DefaultMutableTreeNode("添加学生信息");
		DefaultMutableTreeNode xcha = new DefaultMutableTreeNode("查询学生信息");
		DefaultMutableTreeNode xgai = new DefaultMutableTreeNode("修改学生信息");
		DefaultMutableTreeNode xshan = new DefaultMutableTreeNode("删除学生信息");
		xuesheng.add(xzeng);
		xuesheng.add(xcha);
		xuesheng.add(xgai);
		xuesheng.add(xshan);

		DefaultMutableTreeNode kzeng = new DefaultMutableTreeNode("课程添加");
		DefaultMutableTreeNode kcha = new DefaultMutableTreeNode("课程删除");
		DefaultMutableTreeNode kshan = new DefaultMutableTreeNode("课程查看");
		kecheng.add(kzeng);
		kecheng.add(kcha);
		kecheng.add(kshan);

		//
		DefaultMutableTreeNode zzeng = new DefaultMutableTreeNode("专业信息查询");

		zhuanye.add(zzeng);

		tree = new JTree(root);
		// tree.setBounds(10, 10, 300, 600);
		tree.addTreeSelectionListener(new TreeSelectionListener() {

			@Override
			public void valueChanged(TreeSelectionEvent arg0) {
				// TODO Auto-generated method stub
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree
						.getLastSelectedPathComponent();
				if (node.isLeaf()) {
					if (node.toString().equals("添加学生信息")) {
						int num = Win.tabbedPane.getTabCount();
						if (num >= 1) {
							Win.tabbedPane.removeAll();
						}
						Win.tabbedPane.addTab("添加 学生信息", Face.studentSelect());
						System.out.println("ok");
					} else if (node.toString().equals("查询学生信息")) {
						int num = Win.tabbedPane.getTabCount();
						if (num >= 1) {
							Win.tabbedPane.removeAll();
						}
						Win.tabbedPane.addTab("查询学生信息", Face.findstudent());

					} else if (node.toString().equals("删除学生信息")) {
						int num = Win.tabbedPane.getTabCount();
						if (num >= 1) {
							Win.tabbedPane.removeAll();
						}
						Win.tabbedPane.addTab("删除学生信息", Face.studentDelete());

					} else if (node.toString().equals("修改学生信息")) {
						int num = Win.tabbedPane.getTabCount();
						if (num >= 1) {
							Win.tabbedPane.removeAll();
						}

						Win.tabbedPane.addTab("修改学生信息", Face.studentChange());

					} else if (node.toString().equals("专业信息查询")) {
						int num = Win.tabbedPane.getTabCount();
						if (num >= 1) {
							Win.tabbedPane.removeAll();
						}
						Win.tabbedPane.addTab("修改学生信息", Face.findMajor());

					} else if (node.toString().equals("课程添加")) {
						int num = Win.tabbedPane.getTabCount();
						if (num >= 1) {
							Win.tabbedPane.removeAll();
						}
						Win.tabbedPane.addTab("课程添加", Face.addClass());

					} else if (node.toString().equals("用户信息管理")) {
						int num = Win.tabbedPane.getTabCount();
						if (num >= 1) {
							Win.tabbedPane.removeAll();
						}
						Win.tabbedPane.addTab("用户信息管理", Face.user());

					}else if (node.toString().equals("课程删除")) {
						int num = Win.tabbedPane.getTabCount();
						if (num >= 1) {
							Win.tabbedPane.removeAll();
						}
						Win.tabbedPane.addTab("课程删除", Face.delClass());

					}else if (node.toString().equals("课程查看")) {
						int num = Win.tabbedPane.getTabCount();
						if (num >= 1) {
							Win.tabbedPane.removeAll();
						}
						Win.tabbedPane.addTab("课程查看", Face.findClass());

					}

				}
			}

		});
		tp = new JScrollPane(tree);
		tp.setBounds(0, 0, 300, 1200);
		return tp;
	}
}
