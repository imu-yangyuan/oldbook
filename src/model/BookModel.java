package model;

public class BookModel {
	private String bookId;
    private String userId;
    private String userName;
    private String bookName;
    private String bookPhotoUrl;
    private String userPhotoUrl;
    private String bookAboutText;
    private Double bookPrice;
    private String addTime;
    private String userSex;
    private Integer state;

    public BookModel() {
    }

    public BookModel(String bookId, String userId, String userName, String bookName, String bookPhotoUrl, String userPhotoUrl, String bookAboutText, Double bookPrice, String addTime, String userSex, Integer state) {
        this.bookId = bookId;
        this.userId = userId;
        this.userName = userName;
        this.bookName = bookName;
        this.bookPhotoUrl = bookPhotoUrl;
        this.userPhotoUrl = userPhotoUrl;
        this.bookAboutText = bookAboutText;
        this.bookPrice = bookPrice;
        this.addTime = addTime;
        this.userSex = userSex;
        this.state = state;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBookPhotoUrl() {
        return bookPhotoUrl;
    }

    public void setBookPhotoUrl(String bookPhotoUrl) {
        this.bookPhotoUrl = bookPhotoUrl;
    }

    public String getUserPhotoUrl() {
        return userPhotoUrl;
    }

    public void setUserPhotoUrl(String userPhotoUrl) {
        this.userPhotoUrl = userPhotoUrl;
    }

    public String getBookAboutText() {
        return bookAboutText;
    }

    public void setBookAboutText(String bookAboutText) {
        this.bookAboutText = bookAboutText;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }
}
