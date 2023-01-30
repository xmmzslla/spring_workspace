<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!-- /mapp 프로젝트의 경로 리턴 -->

<div id="bodywrap">
	<form id="frm" method="get" action="write.do">
		<input type="submit" id="btnWrite" value="글쓰기" />
	</form>

	<table class="table table-boarder mt-1">
		<tr>
			<th class="col-md-1 text-center">번호</th>
			<th class="col-md-7 text-center">제목</th>
			<th class="col-md-2 text-center">메일</th>
			<th class="col-md-2 text-center">조회수</th>
		</tr>

		<c:forEach items="${aList}" var="dto">
			<tr>
				<td class="text-center">${dto.num}</td>
				<td class="pl-2 text-left">
				<c:url var="path" value="view.do">
				<c:param name="currentPage" value="${pv.currentPage}" />
				<c:param name="num" value="${dto.num}" />
				</c:url>
				<a href="${path}">${dto.subject}</a>
				</td>
				<td class="text-center">${dto.writer}</td>
				<td class="text-center">${dto.readcount}</td>
			</tr>
		</c:forEach>
	</table>
</div>