package cn.mike.app.MyFrame.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cn.mike.app.MyFrame.pojo.ExpressDetail;
import cn.mike.app.MyFrame.pojo.Page;
import cn.mike.app.MyFrame.pojo.PageInfo;
import cn.mike.app.MyFrame.service.LoginService;
import cn.mike.app.framework.annotation.JSON;
import cn.mike.app.framework.annotation.Module;
import cn.mike.app.framework.annotation.Handler;

@Module(name = "user")
public class LoginController {
	@Inject
	private LoginService loginService;
	

	@Handler(value = "logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		return "WEB-INF/jsp/test.html";
	}
	

	@JSON
	@Handler(value = "getStudent")
	public List<Map<String,String>> getTest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return loginService.findAllStudent();
	}
	
	@JSON
	@Handler(value = "getResultPage")
	public Page getResultPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return loginService.getAllResult(new PageInfo(1, 20));
	}

	@JSON
	@Handler(value = "getExpressDetail")
	public ExpressDetail getExpressDetail(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ExpressDetail detail = new ExpressDetail();
		detail.setExpress_id("1001");
		detail.setGoods_name("可乐");
		return detail;
	}
	
	@JSON
	@Handler(value = "getAllResult")
	public Page getAllResult(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return loginService.getAllResult(new PageInfo(2, 10));
	}
}
