<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

<html>
    <head>
        <title>Tìm kiếm sự kiện</title>
    </head>
    <body>

        <!-- A. HEADER -->

        <h2>
            Kết quả tìm kiếm cho:
            <c:out value="${keyword}" escapeXml="true"/>
        </h2>

        <p>Tìm thấy <c:out value="${totalFound}"/> sự kiện</p>

        <c:if test="${empty events}">
            <p>Không tìm thấy sự kiện nào phù hợp.</p>
        </c:if>

        <!-- B. TABLE -->
        <c:if test="${not empty events}">
            <table border="1">
                <tr>
                    <th>STT</th>
                    <th>Tên sự kiện</th>
                    <th>Ngày tổ chức</th>
                    <th>Giá vé</th>
                    <th>Vé còn lại</th>
                    <th>Thao tác</th>
                </tr>

                <c:forEach var="event" items="${events}" varStatus="loop">
                    <tr>
                        <!-- STT -->
                        <td><c:out value="${loop.count}"/></td>

                        <!-- Tên (CHỐNG XSS) -->
                        <td>
                            <c:out value="${event.name}" escapeXml="true"/>
                        </td>

                        <!-- Ngày -->
                        <td><c:out value="${event.eventDate}"/></td>

                        <!-- Giá vé -->
                        <td>
                            <c:choose>
                                <c:when test="${event.price == 0}">
                                    <span style="color: green;">MIỄN PHÍ</span>
                                </c:when>
                                <c:otherwise>
                                    <fmt:formatNumber value="${event.price}" type="number" groupingUsed="true"/> ₫
                                </c:otherwise>
                            </c:choose>
                        </td>

                        <!-- Vé còn lại -->
                        <td>
                            <c:choose>
                                <c:when test="${event.remainingTickets == 0}">
                                    <span style="color: red;">HẾT VÉ</span>
                                </c:when>
                                <c:when test="${event.remainingTickets < 10}">
                            <span style="color: orange;">
                                Sắp hết (còn <c:out value="${event.remainingTickets}"/> vé)
                            </span>
                                </c:when>
                                <c:otherwise>
                            <span style="color: green;">
                                    <c:out value="${event.eventDate}"/>
                            </span>
                                </c:otherwise>
                            </c:choose>
                        </td>

                        <!-- Thao tác -->
                        <td>
                            <c:choose>
                                <c:when test="${event.remainingTickets == 0}">
                                    <span style="color: gray;">Không khả dụng</span>
                                </c:when>
                                <c:otherwise>
                                    <c:url var="bookUrl" value="/events/${event.id}/book"/>
                                    <a href="${bookUrl}">Đặt vé</a>
                                </c:otherwise>
                            </c:choose>
                        </td>

                    </tr>
                </c:forEach>
            </table>
        </c:if>

        <!-- C. FOOTER -->

        <c:if test="${not empty events}">
            <p>
                Sự kiện đầu tiên:
                <c:if test="${not empty events and not empty events[0].name}"/>
            </p>
        </c:if>

        <p>
            Độ dài từ khóa: <c:out value="${fn:length(keyword)}"/> ký tự
        </p>

    </body>
</html>