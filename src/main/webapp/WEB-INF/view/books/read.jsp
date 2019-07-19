<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글쓰기</title>
</head>
<body>
<form method="post" action="<c:url value="/write"/>" enctype="multipart/form-data">
<table border="1">
<h3>도서정보관리-도서정보</h3>
<tr>
<th>*BOOK ISBN</th>
<td>${booksVO.num}</td>
</tr>
<tr>
<th>*도서명</th>
<td>${booksVO.title}</td>
</tr>
<tr>
<th>*저자</th>
<td>${booksVO.writer}</td>
</tr>
<tr>
<th>*출판사</th>
<td>${booksVO.publisher}</td>
</tr>
<tr>
<th>*도서 가격</th>
<td>${booksVO.price}</td>
</tr>
<tr>
<th>이미지</th>
<td><img src="../image/${booksVO.image }" width="150" height="100" alt="no image"></td>
</tr>
<tr>
<th>*책 소개</th>
<td>${booksVO.content}</td>
</tr>
</table>
<br><br>
<div>
	<input type="button" value="도서 정보 목록" onclick="javascript:location.href='<c:url value="/list"/>'"/>
</div>
</form>
</body>
</html>