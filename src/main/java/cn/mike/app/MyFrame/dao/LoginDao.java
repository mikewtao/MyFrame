package cn.mike.app.MyFrame.dao;

import java.util.List;
import java.util.Map;

import com.google.inject.ImplementedBy;

import cn.mike.app.MyFrame.dao.impl.LoginDaoImpl;
import cn.mike.app.MyFrame.pojo.Page;
import cn.mike.app.MyFrame.pojo.PageInfo;

@ImplementedBy(LoginDaoImpl.class)
public interface LoginDao {

	List<Map<String,String>> getAllStudentFromDB();
	
	Page getAllResultByPage(PageInfo pageInfo);

}