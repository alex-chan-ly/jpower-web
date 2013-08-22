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

<script type="text/javascript" charset="utf-8" src="js/menu.js">

</script>
<script type="text/javascript">
  var imageURLs = [
       "images/index-pic-06.jpg"
     , "images/index-pic-07.jpg"
     , "images/index-pic-08.jpg"
     , "images/index-pic-09.jpg"
     , "images/index-pic-10.jpg"
  ];
  function getImageTag() {
    var img = '<img src=\"';
    var randomIndex = Math.floor(Math.random() * imageURLs.length);
    img += imageURLs[randomIndex];
    img += '\" width=\"800\" alt=\"Some alt text\"/>';
    return img;
  }
</script>
</head>
<%
	String item = request.getParameter("page");
%>
<body onload="MM_preloadImages('images/lang-07-over_01.jpg','images/lang-07-over_03.jpg','images/menu-2_01.png','images/menu-2_02.png','images/menu-2_03.png','images/menu-2_04.png','images/menu-2_05.jpg','images/menu-2_06.png')">
 <div id="main_container">

  <div id="header">
  
  	<div class="logo"><a href="index.jsp"><img src="images/jpower-logo.jpg" width="164" /></a></div>
  	<div class="langauge">
  	  <div class="lang-inside"><a href="index.jsp"><img src="images/lang-07_01.jpg" height="25" id="Image7" onmouseover="MM_swapImage('Image7','','images/lang-07-over_01.jpg',1)" onmouseout="MM_swapImgRestore()" /></a></div>
  	  <div class="lang-inside"><img src="images/lang-07_02.jpg" alt="" height="25" /></div>
  	  <div class="lang-inside"><a href="chi-ver/index.html"><img src="images/lang-07_03.jpg" alt="" height="25" id="Image8" onmouseover="MM_swapImage('Image8','','images/lang-07-over_03.jpg',1)" onmouseout="MM_swapImgRestore()" /></a></div>
    </div>
  	<div class="menu">
  	  <div class="menutab"><a href="index.jsp"><img src="images/menu-1_01.png" height="20" id="Image1" onmouseover="MM_swapImage('Image1','','images/menu-2_01.png',1)" onmouseout="MM_swapImgRestore()" /></a></div>
  	  <div class="menutab2"><a href="whatnew.html"><img src="images/menu-1_02.png" height="20" id="Image2" onmouseover="MM_swapImage('Image2','','images/menu-2_02.png',1)" onmouseout="MM_swapImgRestore()" /></a></div>
  	  <div class="menutab3"><style type="text/css">
</style>

<script type="text/javascript" src="js/jquery.js"> 
</script>

<script type="text/javascript"src="js/menu.js">
</script>

<input type=hidden name=arav value="1*#*#*2"><ul id='nav'>
<li> <a href='#'><img src="images/menu-1_03.png" height="20" id="Image3" onmouseover="MM_swapImage('Image3','','images/menu-2_03.png',1)" onmouseout="MM_swapImgRestore()" /></a>
<ul>
<li style='background-color:#ffffff;'><a href=collection.html>Collection</a></li>
<li style='background-color:#ffffff;'><a href=project.html>Projects</a></li>
</ul>
</li>
</ul>

</div>
  	  <div class="menutab4"><style type="text/css">

</style>

<script type="text/javascript" src="js/jquery.js"> 
</script>

<script type="text/javascript" src="js/menu.js">

</script>

<input type=hidden name=arav value="1*#*#*2"><ul id='nav2'>
<li> <a href='#'><img src="images/menu-1_04.png" height="20" id="Image4" onmouseover="MM_swapImage('Image4','','images/menu-2_04.png',1)" onmouseout="MM_swapImgRestore()" /></a>
<ul>
<li style='background-color:#ffffff;'><a href=collection2.html>Collection</a></li>
<li style='background-color:#ffffff;'><a href=application.html>Application</a></li>
</ul>
</li>
</ul></div>
  	  <div class="menutab5"><style type="text/css">

</style>

<script type="text/javascript" src="js/jquery.js"> 
</script>

<script type="text/javascript" src="js/menu.js">
</script>

<input type=hidden name=arav value="1*#*#*2"><ul id='nav3'>
<li> <a href='#'><img src="images/menu-1_05.jpg" height="20" id="Image5" onmouseover="MM_swapImage('Image5','','images/menu-2_05.jpg',1)" onmouseout="MM_swapImgRestore()" /></a>
<ul>
<li style='background-color:#ffffff;'><a href=aboutus.html>Who we are</a></li>
<li style='background-color:#ffffff;'><a href=team.html>What we do</a></li>
<li style='background-color:#ffffff;'><a href=service.html>Our Service</a></li>
<li style='background-color:#ffffff;'><a href=faq.html>FAQ</a></li>
</ul>
</li>
</ul></div>
  	  <div class="menutab6"><a href="contact.html"><img src="images/menu-1_06.png" height="20" id="Image6" onmouseover="MM_swapImage('Image6','','images/menu-2_06.png',1)" onmouseout="MM_swapImgRestore()" /></a></div>
    </div>
  </div>
  <p><!-- End of Header--></p>
  <!--  Main Content Here -->
  <%
  	if(item == null) {
  %>
  		<div class="mainpicture222">  
   			<script type="text/javascript">
  	 			document.write(getImageTag());
   			</script>
  		</div>
  <%
  	}
  %>
  <!-- ******************* -->
  <div class="subword"><img src="images/word-222-04.png" width="447" /></div>

  <div id="carousel" class="es-carousel-wrapper">
    <!-- End Elastislide Carousel -->
    Copyright  Â© 2013 JIB Ltd. All Right Reserved.</div>
<div class="clear"></div> 
  
   
</div>
<blockquote>	</blockquote>
</body>
</html>
