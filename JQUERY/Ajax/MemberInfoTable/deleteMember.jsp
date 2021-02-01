<%@page import="com.sist.MemberDao.MemberDao"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>


<% 
	String id = request.getParameter("id");

	MemberDao mDao = MemberDao.getInstance();
	
	int re = mDao.deleteMember(id);
%>

<%= re %>