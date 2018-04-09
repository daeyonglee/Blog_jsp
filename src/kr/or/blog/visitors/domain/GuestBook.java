package kr.or.blog.visitors.domain;

public class GuestBook {
	int guestbookId;
	String userId;
	String contents;
	String regdate;
	
	public GuestBook() {}

	public GuestBook(int guestbookId, String userId, String contents, String regdate) {
		super();
		this.guestbookId = guestbookId;
		this.userId = userId;
		this.contents = contents;
		this.regdate = regdate;
	}

	// getter/setter
	public int getGuestbookId() {
		return guestbookId;
	}
	public void setGuestbookId(int guestbookId) {
		this.guestbookId = guestbookId;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "GuestBook [guestbookId=" + guestbookId + ", userId=" + userId
				+ ", contents=" + contents + ", regdate=" + regdate + "]";
	}
}
