package model;


/**
 * Created by yangy on 2016/9/10.
 */
public class UserModel {

    // Fields

    private String id;
    private String secretKey;
    private String username;
    private String phone;
    private String address;
    private String birthday;
    private String universityId;
    private String university;
    private String userPhotoUrl;
    private String token;
    private String sex;

    // Constructors

    /** default constructor */
    public UserModel() {
    }

    public UserModel(String id, String secretKey, String username, String phone, String address, String birthday, String universityId, String university, String userPhotoUrl, String token, String sex) {
        this.id = id;
        this.secretKey = secretKey;
        this.username = username;
        this.phone = phone;
        this.address = address;
        this.birthday = birthday;
        this.universityId = universityId;
        this.university = university;
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

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
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

    public String getUniversityId() {
        return universityId;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }
}
