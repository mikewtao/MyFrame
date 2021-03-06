package cn.mike.app.framework;

import java.lang.reflect.Method;

public class RequestParam {
	private Object clazz;
	private Method method;

	public Object getClazz() {
		return clazz;
	}

	public void setClazz(Object clazz) {
		this.clazz = clazz;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	@Override
	public String toString() {
		return "RequestParam [clazz=" + clazz + ", method=" + method.getName() + "]";
	}
  
}
