<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "com.User.Destiny.Destiny" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사주 결과</title>

<style type="text/css">
	* {
		padding: 0px;
		margin: 0px;
	}
	
	ul {
		list-style: none;
		text-align: center;
	}

	body {
		background-color: black;
	}
	
	#wrap {
		background-color: white;
		width: 550px;
		border: 10px solid pink;
		margin: 350px auto;
		padding: 50px;
		border-radius: 30px;
	}
	
	#hd-h1 {
		display: inline-block;
		border-top: 4px solid pink;
		border-bottom: 4px solid pink;
		padding: 20px;
		margin-bottom: 50px;
	}
	
	#username {
		color:#999;
	}
	
	#h1-cov{
		text-align: center;
	}
	
	#info-h3-wrap{
		text-align: center;
	}
	
	#info-h3 {
		display: inline-block;
		margin-bottom: 50px;
		color: 	
		border-bottom: 1px solid pink;
	}
	
	li {
		font-size: 30px;
		font-family: '맑은 고딕', '돋움', sans-serif;
	}
	
	#li-style {
		font-weight: bold;
		color:#999;
		
	}

</style>
</head>
<body>
	<%
	/* 한글 설정 */
	request.setCharacterEncoding("UTF-8");
	%>
	
	<% 

		String date = request.getParameter("date");
		String name = request.getParameter("name");
		Destiny d = new Destiny(date);
		String[] arr = d.getResult();
		String zodiac = d.getZodiac();
		int[] userDate = d.getUserDate();
		%>
		
		
		<div id = "wrap">
			<div id="h1-cov">
				<h1 id ="hd-h1"><span id="username"><%= name  %></span>님의 사주 분석 결과입니다.</h1>
				<br>
			</div>
		<div id="wrap-h1">
			<div id="info-h3-wrap">
				<h3 id ="info-h3"><%= userDate[0] %>년 <%= userDate[1] %>월 <%= userDate[2] %>일 <%= userDate[3] %>시 <%= userDate[4] %>분 <%= zodiac %>띠</h3>
			</div>
			<ul>
				<li><span id="li-style">생 년</span>: <%=arr[0]%></li>
				<li><span id="li-style">생 월</span>: <%=arr[1]%></li>
				<li><span id="li-style">생 일</span>: <%=arr[2]%></li>
				<li><span id="li-style">생 시</span>: <%=arr[3]%></li>
			</ul>
		</div>
	</div>
</body>
</html>