package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Jobseeker;

public class JobSeekerDao {

    private Connection conn;

    public JobSeekerDao(Connection conn) {
        super();
        this.conn = conn;
    }

    public boolean registerJobSeeker(Jobseeker jobSeeker) {
        boolean success = false;

        try {
            String sql = "INSERT INTO jobseeker_dtls (fname, lname, email, password, highestqualification, phonenumber) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, jobSeeker.getFname());
            ps.setString(2, jobSeeker.getLname());
            ps.setString(3, jobSeeker.getEmail());
            ps.setString(4, jobSeeker.getPassword());
            ps.setString(5, jobSeeker.getHighestqualification());
            ps.setString(6, jobSeeker.getPhoneNumber());

            int rowsInserted = ps.executeUpdate();
            success = rowsInserted > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return success;
    }

    public Jobseeker login(String em, String psw) {
        Jobseeker u = null;

        try {
            String sql = "SELECT * FROM jobseeker_dtls WHERE email=? AND password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, em);
            ps.setString(2, psw);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                u = new Jobseeker();
                u.setId(rs.getInt(1));
                u.setFname(rs.getString(2));
                u.setLname(rs.getString(3));
                u.setEmail(rs.getString(4));
                u.setPassword(rs.getString(5));
                u.setHighestqualification(rs.getString(6));
                u.setPhoneNumber(rs.getString(7));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return u;
    }

    public List<Jobseeker> getAllJobseekers() {
        List<Jobseeker> list = new ArrayList<>();
        try {
            String sql = "select * from jobseeker_dtls order by id desc";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Jobseeker d = new Jobseeker();
                d.setId(rs.getInt(1));
                d.setFname(rs.getString(2));
                d.setLname(rs.getString(3));
                d.setEmail(rs.getString(4));
                d.setPassword(rs.getString(5));
                d.setHighestqualification(rs.getString(6));
                d.setPhoneNumber(rs.getString(7));
                list.add(d);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Jobseeker getJobseekerById(int id) {
        Jobseeker d = null;
        try {
            String sql = "select * from jobseeker_dtls where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                d = new Jobseeker();
                d.setId(rs.getInt(1));
                d.setFname(rs.getString(2));
                d.setLname(rs.getString(3));
                d.setEmail(rs.getString(4));
                d.setPassword(rs.getString(5));
                d.setHighestqualification(rs.getString(6));
                d.setPhoneNumber(rs.getString(7));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }

    public boolean updateJobseeker(Jobseeker jobseeker) {
        boolean f = false;

        try {
            String sql = "update jobseeker_dtls set fname=?,lname=?,email=?,password=?,highestqualification=?, phone=? where id=?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, jobseeker.getFname());
                ps.setString(2, jobseeker.getLname());
                ps.setString(3, jobseeker.getEmail());
                ps.setString(4, jobseeker.getPassword());
                ps.setString(5, jobseeker.getHighestqualification());
                ps.setString(6, jobseeker.getPhoneNumber());
                ps.setInt(7, jobseeker.getId());

                int i = ps.executeUpdate();

                if (i == 1) {
                    f = true;
                }
            }
        } catch (SQLException e) {
            // Handle the exception gracefully, either by throwing a custom exception or logging the error.
            e.printStackTrace();
        }

        return f;
    }

    public boolean deleteJobseekerById(int id) {
        boolean f = false;

        try {
            String sql = "DELETE FROM jobseeker_dtls WHERE id=?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, id);

                int i = ps.executeUpdate();

                if (i == 1) {
                    f = true; // Set to true if one row is affected, indicating successful deletion
                }
            }
        } catch (SQLException e) {
            // Handle the exception gracefully, either by throwing a custom 
            // exception or logging the error.
            e.printStackTrace();
        }

        return f;
    }

}
