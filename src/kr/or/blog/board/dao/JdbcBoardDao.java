package kr.or.blog.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import kr.or.blog.board.domain.Board;

/**
 * BoardDao 구현 클래스
 * @author 이대용
 *
 */
public class JdbcBoardDao implements BoardDao{

	Connection con          = null;
	PreparedStatement pstmt = null;
	ResultSet rs            = null;
	
	private DataSource dataSource = null;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void create(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Board read(int boardId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Board> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
