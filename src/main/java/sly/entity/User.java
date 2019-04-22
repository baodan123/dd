package sly.entity;

public class User {
	private String id;
	private String nickname;
	private String password;
	private String email;
	private String code;
	private String status;
	private String salt;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String id, String nickname, String password, String email,
			String code, String status, String salt) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.password = password;
		this.email = email;
		this.code = code;
		this.status = status;
		this.salt = salt;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nickname=" + nickname + ", password="
				+ password + ", email=" + email + ", code=" + code
				+ ", status=" + status + ", salt=" + salt + "]";
	}
	
	
	
}
