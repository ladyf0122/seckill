<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="common/tag.jsp"%>

<%
	Cookie[] cookies = request.getCookies();
	Cookie cookie = null;
	String phone = null;
	if (cookies != null) {
		for (int i = 0; i < cookies.length; i++) {
			cookie = cookies[i];
			if(cookie.getName().equals("userPhone")){
				phone = cookie.getValue();
			}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<title>秒杀列表页</title>
<%@ include file="common/head.jsp"%>
</head>
<body>
	<h5>当前登陆账号：<%=phone %></h5>
	<button class="btn btn-primary btn-lg" data-toggle="modal"
		data-target="#killPhoneModal">注销</button>
	<div id="killPhoneModal" class="modal fade" tabindex="-1" role="dialog"
		aria-hidden="true">

		<div class="modal-dialog" style="z-index: 1040">

			<div class="modal-content">
				<div class="modal-header">
					<h3 class="modal-title text-center">
						<span class="glyphicon glyphicon-phone"></span>秒杀电话:
					</h3>
				</div>

				<div class="modal-body">
					<div class="row">
						<div class="col-xs-8 col-xs-offset-2">
							<input type="text" name="killPhone" id="killPhoneKey"
								placeholder="填写手机号^o^" class="form-control">
						</div>
					</div>
				</div>

				<div class="modal-footer">
					<%--验证信息--%>
					<span id="killPhoneMessage" class="glyphicon"> </span>
					<button type="button" id="killPhoneBtn" class="btn btn-success">
						<span class="glyphicon glyphicon-phone"></span> Submit
					</button>
				</div>

			</div>
		</div>

	</div>
	<!-- 页面显示部分 -->
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading text-center">
				<h2>秒杀列表</h2>
			</div>
			<div class="panel-body">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>名称</th>
							<th>库存</th>
							<th>开始时间</th>
							<th>结束时间</th>
							<th>创建时间</th>
							<th>详情页</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="sk" items="${list}">
							<tr>
								<td>${sk.name}</td>
								<td>${sk.number}</td>
								<td><fmt:formatDate value="${sk.startTime}"
										pattern="yyyy-MM-dd HH:mm:ss" /></td>
								<td><fmt:formatDate value="${sk.endTime}"
										pattern="yyyy-MM-dd HH:mm:ss" /></td>
								<td><fmt:formatDate value="${sk.createTime}"
										pattern="yyyy-MM-dd HH:mm:ss" /></td>
								<td><a class="btn btn-info"
									href="/seckill/${sk.seckillId}/detail" target="_blank">link</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="/resources/script/seckill.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		$('#killPhoneBtn')
				.click(
						function() {
							var inputPhone = $('#killPhoneKey').val();
							console.log("inputPhone: " + inputPhone);
							if (seckill.validatePhone(inputPhone)) {
								//电话写入cookie(7天过期)
								document.cookie = "userPhone="+inputPhone + ";path=/seckill";
								//验证通过　　刷新页面
								window.location.reload();
							} else {
								//todo 错误文案信息抽取到前端字典里
								$('#killPhoneMessage')
										.hide()
										.html(
												'<label class="label label-danger">手机号错误!</label>')
										.show(300);
							}
						});
	})
</script>
</html>