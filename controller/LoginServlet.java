        package com.smartattendance.controller;
        import jakarta.servlet.*;
import jakarta.servlet.http.*;
        import java.io.IOException;
        public class LoginServlet extends HttpServlet {
          protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String user = req.getParameter("username");
            String pass = req.getParameter("password");
            if ("admin".equals(user) && "admin123".equals(pass)) {
              HttpSession session = req.getSession(true);
              session.setAttribute("user", "admin");
              resp.sendRedirect(req.getContextPath() + "/students");
            } else {
              req.setAttribute("error", "Invalid credentials");
              req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
          }
          protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.sendRedirect("login.jsp");
          }
        }
