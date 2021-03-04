package com.webjjang.util.db;

public class DBSQL {

	// 게시판 쿼리 =====================================================================================================================================================================================
	public static final String BOARD_LIST 	// 게시판 리스트
	= " SELECT rnum, no, title, writer,"
	+ " TO_CHAR(writeDate, 'yyyy.mm.dd') writeDate, hit FROM( "
		+ " SELECT rownum rnum, no, title, writer, writeDate, hit FROM ("
			+ " SELECT no, title, writer, writeDate, hit FROM board"
			+ " order by no desc "
		+ " ) "
	+ ") where rnum between ? and ?  ";
	
	public static final String BOARD_VIEW 	// 게시판 글 보기
	= " SELECT no, title, content, writer, "
	+ " TO_CHAR(writeDate, 'yyyy.mm.dd') writeDate, hit "
	+ " FROM board "
	+ " WHERE no = ?";
	
	public static final String BOARD_WIRTE 	// 게시판 글 쓰기
	= " INSERT INTO board(no, title, content, writer) "
	+ " VALUES(board_seq.NEXTVAL, ?, ?, ?) ";
	
	public static final String BOARD_UPDATE	// 게시판 글 수정
	= " UPDATE board SET title = ? , content = ?, writer = ? "
	+ " WHERE no = ? ";
	
	public static final String BOARD_DELETE 	// 게시판 글 삭제
	= " DELETE FROM board "
	+ " WHERE no = ? ";
	
	public static final String BOARD_INCREASE 	// 조회수 1 증가
	= " UPDATE board SET hit = hit + 1 "
	+ " WHERE no = ? ";
	
	public static final String BOARD_GET_TOTALROW 	// 페이지 처리
	= " SELECT COUNT(*) FROM board ";
	
	
	
	// 공지사항 쿼리 ===============================================================================================
	// 1. 공지사항 리스트 : 번호, 제목, 공지시작일, 공지종료일, 최근 수정일
	public static final String NOTICE_LIST 	// 게시판 리스트
	= " SELECT rnum, no, title, "
	+ " TO_CHAR(startDate, 'yyyy.mm.dd') startDate, "
	+ " TO_CHAR(writeDate, 'yyyy.mm.dd') writeDate, "
	+ " TO_CHAR(endDate, 'yyyy.mm.dd') endDate, "
	+ " TO_CHAR(updateDate, 'yyyy.mm.dd') updateDate FROM( "
		+ " SELECT rownum rnum, no, title, startDate, writeDate, endDate, updateDate FROM ("
			+ " SELECT no, title, startDate, writeDate, endDate, updateDate FROM notice"
			+ " order by no desc "
		+ " ) "
	+ ") where rnum between ? and ?  ";
	
	// 2.
	public static final String NOTICE_GET_TOTALROW 	// 페이지 처리
	= " SELECT COUNT(*) FROM notice ";
	
	// 2. 공지사항 등록
	public static final String NOTICE_WIRTE 	// 게시판 글 쓰기
	= " INSERT INTO notice(no, title, content, startDate, endDate) "
	+ " VALUES(notice_seq.NEXTVAL, ?, ?, ?, ?) ";
	
	
	// 회원관리 쿼리 ===============================================================================================
	public static final String MEMBER_LOGIN =	// 로그인 처리
	  " SELECT m.id, m.name, m.gradeNo, g.gradeName FROM member m, grade g "
	+ " WHERE (m.id = ? AND m.pw = ?) AND (m.gradeNo = g.gradeNo) ";
	
	// 회원관리 리스트 ==============================================================================================
	public static final String MEMBER_LIST =
	  " SELECT m.id, m.name, m.gender, "
	+ " TO_CHAR(birth, 'yyyy.mm.dd') birth, "
	+ " m.status, m.tel, m.gradeNo, g.gradeName "
	+ " FROM member m, grade g "
	+ " WHERE m.gradeNo = g.gradeNo" 
	+ " ORDER BY id ASC ";
	
	// 회원관리 리스트 ===============================================================================================
	public static final String MEMBER1_LIST 	// 회원관리 리스트 : id, name, gender, birth, tel, status, gradeNo, gradeName
	= " SELECT rnum, id, name, gender, "
	+ " TO_CHAR(birth, 'yyyy.mm.dd') birth, tel, status, gradeNo, gradeName FROM ( "
		+ " SELECT ROWNUM rnum, id, name, gender, birth, tel,status, gradeNo, gradeName FROM ( "
			+ " SELECT m.id, m.name, m.gender, m.birth, m.tel, m.status, m.gradeNo, g.gradeName FROM member m, grade g"
			+ " WHERE m.gradeNo = g.gradeNo "
			+ " ORDER BY id ASC "
		+ " ) "
	+ " ) WHERE rnum BETWEEN ? AND ? ";
	
	// 회원등급 수정 =========================================================================================================
	public static final String MEMBER_GRADE_MODIFY = 
	  " UPDATE member set gradeNo = ? "
	+ " WHERE id = ? ";
	
	// 내 정보 관리 ==========================================================================================================
	public static final String MEMBER_VIEW =
	  " SELECT m.id, m.name, m.gender, "
	+ " TO_CHAR(m.birth, 'yyyy.mm.dd') birth, "		// alius에는 붙이지 않는다. 형식(TO_CHAR(m.xxxx, 'yyyy.mm.dd') xxxx)
	+ " m.tel, m.email, "
	+ " TO_CHAR(m.regDate, 'yyyy.mm.dd') regDate, "
	+ " m.gradeNo, g.gradeName, m.status "
	+ " FROM member m, grade g "
	+ " WHERE id = ? AND (m.gradeNo = g.gradeNo) "; 
	
	
	// 메시지 ==========================================================================================================
	public static final String MESSAGE_LIST 
	= " SELECT rnum, no, sender, "
	+ " TO_CHAR(sendDate, 'yyyy.mm.dd') sendDate,"
	+ " accepter, "
	+ " TO_CHAR(acceptDate, 'yyyy.mm.dd') acceptDate"
	+ " FROM ( "
		+ " SELECT ROWNUM rnum, no, sender, sendDate, accepter, acceptDate "
		+ " FROM ( "
			+ " SELECT no, sender, sendDate, accepter, acceptDate "
			+ " FROM message "
			+ " WHERE accepter = ? OR sender = ? "
			+ " ORDER BY no DESC "
		+ " ) "
	+ " ) WHERE rnum BETWEEN ? AND ?";
	
	public static final String MESSAGE_GET_TOTLAROW
	= " SELECT COUNT(*) "
	+ " FROM message "
	+ " WHERE sender = ? OR accepter = ? ";
	
}
