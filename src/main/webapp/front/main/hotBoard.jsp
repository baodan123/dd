<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<h2 class="t_xsrm">
		新书热卖榜
	</h2>
	<div id="NewProduct_1_o_t" onmouseover="">
	<ul>
	<c:forEach var="a" items="${newSales}">
		<li>&nbsp;&nbsp;&nbsp;
			<a  target='_blank' href="/dd/book/findById?id=${a.id}">
				${a.name}
			</a>
		</li>
		</c:forEach>
	</ul>
	<h3 class="second">
		<span class="dot_r"> </span><a href="" target="_blank">更多&gt;&gt;</a>
	</h3>
</div>