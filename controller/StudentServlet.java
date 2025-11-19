        package com.smartattendance.controller;
        import jakarta.servlet.*;
import jakarta.servlet.http.*;
        import java.io.IOException;
        import com.smartattendance.dao.StudentDAO;
        import com.smartattendance.dto.Student;
        import java.util.*;
        public class StudentServlet extends HttpServlet {
          protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            try {
              StudentDAO dao = new StudentDAO();
              req.setAttribute("students", dao.listAll());
              req.getRequestDispatcher("/views/students.jsp").forward(req, resp);
            } catch (Exception e) {
              throw new ServletException(e);
            }
          }
          protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            try {
              String name = req.getParameter("name");
              String dept = req.getParameter("department");
              Student s = new Student();
              s.setName(name);
              s.setDepartment(dept);
              StudentDAO dao = new StudentDAO();
              dao.add(s);
              resp.sendRedirect(req.getContextPath() + "/students");
            } catch (Exception e) {
              throw new ServletException(e);
            }
          }
        }
