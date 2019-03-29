<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.mx.com/tag/page" prefix="page" %>
<%@include file="/common/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		描述:面板加div布局
		作者:郎国峰
		时间:2019年3月15日11:07:00
	 -->
	<div class="panel panel-default">
		    <div class="panel-body">
		        <div>
				    <div class="row" >
				        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" 
				         style="background-color: #dedef8;
				         box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
				         <p>L adipisicing elit.</p>
				        </div>
				   </div>
				   <div class="row">
				   		<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2" 
							style="background-color: #dedef8;
							box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
							<p>L adipisicing elit.</p>
				        </div>
				   		<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10" 
							style="background-color: #dedef8;
							box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
							<!-- 
								描述: 展示查询结果,带语境色彩的面板+悬停表格
								作者: 郎国峰
								时间: 2019年3月14日12:15:17
							 -->
							<div class="panel panel-primary">
							    <div class="panel-heading">
							        <h3 class="panel-title">测试pageHelper查询页面</h3>
							    </div>
							    <div class="panel-body">
							       	 <table class="table table-hover table-bordered text-center" >
										<caption>用户信息</caption>
										<thead >
										  <tr>
										    <th class="text-center">序号</th>
										    <th class="text-center">姓名</th>
										    <th class="text-center">年龄</th>
										  </tr>
										</thead>
										<tbody>
											<c:forEach items="${info.list}" var="user" varStatus="i" >
												<tr>
												    <td style="width: 5%; ">${i.count}</td>
												    <td>${user.userName}</td>
												    <td>${user.userAge}</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
							    </div>
							</div>
				        </div>
				        <!-- 分页标签 -->
				   		<page:page pageName="info" uri="/testPageHelper/queryAll.action"></page:page>
				   </div>
				</div>
		    </div>
		</div>




	
	
	
	

	
	
</body>
</html>