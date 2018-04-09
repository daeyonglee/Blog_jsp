package kr.or.blog.visitors.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.blog.common.dao.DaoFactory;
import kr.or.blog.visitors.dao.GuestBookDao;
import kr.or.blog.visitors.dao.JdbcGuestBookDao;
import kr.or.blog.visitors.domain.GuestBook;

/**
 * Servlet implementation class ListController
 */
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// DB에 조회
		GuestBookDao dao = (GuestBookDao)DaoFactory.getInstance().getDao(JdbcGuestBookDao.class);
		List<GuestBook> list = dao.listAll();
		System.out.println(list.size());
		
		request.setAttribute("list", list);
		request.getRequestDispatcher(getServletContext().getContextPath()+"/visitors/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie[] cookies = request.getCookies();
		String userId = null;
		String contents = request.getParameter("contents");
		
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("id".equals(cookie.getName())) {
					userId = cookie.getValue();
					break;
				}
			}
		}
		
		// DB에 추가
		GuestBookDao dao = (GuestBookDao)DaoFactory.getInstance().getDao(JdbcGuestBookDao.class);
		dao.create(new GuestBook(0, userId, contents, null));
		
		doGet(request, response);
		//response.sendRedirect(getServletContext().getContextPath()+"/visitors/list.jsp");
	}

}
