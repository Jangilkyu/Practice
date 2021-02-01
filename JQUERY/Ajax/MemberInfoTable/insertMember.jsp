<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.Vo.MemberVo"%>
<%@page import="java.util.List"%>
<%@page import="com.sist.MemberDao.MemberDao"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- JSP 내장 객체중에 request는 사용자의 정보를 가지고 있다.  --%>

<%
	
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String email = request.getParameter("email");

	
	MemberVo mVo = new MemberVo(id,name,email);
	
	MemberDao mdao = MemberDao.getInstance();

	int r = mdao.insertMember(mVo);

%>

<%= r %>