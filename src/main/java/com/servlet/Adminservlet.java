package com.servlet;

import com.dao.AdminDao;
import com.db.dbconnect;
import com.entity.Admin;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Adminservlet")
public class Adminservlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        AdminDao dao = new AdminDao(dbconnect.getConn());
        Admin admin = dao.login(email, password);
        if (admin != null) {
            session.setAttribute("userObj", admin);
            session.setAttribute("successMsg", "Login successful"); // Success message
            resp.sendRedirect("AdminDashBoard.jsp");
        } else {
            session.setAttribute("errorMsg", "Invalid email & password"); // Error message
            resp.sendRedirect("AdminLogin.jsp");
        }
    }
}
