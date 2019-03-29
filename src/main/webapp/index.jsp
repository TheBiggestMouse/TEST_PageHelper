<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Hello World!</h2>
	<div class="btn btn-default">
		<input type="button" onclick="testPageHelper()"  value="测试分页组件pageHelper">
	</div>

</body>
<script type="text/javascript">
function testPageHelper(){
	window.location.href = "<%=request.getContextPath() %>/testPageHelper/queryAll.action";
}

</script>
</html>