<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
</head>
<body>
<form:form commandName="booksVO" method="POST">
<h4>도서정보관리-리스트</h4>
<br>
검색 키워드 입력 : <form:input path="search" placeholder="도서제목 또는 저자 입력"/>
<input type="submit" value="찾기"><br><br>
	<table border="1">
		<tr>
		<td><Strong>등록 번호</Strong></td>
		<td><Strong>도서 표지</Strong></td>
		<td><Strong>도서 ISBN</Strong></td>
		<td><Strong>도서 제목</Strong></td>
		<td><Strong>저자</Strong></td>
		<td><Strong>출판사</Strong></td>
		<td><Strong>가격</Strong></td>
		</tr>
		<c:forEach var="books" items="${booksList }" varStatus="loop">
			<tr>
				<td>${books.seq }</td>
				<td><img src="image/${books.image }" width="150" height="100" alt="no image"></td>
				<td>${books.num }</td>
				<td><a href="<c:url value="/read/${books.seq}"/>">
				${books.title }</a> </td>
				<td>${books.writer }</td>
				<td>${books.publisher }</td>
				<td>${books.price }</td>
			</tr>
		</c:forEach>
	</table>
	<div>
	<br><br>
		<input type="button" value="새글쓰기" onclick="javascript:location.href='<c:url value="/write"/>'"/>
	</div>
	</form:form>
</body>
</html>