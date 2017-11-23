package cn.mike.app.MyFrame.service.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import com.google.inject.Guice;
import com.google.inject.Singleton;

import cn.mike.app.MyFrame.dao.LoginDao;
import cn.mike.app.MyFrame.pojo.Page;
import cn.mike.app.MyFrame.pojo.PageInfo;
import cn.mike.app.MyFrame.service.LoginService;
/**
 * 
 * @author 业务层
 *
 */
@Named
public class LoginServiceImpl implements LoginService {

	@Inject
	private LoginDao loginDao;
	
	@Override
	public List<Map<String,String>> findAllStudent() {
		return loginDao.getAllStudentFromDB();
	}

	@Override
	public Page getAllResult(PageInfo pageInfo) {
		return loginDao.getAllResultByPage(pageInfo);
	}
	
	
}
