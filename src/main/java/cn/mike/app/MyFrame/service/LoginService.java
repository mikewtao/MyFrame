package cn.mike.app.MyFrame.service;

import java.util.List;
import java.util.Map;

import javax.inject.Named;

import com.google.inject.ImplementedBy;

import cn.mike.app.MyFrame.pojo.Page;
import cn.mike.app.MyFrame.pojo.PageInfo;
import cn.mike.app.MyFrame.service.impl.LoginServiceImpl;

@ImplementedBy(LoginServiceImpl.class)
//@Named
public interface LoginService {

	List<Map<String,String>> findAllStudent();
	Page getAllResult(PageInfo pageInfo);
}