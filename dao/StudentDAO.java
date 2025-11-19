package com.smartattendance.dao;
import com.smartattendance.dto.Student;
import com.smartattendance.util.DBConnection;
import java.sql.*;
import java.util.*;
public class StudentDAO {
  public List<Student> listAll() throws Exception {
    List<Student> list = new ArrayList<>();
    String sql = "SELECT id, name, department FROM students ORDER BY id";
    try (Connection c = DBConnection.getConnection();
         PreparedStatement ps = c.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
      while (rs.next()) {
        list.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getString("department")));
      }
    }
    return list;
  }
  public void add(Student s) throws Exception {
    String sql = "INSERT INTO students (name, department) VALUES (?, ?)";
    try (Connection c = DBConnection.getConnection();
         PreparedStatement ps = c.prepareStatement(sql)) {
      ps.setString(1, s.getName());
      ps.setString(2, s.getDepartment());
      ps.executeUpdate();
    }
  }
}
