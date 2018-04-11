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
	 * 게시글 등록                                                                              		*
	 ****************************************************************/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String subject = request.getParameter("subject");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		String passwd = request.getParameter("passwd");
		
		Article article = new Article();
		article.setSubject(subject);
		article.setWriter(writer);
		article.setContent(content);
		article.setIp(getClientIP(request));
		article.setPasswd(passwd);
		ArticleDao dao = (ArticleDao) DaoFactory.getInstance().getDao(JdbcArticleDao.class);
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
