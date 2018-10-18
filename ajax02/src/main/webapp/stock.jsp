<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
		$(function(){
			//每隔一段时间执行这段代码
			setInterval(quoto,3000);
		});
		//该函数通过调用ajax对象，来向服务器发送异步请求，
		//服务器返回给一个描述股票信息的json字符串
		//通过解析字符串更新表格
		function quoto(){
			//利用jQuery提供的方法来向服务器发送请求
			$.ajax({
				url:"quoto.do",
				type:"post",
				dataType:"json",
				success:function(stocks){
					//先清空tbody,否则表格中的数据会越来越多
					$('#tb1').empty();
					//$.ajax方法会自动把json字符串转换为JavaScript对象
					for(i = 0; i < stocks.length; i++){
						var s = stocks[i];
						//更新表格
						$('#tb1').append('<tr><td>'+s.code+'</td><td>'+s.name+'</td><td>'+s.price+'</td></tr>');
					}
				}
			});
		}
	</script>
	<style>
		#d1{
			width:450px;
			height:350px;
			background-color: black;
			margin-left:400px;
			margin-top: 20px;
		}
		#d2{
			height:32px;
			background-color: red;
			color:yellow
		}
		table{
			color:white;
			font-style:italic;
			font-size:24px;
		}
	</style>
</head>
<body style="font-size:30px;">
	<div id="d1">
		<div id="d2">股票行情</div>
		<div id="d3">
			<table width=100%>
				<thead>
					<tr>
						<td>代码</td>
						<td>名称</td>
						<td>价格</td>
					</tr>
				</thead>
				<tbody id="tb1">
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>