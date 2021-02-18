package com.webjjang.util.db;

public class DBSQL {

	// 게시판 쿼리
	public static final String BOARD_LIST 
	= " SELECT rnum, no, title, writer, "
	+ " TO_CHAR(writeDate, 'yyyy.mm.dd') writeDate, hit FROM ( "
		+ " SELECT ROWNUM rnum, no, title, writer, writeDate, hit FROM ( "
			+ " SELECT no, title, writer, writeDate, hit FROM board "
			+ " ORDER BY no DESC "
		+ " ) "
	+ " ) WHERE rnum BETWEEN ? AND ? ";
	
	public static final String BOARD_VIEW 
	= " SELECT no, title, content, writer, "
	+ " TO_CHAR(writeDate, 'yyyy.mm.dd') writeDate, hit "
	+ " FROM board "
	+ " WHERE no = ?";
	
	public static final String BOARD_WIRTE 
	= " INSERT INTO board(no, title, content, writer) "
	+ " VALUES(board_seq.NEXTVAL, ?, ?, ?) ";
	
	public static final String BOARD_UPDATE
	= " UPDATE board SET title = ? , content = ?, writer = ? "
	+ " WHERE no = ? ";
	
	public static final String BOARD_DELETE 
	= " DELETE FROM board "
	+ " WHERE no = ? ";
	
	public static final String BOARD_INCREASE 
	= " UPDATE INTO board SET hit = hti + 1 "
	+ " WHERE no = ? ";
	
	public static final String BOARD_GET_TOTALROW 
	= " SELECT COUNT(*) FROMM board ";
	
}
