package kr.or.blog.article.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.blog.article.dao.ArticleDao;
import kr.or.blog.article.dao.JdbcArticleDao;
import kr.or.blog.article.domain.Article;
import kr.or.blog.common.dao.DaoFactory;

/**
 * Servlet implementation class BoardDetailController
 */
public class ArticleDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /****************************************************************
	 * 게시글 상세 보기                                                                      		*
	 ****************************************************************/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String articleId = request.getParameter("article_id");
		
		ArticleDao dao = (ArticleDao) DaoFactory.getInstance().getDao(JdbcArticleDao.class);
		dao.updateHitCount(Integer.valueOf(articleId));
		Article article = dao.read(Integer.valueOf(articleId));
		
		request.setAttribute("article", article);
		
		if (article != null) {
			request.getRequestDispatcher(getServletContext().getContextPath()+"/article/detail.jsp").forward(request, response);;
		}
	}
}
