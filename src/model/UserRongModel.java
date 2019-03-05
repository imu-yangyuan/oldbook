package model;

public class UserRongModel {
		private String id;
	    private String username;
	    private String userPhotoUrl;
	    private String token;
	    private String sex;
	    
		public UserRongModel() {
			super();
			// TODO Auto-generated constructor stub
		}
		public UserRongModel(String id, String username, String userPhotoUrl,
				String token, String sex) {
			super();
			this.id = id;
			this.username = username;
			this.userPhotoUrl = userPhotoUrl;
			this.token = token;
			this.sex = sex;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getUserPhotoUrl() {
			return userPhotoUrl;
		}
		public void setUserPhotoUrl(String userPhotoUrl) {
			this.userPhotoUrl = userPhotoUrl;
		}
		public String getToken() {
			return token;
		}
		public void setToken(String token) {
			this.token = token;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
	    
}
