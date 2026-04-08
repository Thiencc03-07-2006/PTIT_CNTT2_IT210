<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Chi Thien
  Date: 08-4-26
  Time: 7:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <h2>List</h2>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Detail</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="c" items="${customers}">
                    <tr>
                        <td>
                            <c:out value="${c.id}"/>
                        </td>
                        <td>
                            <c:out value="${c.name}"/>
                        </td>
                        <td>
                            <a href="customers/${c.id}">See</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
