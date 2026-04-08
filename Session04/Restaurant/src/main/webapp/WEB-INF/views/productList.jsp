<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Product</title>
    </head>
    <body>
        <h2>Ket qua tim kiem</h2>
        <p>Danh muc: <c:out value="${category}"/></p>
        <p>So luong: <c:out value="${limit}"/></p>
        <p>Thong bao: <c:out value="${message}"/></p>
    </body>
</html>
