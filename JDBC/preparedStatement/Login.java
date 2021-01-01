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

	// 사원번호 검색
	private JLabel jlblSchEmpno;
	private JTextField jtfSchEmpno;
	private JButton jbSchEmpno;

	// 사원번호
	private JLabel jlblEmpno;
	private JTextField jtfEmpno;

	// 직원이름
	private JLabel jlblName;
	private JTextField jtfName;

	// 부서명
	private JLabel jlblJob;
	private JTextField jtfJob;

	// 매니저 번호
	private JLabel jlblMgr;
	private JTextField jtfMgr;

	// 입사 일자
	private JLabel jlblHiredate;
	private JTextField jtfHiredate;

	// 연봉
	private JLabel jlblSal;
	private JTextField jtfSal;

	// 보너스
	private JLabel jlblComm;
	private JTextField jtfComm;

	// 부서번호
	private JLabel jlblDeptno;
	private JTextField jtfDeptno;

	// 값 초기화
	private JButton jbRset;

	// 사원 추가
	private JButton jbEmpAdd;

	// 사원 삭제
	private JButton jbEmpDel;

	// 사원 업데이트
	private JButton jbEmpUp;

	Login l;

	public Login() {
		super("인사 급여 관리");
		l = this;
		// 사원번호검색
		jlblSchEmpno = new JLabel("사원 번호 검색");
		jtfSchEmpno = new JTextField();
		jbSchEmpno = new JButton("검색");

		// 사원번호
		jlblEmpno = new JLabel("사원 번호");
		jtfEmpno = new JTextField();

		// 직원이름
		jlblName = new JLabel("직원 명");
		jtfName = new JTextField();

		// 부서명
		jlblJob = new JLabel("부서 명");
		jtfJob = new JTextField();

		// 매니저 번호
		jlblMgr = new JLabel("매니저 번호");
		jtfMgr = new JTextField();

		// 입사 일자
		jlblHiredate = new JLabel("입사 일자");
		jtfHiredate = new JTextField();

		// 연봉
		jlblSal = new JLabel("연봉");
		jtfSal = new JTextField("");

		// 보너스
		jlblComm = new JLabel("보너스");
		jtfComm = new JTextField();

		// 부서번호
		jlblDeptno = new JLabel("부서번호");
		jtfDeptno = new JTextField();

		// 사원 추가
		jbEmpAdd = new JButton("사원 추가");

		// 사원 삭제
		jbEmpDel = new JButton("사원 삭제");

		// 사원 정보 업데이트
		jbEmpUp = new JButton("사원 정보 수정");

		// 값초기화
		jbRset = new JButton("텍스트 초기화");

		// 배치관리자 수동배치
		setLayout(null);

		// 이름
		add(jlblSchEmpno).setBounds(50, 50, 180, 30);
		jlblSchEmpno.setFont(new Font("굴림", Font.BOLD, 25));
		add(jtfSchEmpno).setBounds(230, 48, 120, 35);
		jtfSchEmpno.setFont(new Font("굴림", Font.BOLD, 20));
		add(jbSchEmpno).setBounds(355, 48, 70, 35);
		jbSchEmpno.setFont(new Font("굴림", Font.BOLD, 18));
		jbSchEmpno.setBackground(new Color(85, 134, 235));

		// 사원번호
		add(jlblEmpno).setBounds(65, 150, 100, 35);
		jlblEmpno.setFont(new Font("굴림", Font.BOLD, 20));
		add(jtfEmpno).setBounds(180, 150, 120, 30);

		// 직원명
		add(jlblName).setBounds(65, 210, 100, 35);
		jlblName.setFont(new Font("굴림", Font.BOLD, 20));
		add(jtfName).setBounds(180, 210, 120, 30);

		// 부서명
		add(jlblJob).setBounds(65, 270, 100, 35);
		jlblJob.setFont(new Font("굴림", Font.BOLD, 20));
		add(jtfJob).setBounds(180, 270, 120, 30);

		// 매니저 번호
		add(jlblMgr).setBounds(65, 330, 110, 35);
		jlblMgr.setFont(new Font("굴림", Font.BOLD, 20));
		add(jtfMgr).setBounds(180, 330, 120, 30);

		// 입사 일자
		add(jlblHiredate).setBounds(350, 150, 100, 35);
		jlblHiredate.setFont(new Font("굴림", Font.BOLD, 20));
		add(jtfHiredate).setBounds(470, 150, 120, 30);

		// 연봉
		add(jlblSal).setBounds(350, 210, 100, 35);
		jlblSal.setFont(new Font("굴림", Font.BOLD, 20));
		add(jtfSal).setBounds(470, 210, 120, 30);

		// 보너스
		add(jlblComm).setBounds(350, 270, 100, 35);
		jlblComm.setFont(new Font("굴림", Font.BOLD, 20));
		add(jtfComm).setBounds(470, 270, 120, 30);

		// 부서번호
		add(jlblDeptno).setBounds(350, 330, 100, 35);
		jlblDeptno.setFont(new Font("굴림", Font.BOLD, 20));
		add(jtfDeptno).setBounds(470, 330, 120, 30);

		// 텍스트 초기화
		add(jbRset).setBounds(40, 400, 150, 35);
		
		// 사원 추가
		add(jbEmpAdd).setBounds(210,400,150,35);
		
		// 사원 삭제
		add(jbEmpDel).setBounds(380,400,150,35);

		// 사원 수정
		add(jbEmpUp).setBounds(550,400,150,35);
		
		Login.EmpEvt ee = this.new EmpEvt();
		jtfSchEmpno.addActionListener(ee);
		jbSchEmpno.addActionListener(ee);

		setSize(750, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
		// 텍스트 초기화
		jbRset.addActionListener(new ActionListener() {		

			@Override
			public void actionPerformed(ActionEvent e) {
				
			int idx = JOptionPane.showConfirmDialog(l, "정말로 입력된 텍스트를 초기화 하겠습니까?","텍스트 초기화",JOptionPane.YES_NO_OPTION);
			
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
						JOptionPane.showMessageDialog(l, "조회한 사원 정보가 존재하지 않습니다.\n 확인 후 입력해주세요.");
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
						JOptionPane.showMessageDialog(l, "사원번호검색에는 숫자만 입력가능합니다.");

					}// end switch
				} // end catch
			} // end if

		}// actionPerformed
		
	}// class

	public static void main(String[] args) {
		new Login();
	}

}// class
