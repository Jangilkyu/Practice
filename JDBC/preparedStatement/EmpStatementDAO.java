package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpStatementDAO {

	private static EmpStatementDAO esDAO;

	private EmpStatementDAO() {

	}// EmpStatementDAO

	public static EmpStatementDAO getInstance() {
		if (esDAO == null) {
			esDAO = new EmpStatementDAO();
		} // end if
		return esDAO;
	}// getInstance
	private Connection getConnection() throws SQLException {
		// 1. 드라이버로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // end catch

		// 2. Connection 얻기
		Connection con = null;

		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pass = "tiger";

		con = DriverManager.getConnection(url, id, pass);

		return con;
	}// getConnection

	public EmpSelectVO selectEmp(String empNo) throws SQLException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		con = getConnection();
		
		try {
		// 3. 쿼리문 생성 객체 얻기
			StringBuilder selectSb = new StringBuilder();
			selectSb
			.append("	SELECT ENAME, JOB, MGR, TO_CHAR(hiredate, 'yyyy-mm-dd') hiredate , sal, nvl(comm,0) comm, deptno	")
			.append("	FROM emp	")
			.append("	WHERE empno = ?");
			
			pstmt = con.prepareStatement(selectSb.toString());
			
		// 4. 쿼리문 수행 후 결과 얻기
			pstmt.setString(1, empNo);
			
			rs = pstmt.executeQuery();
			
			String name = "";
			String job = "";
			int mgr = 0;
			String hiredate = "";
			int sal = 0;
			int comm = 0;
			int deptno = 0;
			EmpSelectVO addVO = null;

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
			
			return addVO;
			
		// 5.
		}finally {
			// 6. 연결끊기
			if(rs != null) {
				rs.close();
			}//end if
			
			if (pstmt != null) {
				pstmt.close();
			}//end if
			
			if (con != null) {
				con.close();
			}//end if
		}//end finally

	}// selectEmp
	
	public int UpdateEmp(int empno,EmpModifyVO eVO) throws SQLException {
		int rowCnt = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		//1.
		//2.
		try {
			con = getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch

		
		try {
		// 3. 쿼리문 생성객체 얻기
		StringBuilder updateEmpno = new StringBuilder();
		
		updateEmpno
		.append("	UPDATE emp	")
		.append("	SET  sal = ?, comm = ?	")
		.append("	WHERE empno = ?	");

		pstmt = con.prepareStatement(updateEmpno.toString());
		
		// 4. 바인드 변수에 값 넣기
		pstmt.setInt(1, eVO.getSal());
		pstmt.setInt(2, eVO.getComm());
		pstmt.setInt(3, empno);

		// 5.쿼리 수행 후결과 얻기
		rowCnt = pstmt.executeUpdate();

		}finally {
			if(pstmt != null) {
				pstmt.close();
			}//end if
			
			if(rs != null) {
				rs.close();
			}//end if
			
			if(con != null) {
				con.close();
			}//end if
		}//end finally

		return rowCnt;
		
	}//UpdateEmp
	
	
	public static void main(String[] args) throws SQLException {
	 EmpStatementDAO.getInstance().UpdateEmp(9999,new EmpModifyVO(47,2));
	}

}// class
