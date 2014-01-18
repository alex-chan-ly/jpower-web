<%
	String catPK = request.getParameter("cat");
	String seriesPK = request.getParameter("series");

%>
<div class="aboutus111">
    <div class="application-top-banner"><img src="images/application-commercial-banner.jpg" width="800" height="147" /><br />
    </div>	
		<jsp:include page="servlet/generatePF?app=commercial&page=3&lang=eng&cat=<%=catPK%>&series=<%=seriesPK%>" />		
    <br />
  </div>
  <div class="clearfix"></div>