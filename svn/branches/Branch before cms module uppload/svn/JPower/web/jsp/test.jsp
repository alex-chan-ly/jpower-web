<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%

String method=request.getMethod();
String IP=request.getRemoteAddr();

String userDir=System.getProperty("user.dir");
String realpath= getServletContext().getRealPath("/");

%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
out.println("Method=" + method);
out.println("<br/>");
out.println("IP=" + IP);
out.println("<br/>");
out.println("user directory=" + userDir);
out.println("<br/>");
out.println("real path=" + realpath);

RandomAccessFile file = new RandomAccessFile(realpath + "/test.txt", "rw");
file.write(new String("This is a testing file").getBytes());
file.close();

%>
</body>
</html>