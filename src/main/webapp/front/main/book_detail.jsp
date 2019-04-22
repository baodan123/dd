<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
		<title>图书详情</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/front/css/book_detail.css"/>
		<link href=" ${pageContext.request.contextPath}/front/css/public_footer.css" rel="stylesheet" type="text/css" />

	</head>
	<body>
		<br/>
		<div>
			<h1>
				丛书名：
			</h1>
			<hr/>
		</div>
		<table width="80%" border="0" align="center" cellspacing="0" cellpadding="5">
			<tr>
				<td rowspan="9" width="20%" valign="top"><img src="/dd/back/img/${book.cover }" width="240px" height="340px" /></td>
				<td colspan="2">作者：${book.author }></td>
			</tr>
			<tr>
				<td colspan="2">出版社：${book.press}</td>
			</tr>
			<tr>
				<td>出版时间：${book.publish_date} </td>
				<td>字数${book.font_num }</td>
			</tr>
			<tr>
				<td>版次：${book.edition }</td>
				<td>页数：${book.page_num }</td>
			</tr>
			<tr>
				<td>印刷时间${book.print_date }</td>
				<td>开本：${book.format}</td>
			</tr>
			<tr>
				<td>印次：${book.print_time }</td>
				<td>纸张：${book.paper }</td>
			</tr>
			<tr>
				<td>ISBN：${book.isbn }</td>
				<td>包装${book.pack }</td>
			</tr>
			<tr>
				<td colspan="2">定价：￥${book.price }&nbsp;&nbsp;&nbsp;&nbsp;
				<font color="red">当当价：￥${book.dd_price }</font>&nbsp;&nbsp;&nbsp;&nbsp;
				节省：￥</td>
			</tr>
			<tr>
				<td colspan="2">
					<a href="/dd/cart/addCart?bookid=${book.id}">
						<img src='/dd/front/images/buttom_goumai.gif' />
					</a>
				</td>
			</tr>
		</table>
		<hr style="border:1px dotted #666"/>
		<h2>编辑推荐</h2>
		<p>${book.recommendation }&nbsp;&nbsp;</p>
		<hr style="border:1px dotted #666"/>
		<h2>内容简介</h2>
		<p>${book.summary }&nbsp;&nbsp;</p>
		<hr style="border:1px dotted #666"/>
		<h2>作者简介</h2>
		<p>${book.resume }&nbsp;&nbsp;</p>
		<hr style="border:1px dotted #666"/>
		<h2>目录</h2>
		<p>${book.catalog }&nbsp;&nbsp;</p>
		<hr style="border:1px dotted #666"/>
		<h2>媒体评论</h2>
		<p>${book.media }&nbsp;&nbsp;</p>
		<hr style="border:1px dotted #666"/>
		<h2>书摘插图</h2>
		<p>&nbsp;&nbsp;</p>
		<!--页尾开始 -->
		<div class="public_footer">
			<div class="public_footer_bottom">
				<div class="public_footer_icp" style="line-height: 48px;">
					Copyright (C) 当当网 2004-2008, All Rights Reserved
					<a href="#" target="_blank"><img src="../images/bottom/validate.gif" border="0" align="middle" /> </a>
					<a href="#" target="_blank" style="color: #666;">京ICP证041189号</a>
				</div>
			</div>
		</div>
		<!--页尾结束 -->
	</body>
</html>
