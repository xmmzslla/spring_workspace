<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memPro</title>
</head>
<body>
	<p>Member Date</p>
	<p>이름: ${name}</p>
	<p>나이: ${age}</p>
	
	
	<p>Member Date</p>
	<p>이름: ${memDTO.name}</p> <!-- (MemDTO dto)의 앞글자를 소문자로 바뀌서 -->
	<p>나이: ${memDTO.age}</p>
	
	<p>Member Date</p>
	<p>이름: ${mt.name}</p>
	<p>나이: ${mt.age}</p>
</body>
</html>