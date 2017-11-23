package cn.mike.app.MyFrame.dao.impl;

import java.util.List;
import java.util.Map;

import com.google.inject.Singleton;

import cn.mike.app.MyFrame.dao.LoginDao;
import cn.mike.app.MyFrame.pojo.Page;
import cn.mike.app.MyFrame.pojo.PageInfo;
import cn.mike.app.framework.jdbc.DBUtil;
import cn.mike.app.framework.jdbc.handler.MapperHandler;
/**
 * 
 * @author B-0012
 * 数据库访问层
 */
@Singleton

public class LoginDaoImpl implements LoginDao {
	@Override
	@SuppressWarnings("unchecked")
	public List<Map<String,String>> getAllStudentFromDB() {
		String sql="select username,role_id from hdi_user";
		List<Map<String, String>> list=DBUtil.query(sql, new Object[]{}, new MapperHandler(),List.class);
		return list;
	}

	@Override
	public Page getAllResultByPage(PageInfo pageInfo) {
		String sql="select t.cnickid,t.crealname,t.cidcard,t.cmobileno,t.ilevel from tb_user t ";
		Page page=DBUtil.PageQuery(sql, new Object[]{}, new MapperHandler(),pageInfo);
		return page;
	}
}
