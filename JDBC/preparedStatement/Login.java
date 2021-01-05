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

	JButton jbmodify;

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

		jbmodify = new JButton("변경");

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
		add(jbEmpAdd).setBounds(210, 400, 150, 35);

		// 사원 삭제
		add(jbEmpDel).setBounds(380, 400, 150, 35);

		// 사원 수정
		add(jbEmpUp).setBounds(550, 400, 150, 35);

		Login.EmpEvt ee = this.new EmpEvt();
		jtfSchEmpno.addActionListener(ee);
		jbSchEmpno.addActionListener(ee);

		setSize(750, 500);
		setLocationRelativeTo(null);
		setVisible(true);

		// ========================================= 버튼 이벤트 =========================================
		// 텍스트 초기화
		jbRset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int idx = JOptionPane.showConfirmDialog(l, "정말로 입력된 텍스트를 초기화 하겠습니까?", "텍스트 초기화",
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
		JFrame jf = new JFrame("사원 인사정보 수정");
//		JLabel jlblEmpno = new JLabel("사원 번호");
		JTextField jtfEmpno1 = new JTextField();
		JLabel jlblSal = new JLabel("연봉");
		JTextField jtfSal1 = new JTextField();
		JLabel jlblComm = new JLabel("보너스");
		JTextField jtfComm1 = new JTextField();

		// 사원 수정(업데이트) ----------------------------------------
		jbEmpUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				jf.setLayout(null);

				// 사원번호
				jf.add(jlblEmpno).setBounds(50, 50, 100, 30);
				jlblEmpno.setFont(new Font("굴림", Font.BOLD, 20));
				jf.add(jtfEmpno1).setBounds(150, 50, 120, 30);

				// 사원 연봉
				jf.add(jlblSal).setBounds(50, 100, 100, 30);
				jlblSal.setFont(new Font("굴림", Font.BOLD, 20));
				jf.add(jtfSal1).setBounds(150, 100, 120, 30);

				// 사원 보너스
				jf.add(jlblComm).setBounds(50, 150, 100, 30);
				jlblComm.setFont(new Font("굴림", Font.BOLD, 20));
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
						JOptionPane.showMessageDialog(l, "사원번호 / 연봉 / 보너스는 숫자만 입력하실 수 있습니다.\n  확인 후 입력부탁드립니다.");
//						e1.printStackTrace();
					} catch (SQLException e1) {
						switch (e1.getErrorCode()) {
						case 1438:
							JOptionPane.showMessageDialog(l, "연봉과 보너스는 7자리 내로 입력가능합니다.\n 또는 사원번호는 4자리인지 확인 부탁드립니다.");
						}// end switch
						e1.printStackTrace();
					} // end catch
				} // end if
			}// actionPerformed
		});// addActionListener

		// 사원 삭제 --------------------------------------
		JFrame jfdel = new JFrame("사원 삭제");
		JTextField jtfdel = new JTextField();
		JButton jbdel = new JButton("사원 삭제");
		jbEmpDel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				jfdel.setLayout(null);

				jfdel.add(jlblEmpno).setBounds(190, 10, 100, 50);
				jlblEmpno.setFont(new Font("굴림", Font.BOLD, 20));
				jfdel.add(jtfdel).setBounds(190, 55, 100, 20);
				jfdel.add(jbdel).setBounds(190, 100, 100, 30);

				jfdel.setSize(500, 200);
				jfdel.setLocationRelativeTo(null);
				jfdel.setVisible(true);
			}// actionPerformed
		});// addActionListener

		// 회원 삭제
		jbdel.addActionListener(new ActionListener() {
			int rows = 0;

			@Override
			public void actionPerformed(ActionEvent ae) {
				EmpStatementDAO eDAO = EmpStatementDAO.getInstance();

				int idx = JOptionPane.showConfirmDialog(l, "해당 사원은 정말로 삭제하시겠습니까?", "사원 삭제", JOptionPane.YES_NO_OPTION);

				if (ae.getSource() == jbdel) {
					switch (idx) {
					case JOptionPane.YES_OPTION: {
						try {
							rows = eDAO.removeEmp(Integer.valueOf(jtfdel.getText()));
							if (rows != 0) {
								JOptionPane.showMessageDialog(l, "삭제가 완료되었습니다.");
							} else {
								JOptionPane.showMessageDialog(l, "사원번호가 존재하지 않습니다.");
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

		// 회원 추가
		jbEmpAdd.addActionListener(new ActionListener() {
			JFrame jfAdd = new JFrame("사원 추가");

			// 사원번호
			private JLabel jlblEmpnoA = new JLabel("사원번호");
			private JTextField jtfEmpnoA = new JTextField();

			// 직원이름
			private JLabel jlblNameA = new JLabel("직원명");
			private JTextField jtfNameA = new JTextField();

			// 부서명
			private JLabel jlblJobA = new JLabel("부서명");
			private JTextField jtfJobA = new JTextField();;

			// 매니저 번호
			private JLabel jlblMgrA = new JLabel("매니저 번호");
			private JTextField jtfMgrA = new JTextField();;

			// 입사 일자
			private JLabel jlblHiredateA = new JLabel("입사 일자");
			private JTextField jtfHiredateA = new JTextField();;
			private JLabel jlblHirechkA = new JLabel("ex)20210101 8글자");
			// 연봉
			private JLabel jlblSalA = new JLabel("연봉");
			private JTextField jtfSalA = new JTextField();;

			// 보너스
			private JLabel jlblCommA = new JLabel("보너스");
			private JTextField jtfCommA = new JTextField();;

			// 부서번호
			private JLabel jlblDeptnoA = new JLabel("부서번호");
			private JTextField jtfDeptnoA = new JTextField();;

			//사원추가 버튼
			private JButton jbAdd = new JButton("사원 추가");

			@Override
			public void actionPerformed(ActionEvent e) {

				jfAdd.setLayout(null);
				// 사원번호
				jfAdd.add(jlblEmpnoA).setBounds(65, 50, 100, 35);
				jlblEmpnoA.setFont(new Font("굴림", Font.BOLD, 20));
				jfAdd.add(jtfEmpnoA).setBounds(180, 50, 120, 30);

				// 직원명
				jfAdd.add(jlblNameA).setBounds(65, 110, 100, 35);
				jlblNameA.setFont(new Font("굴림", Font.BOLD, 20));
				jfAdd.add(jtfNameA).setBounds(180, 110, 120, 30);

				// 부서명
				jfAdd.add(jlblJobA).setBounds(65, 170, 100, 35);
				jlblJobA.setFont(new Font("굴림", Font.BOLD, 20));
				jfAdd.add(jtfJobA).setBounds(180, 170, 120, 30);

				// 매니저 번호
				jfAdd.add(jlblMgrA).setBounds(65, 230, 110, 35);
				jlblMgrA.setFont(new Font("굴림", Font.BOLD, 20));
				jfAdd.add(jtfMgrA).setBounds(180, 230, 120, 30);

				// 입사 일자
				jfAdd.add(jlblHiredateA).setBounds(350, 50, 100, 35);
				jlblHiredateA.setFont(new Font("굴림", Font.BOLD, 20));
				jfAdd.add(jtfHiredateA).setBounds(470, 50, 120, 30);
				jfAdd.add(jlblHirechkA).setBounds(470,20,150,30);
				// 연봉
				jfAdd.add(jlblSalA).setBounds(350, 110, 100, 35);
				jlblSalA.setFont(new Font("굴림", Font.BOLD, 20));
				jfAdd.add(jtfSalA).setBounds(470, 110, 120, 30);

				// 보너스
				jfAdd.add(jlblCommA).setBounds(350, 170, 100, 35);
				jlblCommA.setFont(new Font("굴림", Font.BOLD, 20));
				jfAdd.add(jtfCommA).setBounds(470, 170, 120, 30);

				// 부서번호
				jfAdd.add(jlblDeptnoA).setBounds(350, 230, 100, 35);
				jlblDeptnoA.setFont(new Font("굴림", Font.BOLD, 20));
				jfAdd.add(jtfDeptnoA).setBounds(470, 230, 120, 30);

				// 사원 추가
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
									JOptionPane.showMessageDialog(l, "사원이 정상적으로 추가되지 않았습니다.");
								}
								else {
									JOptionPane.showMessageDialog(l, ename +"사원이 정상적으로 추가되었습니다.");
								}
								
							}catch(SQLException se) {
								switch(se.getErrorCode()) {
								case 1840 : JOptionPane.showMessageDialog(l, "입력된 값의 길이가 날짜 형식에 비해 부족합니다");
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
