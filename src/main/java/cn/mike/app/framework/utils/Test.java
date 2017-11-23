package cn.mike.app.framework.utils;

import cn.mike.app.MyFrame.pojo.User;

import java.lang.reflect.Field;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class Test {
	public String readOnly;
	@Inject
    public User user;
	public static void main(String[] args)throws Exception {
		Class<?> clzz=Class.forName("cn.mike.app.framework.utils.Move");
		//System.out.println(clzz.getGenericSuperclass());
		//System.out.println(clzz.g);
		/*Field f = clzz.getDeclaredField("readOnly");
		Test obj=(Test) clzz.newInstance();
		f.setAccessible(true);
		f.set(obj, "test12345");
		System.out.println(obj.readOnly);*/
	}
}