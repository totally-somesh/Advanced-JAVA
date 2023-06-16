<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All IPL Teams</title>

<jsp:useBean id="ipl" class="Beans.TeamBean" scope="session"/>

</head>
<body>

<h4>Teams : ${sessionScope.ipl.wrapperMethod}</h4>

</body>
</html>