package com.sist.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sist.Vo.MembersVO;

public class MembersDAO {

	private static MembersDAO dao;
	
	private MembersDAO() {
		
	}
	
	public static MembersDAO getInstance() {
		
		if(dao == null) {
			dao = new MembersDAO();
		}
		
		return dao;
	}
	

	public int insert(MembersVO m) {
		int re = -1;
		
		String sql = "INSERT INTO MEMBERS VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pwd = "tiger";
			
			Connection conn = DriverManager.getConnection(url,id,pwd);
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPasswd());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getPhone1());
			pstmt.setString(5, m.getPhone2());
			pstmt.setString(6, m.getPhone3());
			pstmt.setString(7, m.getSex());
			pstmt.setString(8, m.getBlood());
			pstmt.setString(9, m.getHobby());
			pstmt.setString(10, m.getCitiy());
			pstmt.setString(11, m.getInfo());
			
			re = pstmt.executeUpdate();
			// executeUpdate는 성공적으로 sql를 실행한 레코드의 수를 반호나
			// 그값을 가지고 sql을 성공햇는지 실패했는지 판단할 수 있다.
			
			
			if(pstmt != null) {
				pstmt.close();
			}
			
			if(conn != null) {
				conn.close();
			}
			
			
		}catch(Exception e){
			System.out.println("예외 발생:" + e.getMessage());
		}
		
		return re;
	}
	
	// 매개변수로 id를 전달 받아 해당아이디가 이미 member테이블에 있는지 판별하여 
	// 아이디가 이미 있으면 ==> true
	// 아이디가 없으면 ==> false
	
	public boolean isAlreadyId(String id) {
		boolean re = false;
		
		
		String sql = "select * from members where id=?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = 
					DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", 
							"scott", "tiger");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				re = true;
			}
			
			if(rs != null) {
				rs.close();
			}
			
			if(pstmt != null) {
				pstmt.close();
			}
			
			if(conn != null) {
				conn.close();
			}
			
		}catch(Exception e) {

		}
		
		return re;
	}
	
	
}
