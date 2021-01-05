package Project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Login extends JFrame {

	// �����ȣ �˻�
	private JLabel jlblSchEmpno;
	private JTextField jtfSchEmpno;
	private JButton jbSchEmpno;

	// �����ȣ
	private JLabel jlblEmpno;
	private JTextField jtfEmpno;

	// �����̸�
	private JLabel jlblName;
	private JTextField jtfName;

	// �μ���
	private JLabel jlblJob;
	private JTextField jtfJob;

	// �Ŵ��� ��ȣ
	private JLabel jlblMgr;
	private JTextField jtfMgr;

	// �Ի� ����
	private JLabel jlblHiredate;
	private JTextField jtfHiredate;

	// ����
	private JLabel jlblSal;
	private JTextField jtfSal;

	// ���ʽ�
	private JLabel jlblComm;
	private JTextField jtfComm;

	// �μ���ȣ
	private JLabel jlblDeptno;
	private JTextField jtfDeptno;

	// �� �ʱ�ȭ
	private JButton jbRset;

	// ��� �߰�
	private JButton jbEmpAdd;

	// ��� ����
	private JButton jbEmpDel;

	// ��� ������Ʈ
	private JButton jbEmpUp;

	Login l;

	JButton jbmodify;

	public Login() {
		super("�λ� �޿� ����");

		l = this;
		// �����ȣ�˻�
		jlblSchEmpno = new JLabel("��� ��ȣ �˻�");
		jtfSchEmpno = new JTextField();
		jbSchEmpno = new JButton("�˻�");

		// �����ȣ
		jlblEmpno = new JLabel("��� ��ȣ");
		jtfEmpno = new JTextField();

		// �����̸�
		jlblName = new JLabel("���� ��");
		jtfName = new JTextField();

		// �μ���
		jlblJob = new JLabel("�μ� ��");
		jtfJob = new JTextField();

		// �Ŵ��� ��ȣ
		jlblMgr = new JLabel("�Ŵ��� ��ȣ");
		jtfMgr = new JTextField();

		// �Ի� ����
		jlblHiredate = new JLabel("�Ի� ����");
		jtfHiredate = new JTextField();

		// ����
		jlblSal = new JLabel("����");
		jtfSal = new JTextField("");

		// ���ʽ�
		jlblComm = new JLabel("���ʽ�");
		jtfComm = new JTextField();

		// �μ���ȣ
		jlblDeptno = new JLabel("�μ���ȣ");
		jtfDeptno = new JTextField();

		// ��� �߰�
		jbEmpAdd = new JButton("��� �߰�");

		// ��� ����
		jbEmpDel = new JButton("��� ����");

		// ��� ���� ������Ʈ
		jbEmpUp = new JButton("��� ���� ����");

		// ���ʱ�ȭ
		jbRset = new JButton("�ؽ�Ʈ �ʱ�ȭ");

		jbmodify = new JButton("����");

		// ��ġ������ ������ġ
		setLayout(null);

		// �̸�
		add(jlblSchEmpno).setBounds(50, 50, 180, 30);
		jlblSchEmpno.setFont(new Font("����", Font.BOLD, 25));
		add(jtfSchEmpno).setBounds(230, 48, 120, 35);
		jtfSchEmpno.setFont(new Font("����", Font.BOLD, 20));
		add(jbSchEmpno).setBounds(355, 48, 70, 35);
		jbSchEmpno.setFont(new Font("����", Font.BOLD, 18));
		jbSchEmpno.setBackground(new Color(85, 134, 235));

		// �����ȣ
		add(jlblEmpno).setBounds(65, 150, 100, 35);
		jlblEmpno.setFont(new Font("����", Font.BOLD, 20));
		add(jtfEmpno).setBounds(180, 150, 120, 30);

		// ������
		add(jlblName).setBounds(65, 210, 100, 35);
		jlblName.setFont(new Font("����", Font.BOLD, 20));
		add(jtfName).setBounds(180, 210, 120, 30);

		// �μ���
		add(jlblJob).setBounds(65, 270, 100, 35);
		jlblJob.setFont(new Font("����", Font.BOLD, 20));
		add(jtfJob).setBounds(180, 270, 120, 30);

		// �Ŵ��� ��ȣ
		add(jlblMgr).setBounds(65, 330, 110, 35);
		jlblMgr.setFont(new Font("����", Font.BOLD, 20));
		add(jtfMgr).setBounds(180, 330, 120, 30);

		// �Ի� ����
		add(jlblHiredate).setBounds(350, 150, 100, 35);
		jlblHiredate.setFont(new Font("����", Font.BOLD, 20));
		add(jtfHiredate).setBounds(470, 150, 120, 30);

		// ����
		add(jlblSal).setBounds(350, 210, 100, 35);
		jlblSal.setFont(new Font("����", Font.BOLD, 20));
		add(jtfSal).setBounds(470, 210, 120, 30);

		// ���ʽ�
		add(jlblComm).setBounds(350, 270, 100, 35);
		jlblComm.setFont(new Font("����", Font.BOLD, 20));
		add(jtfComm).setBounds(470, 270, 120, 30);

		// �μ���ȣ
		add(jlblDeptno).setBounds(350, 330, 100, 35);
		jlblDeptno.setFont(new Font("����", Font.BOLD, 20));
		add(jtfDeptno).setBounds(470, 330, 120, 30);

		// �ؽ�Ʈ �ʱ�ȭ
		add(jbRset).setBounds(40, 400, 150, 35);

		// ��� �߰�
		add(jbEmpAdd).setBounds(210, 400, 150, 35);

		// ��� ����
		add(jbEmpDel).setBounds(380, 400, 150, 35);

		// ��� ����
		add(jbEmpUp).setBounds(550, 400, 150, 35);

		Login.EmpEvt ee = this.new EmpEvt();
		jtfSchEmpno.addActionListener(ee);
		jbSchEmpno.addActionListener(ee);

		setSize(750, 500);
		setLocationRelativeTo(null);
		setVisible(true);

		// ========================================= ��ư �̺�Ʈ =========================================
		// �ؽ�Ʈ �ʱ�ȭ
		jbRset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int idx = JOptionPane.showConfirmDialog(l, "������ �Էµ� �ؽ�Ʈ�� �ʱ�ȭ �ϰڽ��ϱ�?", "�ؽ�Ʈ �ʱ�ȭ",
						JOptionPane.YES_NO_OPTION);

				switch (idx) {
				case JOptionPane.YES_OPTION: {
					jtfSchEmpno.setText("");
					jtfEmpno.setText("");
					jtfName.setText("");
					jtfJob.setText("");
					jtfMgr.setText("");
					jtfHiredate.setText("");
					jtfSal.setText("");
					jtfComm.setText("");
					jtfDeptno.setText("");
				}
					break;
				case JOptionPane.NO_OPTION:
					break;
				}// end switch
			}// actionPerformed
		});// jbRset.addActionListener
		JFrame jf = new JFrame("��� �λ����� ����");
//		JLabel jlblEmpno = new JLabel("��� ��ȣ");
		JTextField jtfEmpno1 = new JTextField();
		JLabel jlblSal = new JLabel("����");
		JTextField jtfSal1 = new JTextField();
		JLabel jlblComm = new JLabel("���ʽ�");
		JTextField jtfComm1 = new JTextField();

		// ��� ����(������Ʈ) ----------------------------------------
		jbEmpUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				jf.setLayout(null);

				// �����ȣ
				jf.add(jlblEmpno).setBounds(50, 50, 100, 30);
				jlblEmpno.setFont(new Font("����", Font.BOLD, 20));
				jf.add(jtfEmpno1).setBounds(150, 50, 120, 30);

				// ��� ����
				jf.add(jlblSal).setBounds(50, 100, 100, 30);
				jlblSal.setFont(new Font("����", Font.BOLD, 20));
				jf.add(jtfSal1).setBounds(150, 100, 120, 30);

				// ��� ���ʽ�
				jf.add(jlblComm).setBounds(50, 150, 100, 30);
				jlblComm.setFont(new Font("����", Font.BOLD, 20));
				jf.add(jtfComm1).setBounds(150, 150, 120, 30);

				jf.add(jbmodify).setBounds(200, 230, 100, 30);

				jf.setSize(500, 350);
				jf.setLocationRelativeTo(null);
				jf.setVisible(true);

			}// actionPerformed
		});// addActionListener

		jbmodify.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == jbmodify) {
					EmpStatementDAO eDAO = EmpStatementDAO.getInstance();
					try {
						EmpModifyVO EVO = new EmpModifyVO(Integer.valueOf(jtfSal1.getText()),
								Integer.valueOf(jtfComm1.getText()));

						eDAO.updateEmp(Integer.valueOf(jtfEmpno1.getText()), EVO);
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(l, "�����ȣ / ���� / ���ʽ��� ���ڸ� �Է��Ͻ� �� �ֽ��ϴ�.\n  Ȯ�� �� �Էº�Ź�帳�ϴ�.");
//						e1.printStackTrace();
					} catch (SQLException e1) {
						switch (e1.getErrorCode()) {
						case 1438:
							JOptionPane.showMessageDialog(l, "������ ���ʽ��� 7�ڸ� ���� �Է°����մϴ�.\n �Ǵ� �����ȣ�� 4�ڸ����� Ȯ�� ��Ź�帳�ϴ�.");
						}// end switch
						e1.printStackTrace();
					} // end catch
				} // end if
			}// actionPerformed
		});// addActionListener

		// ��� ���� --------------------------------------
		JFrame jfdel = new JFrame("��� ����");
		JTextField jtfdel = new JTextField();
		JButton jbdel = new JButton("��� ����");
		jbEmpDel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				jfdel.setLayout(null);

				jfdel.add(jlblEmpno).setBounds(190, 10, 100, 50);
				jlblEmpno.setFont(new Font("����", Font.BOLD, 20));
				jfdel.add(jtfdel).setBounds(190, 55, 100, 20);
				jfdel.add(jbdel).setBounds(190, 100, 100, 30);

				jfdel.setSize(500, 200);
				jfdel.setLocationRelativeTo(null);
				jfdel.setVisible(true);
			}// actionPerformed
		});// addActionListener

		// ȸ�� ����
		jbdel.addActionListener(new ActionListener() {
			int rows = 0;

			@Override
			public void actionPerformed(ActionEvent ae) {
				EmpStatementDAO eDAO = EmpStatementDAO.getInstance();

				int idx = JOptionPane.showConfirmDialog(l, "�ش� ����� ������ �����Ͻðڽ��ϱ�?", "��� ����", JOptionPane.YES_NO_OPTION);

				if (ae.getSource() == jbdel) {
					switch (idx) {
					case JOptionPane.YES_OPTION: {
						try {
							rows = eDAO.removeEmp(Integer.valueOf(jtfdel.getText()));
							if (rows != 0) {
								JOptionPane.showMessageDialog(l, "������ �Ϸ�Ǿ����ϴ�.");
							} else {
								JOptionPane.showMessageDialog(l, "�����ȣ�� �������� �ʽ��ϴ�.");
							} // end if
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} // end catch
					}
						break;// yes case
					case JOptionPane.NO_OPTION:
						break;
					}// end switch
				} // end if

			}// actionPerformed
		});// addActionListener

		// ȸ�� �߰�
		jbEmpAdd.addActionListener(new ActionListener() {
			JFrame jfAdd = new JFrame("��� �߰�");

			// �����ȣ
			private JLabel jlblEmpnoA = new JLabel("�����ȣ");
			private JTextField jtfEmpnoA = new JTextField();

			// �����̸�
			private JLabel jlblNameA = new JLabel("������");
			private JTextField jtfNameA = new JTextField();

			// �μ���
			private JLabel jlblJobA = new JLabel("�μ���");
			private JTextField jtfJobA = new JTextField();;

			// �Ŵ��� ��ȣ
			private JLabel jlblMgrA = new JLabel("�Ŵ��� ��ȣ");
			private JTextField jtfMgrA = new JTextField();;

			// �Ի� ����
			private JLabel jlblHiredateA = new JLabel("�Ի� ����");
			private JTextField jtfHiredateA = new JTextField();;
			private JLabel jlblHirechkA = new JLabel("ex)20210101 8����");
			// ����
			private JLabel jlblSalA = new JLabel("����");
			private JTextField jtfSalA = new JTextField();;

			// ���ʽ�
			private JLabel jlblCommA = new JLabel("���ʽ�");
			private JTextField jtfCommA = new JTextField();;

			// �μ���ȣ
			private JLabel jlblDeptnoA = new JLabel("�μ���ȣ");
			private JTextField jtfDeptnoA = new JTextField();;

			//����߰� ��ư
			private JButton jbAdd = new JButton("��� �߰�");

			@Override
			public void actionPerformed(ActionEvent e) {

				jfAdd.setLayout(null);
				// �����ȣ
				jfAdd.add(jlblEmpnoA).setBounds(65, 50, 100, 35);
				jlblEmpnoA.setFont(new Font("����", Font.BOLD, 20));
				jfAdd.add(jtfEmpnoA).setBounds(180, 50, 120, 30);

				// ������
				jfAdd.add(jlblNameA).setBounds(65, 110, 100, 35);
				jlblNameA.setFont(new Font("����", Font.BOLD, 20));
				jfAdd.add(jtfNameA).setBounds(180, 110, 120, 30);

				// �μ���
				jfAdd.add(jlblJobA).setBounds(65, 170, 100, 35);
				jlblJobA.setFont(new Font("����", Font.BOLD, 20));
				jfAdd.add(jtfJobA).setBounds(180, 170, 120, 30);

				// �Ŵ��� ��ȣ
				jfAdd.add(jlblMgrA).setBounds(65, 230, 110, 35);
				jlblMgrA.setFont(new Font("����", Font.BOLD, 20));
				jfAdd.add(jtfMgrA).setBounds(180, 230, 120, 30);

				// �Ի� ����
				jfAdd.add(jlblHiredateA).setBounds(350, 50, 100, 35);
				jlblHiredateA.setFont(new Font("����", Font.BOLD, 20));
				jfAdd.add(jtfHiredateA).setBounds(470, 50, 120, 30);
				jfAdd.add(jlblHirechkA).setBounds(470,20,150,30);
				// ����
				jfAdd.add(jlblSalA).setBounds(350, 110, 100, 35);
				jlblSalA.setFont(new Font("����", Font.BOLD, 20));
				jfAdd.add(jtfSalA).setBounds(470, 110, 120, 30);

				// ���ʽ�
				jfAdd.add(jlblCommA).setBounds(350, 170, 100, 35);
				jlblCommA.setFont(new Font("����", Font.BOLD, 20));
				jfAdd.add(jtfCommA).setBounds(470, 170, 120, 30);

				// �μ���ȣ
				jfAdd.add(jlblDeptnoA).setBounds(350, 230, 100, 35);
				jlblDeptnoA.setFont(new Font("����", Font.BOLD, 20));
				jfAdd.add(jtfDeptnoA).setBounds(470, 230, 120, 30);

				// ��� �߰�
				jfAdd.add(jbAdd).setBounds(310, 300, 100, 30);

				jfAdd.setSize(750, 400);
				jfAdd.setLocationRelativeTo(null);
				jfAdd.setVisible(true);
				jbAdd.addActionListener(new ActionListener() {
					EmpStatementDAO empDAO;
					EmpAddVO eAddVO = null;

					@Override
					public void actionPerformed(ActionEvent ae) {
						int rowCnt = 0;
						if (ae.getSource() == jbAdd) {

							int empno = 0;
							String ename = "";
							String job = ""; 
							int mgr = 0;
							String hiredate = "";
							int sal = 0;
							int comm = 0;
							int deptno = 0;


							empDAO = EmpStatementDAO.getInstance();
							try {
								 empno = Integer.valueOf(jtfEmpnoA.getText());
								 ename = jtfNameA.getText();
								 job = jtfJobA.getText();
								 mgr = Integer.valueOf(jtfMgrA.getText());
								 hiredate = String.valueOf(jtfHiredateA.getText());
								 sal = Integer.valueOf(jtfSalA.getText());
								 comm = Integer.valueOf(jtfCommA.getText());
								 deptno = Integer.valueOf(jtfDeptnoA.getText());
								 
								eAddVO = new EmpAddVO(empno, ename, job, mgr, hiredate, sal, comm, deptno);
									
								rowCnt = empDAO.insertEmp(eAddVO);
								if(rowCnt != 1) {
									JOptionPane.showMessageDialog(l, "����� ���������� �߰����� �ʾҽ��ϴ�.");
								}
								else {
									JOptionPane.showMessageDialog(l, ename +"����� ���������� �߰��Ǿ����ϴ�.");
								}
								
							}catch(SQLException se) {
								switch(se.getErrorCode()) {
								case 1840 : JOptionPane.showMessageDialog(l, "�Էµ� ���� ���̰� ��¥ ���Ŀ� ���� �����մϴ�");
								}
							}
						}//end if
					}//actionPerformed
				});
			}// actionPerformed

		});// addActionListener

	}// Login

	class EmpEvt implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {
			String empNo = "";
			if (ae.getSource() == jbSchEmpno || ae.getSource() == jtfSchEmpno) {
				empNo = jtfSchEmpno.getText();

				EmpStatementDAO esDAO = EmpStatementDAO.getInstance();
				EmpSelectVO eAddVo = null;
				int mgr = 0;
				int comm = 0;
				int sal = 0;
				int deptno = 0;
				try {
					eAddVo = esDAO.selectEmp(empNo);

					if (eAddVo == null) {
						JOptionPane.showMessageDialog(l, "��ȸ�� ��� ������ �������� �ʽ��ϴ�.\n Ȯ�� �� �Է����ּ���.");
					} else {
						mgr = eAddVo.getMgr();
						comm = eAddVo.getComm();
						sal = eAddVo.getSal();
						deptno = eAddVo.getDeptno();

						jtfEmpno.setText(empNo);
						jtfName.setText(eAddVo.getEname());
						jtfJob.setText(eAddVo.getJob());
						jtfMgr.setText(String.valueOf(mgr));
						jtfHiredate.setText(eAddVo.getHiredate());
						jtfSal.setText(String.valueOf(sal));
						jtfComm.setText(String.valueOf(comm));
						jtfDeptno.setText(String.valueOf(deptno));
					} // end else
				} catch (SQLException e) {
					switch (e.getErrorCode()) {
					case 1722:
						JOptionPane.showMessageDialog(l, "�����ȣ�˻����� ���ڸ� �Է°����մϴ�.");
					}// end switch
				} // end catch
			} // end if
		}// actionPerformed

	}// class

	public static void main(String[] args) {
		new Login();
	}
}// class
