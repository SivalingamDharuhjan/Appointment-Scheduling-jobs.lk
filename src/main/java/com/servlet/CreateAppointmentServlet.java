package com.servlet;

import com.dao.AppointmentDao;
import com.db.dbconnect;
import com.entity.Appointment;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CreateAppointmentServlet")
public class CreateAppointmentServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(CreateAppointmentServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int consultant_id = Integer.parseInt(request.getParameter("consultant_id"));
            int jobseeker_id = Integer.parseInt(request.getParameter("jobseeker_id"));
            String appointment_datetime = request.getParameter("appointment_date") + 'T' + request.getParameter("appointment_time");

            // Assuming you have validation logic for consultant_id, jobseeker_id, and datetime

            HttpSession session = request.getSession();
            Appointment c = new Appointment(consultant_id, jobseeker_id, appointment_datetime);
            AppointmentDao dao = new AppointmentDao(dbconnect.getConn());
            boolean f = dao.registerAppointment(c);

            if (f) {
                session.setAttribute("sucMsg", "Appointment created successfully");
                response.sendRedirect("AdminDashboard.jsp");
            } else {
                session.setAttribute("errorMsg", "Failed to create appointment");
                response.sendRedirect("CreateAppointment.jsp");
            }
        } catch (NumberFormatException e) {
            // Handle the case where consultant_id or jobseeker_id couldn't be parsed as integers
            logger.log(Level.SEVERE, "Invalid integer input", e);
            // Optionally, you can redirect the user to an error page
            response.sendRedirect("CreateAppointment.jsp");
        }
    }
}
