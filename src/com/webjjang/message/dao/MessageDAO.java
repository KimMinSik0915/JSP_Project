package com.webjjang.message.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.webjjang.member.vo.LoginVO;
import com.webjjang.message.vo.MessageVO;
import com.webjjang.util.PageObject;
import com.webjjang.util.db.DBInfo;
import com.webjjang.util.db.DBSQL;

public class MessageDAO {

	Connection con = null;
	
	PreparedStatement pstmt = null;
	
	ResultSet rs = null;
	
	public List<MessageVO> list() throws Exception {
		
		List<MessageVO> list = null;
		
		LoginVO loginvo = new LoginVO();
		
		try {
			
			con = DBInfo.getConnection();
			
			pstmt = con.prepareStatement(DBSQL.MESSAGE_LIST);
			
			pstmt.setString(1, loginvo.getId() );
			pstmt.setString(2, loginvo.getId());
			pstmt.setLong(3, 1);
			pstmt.setLong(4, 10);
			
			rs = pstmt.executeQuery();
			
			if (rs != null) {
				
				while(rs.next()) {
					
					if(list == null) {
						
						list = new ArrayList<MessageVO>();
						
					}
					
					MessageVO vo = new MessageVO();
					
					vo.setNo(rs.getLong("no"));
					vo.setSender(rs.getString("sender"));
					vo.setSendDate(rs.getString("sendDate"));
					vo.setAccepter(rs.getString("accepter"));
					vo.setAcceptDate(rs.getString("acceptDate"));
					
					list.add(vo);
					
				}
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
			
			throw new Exception("메시지 리스트를 불러오는 중 DB에 오류가 발생하였습니다.");
			
		} finally {
			
			DBInfo.close(con, pstmt, rs);
			
		}
		
		
		return list;
		
	}
	
	// 전체 데이터 개수 구하기
	public long getTotalRow() throws Exception {
		
		long result = 0;
		
		LoginVO loginvo = new LoginVO();
		
		try {
			
			con = DBInfo.getConnection();
			
			pstmt = con.prepareStatement(DBSQL.MESSAGE_GET_TOTLAROW);
			
			pstmt.setLong(1, 1);
			pstmt.setString(2, loginvo.getId());
			pstmt.setString(3, loginvo.getId());
			
			rs = pstmt.executeQuery();
			
			if (rs != null && rs.next()) {
				
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
			
			throw new Exception("전체 데이터를 가져오는 중 DB오류가 발생하였습니다.");
			
		} finally {
			
			DBInfo.close(con, pstmt, rs);
			
		}
		
		return result;
		
	}
	
}
