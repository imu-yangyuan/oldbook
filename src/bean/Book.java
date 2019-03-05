package bean;

/**
 * Book entity. @author MyEclipse Persistence Tools
 */

public class Book implements java.io.Serializable {

	// Fields

	private String id;
	private String userid;
	private Integer universityId;
	private String bookName;
	private String bookPhotoUrl;
	private String bookAboutText;
	private String addTime;
	private Double bookPrice;
	private Integer state;

	// Constructors

	/** default constructor */
	public Book() {
	}

	/** full constructor */
	public Book(String userid, Integer universityId, String bookName,
			String bookPhotoUrl, String bookAboutText, String addTime,
			Double bookPrice, Integer state) {
		this.userid = userid;
		this.universityId = universityId;
		this.bookName = bookName;
		this.bookPhotoUrl = bookPhotoUrl;
		this.bookAboutText = bookAboutText;
		this.addTime = addTime;
		this.bookPrice = bookPrice;
		this.state = state;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Integer getUniversityId() {
		return this.universityId;
	}

	public void setUniversityId(Integer universityId) {
		this.universityId = universityId;
	}

	public String getBookName() {
		return this.bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookPhotoUrl() {
		return this.bookPhotoUrl;
	}

	public void setBookPhotoUrl(String bookPhotoUrl) {
		this.bookPhotoUrl = bookPhotoUrl;
	}

	public String getBookAboutText() {
		return this.bookAboutText;
	}

	public void setBookAboutText(String bookAboutText) {
		this.bookAboutText = bookAboutText;
	}

	public String getAddTime() {
		return this.addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public Double getBookPrice() {
		return this.bookPrice;
	}

	public void setBookPrice(Double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}