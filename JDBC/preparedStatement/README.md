# 사원관리 프로그램

- 제작기간 2020.12.31 ~ 2021.01.06

Java와 Oracle를 JDBC드라이버를 통해 연동하여 PreparedStatement를 사용해 쿼리를 실행 회원조회 CRUD를 만들어보았습니다.

<img src = "https://user-images.githubusercontent.com/69107255/106006862-04e26080-60f9-11eb-99a6-4cc891c54148.png">

현재 `emp테이블`에는 14명에 사원에 정보가 저장이 되어 있고, 해당 테이블에 값을 `추가`,`수정`,`삭제`,`조회`기능이 있는 프로그램을 **jdbc**와 **swing**을 활용해 제작하게 되었습니다.

<hr>

## **메인 화면** 
<img src ="https://user-images.githubusercontent.com/69107255/103910824-a0129680-5148-11eb-9ae6-a2807d0e77a8.png">

- emp테이블에 사원번호를 통하여 `사원번호`,`직원명`,`부서명`,`매니저번호`,`입사일자`,`연봉`,`보너스`,`부서번호`를 조회할 수 있습니다.

<hr>

## **조회**
<img src = "https://user-images.githubusercontent.com/69107255/103911141-04355a80-5149-11eb-9073-893becdc29b5.png">

- **7369번**의 **사원번호**를 입력 후 **검색**버튼을 클릭하여 조회를 해보았습니다.

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
사용자가 입력한 `사원번호`를 `String empNo = jtfSchEmpno.getText();`로 사원번호을 받은 뒤 EmpStatementDAO클래스의 selectEmp(empNo)로 전달하였습니다.

<br>

```java
    StringBuilder selectSb = new StringBuilder();
    selectSb
    .append("	SELECT ENAME, JOB, MGR, TO_CHAR(hiredate, 'yyyy-mm-dd') hiredate , sal, nvl(comm,0) comm, deptno	")
    .append("	FROM emp	")
    .append("	WHERE empno = ?");

    pstmt = con.prepareStatement(selectSb.toString());

```
- selectEmp메소드에서 StringBuilder를 이용해 아래와 같은 쿼리문을 통해 가져왔습니다.
- 쿼리문은 사원번호가 N인 사원의 `이름`,`부서`,`입사 일자`, `연봉`, `보너스`, `부서번호`를 emp테이블에서 조회하도록 설계하였습니다. 

```java
    if(rs.next()) {
        			pstmt.setString(1, empNo);
			
			        rs = pstmt.executeQuery();

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
- resultSet을 통해 사원번호에 대한 값을 받아온 뒤 addVO객체에 값을 담아서 호출한 곳으로 전달하여 JTextField에 setText를 활용해 값을 유저에게 보여줄 수 있도록 하였습니다.

## 삽입

- 메인화면 하단에 있는 **사원 추가** 버튼을 클릭하게 되면 아래 이미지와 같은 JFrame창이 나옵니다.

<img src = "https://user-images.githubusercontent.com/69107255/103914906-d30b5900-514d-11eb-91cd-889238bfe5df.png">

- **사원 추가**는 **jbEmpAddJButton**를 **Anonymous Class**로 정의하였습니다.
```java
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
```

```java
		// 3.쿼리문 생성객체 얻기
		String insertEmp = "INSERT INTO emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (?,?,?,?,?,?,?,?)";
		
		pstmt = con.prepareStatement(insertEmp);
		
		//4.바인드 변수에 값 넣기
		pstmt.setInt(1, eAddVO.getEmpno());
		pstmt.setString(2, eAddVO.getEname());
		pstmt.setString(3, eAddVO.getJob());
		pstmt.setInt(4, eAddVO.getMgr());
		pstmt.setString(5, eAddVO.getHiredate());
		pstmt.setInt(6, eAddVO.getSal());
		pstmt.setInt(7, eAddVO.getComm());
		pstmt.setInt(8, eAddVO.getDeptno());
		
		rowCnt = pstmt.executeUpdate();
		return rowCnt;
```

쿼리문 생성객체를 얻어서 각 바인드 변수에 대입을 하고 정상적으로 값이 추가가 되었다면 rowCnt에 0이 아닌값이 담기게 되고 리턴합니다.

<img src ="https://user-images.githubusercontent.com/69107255/106008260-74a51b00-60fa-11eb-9a58-aca3bfa940fd.png">

input창에 값들을 넣고 **사원추가** 버튼을 클릭 하면 