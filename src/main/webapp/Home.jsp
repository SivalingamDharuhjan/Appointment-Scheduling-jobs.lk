<%-- 
    Document   : Home
    Created on : Aug 22, 2023, 12:39:35 AM
    Author     : DELL
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
    <meta charset="UTF-8"        
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Jobs.lk Consultation Centre</title>
    
    <%@ include file="Header.jsp"%>
    
    <style>
        
    .Back{
   margin: auto;
}

  .image {
    max-width: 100%;
    height: auto;
  }
  .text-overlay {
    position: absolute;
    left: 10%;
    bottom: 25%;
    transform: translateY(-70%);
    padding: 40px;
    font-size: 200px;
    font-family: Palatino, URW Palladio L, serif;
    font-style: normal;
    color: white;
    opacity: 0.1;
    
  }

  .containers {
    text-align: center;
    padding: 20px;
    font-size: 44px;
    font-family: Didot, serif;
    font-style: normal;
    color:whitesmoke;
    border-radius: 5px;
    vertical-align: top;
    font-weight: bolder;
    position: absolute;
    left: 35%;
    bottom: 46%;
    transform: translateY(-50%);
   
  }

  .overlay-image {
   position: relative;
   transform: translateY(-64.2%);
   left: 55%;
  }  

*{
  box-sizing: border-box;
}
.article{
  width:900px;
  margin:30px;
  padding:12px;
  background:#efefef;
  border-radius:5px;
  position: relative;
  transform: translateY(-109.2%);
  left: 25%;
  
}
.image{
  background:silver;
  width:500px;
  height:400px;
  border-radius:5px;
  padding:20px;
  color:#efefef;
  font-size:8rem;
  &.right{
    float:right;
    margin-left:20px;
  }
  &.left{
    float:left;
    margin-right:30px;
  }
}
.content{
  padding: 0 20px;
  color:#071b33;
  .headline{
  color:#0e58b0;
  }
}

.group{
  &:before,
  &:after {
    content: "";
    display: table;
  } 
  &:after {
    clear: both;
  }
}  
   ul {
  background: #3399ff;
  padding: 20px;
}


ul li {
  background: #cce5ff;
  color: darkblue;
  margin: 5px;
}     
        
    </style>
    
    
    
    </head>
    
    <body>
        
    <div class="Back">
 <img src="https://images.unsplash.com/photo-1588421357574-87938a86fa28?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxleHBsb3JlLWZlZWR8Mnx8fGVufDB8fHx8fA%3D%3D&w=1000&q=80" alt="img" height="400" width="1530" > 
 
 
 <div class="text-overlay">
   JOBS.LK

 </div>
 
 <div class="containers">
   The best Consultants-centric<br>
    Ecosystem in Sri Lanka
 </div>

 </div>  <div class="overlay-image"><img src="https://i.ibb.co/K6MhYzj/Ad-6.png"  alt="img-1" border="0" style="width: 700px; height: 600px;"> </div>

</div>
</div>  

<article class="article group">
   <section class="content">
    <h2 class="headline">Welcome to Jobs.lk Consultation Centre</h2>
    <p>The Jobs.lk Consultation Centre in Colombo provides free consultation services to job seekers planning to go abroad for jobs.</p>
        Our consultants are specialized in various countries and job types. We offer part-time consultation services to help </p> you make informed decisions.
    <h2>About Us</h2>
            <p>We provide different types of appointment services to cater to your needs:</p>
            <ul>
                <li><strong>Direct Appointments:</strong> If you are ready to apply for a specific job, you can directly book an appointment.</li>
            </ul>
            <p>For direct appointment inquiries, you can contact us using the following details:</p>
            <ul>
                <li><strong>Telephone:</strong> 01112245326</li>
                <li><strong>Email:</strong> jobs@gmail.lk</li>
                <li><strong>Address:</strong> No 421, Galle Road, Colombo 3, Wellawatte, Sri Lanka</li>
            </ul>
  </section>
</article>



        
    </body>
    
</html>
    
