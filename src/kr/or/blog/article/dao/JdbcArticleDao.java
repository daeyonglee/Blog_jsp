package kr.or.blog.article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import kr.or.blog.article.domain.Article;
import kr.or.blog.article.domain.Params;
import kr.or.blog.common.dao.DaoFactory;

/**
 * ArticleDao 구현 클래스
 * @author 이대용
 *
 */
public class JdbcArticleDao implements ArticleDao{

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
	
	/** 게시글 생성 */
	@Override
	public void create(Article article) {
		String sql = "INSERT INTO article  (" + 
				     "             article_id" + 
				     "           , board_id" + 
				     "           , writer" + 
				     "           , subject" + 
				     "           , content" + 
				     "           , regdate" + 
				     "           , hitcount" + 
				     "           , ip" + 
				     "           , passwd" + 
				     "           , attach_file" + 
				     "           , group_no" + 
				     "           , level_no" + 
				     "           , order_no" + 
				     "           ) VALUES (" + 
				     "             article_id_seq.nextval" + 
				      "            , 1" + 
				     "             , ?" + 
				     "             , ?" + 
				     "             , ?" + 
                   "           , sysdate" + 
				     "             , 0" + 
				     "             , ?" + 
				     "             , ?" + 
				     "           , null" + 
				     "           , article_id_seq.currval" + 
				     "             , 0" + 
				     "             , 0" + 
				     "                     )";
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, article.getWriter());
			pstmt.setString(2, article.getSubject());
			pstmt.setString(3, article.getContent());
			pstmt.setString(4, article.getIp());
			pstmt.setString(5, article.getPasswd());
			
			pstmt.executeUpdate();
			con.commit();
			
		} catch (Exception e) {
			try {
				e.printStackTrace();
				con.rollback();
				throw new RuntimeException("ArticleDao.create(Article article) : " + e.toString());
			} catch (SQLException e1) {}
		} finally {
			close(null, pstmt, con);
		}
	}
	
	/** 게시글 조회 */
	@Override
	public Article read(int articleId) {
		String sql = "SELECT article_id" + 
					  "     , writer" + 
					  "     , subject" + 
					  "     , content" + 
					  "     , regdate" + 
					  "     , passwd" + 
					  "     , group_no" + 
					  "     , level_no" + 
					  "     , order_no" + 
					  "  FROM article" + 
					  " WHERE article_id=?";
		
		Article article = new Article();
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, articleId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				article.setArticleId(rs.getInt("article_id"));
				article.setWriter(rs.getString("writer"));
				article.setSubject(rs.getString("subject"));
				article.setContent(rs.getString("content"));
				article.setRegdate(rs.getString("regdate"));
				article.setPasswd(rs.getString("passwd"));
				article.setGroupNo(rs.getInt("group_no"));
				article.setLevelNo(rs.getInt("level_no"));
				article.setOrderNo(rs.getInt("order_no"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("ArticleDao.read(int articleId) : " + e.toString());
		} finally {
			close(rs, pstmt, con);
		}
		
		return article;
	}

	@Override
	public void update(Article article) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int articleId) {
		// TODO Auto-generated method stub
		
	}

	/** 게시글 전체 조회 */
	@Override
	public List<Article> listAll() {
		String sql = "SELECT article_id" + 
				     "     , board_id" + 
				     "     , writer" + 
				     "     , subject" + 
				     "     , content" + 
				     "     , TO_CHAR(regdate, 'YYYY-MM-DD') as regdate" + 
				     "     , hitcount" + 
				     "     , ip" + 
				     "     , passwd" + 
				     "     , attach_file" + 
				     "     , group_no" + 
				     "     , level_no" + 
				     "     , order_no" + 
				     "  FROM article" +
				     " WHERE board_id = 1" +
				     " ORDER BY article_id desc";
	
		List<Article> list = new ArrayList<Article>();
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Article article = new Article();
				article.setArticleId(rs.getInt("article_id"));
				article.setBoardId(rs.getInt("board_id"));
				article.setWriter(rs.getString("writer"));
				article.setSubject(rs.getString("subject"));
				article.setContent(rs.getString("content"));
				article.setRegdate(rs.getString("regdate"));
				article.setHitcount(rs.getInt("hitcount"));
				article.setIp(rs.getString("ip"));
				article.setPasswd(rs.getString("passwd"));
				article.setAttachFile(rs.getString("attach_file"));
				article.setGroupNo(rs.getInt("group_no"));
				article.setLevelNo(rs.getInt("level_no"));
				article.setOrderNo(rs.getInt("order_no"));
				list.add(article);
			}
		} catch (Exception e) {
			throw new RuntimeException("ArticleDao.listAll() : " + e.toString());
		} finally {
			close(rs, pstmt, con);
		}
			
		return list;
		
	}

	/** 해당 페이지의 게시글 조회 */
	@Override
	public List<Article> listPage(int page) {
		String sql = "SELECT article_id "         +
				     "     , subject " + 
				     "     , writer  " + 
				     "     , regdate " + 
				     "     , ip      " + 
				     "     , hitcount" + 
				     "  FROM (SELECT CEIL(rownum / 10) as page" + 
				     "             , article_id " + 
				     "             , subject " + 
				     "             , writer  " + 
				     "             , TO_CHAR(regdate, 'YYYY-MM-DD HH24:MI') regdate" + 
				     "             , ip " + 
				     "             , hitcount " + 
				     "          FROM (SELECT article_id " + 
				     "                     , subject " + 
				     "                     , writer " + 
				     "                     , regdate " + 
				     "                     , ip " + 
				     "                     , hitcount " + 
				     "                  FROM article " + 
				     "                 WHERE board_id = 1  ";
		      sql += "                 ORDER BY group_no DESC, " + 
				     "                          order_no ASC" + 
				     "               )" + 
				     "        )" + 
				     "WHERE page = ?";

		List<Article> list = new ArrayList<Article>();
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, page);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Article article = new Article();
				article.setArticleId(rs.getInt("article_id"));
				article.setWriter(rs.getString("writer"));
				article.setSubject(rs.getString("subject"));
				article.setRegdate(rs.getString("regdate"));
				article.setHitcount(rs.getInt("hitcount"));
				article.setIp(rs.getString("ip"));
				list.add(article);
			}
		} catch (Exception e) {
			throw new RuntimeException("ArticleDao.listPage(int page) : " + e.toString());
		} finally {
			close(rs, pstmt, con);
		}
			
		return list;
	}

	@Override
	public List<Article> listPage(int page, String... searchOptions) {
		// searchOptions의 index 0 은 searchType, 1은 searchValue
		String searchType = searchOptions[0];
		String searchValue = searchOptions[1];
		String sql = "SELECT article_id "         +
			     "     , subject " + 
			     "     , writer  " + 
			     "     , regdate " + 
			     "     , ip      " + 
			     "     , hitcount" + 
			     "  FROM (SELECT CEIL(rownum / 10) as page" + 
			     "             , article_id " + 
			     "             , subject " + 
			     "             , writer  " + 
			     "             , TO_CHAR(regdate, 'YYYY-MM-DD HH24:MI') regdate" + 
			     "             , ip " + 
			     "             , hitcount " + 
			     "          FROM (SELECT article_id " + 
			     "                     , subject " + 
			     "                     , writer " + 
			     "                     , regdate " + 
			     "                     , ip " + 
			     "                     , hitcount " + 
			     "                  FROM article " + 
			     "                 WHERE board_id = 1  ";
		  sql += "                   AND " + searchType + " LIKE ?";  
		  sql += "                 ORDER BY group_no DESC, " + 
			     "                          order_no ASC" + 
			     "               )" + 
			     "        )" + 
			     " WHERE page = ?";
		 System.out.println(sql);
		List<Article> list = new ArrayList<Article>();
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+searchValue+"%");
			pstmt.setInt(2, page);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Article article = new Article();
				article.setArticleId(rs.getInt("article_id"));
				article.setWriter(rs.getString("writer"));
				article.setSubject(rs.getString("subject"));
				article.setRegdate(rs.getString("regdate"));
				article.setHitcount(rs.getInt("hitcount"));
				article.setIp(rs.getString("ip"));
				list.add(article);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("ArticleDao.listPage(int page, String... searchOptions) : " + e.toString());
		} finally {
			close(rs, pstmt, con);
		}
			
		return list;
	}

	@Override
	public List<Article> listPage(Params params) {
		// TODO Auto-generated method stub
		return null;
	}

	/** 페이지 수 조회 (전체 게시글) */
	@Override
	public int pageCount(Params params) {
		String sql =  "SELECT CEIL(count(*) / ?) as count" + 
				      "  FROM article ";
			  sql += " WHERE " + params.getSearchType() + " LIKE ?";  
		

		int count = 1;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, params.getPageSize());
			pstmt.setString(2, "%"+params.getSearchValue()+"%");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			throw new RuntimeException("ArticleDao.pageCount(Params param) : " + e.toString());
		} finally {
			close(rs, pstmt, con);
		}
			
		return count;
	}
	
	/** Hit 수 증가 */
	@Override
	public void updateHitCount(int articleId) {
		String sql = " UPDATE article" + 
				      "    SET hitcount = hitcount + 1" + 
				      "  WHERE article_id=?";
		try {
				con = dataSource.getConnection();
				con.setAutoCommit(false);
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, articleId);
				pstmt.executeUpdate();
				
				con.commit();
				
		} catch (Exception e) {
			try {
				e.printStackTrace();
				con.rollback();
				throw new RuntimeException("ArticleDao.updateHitCount(int articleId) : " + e.toString());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			close(rs, pstmt, con);
		}
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
		ArticleDao dao = (ArticleDao) DaoFactory.getInstance().getDao(JdbcArticleDao.class);
		List<Article> list = dao.listPage(1, "subject","글쓰기");
		for (Article article : list) {
			System.out.println(article);
		}
		System.out.println(dao.pageCount(new Params(0, "subject", "", 10, 0)));
	}
}
