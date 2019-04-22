<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<h2>
	编辑推荐
</h2>
<div id=__bianjituijian/danpin>

	<div class=second_c_02>
	<c:forEach var="a" items="${requestScope.recommend}">
		<div class=second_c_02_b1>
			<div class=second_c_02_b1_1>
				<a href='/dd/book/findById?id=${a.id}' target='_blank'>
					<img src="/dd/back/img/${a.cover}" width=70 border=0 /> 
				</a>
			</div>
			<div class=second_c_02_b1_2>
				<h3>
					<a href='/dd/book/findById?id=${a.id}' target='_blank' title='输赢'>${a.name}</a>
				</h3>
				<h4>
					作者：${a.author} 著
					<br />
					出版社：${a.press}&nbsp;&nbsp;&nbsp;&nbsp;
					出版时间：${a.publish_date}
				</h4>
				<h5>
					简介:${a.summary }
				</h5>
				<h6>
					定价：￥${a.price}&nbsp;&nbsp;
					当当价：￥${a.dd_price}
					销量：<font color="red">${a.sales }</font>
				</h6>
				<div class=line_xx></div>
			</div>
		</div>	</c:forEach>
	</div>
		
</div>
