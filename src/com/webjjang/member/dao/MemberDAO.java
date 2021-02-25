package com.webjjang.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.webjjang.member.vo.LoginVO;
import com.webjjang.member.vo.MemberVO;
import com.webjjang.util.db.DBInfo;
import com.webjjang.util.db.DBSQL;

public class MemberDAO {

	// 필요햔 객체 선언
	Connection con = null;
	
	PreparedStatement pstmt = null;
	
	ResultSet rs = null;
	
	// 로그인 처리를 위한 method 만들기
	public LoginVO login(LoginVO vo) throws Exception {
		
		LoginVO loginVO = null;
		
		try {
			
			con = DBInfo.getConnection();	// 드라이버 확인 및 연결객체
			
			pstmt = con.prepareStatement(DBSQL.MEMBER_LOGIN);	// SQL처리 및 데이터 세팅
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			
			rs = pstmt.executeQuery();	// 실행
			
			if(rs != null && rs.next()) {		// 표시 및 데이터 담기
				
				loginVO = new LoginVO();
				
				loginVO.setId(rs.getString("id"));
				loginVO.setName(rs.getString("name"));
				loginVO.setGradeNo(rs.getInt("gradeNo"));
				loginVO.setGradeName(rs.getString("gradeName"));
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			throw new Exception("로그인 DB처리중 오류가 발생하였습니다.");
			
		} finally {
			
			DBInfo.close(con, pstmt, rs);
			
		}
		
		return loginVO;
		
	}
	
	// ================================================ 회원 리스트 ===========================================================================
	public List<MemberVO> list() throws Exception {
		
		List<MemberVO> list = null;
		
		try {
			
			con = DBInfo.getConnection();
			
			pstmt = con.prepareStatement(DBSQL.MEMBER1_LIST);
			
			pstmt.setLong(1, 1);
			pstmt.setLong(2, 10);
			
			
			rs = pstmt.executeQuery();
			
			if(rs != null) {
				
				while(rs.next()) {
					
					if(list == null) {
						
						list = new ArrayList<>();
						
					}	// if(list == null)
					
					MemberVO vo = new MemberVO();
					
					vo.setId(rs.getString("id"));
					vo.setName(rs.getNString("name"));
					vo.setGender(rs.getString("gender"));
					vo.setBirth(rs.getString("birth"));
					vo.setTel(rs.getString("tel"));
					vo.setGradeNo(rs.getInt("gradeNo"));
					vo.setGradeName(rs.getString("gradeName"));
					vo.setStatus(rs.getString("status"));
					
					list.add(vo);
					
				}	// while(rs.next())
				
			}	// if(rs != null)
			
			return list;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			throw new Exception("회원관리 DB를 가져오는 중 오류가 발생하였습니다.");

		} finally {
			
			DBInfo.close(con, pstmt, rs);
			
		}
		
		
	}
	
}
