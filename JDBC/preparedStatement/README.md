# 사원관리 프로그램

- 제작기간 2020.12.31 ~ 2021.01.06

Java와 Oracle를 JDBC드라이버를 통해 연동하여 PreparedStatement를 사용해 쿼리를 실행 회원조회 CRUD를 만들어보았습니다.

## 메인 화면 
<img src ="https://user-images.githubusercontent.com/69107255/103910824-a0129680-5148-11eb-9ae6-a2807d0e77a8.png">

- emp테이블에 사원번호를 통하여 `사원번호`,`직원명`,`부서명`,`매니저번호`,`입사일자`,`연봉`,`보너스`,`부서번호`를 조회할 수 있습니다.

## 조회
<img src = "https://user-images.githubusercontent.com/69107255/103911141-04355a80-5149-11eb-9073-893becdc29b5.png">

- 사원번호를 입력 후 조회를 해보았습니다.

- `EmpView.java`에 Inner class인 `EmpEvtclass`에 ActionEvent의 코드 일부분을 가져왔습니다.
```java
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
```
- 사용자가 입력한 `사원번호`를 `String empNo = jtfSchEmpno.getText();`로 사원번호을 받은 뒤 EmpStatementDAO클래스의 selectEmp(empNo)로 전달하였습니다.

- selectEmp메소드에서 StringBuilder를 이용해 아래와 같은 쿼리문을 통해 가져왔습니다.
- 사원번호가 N인 사원의 `이름`,`부서`,`입사 일자`, `연봉`, `보너스`, `부서번호`를 emp테이블에서 조회한다. 
```java
    StringBuilder selectSb = new StringBuilder();
    selectSb
    .append("	SELECT ENAME, JOB, MGR, TO_CHAR(hiredate, 'yyyy-mm-dd') hiredate , sal, nvl(comm,0) comm, deptno	")
    .append("	FROM emp	")
    .append("	WHERE empno = ?");
```

```java
    if(rs.next()) {
                    name = rs.getString("ename");
                    job = rs.getString("job");
                    mgr = rs.getInt("mgr");
                    hiredate = rs.getString("hiredate");
                    sal = rs.getInt("sal");
                    comm = rs.getInt("comm");
                    deptno = rs.getInt("deptno");
                    addVO = new EmpSelectVO(name,job,mgr,hiredate,sal,comm,deptno);
    		    }//end if
```