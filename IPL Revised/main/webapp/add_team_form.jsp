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
<jsp:useBean id="ipl2" class="Beans.TeamBean" scope="application" />
<jsp:useBean id="ipl" class="Beans.IPLBean" scope="application" />
<jsp:setProperty property="*" name="ipl2" />
<body>
	<form action="team_status.jsp" method="get">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Add New Team</td>
				<td><input type="text" name="tm" />
				</td>
			</tr>
			<tr>
				<td>Enter Abbrevation</td>
				<td><input type="text" name="abv" /></td>
			</tr>
			<tr>
				<td>Enter Owner Name</td>
				<td><input type="text" name="ow" /></td>
			</tr>
			
			<tr>
				<td>Min Batting Average Needed</td>
				<td><input type="number" name="avg" /></td>
			</tr>
			<tr>
				<td>Min Wickets Needed</td>
				<td><input type="number" name="wickets" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add A Team" /></td>
			</tr>
		</table>
	</form>
	<%-- <h5>Teams : ${applicationScope.ipl.fetchAllTeams()}</h5> --%>
</body>


</html>