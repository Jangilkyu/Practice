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
		// 1. ����̹��ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // end catch

		// 2. Connection ���
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
		// 3. ������ ���� ��ü ���
			StringBuilder selectSb = new StringBuilder();
			selectSb
			.append("	SELECT ENAME, JOB, MGR, TO_CHAR(hiredate, 'yyyy-mm-dd') hiredate , sal, nvl(comm,0) comm, deptno	")
			.append("	FROM emp	")
			.append("	WHERE empno = ?");
			
			pstmt = con.prepareStatement(selectSb.toString());
			
		// 4. ������ ���� �� ��� ���
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
			// 6. �������
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
		// 3. ������ ������ü ���
		StringBuilder updateEmpno = new StringBuilder();
		
		updateEmpno
		.append("	UPDATE emp	")
		.append("	SET  sal = ?, comm = ?	")
		.append("	WHERE empno = ?	");

		pstmt = con.prepareStatement(updateEmpno.toString());
		
		// 4. ���ε� ������ �� �ֱ�
		pstmt.setInt(1, eVO.getSal());
		pstmt.setInt(2, eVO.getComm());
		pstmt.setInt(3, empno);

		// 5.���� ���� �İ�� ���
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
