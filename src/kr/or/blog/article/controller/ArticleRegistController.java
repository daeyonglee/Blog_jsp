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
 * Servlet implementation class BoardRegistController
 */
public class ArticleRegistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/****************************************************************
	 * 게시글 답글쓰기 시 article/regist.jsp로 이동                                                                              		*
	 ****************************************************************/
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String articleId = request.getParameter("article_id");
		
		ArticleDao dao = (ArticleDao) DaoFactory.getInstance().getDao(JdbcArticleDao.class);
		dao.updateHitCount(Integer.valueOf(articleId));
		Article article = dao.read(Integer.valueOf(articleId));
		request.setAttribute("article", article);
		
		if (article != null) {
			request.getRequestDispatcher(getServletContext().getContextPath()+"/article/regist.jsp").forward(request, response);;
		}
	}
	
	/****************************************************************
	 * 게시글 등록                                                                              		*
	 ****************************************************************/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String subject = request.getParameter("subject");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		String passwd = request.getParameter("passwd");
		String articleId = request.getParameter("articleId");
		String groupNo = request.getParameter("groupNo");
		String levelNo = request.getParameter("levelNo");
		String orderNo = request.getParameter("orderNo");
		
		
		Article article = new Article();
		article.setSubject(subject);
		article.setWriter(writer);
		article.setContent(content);
		article.setIp(getClientIP(request));
		article.setPasswd(passwd);
		ArticleDao dao = (ArticleDao) DaoFactory.getInstance().getDao(JdbcArticleDao.class);
		
		// 답글쓰기
		if (articleId != null) {
			article.setGroupNo(Integer.valueOf(groupNo));
			article.setLevelNo(Integer.valueOf(levelNo));
			article.setOrderNo(Integer.valueOf(orderNo));
			article.setArticleId(Integer.valueOf(articleId));
			// 그룹번호와 레벨이 같은 데이터들의 order_no값을 +1
			dao.updateRepOrderNo(article.getGroupNo(), article.getArticleId());
		} 
		
		dao.create(article);
	
		response.sendRedirect(getServletContext().getContextPath()+"/article/list.do");
	}
	
	public String getClientIP(HttpServletRequest request) {

	     String ip = request.getHeader("X-FORWARDED-FOR"); 
	     
	     if (ip == null || ip.length() == 0) {
	         ip = request.getHeader("Proxy-Client-IP");
	     }

	     if (ip == null || ip.length() == 0) {
	         ip = request.getHeader("WL-Proxy-Client-IP");  // 웹로직
	     }

	     if (ip == null || ip.length() == 0) {
	         ip = request.getRemoteAddr() ;
	     }
	     
	     return ip;

	 }
}
