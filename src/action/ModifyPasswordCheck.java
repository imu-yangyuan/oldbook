package action;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.util.List;

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

import service.UserService;
import bean.User;

import com.opensymphony.xwork2.ActionSupport;

public class ModifyPasswordCheck extends ActionSupport {
	private String userPhone;
	private String checkCode;
	private CommonReturnData commonReturnData=new CommonReturnData("",0);
	@Resource
	private UserService userService;
public CommonReturnData getCommonReturnData() {
		return commonReturnData;
	}
	public void setCommonReturnData(CommonReturnData commonReturnData) {
		this.commonReturnData = commonReturnData;
	}
@Override
public String execute() throws Exception {
	// TODO Auto-generated method stub
	if(ServletActionContext.getRequest().getMethod().equals("GET")){
		   // userLoginData=(UserLoginData)getObjectBySpring.getObject("userLoginData");
		commonReturnData.setMsg("请求方式错误！");
		commonReturnData.setState(0);
			return "success";
		}
	else if (StringUtils.isNotBlank(userPhone)
			&& StringUtils.isNotBlank(checkCode)
			&& StringUtils.isNotBlank(userPhone)
			&& StringUtils.isNotBlank(checkCode)){
		List<User> users = userService.findUsersByPhone(userPhone);
		if (users == null && users.size() == 0){
			commonReturnData.setMsg("手机号手机号不存在！");
			commonReturnData.setState(0);
			return SUCCESS;
		}else{
			/*String result = requestData(
					"https://webapi.sms.mob.com/sms/verify",
					"appkey=17094dcb97a9e&phone="+userPhone+"&zone=86&&code="+checkCode);
			if ("200".equals(result)){*/
				commonReturnData.setMsg("验证成功！");
				commonReturnData.setState(1);
				User user=users.get(0);
				user.setCheckCode(checkCode);
				userService.update(user);
				/*ServletActionContext.getRequest().getSession()
				.setAttribute("ModifyPasswordModel", users.get(0));*/
					return "success";
			/*}else {
				commonReturnData.setMsg("验证码错误");
				commonReturnData.setState(0);
				return SUCCESS;
			}*/
		}
		
	}
	
	return super.execute();
}
public String getUserPhone() {
	return userPhone;
}
public void setUserPhone(String userPhone) {
	this.userPhone = userPhone;
}
public String getCheckCode() {
	return checkCode;
}
public void setCheckCode(String checkCode) {
	this.checkCode = checkCode;
}
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
}
