package kr.or.blog.article.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ArticleAttachDownController
 */
public class ArticleAttachDownController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static String fileDirectory;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		fileDirectory = getServletContext().getInitParameter("fileDirectory");
		
		String fileName = request.getParameter("file");
		if (fileName == null || fileName.equals(""))
			return;

		String filePath = fileDirectory + fileName;
		File file = new File(filePath);

		// HTTP 버전별 브라우저 캐시 사용 않도록 응답헤더 설정
		String httpVersion = request.getProtocol();
		if (httpVersion.equals("HTTP/1.0")) {
			response.setDateHeader("Expires", 0);
			response.setHeader("Pragma", "no-cache");
		} else if (httpVersion.equals("HTTP/1.1")) {
			response.setHeader("Cache-Control", "no-cache");
		}
		
		// 파일 다운로드 처리를 위한 응답헤더에 마임타입 설정
		response.setContentType("application/octet-stream");
		fileName = URLEncoder.encode(fileName, "utf-8");
		response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ";");
		response.setHeader("Content-Length", "" + file.length());

		FileInputStream in = new FileInputStream(file);
		OutputStream out = response.getOutputStream();
		try{
			byte[] buffer = new byte[1024];
			int count = 0;
			while ((count = in.read(buffer)) != -1) {
				out.write(buffer, 0, count);
			}
		}finally{
			if(out != null) out.close();
			if(in != null)  in.close();
		}		
		
	}

}
