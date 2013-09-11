<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<title>J POWER</title>
<link rel="stylesheet" type="text/css" media="all" href="css/style_eng.css" />
<link rel="SHORTCUT ICON" href="images/favicon.ico" />

<script type="text/javascript" charset="utf-8" src="js/menu.js">

</script>
<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-43719367-1', 'jpower.com.hk');
  ga('send', 'pageview');

</script>
</head>
<%
	String eng_link, chn_link;
	String item = request.getParameter("page");
	if(item == null) {
		eng_link = "index.jsp";
		chn_link = "zh_hk/index.jsp";
	} else {
		eng_link = "index.jsp?page=" + item;
		chn_link = "zh_hk/index.jsp?page=" + item;
	}
%>
<body onload="MM_preloadImages('images/lang-07-over_01.jpg','images/lang-07-over_03.jpg','images/menu-2_01.png','images/menu-2_02.png','images/menu-2_03.png','images/menu-2_04.png','images/menu-2_05.jpg','images/menu-2_06.png')">


 <div id="main_container">

  <div id="header">
  
  	<div class="logo"><a href="."><img src="images/jpower-logo.jpg" width="164" /></a></div>
  	<div class="langauge">
  	 	
  	  <div class="lang-inside"><a href="<%=eng_link%>"><img src="images/lang-07_01.jpg" height="25" id="Image7" onmouseover="MM_swapImage('Image7','','images/lang-07-over_01.jpg',1)" onmouseout="MM_swapImgRestore()" /></a></div>  	 
  	  <div class="lang-inside"><img src="images/lang-07_02.jpg" alt="" height="25" /></div>
  	  <div class="lang-inside"><a href="<%=chn_link%>"><img src="images/lang-07_03.jpg" alt="" height="25" id="Image8" onmouseover="MM_swapImage('Image8','','images/lang-07-over_03.jpg',1)" onmouseout="MM_swapImgRestore()" /></a></div>
  	  
    </div>
  	<div class="menu">
  	  <div class="menutab"><a href="."><img src="images/menu-1_01.png" height="20" id="Image1" onmouseover="MM_swapImage('Image1','','images/menu-2_01.png',1)" onmouseout="MM_swapImgRestore()" /></a></div>
  	  <div class="menutab2"><a href="index.jsp?page=comingsoon"><img src="images/menu-1_02.png" height="20" id="Image2" onmouseover="MM_swapImage('Image2','','images/menu-2_02.png',1)" onmouseout="MM_swapImgRestore()" /></a></div>
  	  <div class="menutab3"><style type="text/css">
</style>

<script type="text/javascript" src="js/jquery.js"> 
</script>

<script type="text/javascript">
$(document).ready(function () {	
	$('#nav li').hover(
	function () {
	//show its submenu
	$('ul', this).slideDown(350);
	}, 
	function () {
	//hide its submenu
	$('ul', this).slideUp(350);	
	}
	);
	});
</script>

<input type=hidden name=arav value="1*#*#*2"><ul id='nav'>
<li> <a href="index.jsp?page=comingsoon"><img src="images/menu-1_03.png" height="20" id="Image3" onmouseover="MM_swapImage('Image3','','images/menu-2_03.png',1)" onmouseout="MM_swapImgRestore()" /></a>
<ul>
<li style='background-color:#ffffff;'><a href="index.jsp?page=comingsoon">Collection</a></li>
<li style='background-color:#ffffff;'><a href="index.jsp?page=comingsoon">Projects</a></li>
</ul>
</li>
</ul>

</div>
  	  <div class="menutab4"><style type="text/css">

</style>

<script type="text/javascript" src="js/jquery.js"> 
</script>

<script type="text/javascript">
$(document).ready(function () {	
	$('#nav2 li').hover(
	function () {
	//show its submenu
	$('ul', this).slideDown(350);
	}, 
	function () {
	//hide its submenu
	$('ul', this).slideUp(350);	
	}
	);
	});

</script>

<input type=hidden name=arav value="1*#*#*2"><ul id='nav2'>
<li> <a href="index.jsp?page=comingsoon"><img src="images/menu-1_04.png" height="20" id="Image4" onmouseover="MM_swapImage('Image4','','images/menu-2_04.png',1)" onmouseout="MM_swapImgRestore()" /></a>
<ul>
<li style='background-color:#ffffff;'><a href="index.jsp?page=comingsoon">Collection</a></li>
<li style='background-color:#ffffff;'><a href="index.jsp?page=comingsoon">Application</a></li>
</ul>
</li>
</ul></div>
  	  <div class="menutab5"><style type="text/css">

</style>

<script type="text/javascript" src="js/jquery.js"> 
</script>

<script type="text/javascript">
$(document).ready(function () {	
	$('#nav3 li').hover(
	function () {
	//show its submenu
	$('ul', this).slideDown(350);
	}, 
	function () {
	//hide its submenu
	$('ul', this).slideUp(350);	
	}
	);
	});
</script>

<input type=hidden name=arav value="1*#*#*2"><ul id='nav3'>
<li> <a href="index.jsp?page=aboutus"><img src="images/menu-1_05.jpg" height="20" id="Image5" onmouseover="MM_swapImage('Image5','','images/menu-2_05.jpg',1)" onmouseout="MM_swapImgRestore()" /></a>
<ul>
<li style='background-color:#ffffff;'><a href="index.jsp?page=aboutus">Who we are</a></li>
<li style='background-color:#ffffff;'><a href="index.jsp?page=team">What we do</a></li>
<li style='background-color:#ffffff;'><a href="index.jsp?page=enquiry">Our Service</a></li>
<li style='background-color:#ffffff;'><a href="index.jsp?page=faq">FAQ</a></li>
</ul>
</li>
</ul></div>
  	  <div class="menutab6"><a href="index.jsp?page=contactus"><img src="images/menu-1_06.png" height="20" id="Image6" onmouseover="MM_swapImage('Image6','','images/menu-2_06.png',1)" onmouseout="MM_swapImgRestore()" /></a></div>
    </div>
  </div>
  <p><!-- End of Header--></p>
  <!--  Main Content Here -->
  <%
  	if(item == null) {
  %>
 		<%@ include file="home.html" %>
  <%
  	} else {
  		String pageName = item + ".html";
  		pageContext.include(pageName);
  	}
  %>
  
  <!-- ******************* -->

  <div id="carousel" class="es-carousel-wrapper">
    <!-- End Elastislide Carousel -->
    Copyright  © 2013 JIB Ltd. All Right Reserved.</div>
<div class="clear"></div> 
  
   
</div>
<blockquote>	</blockquote>
</body>
</html>
