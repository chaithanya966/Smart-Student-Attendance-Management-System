package com.smartattendance.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.InputStream;

public class DBConnection {
  private static Connection conn;
  public static Connection getConnection() throws Exception {
    if (conn == null || conn.isClosed()) {
      Properties props = new Properties();
      try (InputStream in = DBConnection.class.getResourceAsStream("/WEB-INF/config.properties")) {
        props.load(in);
      }
      String url = props.getProperty("db.url");
      String user = props.getProperty("db.user");
      String pass = props.getProperty("db.password");
      Class.forName("com.mysql.cj.jdbc.Driver");
      conn = DriverManager.getConnection(url, user, pass);
    }
    return conn;
  }
}
