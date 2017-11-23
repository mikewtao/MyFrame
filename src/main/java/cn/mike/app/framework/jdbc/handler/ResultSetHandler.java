package cn.mike.app.framework.jdbc.handler;

import java.sql.ResultSet;

public interface ResultSetHandler {
  public Object handler(ResultSet rs);
}
