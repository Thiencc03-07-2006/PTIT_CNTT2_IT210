<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Chi Thien
  Date: 08-4-26
  Time: 7:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <h2>Detail</h2>
        <p>ID: <c:out value="${customer.id}"/></p>
        <p>Name: <c:out value="${customer.name}"/></p>
    </body>
</html>
