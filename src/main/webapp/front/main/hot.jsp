<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>
	<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>热销图书
</h2>
<div class="book_c_04">
<c:forEach var="a" items="${requestScope.sales}">
	<!--热销图书A开始-->
	<div class="second_d_wai">
	
		<div class="img">
			<a href="/dd/book/findById?id=${a.id}" target='_blank'>
				<img src="/dd/back/img/${a.cover}" border=0 /> 
			</a>
		</div>
		<div class="shuming">
			<a href="#" target="_blank">${a.name}</a><a href="#" target="_blank"></a>
		</div>
		<div class="price">
			定价：￥${a.price}
		</div>
		<div class="price">
			当当价：￥${a.dd_price}
		</div>
		<div class="price">
			销量：<font color="red">${a.sales}</font>
		</div>
		
	</div>
	
	<div class="book_c_xy_long"></div>
	<!--热销图书A结束-->
</c:forEach>
</div>
<div class="clear"></div>