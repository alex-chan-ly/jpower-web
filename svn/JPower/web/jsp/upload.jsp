<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<body>
<%
	String status = (String)request.getSession().getAttribute("STATUS");
	if( (status == null) || (!status.equals("AUTHENTICATED")) ) {

		response.sendRedirect("admin.jsp");
 		
	}
%>
<table width="100%">
	<tr align="center">
		<td style="FONT-SIZE: xx-large; FONT-WEIGHT: bold;">
			JPower Content Upload.
		</td>
	</tr>
	
	<tr>
		<td><hr/></td>
	</tr>
	<tr align="center">
		<td>
			<form action="servlet/upload" method="post" enctype="multipart/form-data">
			Select a zip file to upload:<input type="file" name="zipFile">						
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>	
	<tr align="center">
		<td><input type="submit" value="Upload"></td> 
		</form>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>		
	<tr align="center">
		<td style="FONT-WEIGHT: bold; color:DeepPink;">
			<% 
				String result = (String)request.getSession().getAttribute("RESULT");
				if(result != null) {
					out.println(result);
				}
				request.getSession().removeAttribute("RESULT");
			%>
		</td>
	</tr>
</table>

</body>
</html>