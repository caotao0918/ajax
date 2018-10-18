<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
		$(function(){
			$('#a1').click(showNumber);
		});
		function showNumber(){
			$('#d1').load("luck.do");
		}
	</script>
</head>
<body style="font-size:30px;">
	<a id="a1" href="javascript:">你的幸运数字是：</a><br/>
	<div id="d1">
	</div>
</body>
</html>