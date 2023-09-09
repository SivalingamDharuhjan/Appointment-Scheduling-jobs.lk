package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.JobSeekerDao;
import com.db.dbconnect;
import com.entity.Jobseeker;

@WebServlet("/UpdateJobseekerServlet")
public class UpdateJobseekerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            JobSeekerDao dao = new JobSeekerDao(dbconnect.getConn());
            Jobseeker jobseeker = dao.getJobseekerById(id);

            String fname = req.getParameter("fname");
            String lname = req.getParameter("lname");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            String highestQualification = req.getParameter("highestQualification");
            String phoneNumber = req.getParameter("phoneNumber");

            if (fname != null && !fname.isEmpty()) {
                jobseeker.setFname(fname);
            }
            if (lname != null && !lname.isEmpty()) {
                jobseeker.setLname(lname);
            }
            if (email != null && !email.isEmpty()) {
                jobseeker.setEmail(email);
            }
            if (password != null && !password.isEmpty()) {
                jobseeker.setPassword(password);
            }
            if (highestQualification != null && !highestQualification.isEmpty()) {
                jobseeker.setHighestqualification(highestQualification);
            }
            if (phoneNumber != null && !phoneNumber.isEmpty()) {
                jobseeker.setPhoneNumber(phoneNumber);
            }

            boolean isUpdated = dao.updateJobseeker(jobseeker);

            if (isUpdated) {
                session.setAttribute("succMsg", "Jobseeker Updated successfully");
                resp.sendRedirect("AdminDashboard.jsp");
            } else {
                session.setAttribute("errorMsg", "Something went wrong on the server");
                resp.sendRedirect("EditJobseeker.jsp");
            }
        } catch (Exception e) {
            // Print the exception details for debugging
            e.printStackTrace();
            // You can also set an error message for the user or take appropriate action
            session.setAttribute("errorMsg", "An error occurred while updating the Jobseeker");
            resp.sendRedirect("EditJobseeker.jsp");
        }
    }
}
