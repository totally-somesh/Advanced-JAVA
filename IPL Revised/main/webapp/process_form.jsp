<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%-- import JSTL's Core Tag Lib --%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:setProperty property="*" name="ipl1" />
<body>
	Message : ${applicationScope.ipl1.validateAndAddNewPlayer()} 
</body>

</html>