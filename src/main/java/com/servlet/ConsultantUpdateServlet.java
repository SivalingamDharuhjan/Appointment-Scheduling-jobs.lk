package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ConsultantDao;
import com.db.dbconnect;
import com.entity.Consultant;

@WebServlet("/ConsultantUpdateServlet")
public class ConsultantUpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            int id = Integer.parseInt(req.getParameter("id"));
            ConsultantDao dao = new ConsultantDao(dbconnect.getConn());
            Consultant consultant = dao.getConsultantById(id);

            String fname = req.getParameter("fname");
            String lname = req.getParameter("lname");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            String specializedCountries = req.getParameter(
                    "SpecializedCountries");
            String phoneNumber = req.getParameter("phoneNumber");

            if (fname != null) {
                consultant.setFname(fname);
            }
            if (lname != null) {
                consultant.setLname(lname);
            }
            if (email != null) {
                consultant.setEmail(email);
            }
            if (password != null) {
                consultant.setPassword(password);
            }
            if (specializedCountries != null) {
                consultant.setSpecializedCountries(
                        specializedCountries);
            }
            if (phoneNumber != null) {
                consultant.setPhoneNumber(phoneNumber);
            }

            HttpSession session = req.getSession();
            try {
                boolean isUpdated = dao.updateConsultant(consultant);

                if (isUpdated) {
                    session.setAttribute("succMsg",
                            "Consultant Updated sucessfully");
                    resp.sendRedirect("ConsultantDashboard.jsp");
                } else {
                    session.setAttribute("errorMsg",
                            "Something wrong on server");
                    resp.sendRedirect("ConsultantEdit.jsp");
                }
            } catch (Exception e) {
                // Print the exception details for debugging
                e.printStackTrace();
                // You can also set an error message for 
                // the user or take appropriate action
                session.setAttribute("errorMsg",
                        "An error occurred while updating the consultant");
                resp.sendRedirect("ConsultantEdit.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
