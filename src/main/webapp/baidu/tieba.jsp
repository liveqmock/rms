<%@page import="org.durcframework.rms.util.RightUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test='<%=RightUtil.check(request.getParameter("srId"), "view")%>'>
		<iframe id="iframe" src="http://tieba.baidu.com" width="100%" height="400"></iframe>
	</c:when>
	<c:otherwise>
		您无权限查看
	</c:otherwise>
</c:choose>

<c:if test='<%=RightUtil.check(request.getParameter("srId"), "qiaoqiaohua")%>'>
悄悄话只对你说.
</c:if>
</body>
</html>