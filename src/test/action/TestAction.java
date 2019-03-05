package test.action;

import javax.annotation.Resource;

import test.service.TestService;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport {

	@Resource
	TestService testService;

	public String execute() {
		testService.say();
		return SUCCESS;
	}

	public String hhh() {
		testService.say();
		System.out.println("hhh");
		return SUCCESS;
	}

}
