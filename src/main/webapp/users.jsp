<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ page import="com.fooddelivery.model.User, java.util.List" %>   
   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	
	List<User> users =(List<User>) request.getAttribute("usersList");
	for(User user : users){
	%>
	<div>
	<h1><%= user.getUsername() %></h1>
	</div>
	<% 
	}
	
	%>



</body>
</html>