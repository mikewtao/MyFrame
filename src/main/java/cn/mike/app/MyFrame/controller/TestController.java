package cn.mike.app.MyFrame.controller;

import javax.inject.Inject;

import cn.mike.app.MyFrame.service.LoginService;
import cn.mike.app.framework.annotation.Module;

@Module(name="Test")
public class TestController {
    
	//@Inject
	//private LoginService loginService=Guice.createInjector().getInstance(LoginService.class);
	@Inject
	private LoginService loginService;
	

}
