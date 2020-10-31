package com.kh.member.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static com.kh.common.JDBCTemplate.*;
import com.kh.member.model.vo.Member;

public class MemberDao {
	
	private Properties prop = new Properties();
	
	public MemberDao() {
		
		String fileName = MemberDao.class.getResource("/sql/member/member-mapper.xml").getPath();
		
		try {
			//prop.load(new FileInputStream(fileName));
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Member loginMember(Connection conn, String userId, String userPwd) {
		// select문 => 한 행 => Member 
		
		// 필요한 변수들 먼저 셋팅
		Member m = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		// 실행할 sql문
		String sql = prop.getProperty("loginMember");
		
		try {
			pstmt = conn.prepareStatement(sql); // 애초에 sql문 담은채로 생성
			// 현재 담긴 sql문이 미완성된 sql문이기 때문에 바로 실행 불가!
			
			// 완성형태로 만든 후에 실행해야됨!!
			pstmt.setString(1, userId); // 'admin'
			pstmt.setString(2, userPwd);// '1234'
			
			// 실행! (select문 => executeQuery(반환형ResultSet) / dml문 => executeUpdate(반환형int))
			rset = pstmt.executeQuery();
			
			if(rset.next()) { // 일치하는 회원을 찾았을 경우
				m = new Member(
							   rset.getInt("USER_NO"), 
							   rset.getString("USER_ID"),
							   rset.getString("user_pwd"),
							   rset.getString("user_name"),
							   rset.getString("phone"),
							   rset.getString("email"),
							   rset.getString("address"),
							   rset.getString("interest"),
							   rset.getDate("enroll_date"),
							   rset.getDate("modify_date"),
							   rset.getString("status")
							  );
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			/*JDBCTemplate.*/close(rset);
			/*JDBCTemplate.*/close(pstmt);
		}
		
		return m; // 일치하는회원을 찾았을 경우 생성된 Member 객체 반환 / 일치하는회원을 찾지 못했을 경우 null 반환
		
	}
	
	public int insertMember(Connection conn, Member m) {
		// insert문 => 처리된 행 수
		
		// 필요한 변수들 셋팅
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertMember"); // 미완성
		
		try {
			pstmt = conn.prepareStatement(sql); // 담긴 sql문이 미완성
			
			// 완성형태로 만들고
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getPhone());
			pstmt.setString(5, m.getEmail());
			pstmt.setString(6, m.getAddress());
			pstmt.setString(7, m.getInterest());
			
			// 실행
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public int updateMember(Connection conn, Member m) {
		// update문 => 처리된 행수
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateMember");
		
		try {
			pstmt = conn.prepareStatement(sql); // 미완성된 sql문
			
			// 완성형태로 채운후 
			pstmt.setString(1, m.getUserName());
			pstmt.setString(2, m.getPhone());
			pstmt.setString(3, m.getEmail());
			pstmt.setString(4, m.getAddress());
			pstmt.setString(5, m.getInterest());
			pstmt.setString(6, m.getUserId());
			
			// 실행 후 결과 받기
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public Member selectMember(Connection conn, String userId) {
		// select문 => 한 행 조회 => Member객체
		Member m = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMember");
		
		try {
			pstmt = conn.prepareStatement(sql); // 미완성 sql문
			
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member(
							   rset.getInt("USER_NO"), 
							   rset.getString("USER_ID"),
							   rset.getString("user_pwd"),
							   rset.getString("user_name"),
							   rset.getString("phone"),
							   rset.getString("email"),
							   rset.getString("address"),
							   rset.getString("interest"),
							   rset.getDate("enroll_date"),
							   rset.getDate("modify_date"),
							   rset.getString("status")
							  );
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return m;
		
	}
	
	public int updatePwdMember(Connection conn, String userId, String userPwd, String updatePwd) {
		
		// update문 => 처리된 행수 
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updatePwdMember");
		
		try {
			pstmt = conn.prepareStatement(sql); // 미완성된 sql문
			
			pstmt.setString(1, updatePwd);
			pstmt.setString(2, userId);
			pstmt.setString(3, userPwd);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	public int deleteMember(Connection conn, String userId, String userPwd) {
		// update문 => 처리된 행수
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteMember");
		
		try {
			pstmt = conn.prepareStatement(sql); // 미완성 sql
			
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public int idCheck(Connection conn, String checkId) {
		//select문 => 갯수(int)
		int count = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("idCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, checkId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				count = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return count;
		
		
	}

}








