package kr.or.blog.user.domain;

/**
 * 로그인 구현을 위한 도메인 클래스
 * @author 이대용
 *
 */
public class User {
	private String id;
	private String name;
	private String passwd;
	private String email;

	public User() {}
	
	public User(String id, String name, String passwd, String email) {
		super();
		this.id = id;
		this.name = name;
		this.passwd = passwd;
		this.email = email;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", passwd=" + passwd + ", email=" + email + "]";
	}
}
