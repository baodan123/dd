<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>index.html</title>
	<link rel="stylesheet" href="/dd/back/css/btn.css" />
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=GBK">
    <script type="text/javascript" src="/dd/back/js/jquery-3.3.1.js"></script>
  </head>
  
  <body style="background-color: #f0f9fd;text-align: center">
  	<div style="text-align: center;font-size: 18px">添加商品类别</div><hr/>
  	<form action="/dd/type/addFirst" method="post">
  		类别名:<input class="el-input__inner" type="text" name="type.name" id="fname"/><span id="fnameMsg"></span><br/>
  		levels:<input class="el-input__inner" type="text" name="type.levels" value="1" readonly/><br/>
  		<input class="button btn-p" type="submit" value="提交">&emsp;
		<div class="button btn-p"  onclick="history.go(-1);">返回上级</div>
  	</form>
    	
  </body>
</html>
