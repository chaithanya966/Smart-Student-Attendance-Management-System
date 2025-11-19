        package com.smartattendance.controller;
        import jakarta.servlet.*;
import jakarta.servlet.http.*;
        import java.io.IOException;
        import com.smartattendance.dao.AttendanceDAO;
        import java.text.SimpleDateFormat;
        import java.util.Date;
        import java.util.*;
        public class AttendanceServlet extends HttpServlet {
          protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            try {
              String dateStr = req.getParameter("date");
              Date date = dateStr==null ? new Date() : new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
              AttendanceDAO dao = new AttendanceDAO();
              req.setAttribute("attendanceList", dao.getForDate(date));
              req.getRequestDispatcher("/views/attendance.jsp").forward(req, resp);
            } catch (Exception e) {
              throw new ServletException(e);
            }
          }
          protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            try {
              String sid = req.getParameter("studentId");
              String dateStr = req.getParameter("date");
              Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
              AttendanceDAO dao = new AttendanceDAO();
              dao.markPresent(Integer.parseInt(sid), date);
              resp.sendRedirect(req.getContextPath() + "/attendance?date=" + dateStr);
            } catch (Exception e) {
              throw new ServletException(e);
            }
          }
        }
