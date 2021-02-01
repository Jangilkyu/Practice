package com.sist.MemberDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sist.Vo.MemberVo;

public class MemberDao {
	
	private static MemberDao mDao;
	
	private MemberDao() {
		
	}//MemberDao
	
	public static MemberDao getInstance() {
		
		if(mDao == null) {
			mDao = new MemberDao();
		}
		
		return mDao;
		
	}//MemberDao
	
	
	public Connection getConnection() throws SQLException {
		
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
		
	}
	
	
	public int insertMember(MemberVo mVo) throws SQLException{
		int re = -1;
		
		Connection  conn = null;
		PreparedStatement pstmt = null;
		
		try {
		conn = getConnection();
		
		String sql = "INSERT INTO member VALUES (?,?,?)";

		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, mVo.getId());
		pstmt.setString(2, mVo.getName());
		pstmt.setString(3, mVo.getEmail());

		re = pstmt.executeUpdate();
		
		}finally {
			
			if(pstmt != null) {
				pstmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		}
		
		return re;
	}//insertMember
	
	public ArrayList<MemberVo> selectAllMember() throws SQLException{
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = getConnection();
			
			String sql = "SELECT id, name, email FROM member";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			MemberVo mVo;
			String id ="";
			String name = "";
			String email = "";
			
			while(rs.next()) {
				id = rs.getString("id");
				name = rs.getString("name");
				email = rs.getString("email");
				
				mVo = new MemberVo(id, name, email);
				
				list.add(mVo);
				
			}//end while
			
		}finally {
			if(rs != null) {
				rs.close();
			}
		}
		return list;
	}//selectAllMember
	
	public int updateMember(MemberVo mVo) throws SQLException {
		int re = -1;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = getConnection();
			
			String sql = "UPDATE member SET name = ?, email = ? WHERE ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, mVo.getName());
			pstmt.setString(2, mVo.getEmail());
			pstmt.setString(3, mVo.getId());
			
			re = pstmt.executeUpdate();
			
		}finally {
			if(pstmt != null) {
				pstmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		}
		return re;
	}//updateMember
	
	
	public int deleteMember(String id) throws SQLException{
		int re = -1;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = getConnection();
			
			String sql = "DELETE FROM member WHERE ID = ? ";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			re = pstmt.executeUpdate();
			
		}finally {
			
			if(pstmt != null) {
				pstmt.close();
			}
			
			if(conn != null) {
				conn.close();
			}
		}
		return re;
	}
}//class
