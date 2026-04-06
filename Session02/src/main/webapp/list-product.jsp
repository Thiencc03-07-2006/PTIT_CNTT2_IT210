<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<meta charset="UTF-8">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>JSQL</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container table-container">
    <div class="row">
        <div class="col-12">
            <h2 class="text-center text-primary mb-4">QUẢN LÝ SẢN PHẨM</h2>

            <div class="d-flex justify-content-between mb-3">
                <button class="btn btn-success">Thêm sản phẩm mới</button>
                <form class="form-inline">
                    <input class="form-control mr-sm-2" type="search" placeholder="Tìm kiếm...">
                    <button class="btn btn-outline-primary" type="submit">Tìm</button>
                </form>
            </div>

            <table class="table table-bordered table-hover shadow-sm">
                <thead class="thead-dark">
                <tr>
                    <th>STT</th>
                    <th>Mã SP</th>
                    <th>Tên sản phẩm</th>
                    <th>Đơn giá</th>
                    <th>Trạng thái</th>
                    <th class="text-center">Hành động</th>
                </tr>
                </thead>
                <tbody>
                <%-- Giả sử biến "products" được gửi từ Controller qua model.addAttribute("products", list) --%>
                <c:forEach items="${products}" var="p" varStatus="loop">
                    <tr>
                        <td>${loop.count}</td>
                        <td>SP-${p.id}</td>
                        <td><strong>${p.name}</strong></td>
                        <td class="text-danger font-weight-bold"><fmt:formatNumber value="${p.price}" pattern="#,###" /> VNĐ</td>
                        <td>
                            <span class="badge ${p.status ? 'badge-success' : 'badge-secondary'}">
                                    ${p.status ? 'Còn hàng' : 'Hết hàng'}
                            </span>
                        </td>
                        <td class="text-center action-btns">
                            <a href="#" class="btn btn-warning btn-sm">Sửa</a>
                            <a href="#" class="btn btn-danger btn-sm">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>

                <%-- Hiển thị thông báo nếu danh sách trống --%>
                <c:if test="${empty products}">
                    <tr>
                        <td colspan="6" class="text-center text-muted">Không có sản phẩm nào để hiển thị.</td>
                    </tr>
                </c:if>
                </tbody>
            </table>
        </div>
    </div>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>