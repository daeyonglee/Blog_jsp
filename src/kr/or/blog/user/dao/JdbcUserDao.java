package kr.or.blog.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import kr.or.blog.common.dao.DaoFactory;
import kr.or.blog.user.domain.User;


/**
 * UserDao구현클래스
 * @author 이대용
 *
 */
public class JdbcUserDao implements UserDao{
	
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

	/** 사용자 등록 
	 * @throws Exception */
	public void create(User user) throws RuntimeException{
		
		String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?)";
		
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPasswd());
			pstmt.setString(4, user.getEmail());
			
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
	
	/** 아이디로 사용자 조회 
	 * @throws SQLException */
	public User read(String id) throws RuntimeException {
		
		String sql = "SELECT ID, NAME, PASSWD, EMAIL FROM USERS WHERE ID = ?";
		
		User user = null;
		try {
			con   = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user = new User();
				user.setId(rs.getString("ID"));
				user.setName(rs.getString("NAME"));
				user.setPasswd(rs.getString("PASSWD"));
				user.setEmail(rs.getString("EMAIL"));
			}
			
		} catch (Exception e) {
			throw new RuntimeException("UserDao.read(String id) : " + e.toString());
		} finally {
			close(rs, pstmt, con);
		}
		
		return user;
	}
	
	/** 아이디와 비밀번호를 이용한 회원인증*/
	public User isMember(String id, String passwd) throws RuntimeException {
		String sql = "SELECT ID, NAME, PASSWD, EMAIL FROM USERS WHERE ID = ? AND PASSWD = ?";
		
		User user = null;
		try {
			con   = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user = new User();
				user.setId(rs.getString("ID"));
				user.setName(rs.getString("NAME"));
				user.setPasswd(rs.getString("PASSWD"));
				user.setEmail(rs.getString("EMAIL"));
			}
			
		} catch (Exception e) {
			throw new RuntimeException("UserDao.isMember(String id, String passwd) : " + e.toString());
		} finally {
			close(rs, pstmt, con);
		}
		
		return user;
	}

	/** 사용자 이름으로 검색 */
	public List<User> search(String name) throws RuntimeException {
		
		String sql = "SELECT ID, NAME, PASSWD, EMAIL FROM USERS WHERE NAME LIKE '%' || ? || '%'";
		List<User> list = new ArrayList<User>();
		
		try {
			con   = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getString("ID"));
				user.setName(rs.getString("NAME"));
				user.setPasswd(rs.getString("PASSWD"));
				user.setEmail(rs.getString("EMAIL"));
				list.add(user);
			}
			
		} catch (Exception e) {
			throw new RuntimeException("UserDao.search(String name) : " + e.toString());
		} finally {
			close(rs, pstmt, con);
		}
		
		return list;
	}
	
	/** 사용자 전체 조회 */
	public List<User> listAll() throws RuntimeException{
		
		String sql = "SELECT ID, NAME, PASSWD, EMAIL FROM USERS";
		
		List<User> list = new ArrayList<User>();
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getString("ID"));
				user.setName(rs.getString("NAME"));
				user.setPasswd(rs.getString("PASSWD"));
				user.setEmail(rs.getString("EMAIL"));
				list.add(user);
			}
		} catch (Exception e) {
			throw new RuntimeException("UserDao.listAll() : " + e.toString());
		} finally {
			close(rs, pstmt, con);
		}
		
		return list;
	}
	
	/** 사용자 정보 수정 */
	public void update(User user) throws RuntimeException{
		
		String sql = "UPDATE USERS SET NAME = ?, PASSWD = ?, EMAIL = ? WHERE ID = ?";
		
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPasswd());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getId());
			
			pstmt.executeUpdate();
			
			con.commit();
			
		} catch (Exception e) {
			try {
				con.rollback();
				throw new RuntimeException("UserDao.update(User user) : " + e.toString());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	/** 사용자 정보 삭제 */
	public void delete(String id) throws RuntimeException{
		
		String sql = "DELETE FROM USERS WHERE ID = ?";
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
			con.commit();
		} catch (Exception e) {
			try {
				con.rollback();
				throw new RuntimeException("UserDao.delete(String id) : " + e.toString());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	
	public List<Map<String, Object>> employeeList() {
		
		String sql = "SELECT E.EMPLOYEE_ID" + 
					 "     , E.LAST_NAME" + 
					 "     , D.DEPARTMENT_ID" + 
					 "     , D.DEPARTMENT_NAME" + 
					 "  FROM EMPLOYEES E " + 
					 " INNER JOIN DEPARTMENTS D" + 
					 "    ON E.DEPARTMENT_ID = D.DEPARTMENT_ID"; 
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = null;
		ResultSetMetaData rsmd = null;
		try {
			con   = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			rs    = pstmt.executeQuery();
			rsmd = rs.getMetaData();
			System.out.println(rsmd.getColumnLabel(1) + "\t" + rsmd.getColumnLabel(2) + "\t" + rsmd.getColumnLabel(3) + "\t" + rsmd.getColumnLabel(4));
			System.out.println("====================================================");
			while(rs.next()) {
				map = new HashMap<String, Object>();
				map.put("user", new User(rs.getString("EMPLOYEE_ID"), rs.getString("LAST_NAME"), null, null));
				map.put("department_id", rs.getString("DEPARTMENT_ID"));
				map.put("department_name", rs.getString("DEPARTMENT_NAME"));
				list.add(map);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		UserDao dao = (UserDao) DaoFactory.getInstance().getDao(JdbcUserDao.class);
		
		try {
			User user = dao.isMember("bbbb", "6666");
			System.out.println(user.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

