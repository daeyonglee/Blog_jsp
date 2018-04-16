package kr.or.blog.article.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.blog.article.dao.ArticleDao;
import kr.or.blog.article.dao.JdbcArticleDao;
import kr.or.blog.article.domain.Article;
import kr.or.blog.common.dao.DaoFactory;

/**
 * Servlet implementation class ArticleAttachListController
 */
public class ArticleAttachListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String fileDirectory;

	/****************************************************************
	 * 자료실 목록 보기                                                                      		*
	 ****************************************************************/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		fileDirectory = getServletContext().getInitParameter("fileDirectory");
		
		// 디비에서 파일 목록 얻어오기
		ArticleDao dao = (ArticleDao) DaoFactory.getInstance().getDao(JdbcArticleDao.class);
		
		List<Article> list = dao.attachListAll();
		
		List<Map<String, Object>> responseList = new ArrayList<Map<String, Object>>();
		for (Article article : list) {
			Map<String, Object> map = new HashMap<String, Object>();
			File file = new File(fileDirectory+article.getAttachFile());
			if (file.exists()) {
				map.put("article", article);
				map.put("fileSize", file.length()/1000+"KB");
				responseList.add(map);
			}
		}
		
		request.setAttribute("list", responseList);
		
		request.getRequestDispatcher(getServletContext().getContextPath()+"/article/attachList.jsp").forward(request, response);
	}
}
