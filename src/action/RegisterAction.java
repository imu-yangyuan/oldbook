package action;

import io.rong.RongCloud;
import io.rong.models.TokenReslut;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.security.cert.X509Certificate;

import model.CommonReturnData;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.envers.tools.Tools;
import org.springframework.beans.factory.annotation.Autowired;

import rongutils.RongTools;
import service.SchoolService;
import service.UserService;
import service.impl.UserServiceImpl;
import util.IDTools;
import bean.School;
import bean.User;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {
	private String userPhone;
	private String password;
	private String nickName;
	private String checkCode;
	private String university;
	@Autowired
	private CommonReturnData commonReturnData;
	private User user;

	@Resource
	private UserService userService;
	@Resource
	private SchoolService schoolService;

	public String execute() {
		commonReturnData.setMsg("");
		commonReturnData.setState(0);
		try {
			if (ServletActionContext.getRequest().getMethod().equals("GET")) {
				// userLoginData=(UserLoginData)getObjectBySpring.getObject("userLoginData");
				commonReturnData.setMsg("请求方式错误！");
				commonReturnData.setState(0);
				return "success";
			} else if (StringUtils.isNotBlank(userPhone)
					&& StringUtils.isNotBlank(password)
					&& StringUtils.isNotBlank(nickName)
					&& StringUtils.isNotBlank(checkCode)
					&& StringUtils.isNotBlank(university)) {
				String result = requestData(
						"https://webapi.sms.mob.com/sms/verify",
						"appkey=17094dcb97a9e&phone="+userPhone+"&zone=86&&code="+checkCode);
				if ("200".equals(result)) {
					List<User> users = userService.findUsersByPhone(userPhone);
					List<School> schools = schoolService
							.findSchoolByName(university);
					if (users != null && users.size() > 0) {
						commonReturnData.setMsg("手机号已被注册！");
						commonReturnData.setState(0);
					} else if (schools == null || schools.size() <= 0) {
						commonReturnData.setMsg("大学不存在");
						commonReturnData.setState(0);
					} else {
						user = new User();
						user.setId(IDTools.getId());
						TokenReslut tokenReslut=RongTools.getRongTokenReslut(user.getId(), nickName, "http://oe1rqbymq.bkt.clouddn.com//oldbook/11.jpg");
						
						if ("200".equals(tokenReslut.getCode())) {
							user.setPhone(userPhone);
							user.setPassword(password);
							user.setUsername(nickName);
							user.setToken(tokenReslut.getToken());
							user.setUniversity(schools.get(0).getId()+"");
							getToken(user.getId(), nickName);
							user.setUniversity(schools.get(0).getId() + "");
							user.setSex("未知性别");
							user.setIpAddress(getIp());
							user.setRegisterTime(System.currentTimeMillis() + "");
							userService.save(user);
							commonReturnData.setState(1);
							commonReturnData.setMsg("注册成功！");
						}else {
							commonReturnData.setState(0);
							commonReturnData.setMsg("注册失败");
						}
					}

				}
			} else {
				commonReturnData.setMsg("手机号或验证码错误");
				commonReturnData.setState(0);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			commonReturnData.setState(0);
			commonReturnData.setMsg("注册失败");
		}
		return SUCCESS;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// ////////////////////////
	/**
	 * 发起https 请求
	 * 
	 * @param address
	 * @param m
	 * @return
	 */
	public String requestData(String address, String params) {

		HttpURLConnection conn = null;
		try {
			// Create a trust manager that does not validate certificate chains
			TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				public void checkClientTrusted(X509Certificate[] certs,
						String authType) {
				}

				public void checkServerTrusted(X509Certificate[] certs,
						String authType) {
				}

				@Override
				public void checkClientTrusted(
						java.security.cert.X509Certificate[] chain,
						String authType) throws CertificateException {
					// TODO Auto-generated method stub

				}

				@Override
				public void checkServerTrusted(
						java.security.cert.X509Certificate[] chain,
						String authType) throws CertificateException {
					// TODO Auto-generated method stub

				}
			} };

			// Install the all-trusting trust manager
			SSLContext sc = SSLContext.getInstance("TLS");
			sc.init(null, trustAllCerts, new SecureRandom());

			// ip host verify
			HostnameVerifier hv = new HostnameVerifier() {
				public boolean verify(String urlHostName, SSLSession session) {
					return urlHostName.equals(session.getPeerHost());
				}
			};

			// set ip host verify
			HttpsURLConnection.setDefaultHostnameVerifier(hv);

			HttpsURLConnection
					.setDefaultSSLSocketFactory(sc.getSocketFactory());

			URL url = new URL(address);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");// POST
			conn.setConnectTimeout(3000);
			conn.setReadTimeout(3000);
			// set params ;post params
			if (params != null) {
				conn.setDoOutput(true);
				DataOutputStream out = new DataOutputStream(
						conn.getOutputStream());
				out.write(params.getBytes(Charset.forName("UTF-8")));
				out.flush();
				out.close();
			}
			conn.connect();
			// get result
			if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				String result = parsRtn(conn.getInputStream());
				// System.out.println(result);
				return result;
			} else {
				System.out.println(conn.getResponseCode() + " "
						+ conn.getResponseMessage());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				conn.disconnect();
		}
		return null;
	}

	public String parsRtn(InputStream input) throws Exception {
		String DEFAULT_ENCODING = "UTF-8";// 编码
		int PROTECTED_LENGTH = 51200;// 输入流保护 50KB
		if (input == null) {
			return "";
		}

		byte[] bcache = new byte[2048];
		int readSize = 0;// 每次读取的字节长度
		int totalSize = 0;// 总字节长度
		ByteArrayOutputStream infoStream = new ByteArrayOutputStream();
		try {
			// 一次性读取2048字节
			while ((readSize = input.read(bcache)) > 0) {
				totalSize += readSize;
				if (totalSize > PROTECTED_LENGTH) {
					throw new Exception("输入流超出50K大小限制");
				}
				// 将bcache中读取的input数据写入infoStream
				infoStream.write(bcache, 0, readSize);
			}
		} catch (IOException e1) {
			throw new Exception("输入流读取异常");
		} finally {
			try {
				// 输入流关闭
				input.close();
			} catch (IOException e) {
				throw new Exception("输入流关闭异常");
			}
		}

		try {
			return infoStream.toString(DEFAULT_ENCODING);
		} catch (UnsupportedEncodingException e) {
			throw new Exception("输出异常");
		}
	}

	private String getIp() {
		return ServletActionContext.getRequest().getRemoteAddr();
	}

	public CommonReturnData getCommonReturnData() {
		return commonReturnData;
	}

	public void setCommonReturnData(CommonReturnData commonReturnData) {
		this.commonReturnData = commonReturnData;
	}

	public String getToken(String userId, String nickName) {
		String appKey = "cpj2xarljcrmn";
		String appSecret = "xqalPaMlwFoRG";
		Reader reader = null;
		RongCloud rongCloud = RongCloud.getInstance(appKey, appSecret);
		try {
			TokenReslut userGetTokenResult = rongCloud.user.getToken(userId,
					nickName, "http://www.rongcloud.cn/images/logo.png");
			return userGetTokenResult.getToken();
		} catch (Exception e) {
			return "获取token错误";
		}

	}
}
