package kr.or.blog.article.domain;

public class Article {
	
	private Integer articleId;
	private Integer boardId;
	private String writer;
	private String subject;
	private String content;
	private String regdate;
	private Integer hitcount;
	private String ip;
	private String passwd;
	private String attachFile;
	private Integer groupNo;
	private Integer levelNo;
	private Integer orderNo;
	
	public Article() {}

	public Article(Integer articleId, Integer boardId, String writer, String subject, String content, String regdate,
			Integer hitcount, String ip, String passwd, String attachFile, Integer groupNo, Integer levelNo,
			Integer orderNo) {
		super();
		this.articleId = articleId;
		this.boardId = boardId;
		this.writer = writer;
		this.subject = subject;
		this.content = content;
		this.regdate = regdate;
		this.hitcount = hitcount;
		this.ip = ip;
		this.passwd = passwd;
		this.attachFile = attachFile;
		this.groupNo = groupNo;
		this.levelNo = levelNo;
		this.orderNo = orderNo;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public Integer getBoardId() {
		return boardId;
	}

	public void setBoardId(Integer boardId) {
		this.boardId = boardId;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public Integer getHitcount() {
		return hitcount;
	}

	public void setHitcount(Integer hitcount) {
		this.hitcount = hitcount;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getAttachFile() {
		return attachFile;
	}

	public void setAttachFile(String attachFile) {
		this.attachFile = attachFile;
	}

	public Integer getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(Integer groupNo) {
		this.groupNo = groupNo;
	}

	public Integer getLevelNo() {
		return levelNo;
	}

	public void setLevelNo(Integer levelNo) {
		this.levelNo = levelNo;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", boardId=" + boardId + ", writer=" + writer + ", subject="
				+ subject + ", content=" + content + ", regdate=" + regdate + ", hitcount=" + hitcount + ", ip=" + ip
				+ ", passwd=" + passwd + ", attachFile=" + attachFile + ", groupNo=" + groupNo + ", levelNo=" + levelNo
				+ ", orderNo=" + orderNo + "]";
	}
}
