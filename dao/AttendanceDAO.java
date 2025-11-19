package com.smartattendance.dao;
import com.smartattendance.util.DBConnection;
import java.sql.*;
import java.util.*;
public class AttendanceDAO {
  public void markPresent(int studentId, java.util.Date date) throws Exception {
    String sql = "INSERT INTO attendance (student_id, date, status) VALUES (?, ?, ?)";
    try (Connection c = DBConnection.getConnection();
         PreparedStatement ps = c.prepareStatement(sql)) {
      ps.setInt(1, studentId);
      ps.setDate(2, new java.sql.Date(date.getTime()));
      ps.setString(3, "P");
      ps.executeUpdate();
    }
  }
  public List<Map<String,Object>> getForDate(java.util.Date date) throws Exception {
    String sql = "SELECT a.id, s.name, a.status FROM attendance a JOIN students s ON a.student_id=s.id WHERE a.date=?";
    List<Map<String,Object>> res = new ArrayList<>();
    try (Connection c = DBConnection.getConnection();
         PreparedStatement ps = c.prepareStatement(sql)) {
      ps.setDate(1, new java.sql.Date(date.getTime()));
      try (ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
          Map<String,Object> row = new HashMap<>();
          row.put("id", rs.getInt("id"));
          row.put("name", rs.getString("name"));
          row.put("status", rs.getString("status"));
          res.add(row);
        }
      }
    }
    return res;
  }
}
