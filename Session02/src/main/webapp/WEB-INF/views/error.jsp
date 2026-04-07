<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
    <head>
        <title>Lỗi hệ thống</title>
    </head>
    <body>

        <h2 style="color:red;">Đã xảy ra lỗi</h2>

        <p>${errorMessage}</p>

        <br/>

        <a href="<c:url value='/employees'/>">Quay lại danh sách</a>

    </body>
</html>