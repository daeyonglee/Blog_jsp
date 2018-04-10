package kr.or.blog.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 로그아웃 처리 (쿠키 삭제)
 * @author 이대용
 *
 */
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String url = request.getParameter("url");
		Cookie[] cookies = request.getCookies();
		
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("id".equals(cookie.getName())) {
					cookie.setMaxAge(0);
					cookie.setPath("/");
					response.addCookie(cookie);
					break;
				}
			}
		}
		
		response.sendRedirect(getServletContext().getContextPath() + "/index.jsp");
		
	}

}
