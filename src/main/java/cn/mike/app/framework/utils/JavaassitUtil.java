package cn.mike.app.framework.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import cn.mike.app.MyFrame.pojo.ExpressDetail;
import cn.mike.app.MyFrame.pojo.People;
import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;

public class JavaassitUtil {

	public static String[] getParams(Class<?> clazz, String method) throws Exception {
		ClassPool pool = ClassPool.getDefault();
		ClassClassPath classPath = new ClassClassPath(JavaassitUtil.class);
		pool.insertClassPath(classPath);
		CtClass cc = pool.get(clazz.getName());
		CtMethod cm = cc.getDeclaredMethod(method);
		// 使用javaassist的反射方法获取方法的参数名
		MethodInfo methodInfo = cm.getMethodInfo();
		CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
		LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
		if (attr == null) {
			// exception
		}
		String[] paramNames = new String[cm.getParameterTypes().length];
		int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;
		for (int i = 0; i < paramNames.length; i++)
			paramNames[i] = attr.variableName(i + pos);
		return paramNames;
	}

	public static void main(String[] args) throws Exception {
			/*ExpressDetail detail=new ExpressDetail();
			detail.setExpress_id("1001");
			detail.setGoods_name("哇哈哈");
			Object oj=detail;*/
		    Class<?> pcls=People.class;
		    Method m=pcls.getMethod("setDetail", ExpressDetail.class);
			Class<?> cl=ExpressDetail.class;
			Field[] ffs=cl.getDeclaredFields();
			Object oo1=pcls.newInstance();
			Object o3=cl.newInstance();
			for(Field f1:ffs){
				f1.setAccessible(true);
				String fieldNamed = f1.getName().substring(0, 1).toUpperCase() + f1.getName().substring(1);
				Method fm = cl.getMethod("set" + fieldNamed, f1.getType().newInstance().getClass());
				fm.invoke(o3, "1001");
			}
			m.invoke(oo1, o3);
			System.out.println(oo1.toString());
		}
	
	public static boolean isJavaClass(Class<?> clz) {
		return clz != null && clz.getClassLoader() == null;
	}
	
	public static void call(People p){
		System.out.println(p.toString());
	}
}
