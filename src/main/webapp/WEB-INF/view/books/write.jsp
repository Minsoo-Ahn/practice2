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
<tr>*표시는 필수 입니다.</tr>
<tr>
<th>*BOOK ISBN</th>
<td><input name="num"/></td>
</tr>
<tr>
<th>*도서명</th>
<td><input name="title"/></td>
</tr>
<tr>
<th>*저자</th>
<td><input name="writer"/></td>
</tr>
<tr>
<th>*출판사</th>
<td><input name="publisher"/></td>
</tr>
<tr>
<th>*도서 가격</th>
<td><input name="price"/></td>
</tr>
<tr>
<th>이미지</th>
<td><input type ="file" name="fileName"/></td>
</tr>
<tr>
<th>*책 소개</th>
<td><textarea name="content" cols="35" rows="10"></textarea></td>
</tr>
</table>
<div>
	<input type="submit" value="도서 정보 추가"/>
	&nbsp;&nbsp;
	<input type="button" value="도서 정보 목록" onclick="javascript:location.href='<c:url value="/list"/>'"/>
</div>
</form>
</body>
</html>