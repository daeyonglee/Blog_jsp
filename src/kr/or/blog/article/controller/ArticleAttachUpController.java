package kr.or.blog.article.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import kr.or.blog.article.dao.ArticleDao;
import kr.or.blog.article.dao.JdbcArticleDao;
import kr.or.blog.article.domain.Article;
import kr.or.blog.common.dao.DaoFactory;

/**
 * Servlet implementation class ArticleAttachUpController
 */
public class ArticleAttachUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String fileDirectory;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		fileDirectory = getServletContext().getInitParameter("fileDirectory");
		
		Article article = new Article();
		article.setIp(request.getRemoteAddr());
		// 아파치 파일 업로드 API를 이용한 파일 수신 및 서버 디렉토리에 저장
		DiskFileItemFactory itemFactory = new DiskFileItemFactory();
		ServletFileUpload fileUpload = new ServletFileUpload(itemFactory);
		fileUpload.setSizeMax(500 * 1024 * 1024); // 업로드 파일 용량 제한
		
		List<FileItem> fileList = null;
		
		try {
			fileList = fileUpload.parseRequest(request);
			for (FileItem item : fileList) {
				if (item.isFormField()) {
					String writer = item.getString("utf-8");
					article.setWriter(writer);
					System.out.println("작성자: " + writer);
				}else {// 업로드 파일인 경우
					String fileName = item.getName();
					System.out.println("업로드 파일명: " + fileName);
					// fileName = c:\xxx\yyy\업로드파일명
					String[] tokens = fileName.split("\\\\");
					fileName = tokens[tokens.length-1];//파일명만 추출
					article.setAttachFile(fileName);
					long fileSize = item.getSize();
					System.out.println("파일사이즈: " + fileSize);
					
					ArticleDao dao = (ArticleDao) DaoFactory.getInstance().getDao(JdbcArticleDao.class);
					dao.createAttachFile(article);
					
					// 업로드된 파일을 서버의 특정 디렉토리에 저장
					File saveFile = new File(fileDirectory + fileName);
					item.write(saveFile);
				}
			}
			
			// 디비 업데이트
			
			
			response.sendRedirect(getServletContext().getContextPath()+"/article/attachList.do");
		} catch (Exception e) {
			new ServletException(e.getMessage());
		}
	}
}
