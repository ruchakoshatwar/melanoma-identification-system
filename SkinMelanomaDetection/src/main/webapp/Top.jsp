<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
 
<html>
<head>
<title> </title>
<meta charset="UTF-8">
     <meta http-equiv="X-UA-Compatible" content="IE=Edge">
     <meta name="description" content="">
     <meta name="keywords" content="">
     <meta name="author" content="Tooplate">
     <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

     <link rel="stylesheet" href="css/bootstrap.min.css">
     <link rel="stylesheet" href="css/font-awesome.min.css">
     <link rel="stylesheet" href="css/animate.css">
     <link rel="stylesheet" href="css/owl.carousel.css">
     <link rel="stylesheet" href="css/owl.theme.default.min.css">

     <!-- MAIN CSS -->
     <link rel="stylesheet" href="css/tooplate-style.css">

</head>
<body id="top" data-spy="scroll" data-target=".navbar-collapse" data-offset="50">
<%
try
{  response.setHeader("Pragma", "No-cache");
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setDateHeader("Expires", -1);
if(session.getAttribute("userid")==null)
{
	response.sendRedirect("home");
}
%>
   
 
     <!-- MENU -->
     <section class="navbar navbar-default navbar-static-top top_header" role="navigation">
          <div class="container-fluid ">

               <div class="navbar-header ">
                    <button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                         <span class="icon icon-bar"></span>
                         <span class="icon icon-bar"></span>
                         <span class="icon icon-bar"></span>
                    </button>

                    <!-- lOGO TEXT HERE -->
                    <a href="home" class="navbar-brand logoHeading">Skin Melanoma Detection using machine learning</a>
               </div>

               <!-- MENU LINKS -->
               <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                         <li><a href="<%=session.getAttribute("utype").toString()+"Home" %>" class="smoothScroll">Home</a></li>
 
                         <%if(session.getAttribute("utype").toString().trim().equals("admin"))
                                	{
                                	%>
						<!-- <li class="smoothScroll" id="moble_nav_item_2"> <a href="ExpertReg" class="menu__link">Expert Registration </a> </li>
						 <li class="smoothScroll" ><a href="viewExperts">View Experts</a></li>
							 -->		 
									<li  ><a href="RegImgDataset.jsp" class="smoothScroll">Upload Dataset Images</a></li>
									<li  ><a href="RegImgDataset2.jsp" class="smoothScroll">Upload Melanoma Dataset Images</a></li>
										<li  ><a href="RegDiseaseTests.jsp" class="smoothScroll">Pathology Tests</a></li>
								<li  ><a class="smoothScroll" href="http://localhost:80/SkinMelanomaDetectionPython/trainCNN.py">Train Dataset</a></li>
									<li ><a class="smoothScroll" href="http://localhost:80/SkinMelanomaDetectionPython/trainCNN1.py">Train Malanoma Dataset</a></li>
							
							 
						<%}      %>
                            	<li  id="moble_nav_item_2"> <a class="smoothScroll" href="ChangePass" class="menu__link">Change Password</a> </li>		
						<li  id="moble_nav_item_2"> <a class="smoothScroll" href="logout" class="menu__link">Logout</a> </li>		
						
                          </ul>
               </div>

          </div>
     </section>

<div class="banner1"></div>

  
	<div class="services-breadcrumb">
		<div class="container">
			<p class="para">
            Logged in as <%=session.getAttribute("username").toString() %>( <%=session.getAttribute("utype").toString() %>)
            </p>
		</div>
	</div>
<!-- //banner1 -->
<!--start-home-->
  
<!--//header-top-->
 	<div class="top_banner two">
			<div class="container">
			       <div class="sub-hd-inner">
						<h3 class="tittle" style="text-transform: capitalize;"> <%=session.getAttribute("utype").toString() %> <span> Home </span></h3>
					</div>
			</div>
		</div>

 
    <!--// end-smoth-scrolling -->
    <%}catch(Exception ex)
{
    	System.out.println("err="+ex.getMessage());
    	 
}%>
<a href="#" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
 <!-- js -->
<script src="js/jquery-2.2.3.min.js"></script>
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script>
<!-- start-smoth-scrolling -->
			<script src="js/jarallax.js"></script>
	<script src="js/SmoothScroll.min.js"></script>
	<script type="text/javascript">
		/* init Jarallax */
		$('.jarallax').jarallax({
			speed: 0.5,
			imgWidth: 1366,
			imgHeight: 768
		})
	</script>
	
	<script src="js/bootstrap.js"></script>
<!-- //for bootstrap working -->
<!-- here stars scrolling icon -->
	<script type="text/javascript">
		$(document).ready(function() {
			/*
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
			*/
								
			$().UItoTop({ easingType: 'easeOutQuart' });
								
			});
	</script>
</body>

</html>