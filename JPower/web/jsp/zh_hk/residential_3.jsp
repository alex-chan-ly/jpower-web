<%
	String catPK = request.getParameter("cat");
	String seriesPK = request.getParameter("series");

%>
<div class="aboutus111">
    <div class="application-top-banner"><img src="../images/application-residential-topbanner_chn.jpg" width="800" height="147" /><br /></div>   
		<jsp:include page="servlet/generatePF?app=residential&page=3&lang=chn&cat=<%=catPK%>&series=<%=seriesPK%>" />		
</div>
 <div class="clearfix"></div>