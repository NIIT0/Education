     <%@page import="java.sql.ResultSet"%>
<%@page import="DBPack.DBManagement"%>
<%
    //dont change this
    String logout=request.getParameter("logout");
    if(logout!=null){
        session.setAttribute("user", null);
        response.sendRedirect("index.jsp");
    }
    ResultSet user=null;
    //dont change this
    
ResultSet teacher=null;
ResultSet student=null;


%>
<!DOCTYPE html>
       <html lang="en">
       <head>
       <title>website ft page</title>
       <meta charset="utf-8">
       <meta name="viewport" content="width=device-width, initial-scale=1">
       <link rel="stylesheet" href="bootstrap.min.css">
       <script src="jquery.min.js"></script>
       <script src="popper.min.js"></script>
       <script src="bootstrap.min.js"></script>



    <!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Counters -->
	<script src="js/jquery.countTo.js"></script>
	<!-- Flexslider -->
	<script src="js/jquery.flexslider-min.js"></script>

	<!-- Main JS (Do not remove) -->
	<script src="js/main.js"></script>


<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>




    <script src="flexslider.css.js" rel="stylesheet" media="screen" />	
    <script src="cubeportfolio.min.css.js" rel="stylesheet" />
    <script src="style.css.js" rel="stylesheet" />


        <script src="bootstrap-theme.min.css.js" rel="stylesheet"></script>
        <script src="owl.carousel.css.js" rel="stylesheet"></script>
        <script src="owl.theme.default.min.css.js" rel="stylesheet"></script>
        <script src="magnific-popup.css.js" rel="stylesheet"></script>

        <script src="animate.js" rel="stylesheet"></script>
        <script src="bootstrap.js" rel="stylesheet"></script>
        <script src="classie.js" rel="stylesheet"></script>
        <script src="custom.js" rel="stylesheet"></script>
		
		<script src="flexslider.config.js" rel="stylesheet"></script>
        <script src="jquery.appear.js" rel="stylesheet"></script>
        <script src="jquery.backtotop.js" rel="stylesheet"></script>
        <script src="jquery.cookie.js" rel="stylesheet"></script>

		<script src="jquery.countdown.min.js" rel="stylesheet"></script>
        <script src="jquery.countTo.js" rel="stylesheet"></script>
        <script src="jquery.easing.1.3.js" rel="stylesheet"></script>
        <script src="jquery.easing" rel="stylesheet"></script>

		<script src="jquery.flexslidermin.js" rel="stylesheet"></script>
        <script src="jquery.js" rel="stylesheet"></script>
        <script src="main.js" rel="stylesheet"></script>
        <script src="script.js" rel="stylesheet"></script>

		<script src="revslider.js" rel="stylesheet"></script>
        <script src="validate.js" rel="stylesheet"></script>
        <script src="uisearch.js"rel="stylesheet"></script>
        <script src="stellar.js" rel="stylesheet"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <link rel="stylesheet" href="layout/styles/layout.css" type="text/css" />
        <script type="text/javascript" src="layout/scripts/jquery.min.js"></script>
        <script type="text/javascript" src="layout/scripts/jquery.slidepanel.setup.js"></script>
        <script type="text/javascript" src="layout/scripts/jquery.ui.min.js"></script>
        <script type="text/javascript" src="layout/scripts/jquery.tabs.setup.js"></script>


       <style>
h2
      {
       color:orange;
       font-size:55px;
       }

b
       { 
        font-size:20px;
        color:black;
        }
	p
	   {
	   font-size:25px;
	   color:blue;
	   }
h1
        {
         color: black;
         }
 a
        {
          color:black;
        }
h3
        {
		font-size:47px;
		color: black ;
		}



          </style>
          </head>




         <body>





<div class="wrapper col0">

<div id="topbar">

<div id="slidepanel">


 
 <div class="topbox">
     
<% 
    
    
    user=(ResultSet)session.getAttribute("user");
    if(user!=null){%>
    Full Name:<%out.println(user.getString(1));%>
    <a href="index.jsp?logout">Logout</a>
    <%}
else{
%>     
<h2>Teachers Login Here</h2>
<form action="#" method="post">


<fieldset>
<legend>Teachers Login Form</legend>
<label for="teachername">Username:
<input type="text" name="teachername" id="teachername" value="" />
</label>


<label for="teacherpass">Password:
<input type="password" name="teacherpass" id="teacherpass" value="" />
</label>


<label for="teacherremember">
<input class="checkbox" type="checkbox" name="teacherremember" id="teacherremember" checked="checked" />
  Remember me</label>
<p>



<input type="submit" name="teacherlogin" id="teacherlogin" value="Login" />
&nbsp;
<input type="reset" name="teacherreset" id="teacherreset" value="Reset" />
</p>
</fieldset>


</form>

<%
    if(request.getParameter("teacherlogin")!=null){
        String username=request.getParameter("teachername");
        String password=request.getParameter("teacherpass");
        teacher=DBManagement.executeQuery("SELECT * FROM  universities_info WHERE username =  '"+username+"' AND PASSWORD =  '"+password+"'LIMIT 1");
    
        teacher.first();
        if(teacher.getRow()>0){
            session.setAttribute("user", teacher);
            response.sendRedirect("index.jsp");
        }
    }
%>

</div>


<div class="topbox">
<h2>Student Login Here</h2>


<form action="#" method="post">
<fieldset>


<legend>Student Login Form</legend>
<label for="pupilname">Username:
<input type="text" name="pupilname" id="pupilname" value="" />
</label>


<label for="pupilpass">Password:
<input type="password" name="pupilpass" id="pupilpass" value="" />
</label>


<label for="pupilremember">
<input class="checkbox" type="checkbox" name="pupilremember" id="pupilremember" checked="checked" />
  Remember me</label>


<p>
<input type="submit" name="pupillogin" id="pupillogin" value="Login" />
  &nbsp;

<input type="reset" name="pupilreset" id="pupilreset" value="Reset" />
</p>


</fieldset>
</form>
<%
    if(request.getParameter("pupillogin")!=null){
        String username=request.getParameter("pupilname");
        String password=request.getParameter("pupilpass");
        student=DBManagement.executeQuery("SELECT * FROM  student_info WHERE username =  '"+username+"' AND PASSWORD =  '"+password+"'LIMIT 1");
    
        student.first();
        if(student.getRow()>0){
            session.setAttribute("user", student);
            response.sendRedirect("index.jsp");
        }
    }
%>

</div>

<div class="topbox last">
<h2>Parents Login Here</h2>


<form action="#" method="post">
<fieldset>


<legend>Parents Login Form</legend>
<label for="pupilname">Username:
<input type="text" name="pupilname" id="pupilname" value="" />
</label>


<label for="pupilpass">Password:
<input type="password" name="pupilpass" id="pupilpass" value="" />
</label>


<label for="pupilremember">
<input class="checkbox" type="checkbox" name="pupilremember" id="pupilremember" checked="checked" />
  Remember me</label>


<p>
<input type="submit" name="pupillogin" id="pupillogin" value="Login" />
  &nbsp;

<input type="reset" name="pupilreset" id="pupilreset" value="Reset" />
</p>


</fieldset>
</form>


</div>

<br class="clear" />
</div>

<div id="loginpanel">


<ul>
<li class="left">Log In Here &raquo;</li>
<li class="right" id="toggle"><a id="slideit" href="#slidepanel">LOG INN</a><a id="closeit" style="display: none;" href="#slidepanel">Close Panel</a></li>
</ul>

</div>

<% }%>
<br class="clear" />


</div>
</div>








 <nav class="navbar navbar-expand-sm bg-secondary navbar-dark sticky-top">
  <a class="navbar-brand" href="#">
    <img src="bird.jpg" alt="logo" style="width:40px;">
	</a>
  
  
  
  
  
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  
   
   
   
   <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="index.jsp"><em><b><a href="index.jsp">Home</a></b></em></a>
    </li>
	
	 
	 
	 
	 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    
	
	
	<li class="nav-item">
      <a class="nav-link" href="#"><em><b><a href="">Plans</a></b></em></a>

    </li>



	 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    
	
	
	
	<li class="nav-item">
      <a class="nav-link" href="courses.jsp"><em><b><a href="courses.jsp">Courses</a></b></em></a>
    </li>
	
	 
	 
	 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	
	
	
	<li class="nav-item">
      <a class="nav-link" href="aboutus.jsp"><em><b><a href="aboutus.jsp">AboutUs</a></b></em></a>
    </li>
	
	 
	 
	 
	 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	
	
	
	<li class="nav-item">
      <a class="nav-link" href="school.jsp"><em><b><a href="schools.jsp">Schools</a></b></em></a>
    </li>
	
	 
	 
	 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	
	
	
	
	<li class="nav-item">
      <a class="nav-link" href="feedback.jsp"><em><b><a href="feedback.jsp">FeedBack</a></b></em></a>
    </li>
	
	 
	 
	 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	 
	 
	 
	 
	 <form class="form-inline" action="/action_page.php">
    <input class="form-control mr-sm-2" type="text" placeholder="Search">
    <button class="btn btn-success" type="submit">Search</button>
  
    </form>
    </ul>



    </nav>











    <div class="card img-fluid" style="width:1550px" >
    <img class="card-img-top" src="images/...jpg" alt="Card image" style="width:100% ; height:900px">
    <div class="card-img-overlay">

	
    
  <br>	
	
	<b><center><h2><em>Welcome To Your Passion World</em></h2></center></b>
    
	
	<br>

   <center><p>Education is the most powerful weapon , We can use to change the World .</p></center>


   <br><br>

 <center><h3>APPLY AN ACCOUNT</h3></center>
	
	  <br>
	  
	  <center><a href="register.jsp"><button type="button" class="btn btn-primary" ><b> REGISTER__NOW</b></button></a></center>
	 


<br><br><br>

   <center><h3>Logg Inn</h3></center>

<div class="container">

   <div class="form-group">
      <label for="email"><b>Mobile No:</b></label>
      <input type="email" class="form-control" id="email" placeholder="Mobile number" name="email">
    </div>
	
  <div class="form-group">
      <label for="pwd"><b>Password:</b></label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pswd">
    </div>
    <div class="form-group form-check">
      <label class="form-check-label">
        <input class="form-check-input" type="checkbox" name="remember"><b><center> Remember me</center></b>
      </label>
    </div>


<br>
	<div class="text-right">
    <p><a href="forget.jsp">forget password ? </a></p>

   <center><a href="formsubmit.jsp"> <button type="submit" class="btn btn-primary"><b>Submit</b></button></center></a>
  </form>

</div>
<br>





</div>



 



   </div>
	   
  </div>

  </div>
  


  <div class="jumbotron">
   <div class="container">
  
  
  <br>
  <br>




  <center><b><h1><em>Begin Your Aventure By browsing Our Exploration</h1></b></em></center>





<br><br><br>





<div class="card-deck">

 


<div class="card" style="width:300px">

 
 
 <img class="rounded-circle"src="images/09.jpg" style="width:100% ; height:250px" alt="card image">
 
 <div class="card-body">



  <center><button type="submit" class="btn btn-dark grey"><a href="education.jsp">Click to Explore </a></button></center>

 
 </div>
 </div>
  
 
 
 <div class="card" style="width:300px">
 
 <img class="rounded-circle"src="images/02.jpg" style="width:100% ; height:250px" alt="card image">
 <div class="card-body">
 


<center><a href="#"><button type="submit" class="btn btn-dark grey">Click to Explore </button></a></center>

 
 
 </div>
 </div>
   
 <div class="card" style="width:300px">
 
 <img class="rounded-circle"src="images/01.png" style="width:100% ; height:250px" alt="card image">
 <div class="card-body">
 
  
<center><a href="#"><button type="submit" class="btn btn-dark grey">Click to Explore </button></a></center>

  



 </div>
 </div>
 
 
 
 </div>
<br><BR><Br>




<div class="card-deck">
<div class="card" style="width:300px">
 
 <img class="rounded-circle"src="images/.1.jpg" style="width:100%" alt="card image">
 <div class="card-body">
  <br>
  <center><a href="#"><button type="submit" class="btn btn-dark grey">Click to Explore </button></a></center>
 
 
 </div>
 </div>
  
 <div class="card" style="width:300px">
 
 <img class="rounded-circle"src="images/.2.jpg" style="width:100%" alt="card image">
 <div class="card-body">
<br>
 <center><a href="#"><button type="submit" class="btn btn-dark grey">Click to Explore </button></a></center>
 </div>
 </div>
   
 <div class="card" style="width:300px">

 <img class="rounded-circle"src="images/.3.jpg" style="width:100%" alt="card image">
 <div class="card-body">
<br>
<center><a href="#"><button type="submit" class="btn btn-dark grey">Click to Explore </button></a></center>
  </div>
 </div>


 </div>
<br>





 </div>
<div class="container">

<img src="images/13.png" width="100%" height="600" border="0" alt="">



</div>

<br><br><br><br>


 <section id="team" class="team section">
 
 <div class="container">

 <center><h1 class="title">Our team</h1></center>
 <br><br>
 <div class="row">
 <div class="col-sm-4">
 <div class="ubutia-card">
 <div class="ubutia-card-header">
 <img class="img-responsive" src="assets/images/8.jpg">
 </div>
 <div class="ubutia-card-content">
 <h3>NAME</h3>
 <p>DESCRIPTION </p>
  <div class="social-icons">
  <ul>
  <a href="#"><li><span class="ion-social-facebook"></span></li></a>
  <a href="#"><li><span class="ion-social-twitter"></span></li></a>
  </ul>
  </div>
  </div>
  </div>
  </div>
  
  <div class="col-sm-4">
  <div class="ubutia-card">
  <div class="ubutia-card-header">
  <img class="img-responsive" src="assets/images/9.jpg">
  </div>
  
  <div class="ubutia-card-content">
  <h3>NAME </h3>
  <p>
   DESCRIPTION
  </p>
  <div class="social-icons">
  
  <ul>
  <a href="#"><li><span class="ion-social-facebook"></span></li></a>
  <a href="#"><li><span class="ion-social-twitter"></span></li></a>
  
  </ul>
  </div>
  </div>
  </div>
  </div>
 
  <div class="col-sm-4">
  
  <div class="ubutia-card">
  <div class="ubutia-card-header">
  <img class="img-responsive" src="assets/images/10.jpg">
  </div>
  
  <div class="ubutia-card-content">
  <h3>NAME</h3>
  <p>DESCRIPTION 
        </p>
   <div class="social-icons">
   <ul>
   <a href="#"><li><span class="ion-social-facebook"></span></li></a>
   <a href="#"><li><span class="ion-social-twitter"></span></li></a>
   </ul>
   </div>
   </div>
   </div>
   </div>
   </div>
   </div>
   </section>

   </div>

<div class="card" style="width:100%">
<img class="quote" src="images/5.jpg" style="width:100% ; height : 500px">
<div class="card-img-overlay">

   <br><br>

<div class="container">

<center><b><h2><em>Successful people do what unsuccessful people are not willing to do. Don't wish it were easier; wish you were better.</em></h2></b></center>

<br><br>

<center><b><p class="author">=>Jim Rohn</p></b></center>

 </div>
 </div>
 </div>

<div class="jumbotron">
<footer>
<div class="container">
<div class="row">
<div class="col-sm-3 col-lg-3">
<div class="widget">
<h4>Get in touch with us</h4>
<address>
<strong>Sailor company Inc</strong><br>
 Sailor suite room V124, DB 91<br>
 Someplace 71745 Earth </address>
<p>
<i class="icon-phone"></i> (123) 456-7890 - (123) 555-7891 <br>
<i class="icon-envelope-alt"></i> email@domainname.com
	</p>
	</div>
	</div>
	<div class="col-sm-3 col-lg-3">
	<div class="widget">
	<h4>Information</h4>
	<ul class="link-list">
	<li><a href="#">Press release</a></li>
	<li><a href="#">Terms and conditions</a></li>
	<li><a href="#">Privacy policy</a></li>
	<li><a href="#">Career center</a></li>
	<li><a href="#">Contact us</a></li>
	</ul>
	</div>
	</div>
	
	<div class="col-sm-3 col-lg-3">
	<div class="widget">
	<h4>Pages</h4>
	<ul class="link-list">
	<li><a href="#">Press release</a></li>
	<li><a href="#">Terms and conditions</a></li>
	<li><a href="#">Privacy policy</a></li>
	<li><a href="#">Career center</a></li>
	<li><a href="#">Contact us</a></li>
	</ul>
	</div>
	</div>
	<div class="col-sm-3 col-lg-3">
	<div class="widget">
	<h4>Newsletter</h4>
	<p>Fill your email and sign up for monthly newsletter to keep updated</p>
    <div class="form-group multiple-form-group input-group">
    <input type="email" name="email" class="form-control">
    <span class="input-group-btn">
    <button type="button" class="btn btn-theme btn-add">Subscribe</button>
    </span>
    </div>
	</div>
	</div>
	</div>
	</div>
	<div id="sub-footer">
	<div class="container">
	<div class="row">
	<div class="col-lg-6">
	<div class="copyright">
	<p>
            <span>&copy; Sailor 2015 All right reserved. | <a href="http://bootstraptaste.com/">Bootstrap Themes</a> by BootstrapTaste</span>
    <!-- 
                                All links in the footer should remain intact. 
                                Licenseing information is available at: http://bootstraptaste.com/license/
                                You can buy this theme without footer links online at: http://bootstraptaste.com/buy/?theme=Sailor
                            -->
						
		</p>
		</div>
		</div>
		<div class="col-lg-6">
		<ul class="social-network">
		<li><a href="#" data-placement="top" title="Facebook"><i class="fa fa-facebook"></i></a></li>
		<li><a href="#" data-placement="top" title="Twitter"><i class="fa fa-twitter"></i></a></li>
		<li><a href="#" data-placement="top" title="Linkedin"><i class="fa fa-linkedin"></i></a></li>
		<li><a href="#" data-placement="top" title="Pinterest"><i class="fa fa-pinterest"></i></a></li>
		<li><a href="#" data-placement="top" title="Google plus"><i class="fa fa-google-plus"></i></a></li>
		</ul>
		</div>
		</div>
		</div>
	    </div>
	    </footer>

</div>
</div>

<script src="jquery.min.js"></script>
<script src="modernizr.custom.js"></script>
<script src="jquery.easing.1.3.js"></script>
<script src="bootstrap.min.js"></script>
<script src="jquery.flexslider-min.js"></script> 
<script src="flexslider.config.js"></script>
<script src="jquery.appear.js"></script>
<script src="stellar.js"></script>
<script src="classie.js"></script>
<script src="uisearch.js"></script>
<script src="jquery.cubeportfolio.min.js"></script>
<script src="google-code-prettify/prettify.js"></script>
<script src="animate.js"></script>
<script src="custom.js"></script>
     
     </body>
  </html>

