<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard - StudentHub</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <style>
        * {
            font-family: 'Inter', sans-serif;
        }
        body {
            background-color: #f5f7fa;
        }
        .navbar {
            background: white !important;
            box-shadow: 0 1px 3px rgba(0,0,0,0.05);
            border-bottom: 1px solid #e9ecef;
        }
        .navbar-brand {
            color: #212529 !important;
        }
        .stat-card {
            transition: all 0.3s ease;
            border: 1px solid #e9ecef;
            border-radius: 16px;
            cursor: pointer;
            background: white;
        }
        .stat-card:hover {
            transform: translateY(-4px);
            box-shadow: 0 10px 30px rgba(0,0,0,0.05);
            border-color: #dee2e6;
        }
        .stat-card .card-title {
            color: #6c757d;
            font-weight: 500;
        }
        .stat-card .stat-value {
            color: #212529;
        }
        .table-custom {
            border-radius: 12px;
            overflow: hidden;
        }
        .btn-custom {
            border-radius: 25px;
            padding: 10px 28px;
            font-weight: 500;
            transition: all 0.3s ease;
        }
        .btn-custom:hover {
            transform: translateY(-2px);
        }
        .nav-link-custom {
            font-weight: 500;
            padding-bottom: 5px;
            border-bottom: 2px solid transparent;
            transition: all 0.3s ease;
            text-decoration: none;
            color: #6c757d;
        }
        .nav-link-custom:hover {
            border-bottom-color: #adb5bd;
            color: #212529;
        }
        .nav-link-custom.active {
            border-bottom-color: #212529;
            color: #212529;
        }
        .badge-status {
            padding: 6px 14px;
            border-radius: 20px;
            font-weight: 500;
            font-size: 0.85rem;
        }
        .card-main {
            border: 1px solid #e9ecef;
            border-radius: 20px;
            background: white;
        }
        .card-main .card-header {
            background: white;
            border-bottom: 1px solid #e9ecef;
        }
        .table-bordered-custom {
            border: 1px solid #e9ecef;
        }
        .table-bordered-custom thead th {
            background-color: #f8f9fa;
            color: #495057;
            font-weight: 600;
            border-bottom: 2px solid #e9ecef;
        }
        .table-bordered-custom td {
            border-color: #e9ecef;
        }
    </style>
</head>
<body>
<c:url var="dashboardUrl" value="/dashboard" />
<c:url var="studentsUrl" value="/students" />

<nav class="navbar navbar-light mb-5 py-3">
    <div class="container">
        <a class="navbar-brand fw-bold fs-2" href="${dashboardUrl}">
            <i class="bi bi-mortarboard-fill me-2" style="color: #212529;"></i>
            StudentHub
        </a>
        <div>
            <a href="${dashboardUrl}" class="nav-link-custom me-3 active">
                Dashboard
            </a>
            <a href="${studentsUrl}" class="nav-link-custom">
                Sinh viên
            </a>
        </div>
    </div>
</nav>

<div class="container">
    <div class="row mb-4">
        <div class="col-12">
            <h2 class="fw-bold mb-2" style="color: #212529;">
                Tổng quan hệ thống
            </h2>
            <p style="color: #6c757d;">Thống kê và quản lý sinh viên</p>
        </div>
    </div>

    <div class="row g-4 mb-5">
        <div class="col-md-4">
            <div class="card stat-card">
                <div class="card-body text-center p-4">
                    <i class="bi bi-people-fill fs-1" style="color: #6c757d;"></i>
                    <h6 class="card-title mt-3">Tổng sinh viên</h6>
                    <p class="display-4 fw-bold mb-0 stat-value">${total}</p>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card stat-card">
                <div class="card-body text-center p-4">
                    <i class="bi bi-bar-chart-fill fs-1" style="color: #6c757d;"></i>
                    <h6 class="card-title mt-3">GPA Trung bình</h6>
                    <p class="display-4 fw-bold mb-0 stat-value">${avgGpa}</p>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card stat-card">
                <div class="card-body text-center p-4">
                    <i class="bi bi-trophy-fill fs-1" style="color: #6c757d;"></i>
                    <h6 class="card-title mt-3">Thủ khoa</h6>
                    <p class="fw-bold fs-4 mb-1 stat-value">${topStudent.fullName}</p>
                    <span class="badge" style="background-color: #e9ecef; color: #495057; border-radius: 20px; padding: 6px 14px;">GPA: ${topStudent.gpa}</span>
                </div>
            </div>
        </div>
    </div>

    <div class="card card-main">
        <div class="card-header bg-white pt-4 px-4">
            <h5 class="mb-0 fw-bold" style="color: #212529;">
                <i class="bi bi-pie-chart-fill me-2" style="color: #6c757d;"></i> Tỷ lệ theo Trạng thái
            </h5>
        </div>
        <div class="card-body p-4">
            <table class="table table-bordered table-bordered-custom align-middle">
                <thead>
                <tr>
                    <th class="ps-4">Trạng thái</th>
                    <th>Số lượng</th>
                    <th>Tỷ lệ</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${statusCount}" var="entry">
                    <tr>
                        <td class="ps-4">

                            <c:choose>
                                <c:when test="${entry.key == 'Đang học'}">
         <span class="badge bg-success bg-opacity-25 text-success rounded-pill px-3 py-2">
                                            <i class="bi bi-check-circle-fill me-1"></i>${entry.key}
                                        </span>
                                </c:when>
                                <c:when test="${entry.key == 'Bảo lưu'}">
        <span class="badge rounded-pill px-3 py-2" style="background-color: #ffe8cc; color: #e8590c;">
            <i class="bi bi-pause-circle-fill me-1"></i>${entry.key}
        </span>
                                </c:when>
                                <c:otherwise>
        <span class="badge rounded-pill px-3 py-2" style="background-color: #d3f9f9; color: #0c8599;">
            <i class="bi bi-graduation-cap-fill me-1"></i>${entry.key}
        </span>
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td class="fw-bold fs-5" style="color: #212529;">${entry.value}</td>
                        <td class="fw-bold" style="color: #495057;">${statusPercent[entry.key]}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="card-footer bg-white border-0 pb-4 text-center">
            <a href="${studentsUrl}" class="btn px-4 py-2 rounded-pill fw-semibold"
               style="background-color: #f8f9fa; border: 1px solid #dee2e6; color: #495057;">
                <i class="bi bi-list-ul me-2"></i> Xem danh sách sinh viên
                <i class="bi bi-arrow-right ms-2"></i>
            </a>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>