package cn.mike.app.framework.utils;

public class Test02 {
  public static void main(String[] args) throws Exception {
	 Test01 test01=new Test01();
	 //此处获得一个对象
	 Test obj=(Test) test01.getObj();
	 obj.user.sayhello();
  }
}
