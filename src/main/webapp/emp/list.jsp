<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="../css/index_work.css">
		<script type="text/javascript" src="../js/jquery-1.8.3.js"></script>
		<script type="text/javascript">
		var cp=1;
			function fenye(currentPage){
				cp=currentPage;
				$("#cp").val(cp);
				$("#mohu_form").submit();
				/* var mohu=$("#mohu").val();
				location="list?currentPage="+currentPage+"&mohu="+mohu; */
				}
			$(function (){
				$("#mohu").blur(function (){

					fenye(cp);	
					})
				$.ajax({
					<%-- <%=request.getContextPath()%> 从根目录开始查找也称全路径 --%>
					
					url:"<%=request.getContextPath()%>/dept/queryDeptAll",
					dataType:"json",
					success : function (ooj){
						for(var i in ooj){
							$("#did").append("<option value="+ooj[i].did+">"+ooj[i].dname+"</option>")

							}
							$("#did").val($("#result_did").val());
						}
				})
				$("#did").change(function(){
					var did = $(this).val();
					console.log("内容改变"+$(this).val());
					fenye(cp);
					})
			})
		</script>
	</head>
	<body>
		<form action="list" method="post" id="mohu_form">
			按照姓名查询：<input type="text" name="mohu" id="mohu" value="${mohu }"/>
			<input type="hidden" readonly="readonly" name="currentPage" id="cp" />
			<input type="hidden" readonly="readonly" id="result_did" value="${result_did }"/>
			<!-- <input type="submit" value="查询"/> -->
			<select name="did" id="did">
				<option value="0">---请选择---</option>
			</select>
		</form>
		<table>
			<tr>
				<td>序号</td>
				<td>用户名</td>
				<td>密码</td>
				<td>性别</td>
				<td>年龄</td>
				<td>生日</td>
				<td>地址</td>
				<td>部门</td>
				<td>
					<input type="button" value="添加">
				</td>
			</tr>
			
			 	<c:forEach items="${list }" var="e" varStatus="i">
			 		<tr>
			 			<td>${i.count }</td>
			 			<td>${e.username }</td>
			 			<td>${e.password }</td>
			 			<td>${e.sex }</td>
			 			<td>${e.age }</td>
			 			<td>${e.birthday }</td>
			 			<td>${e.address }</td>
			 			<td>${e.dept.dname }</td>
			 			<td>
			 				<input type="button" value="修改"/>
			 				<input type="button" value="删除"/>
			 			</td>
			 		</tr>
			 	</c:forEach>
			 	<tr>
			 		<td colspan="10">
			 			<input type="button" value="首页" onclick="fenye(1)"/>
			 			<input type="button" value="上一页" onclick="fenye(${page.prevPage})"/>
			 			<input type="button" value="下一页" onclick="fenye(${page.nextPage})"/>
			 			<input type="button" value="尾页" onclick="fenye(${page.pageCount})"/>
			 		</td>
			 	</tr>
		</table>
	</body>
</html>