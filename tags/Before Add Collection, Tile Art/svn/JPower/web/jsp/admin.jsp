<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<body>
<%
	String status = (String)request.getSession().getAttribute("STATUS");
	if( (status != null) && (status.equals("AUTHENTICATED")) ) {

		response.sendRedirect("upload.jsp");
 		
	}
%>
<table width="100%">
	<tr align="center">
		<td style="FONT-SIZE: xx-large; FONT-WEIGHT: bold;">
			JPower Content Upload Authentication.
		</td>
	</tr>
	
	<tr>
		<td><hr/></td>
	</tr>
	<tr align="center">
		<td>
			<form action="servlet/authenticate" method="post">
				Security code : <input type="password" size="10" name="code">
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>
	<tr align="center">
		<td>
			<input type="submit" value="Authenticate">
		</td>
	</tr>	
	<tr>
		<td>&nbsp;</td>
	</tr>		
	<tr align="center">
		<td style="FONT-WEIGHT: bold; color:DeepPink;">
			<% 
				String error = (String)request.getSession().getAttribute("ERROR");
				if(error != null) {
					out.println(error);
				}
				request.getSession().removeAttribute("ERROR");
			%>
		</td>
	</tr>	

</table>

</body>
</html>