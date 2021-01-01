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
		add(jbEmpAdd).setBounds(210,400,150,35);
		
		// ��� ����
		add(jbEmpDel).setBounds(380,400,150,35);

		// ��� ����
		add(jbEmpUp).setBounds(550,400,150,35);
		
		Login.EmpEvt ee = this.new EmpEvt();
		jtfSchEmpno.addActionListener(ee);
		jbSchEmpno.addActionListener(ee);

		setSize(750, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
		// �ؽ�Ʈ �ʱ�ȭ
		jbRset.addActionListener(new ActionListener() {		

			@Override
			public void actionPerformed(ActionEvent e) {
				
			int idx = JOptionPane.showConfirmDialog(l, "������ �Էµ� �ؽ�Ʈ�� �ʱ�ȭ �ϰڽ��ϱ�?","�ؽ�Ʈ �ʱ�ȭ",JOptionPane.YES_NO_OPTION);
			
				switch(idx) {
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
					}break;
					case JOptionPane.NO_OPTION : break; 
				}//end switch
			}// actionPerformed
		});// jbRset.addActionListener
		
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
					eAddVo = esDAO.select(empNo);

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
