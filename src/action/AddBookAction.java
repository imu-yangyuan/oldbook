package action;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import service.BookService;
import service.UserService;
import util.IDTools;
import util.UpPhoto;
import model.CommonReturnData;
import model.UserLoginData;
import bean.Book;
import bean.User;

import com.opensymphony.xwork2.ActionSupport;

public class AddBookAction extends ActionSupport {
	private String userPhone;
	private String secretKey;
	private String bookName;
	private String bookAboutText;
	private String addTime;
	private String bookPrice;
	private File bookImg;
	private String bookImgFileName;
	private String bookImgContentType;
	private CommonReturnData commonReturnData=new CommonReturnData("",0);
	@Resource
	private UserService userService;
	@Resource
	private BookService bookService;
	@Override
	public String execute() throws Exception {
		try {
			// TODO Auto-generated method stub
			if (bookPrice == null)
				bookPrice = "0";
			if (!ServletActionContext.getRequest().getMethod().equals("POST")) {
				// userLoginData=(UserLoginData)getObjectBySpring.getObject("userLoginData");
				commonReturnData.setMsg("请求方式错误！");
				commonReturnData.setState(0);
				return "success";
			} else if ("".equals(userPhone) || "".equals(secretKey)
					|| userPhone == null || secretKey == null
					|| Double.parseDouble(bookPrice) < 0) {
				commonReturnData.setMsg("提交数据有误！");
				commonReturnData.setState(0);
				return SUCCESS;
			} else if (StringUtils.isNotBlank(userPhone)
					&& StringUtils.isNotBlank(secretKey)) {
				List<User> users = userService.findUsersByPhoneAndSecretKey(
						userPhone, secretKey);
				if (users == null && users.size() <= 0) {
					commonReturnData.setMsg("用户不存在");
					commonReturnData.setState(0);
				} else {
					final String urlhead = "http://oe1rqbymq.bkt.clouddn.com/";
					String keyString = IDTools.getId() + "."
							+ (StringUtils.split(bookImgFileName, '.'))[1];
					String bookPhotoUrl = urlhead + keyString;
					UpPhoto upPhoto = new UpPhoto();
					if (upPhoto.upload(bookImg, keyString)) {
						Book book = new Book();
						book.setBookName(bookName);
						book.setUserid(users.get(0).getId());
						book.setBookAboutText(bookAboutText);
						if (bookPrice != null)
							book.setBookPrice(Double.valueOf(bookPrice));
						else {
							book.setBookPrice(-1.0);
						}
						book.setBookPhotoUrl(bookPhotoUrl);
						book.setAddTime(System.currentTimeMillis() + "");
						book.setState(0);
						bookService.save(book);
						commonReturnData.setMsg("上传成功");
						commonReturnData.setState(1);
					} else {
						LOG.error("添加图书", "图片上传失败");
						commonReturnData.setMsg("图片保存失败");
						commonReturnData.setState(0);
					}
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
			commonReturnData.setMsg("上传失败");
			commonReturnData.setState(0);
		}
		return SUCCESS;
	}
	public void setBookImgFileName(String bookImgFileName) {
		this.bookImgFileName = bookImgFileName;
	}
	public void setBookImgContentType(String bookImgContentType) {
		this.bookImgContentType = bookImgContentType;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public void setBookAboutText(String bookAboutText) {
		this.bookAboutText = bookAboutText;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	public void setBookPrice(String bookPrice) {
		this.bookPrice = bookPrice;
	}
	public void setBookImg(File bookImg) {
		this.bookImg = bookImg;
	}
	public CommonReturnData getCommonReturnData() {
		return commonReturnData;
	}
	
}
