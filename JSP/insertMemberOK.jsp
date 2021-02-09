<%@page import="java.util.Arrays"%>
<%@page import="com.sist.Vo.MembersVO"%>
<%@page import="com.sist.DAO.MembersDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

	request.setCharacterEncoding("UTF-8");


	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	String name = request.getParameter("name");
	String phone1 = request.getParameter("phone1");
	String phone2 = request.getParameter("phone2");
	String phone3 = request.getParameter("phone3");
	String sex = request.getParameter("sex");
	String bloodType = request.getParameter("bloodType");
	//hobby는 여러개가 올수 있기 때문에 배열로 받는다
	String[] hobby = request.getParameterValues("hobby");
	//취미는 체크박스로 표현되어 있어 여러개를 선택할 수 있다.
	// 그래서 배열로 받아야한다.
	
	//toString()을 통해서 배열의 내용을 문자열로 만들어준다.
	String hobbys = Arrays.toString(hobby);
	
	String city = request.getParameter("city");
	String info = request.getParameter("comment");
	
	MembersDAO dao = MembersDAO.getInstance();

	MembersVO m = new MembersVO();
	m.setId(id);
	m.setPasswd(passwd);
	m.setName(name);
	m.setPhone1(phone1);
	m.setPhone2(phone2);
	m.setPhone3(phone3);
	m.setSex(sex);
	m.setBlood(bloodType);
	m.setHobby(hobbys);
	m.setCitiy(city);
	m.setInfo(info);
	
	int re =dao.insert(m);
	

%>

<%= re %>

</body>
</html>