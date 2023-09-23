/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.dao;

import com.entity.Jobseeker;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DELL
 */
public class JobSeekerDaoTest {
    
    public JobSeekerDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of registerJobSeeker method, of class JobSeekerDao.
     */
    
    @Test
    public void testRegisterJobSeeker() throws SQLException {
        System.out.println("RegisterJobSeeker");

        // Create a Jobseeker with the provided values
        Jobseeker jobSeeker = new Jobseeker();
        jobSeeker.setFname("Lokesh");
        jobSeeker.setLname("Kanagaraj");
        jobSeeker.setEmail("Lokesh@gmail.com");
        jobSeeker.setPassword("Lokesh123");
        jobSeeker.setHighestqualification("Msc Marketing Business");
        jobSeeker.setPhoneNumber("021300423071");

        // Create a Connection object
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/appointment-scheduling-jobs.lk?useSSL=false", "root", "Dharuhjan24");

        // Pass the established database connection to the JobSeekerDao constructor
        JobSeekerDao instance = new JobSeekerDao(connection);

        // Attempt to register the JobSeeker
        boolean result = instance.registerJobSeeker(jobSeeker);

        // Check if the registration was successful
        assertTrue(result); // This assertion will pass if 'result' is true (successful registration)

        // Retrieve the registered job seeker by ID (assuming ID 3)
        int registeredJobSeekerId = 1; // Adjust the ID as needed
        Jobseeker registeredJobSeeker = instance.getJobseekerById(registeredJobSeekerId);

        // Check if the retrieved details match the expected values
        assertEquals("Lokesh", registeredJobSeeker.getFname());
        assertEquals("Kanagaraj", registeredJobSeeker.getLname());
        assertEquals("Lokesh@gmail.com", registeredJobSeeker.getEmail());
        assertEquals("Lokesh123", registeredJobSeeker.getPassword());
        assertEquals("Msc Marketing Business", registeredJobSeeker.getHighestqualification());
        assertEquals("021300423071", registeredJobSeeker.getPhoneNumber());
    }
    
      @Test
    public void testLogin() throws Exception {
        System.out.println("Jobseeker login");

        int jobseekerId = 16;
        String expectedEmail = "Lokesh@gmail.com";
        String expectedPassword = "Lokesh123";

        // Create a Connection object
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/appointment-scheduling-jobs.lk?useSSL=false", "root", "Dharuhjan24");

        // Pass the Connection object to the JobSeekerDao constructor
        JobSeekerDao instance = new JobSeekerDao(connection);

        // Get the jobseeker's email and password by ID from the database
        Jobseeker jobseeker = instance.getJobseekerById(jobseekerId);

        // Check if the jobseeker is not null, indicating that the ID exists
        assertNotNull(jobseeker);

        // Retrieve the email and password from the jobseeker object
        String email = jobseeker.getEmail();
        String password = jobseeker.getPassword();

        // Perform the login with the retrieved email and password
        Jobseeker result = instance.login(email, password);

        // Check if the result is not null, indicating a successful login
        assertNotNull(result);

        // Check if the retrieved email and password match the expected values
        assertEquals(expectedEmail, email);
        assertEquals(expectedPassword, password);
    }

   
}
