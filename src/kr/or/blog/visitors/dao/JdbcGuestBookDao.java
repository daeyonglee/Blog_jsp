package kr.or.blog.visitors.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import kr.or.blog.common.dao.DaoFactory;
import kr.or.blog.user.domain.User;
import kr.or.blog.visitors.domain.GuestBook;

public class JdbcGuestBookDao implements GuestBookDao{
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
	
	/**
	 * 방명록 생성
	 * @param guestBook
	 */
	@Override
	public void create(GuestBook guestBook) {
		
		String sql = "INSERT INTO GUESTBOOK         "
				+ "            (                          "
				+ "            guestbook_id          "
				+ "          , user_id               "
				+ "          , contents              "
				+ "          ) VALUES (              "
				+ "            guestbook_seq.nextval "
				+ "            , ?                        "
				+ "            , ?       )                ";
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, guestBook.getUserId());
			pstmt.setString(2, guestBook.getContents());
			
			pstmt.executeUpdate();
			
			con.commit();
			
		} catch (Exception e) {
			try {
				con.rollback();
				throw new RuntimeException("UserDao.create(User user) : " + e.toString());
			} catch (SQLException e1) {}
		} finally {
			close(null, pstmt, con);
		}
	}
	
	/**
	 * 방명록 리스트 조회
	 * @return
	 */
	@Override
	public List<GuestBook> listAll() {
			
		String sql = "SELECT guestbook_id"
				    + "     , user_id"
				    + "     , contents"
				    + "     , TO_CHAR(regdate, 'YYYY/MM/DD HH24:MI DAY') regdate" + 
				      "  FROM guestbook" + 
				      " ORDER BY guestbook_id DESC";
		
		List<GuestBook> list = new ArrayList<GuestBook>();
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				GuestBook guestBook = new GuestBook();
				guestBook.setGuestbookId(rs.getInt("guestbook_id"));
				guestBook.setUserId(rs.getString("user_id"));
				guestBook.setContents(rs.getString("contents"));
				guestBook.setRegdate(rs.getString("regdate"));
				list.add(guestBook);
			}
		} catch (Exception e) {
			throw new RuntimeException("UserDao.listAll() : " + e.toString());
		} finally {
			close(rs, pstmt, con);
		}
			
		return list;
	}
	
	private void close(ResultSet rs, PreparedStatement pstmt, Connection con) {
		try {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		GuestBookDao dao = (GuestBookDao)DaoFactory.getInstance().getDao(JdbcGuestBookDao.class);
		List<GuestBook> list = dao.listAll();
		System.out.println(list.size());
		for (GuestBook guestBook : list) {
			System.out.println(guestBook.toString());
		}
		
		/*dao.create(new GuestBook(0, "admin", "안녕하세요"));
		System.out.println("완료");*/
	}
}
