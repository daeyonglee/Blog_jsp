package kr.or.blog.board.dao;

import java.util.List;

import kr.or.blog.board.domain.Board;

/**
 * 게시판 Dao 인터페이스
 * @author 이대용
 *
 */
public interface BoardDao {
	
	/** 게시판 생성 */
	public void create(Board board);
	
	/** 게시판 조회 */
	public Board read(int boardId);
	
	/** 게시판 전체 조회 */
	public List<Board> listAll();
		
}
