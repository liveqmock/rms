<%@page import="org.durcframework.rms.util.RightUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>监控页面</title>
</head>
<body>

<c:if test='<%=RightUtil.check(request.getParameter("srId"), "monitor")%>'>
	<script type="text/javascript">
		window.location = '${ctx}druid/index.html';
	</script>
</c:if>
</body>
</html>