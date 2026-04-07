<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
    <head>
        <title>Danh sách đơn hàng</title>
    </head>
    <body>

        <h2>
            Xin chào, ${sessionScope.loggedUser}!
            Vai trò: ${sessionScope.role}
        </h2>

        <a href="${pageContext.request.contextPath}/logout">Đăng xuất</a>

        <table border="1">
            <tr>
                <th>Mã đơn</th>
                <th>Sản phẩm</th>
                <th>Tổng tiền</th>
                <th>Ngày đặt</th>
            </tr>

            <c:forEach var="o" items="${orderList}">
                <tr>
                    <td>${o.orderId}</td>
                    <td>${o.name}</td>

                    <!-- Format tiền -->
                    <td>
                        <fmt:formatNumber value="${o.price}" type="currency" currencySymbol="₫"/>
                    </td>

                    <!-- Format ngày -->
                    <td>
                        <fmt:formatDate value="${o.date}" pattern="dd/MM/yyyy"/>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <br/>

        <p>
            Tổng lượt xem đơn hàng toàn hệ thống:
            ${applicationScope.totalViewCount}
        </p>

    </body>
</html>