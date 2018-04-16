package kr.or.blog.article.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.blog.article.dao.ArticleDao;
import kr.or.blog.article.dao.JdbcArticleDao;
import kr.or.blog.article.domain.Article;
import kr.or.blog.article.domain.Params;
import kr.or.blog.common.dao.DaoFactory;

public class ArticleListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/****************************************************************
	 * 게시글 목록 출력                                                                      		*
	 ****************************************************************/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Params params = new Params();
		String requestPage = request.getParameter("page");
		String searchType = request.getParameter("searchType");
		String searchValue = request.getParameter("searchValue");
		String pageSize = request.getParameter("pageSize");
		
		
		if ("".equals(searchType) || searchType == null) {
			searchType = "subject";
		}
		
		if ("".equals(searchValue) || searchValue == null) {
			searchValue = "";
		}
		
		if ("".equals(pageSize) || pageSize == null) {
			pageSize = "10";
		}
		
		if ("".equals(requestPage) || requestPage == null) {
			requestPage = "1";
		}
		
		params.setPageSize(Integer.valueOf(pageSize));
		
		int page = Integer.valueOf(requestPage);
		
		ArticleDao dao = (ArticleDao) DaoFactory.getInstance().getDao(JdbcArticleDao.class);
		List<Article> list = dao.listPage(page, searchType, searchValue);
		
		// 페이지 수 확인
		params.setPageNum(dao.pageCount(new Params(0, searchType, searchValue, 10, 0)));
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
		
		request.getRequestDispatcher(getServletContext().getContextPath()+"/article/list.jsp").forward(request, response);
	}
}
