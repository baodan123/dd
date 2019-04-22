<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="book_l_border1" id="__FenLeiLiuLan">
	<div class="book_sort_tushu">
		<h2>
			分类浏览
		</h2>
		<c:forEach var="a" items="${requestScope.types}">
		<!--1级分类开始-->

			<div class="bg_old" onmouseover="this.className = 'bg_white';"
				onmouseout="this.className = 'bg_old';">
				<h3>
					[<a href='/dd/book/secondPage?fname=${a.name}'>${a.name}</a>]
				</h3>
				<ul class="ul_left_list">

						<!--2级分类开始-->
						<c:forEach var="b" items="${a.second}">
						<li>
							<a href='/dd/book/secondPage?fname=${a.name}&sname=${b.name}'>${b.name}</a>
						</li>
						</c:forEach>   
						<!--2级分类结束-->

				</ul>
				<div class="empty_left">
				</div>
			</div>

			<div class="more2">
			</div>
		<!--1级分类结束-->
		</c:forEach>
	


		<div class="bg_old">
			<h3>
				&nbsp;
			</h3>
		</div>
	</div>
</div>
