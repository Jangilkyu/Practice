<%@page import="com.google.gson.Gson"%>
<%@page import="com.sist.MemberDao.MemberDao"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.Vo.MemberVo"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<% 
	MemberDao mDao = MemberDao.getInstance();

	ArrayList<MemberVo> list = mDao.selectAllMember();
	
	Gson gson = new Gson();
	
	String r = gson.toJson(list);
	
%>

<%= r %>