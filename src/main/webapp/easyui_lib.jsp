<%@page import="org.durcframework.rms.common.PropertiesManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="taglib.jsp" %>
<link href="${ctx}favicon.ico" rel="SHORTCUT ICON">
<link rel="stylesheet" type="text/css" id="easyuiCssId" href="${easyui}themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${easyui}themes/icon.css">
<link rel="stylesheet" type="text/css" href="${easyui}style.css">
<script type="text/javascript">var ctx = '${ctx}';</script>
<script type="text/javascript" src="${ctx}js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${easyui}jquery.easyui.min.js"></script>
<script type="text/javascript" src="${easyui}locale/easyui-lang-zh_CN.js"></script>
<%
String debugModel = PropertiesManager.getInstance().get("debugModel");
// 如果是调试模式
if("true".equals(debugModel)){
%>
<script type="text/javascript" src="${ctx}js/need_compress/Globle.js"></script>
<script type="text/javascript" src="${ctx}js/need_compress/Action.js"></script>
<script type="text/javascript" src="${ctx}js/need_compress/Crud.js"></script>
<script type="text/javascript" src="${ctx}js/need_compress/EventUtil.js"></script>
<script type="text/javascript" src="${ctx}js/need_compress/FunUtil.js"></script>
<script type="text/javascript" src="${ctx}js/need_compress/HtmlUtil.js"></script>
<script type="text/javascript" src="${ctx}js/need_compress/MaskUtil.js"></script>
<script type="text/javascript" src="${ctx}js/need_compress/MsgUtil.js"></script>
<%}else{%>
<script type="text/javascript" src="${ctx}js/common.min.js"></script>
<%} %>
