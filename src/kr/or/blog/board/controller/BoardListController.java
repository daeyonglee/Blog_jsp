package kr.or.blog.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.blog.board.dao.ArticleDao;
import kr.or.blog.board.dao.JdbcArticleDao;
import kr.or.blog.board.domain.Article;
import kr.or.blog.board.domain.Params;
import kr.or.blog.common.dao.DaoFactory;

/**
 * Servlet implementation class BoardListController
 */
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/****************************************************************
	 * 게시글 목록 출력                                                                      		*
	 ****************************************************************/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Params params = new Params();
		String requestPage = request.getParameter("page");
		
		if ("".equals(requestPage) || requestPage == null) {
			requestPage = "1";
		}
		
		int page = Integer.valueOf(requestPage);
		
		ArticleDao dao = (ArticleDao) DaoFactory.getInstance().getDao(JdbcArticleDao.class);
		List<Article> list = dao.listPage(page);
		
		// 페이지 수 확인
		params.setPageNum(dao.pageCount(new Params()));
		
		int startPage = ((page -1) / params.getPageSize()) * params.getPageSize() + 1;
		int endPage = startPage + params.getPageSize() - 1;
		
		// 마지막 페이지보다 클 경우 마지막 페이지의 번호 조정
		if (endPage > params.getPageNum()) {
			endPage = params.getPageNum();
		}
		
		request.setAttribute("page", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("list", list);
		request.setAttribute("params", params);
		
		request.getRequestDispatcher(getServletContext().getContextPath()+"/board/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
