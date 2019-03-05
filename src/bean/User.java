package bean;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private String id;
	private String phone;
	private String password;
	private String username;
	private String token;
	private String checkCode;
	private String secretKey;
	private String sex;
	private String address;
	private String birthday;
	private String university;
	private String userPhotoUrl;
	private String registerTime;
	private String ipAddress;
	private String loginTime;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String phone, String password, String username, String token,
			String checkCode, String secretKey, String sex, String address,
			String birthday, String university, String userPhotoUrl,
			String registerTime, String ipAddress, String loginTime) {
		this.phone = phone;
		this.password = password;
		this.username = username;
		this.token = token;
		this.checkCode = checkCode;
		this.secretKey = secretKey;
		this.sex = sex;
		this.address = address;
		this.birthday = birthday;
		this.university = university;
		this.userPhotoUrl = userPhotoUrl;
		this.registerTime = registerTime;
		this.ipAddress = ipAddress;
		this.loginTime = loginTime;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getCheckCode() {
		return this.checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	public String getSecretKey() {
		return this.secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getUniversity() {
		return this.university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getUserPhotoUrl() {
		return this.userPhotoUrl;
	}

	public void setUserPhotoUrl(String userPhotoUrl) {
		this.userPhotoUrl = userPhotoUrl;
	}

	public String getRegisterTime() {
		return this.registerTime;
	}

	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}

	public String getIpAddress() {
		return this.ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

}