package kr.or.blog.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.blog.common.dao.DaoFactory;
import kr.or.blog.user.dao.JdbcUserDao;
import kr.or.blog.user.dao.UserDao;
import kr.or.blog.user.domain.User;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/****************************************************************
	 * 유저 정보를 DB에서 확인 후 이미 가입된 유저라면 로그인 처리			*
	 * 가입된 유저가 아니라면 메시지 출력								*
	 ****************************************************************/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String url = request.getParameter("url");
		
		// DB연결 후 확인
		UserDao dao = (UserDao) DaoFactory.getInstance().getDao(JdbcUserDao.class);
		
		User user = dao.isMember(id, passwd);
		
		if (user != null) {
			Cookie cookie = new Cookie("id", id);
			cookie.setPath("/");
			response.addCookie(cookie);
			response.sendRedirect(getServletContext().getContextPath()+"/index.jsp");
		} else {
			response.sendRedirect(getServletContext().getContextPath()+"/user/login.jsp");
		}
		
		
	}

	/****************************************************************
	 * 회원가입 처리			                                        *
	 ****************************************************************/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		
		User user = new User(id, name, passwd, email, telephone);
		
		// DB 전송
		UserDao dao = (UserDao) DaoFactory.getInstance().getDao(JdbcUserDao.class);
		dao.create(user);
		
		// 디비 insert 성공
		request.getRequestDispatcher(getServletContext().getContextPath()+"/user/success.jsp").forward(request, response);
	}
}
