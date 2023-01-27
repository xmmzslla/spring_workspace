<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title><tiles:insertAttribute name="title" /></title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous"> </head>

<%-- <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
 --%>
</head>
<body>
 
  <tiles:insertAttribute name="header" />
  <div class="jumbotron" align="center">
     <div class="container">
      <h1 class="display-3"><tiles:insertAttribute name="heading" /></h1>
      <p><tiles:insertAttribute name="subheading" />
    </div>
  </div>
  
  <div class="container">
    <div class="row">
       <tiles:insertAttribute name="content" />
    </div>
  </div>
  
  <div class="footer">
     <tiles:insertAttribute name="footer" />
  </div>
  </body>
</html>