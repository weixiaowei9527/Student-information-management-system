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

		// ѧ����Ϣ����
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("�ɼ�����ϵͳ");
		DefaultMutableTreeNode xuesheng = new DefaultMutableTreeNode("ѧ����Ϣ����");
		DefaultMutableTreeNode kecheng = new DefaultMutableTreeNode("�γ���Ϣ����");
		DefaultMutableTreeNode zhuanye = new DefaultMutableTreeNode("רҵ��Ϣ����");
		DefaultMutableTreeNode yonghu = new DefaultMutableTreeNode("�û���Ϣ����");
		root.add(xuesheng);
		root.add(kecheng);
		root.add(zhuanye);
		root.add(yonghu);
		//
		DefaultMutableTreeNode xzeng = new DefaultMutableTreeNode("���ѧ����Ϣ");
		DefaultMutableTreeNode xcha = new DefaultMutableTreeNode("��ѯѧ����Ϣ");
		DefaultMutableTreeNode xgai = new DefaultMutableTreeNode("�޸�ѧ����Ϣ");
		DefaultMutableTreeNode xshan = new DefaultMutableTreeNode("ɾ��ѧ����Ϣ");
		xuesheng.add(xzeng);
		xuesheng.add(xcha);
		xuesheng.add(xgai);
		xuesheng.add(xshan);

		DefaultMutableTreeNode kzeng = new DefaultMutableTreeNode("�γ����");
		DefaultMutableTreeNode kcha = new DefaultMutableTreeNode("�γ�ɾ��");
		DefaultMutableTreeNode kshan = new DefaultMutableTreeNode("�γ̲鿴");
		kecheng.add(kzeng);
		kecheng.add(kcha);
		kecheng.add(kshan);

		//
		DefaultMutableTreeNode zzeng = new DefaultMutableTreeNode("רҵ��Ϣ��ѯ");

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
					if (node.toString().equals("���ѧ����Ϣ")) {
						int num = Win.tabbedPane.getTabCount();
						if (num >= 1) {
							Win.tabbedPane.removeAll();
						}
						Win.tabbedPane.addTab("��� ѧ����Ϣ", Face.studentSelect());
						System.out.println("ok");
					} else if (node.toString().equals("��ѯѧ����Ϣ")) {
						int num = Win.tabbedPane.getTabCount();
						if (num >= 1) {
							Win.tabbedPane.removeAll();
						}
						Win.tabbedPane.addTab("��ѯѧ����Ϣ", Face.findstudent());

					} else if (node.toString().equals("ɾ��ѧ����Ϣ")) {
						int num = Win.tabbedPane.getTabCount();
						if (num >= 1) {
							Win.tabbedPane.removeAll();
						}
						Win.tabbedPane.addTab("ɾ��ѧ����Ϣ", Face.studentDelete());

					} else if (node.toString().equals("�޸�ѧ����Ϣ")) {
						int num = Win.tabbedPane.getTabCount();
						if (num >= 1) {
							Win.tabbedPane.removeAll();
						}

						Win.tabbedPane.addTab("�޸�ѧ����Ϣ", Face.studentChange());

					} else if (node.toString().equals("רҵ��Ϣ��ѯ")) {
						int num = Win.tabbedPane.getTabCount();
						if (num >= 1) {
							Win.tabbedPane.removeAll();
						}
						Win.tabbedPane.addTab("�޸�ѧ����Ϣ", Face.findMajor());

					} else if (node.toString().equals("�γ����")) {
						int num = Win.tabbedPane.getTabCount();
						if (num >= 1) {
							Win.tabbedPane.removeAll();
						}
						Win.tabbedPane.addTab("�γ����", Face.addClass());

					} else if (node.toString().equals("�û���Ϣ����")) {
						int num = Win.tabbedPane.getTabCount();
						if (num >= 1) {
							Win.tabbedPane.removeAll();
						}
						Win.tabbedPane.addTab("�û���Ϣ����", Face.user());

					}else if (node.toString().equals("�γ�ɾ��")) {
						int num = Win.tabbedPane.getTabCount();
						if (num >= 1) {
							Win.tabbedPane.removeAll();
						}
						Win.tabbedPane.addTab("�γ�ɾ��", Face.delClass());

					}else if (node.toString().equals("�γ̲鿴")) {
						int num = Win.tabbedPane.getTabCount();
						if (num >= 1) {
							Win.tabbedPane.removeAll();
						}
						Win.tabbedPane.addTab("�γ̲鿴", Face.findClass());

					}

				}
			}

		});
		tp = new JScrollPane(tree);
		tp.setBounds(0, 0, 300, 1200);
		return tp;
	}
}
