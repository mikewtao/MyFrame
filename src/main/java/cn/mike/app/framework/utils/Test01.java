package cn.mike.app.framework.utils;

import java.lang.reflect.Field;

import javax.inject.Inject;
import javax.inject.Named;

public class Test01 {
    public Object getObj() throws Exception{
    	Class<?> clzz1 = Class.forName("cn.mike.app.framework.utils.Test");
		Field[] fields = clzz1.getDeclaredFields();
		//此pojo组件直接new 采用单例
		Object obj=clzz1.newInstance();
        for(Field field:fields){
            Inject af=field.getAnnotation(Inject.class);
            if(af!=null){
            	//Class<?> fieldCls=field.getType().getClass();
            	//此处根据接口查找实现类  ClassScan
            	System.out.println(field.getType().getName());
            	Class<?> fieldCls=Class.forName("cn.mike.app.MyFrame.pojo.User");
            	field.setAccessible(true);
            	//给字段设值
            	field.set(obj, fieldCls.newInstance());
            }
        }
        return obj;
    }

}
