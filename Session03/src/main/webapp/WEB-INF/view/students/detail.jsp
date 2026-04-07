<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Chi tiết Sinh viên - StudentHub</title>
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
        .nav-link-custom {
            font-weight: 500;
            padding-bottom: 8px;
            border-bottom: 2px solid transparent;
            transition: all 0.2s ease;
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
        .detail-card {
            border-radius: 16px;
            border: 1px solid #e9ecef;
            overflow: hidden;
            background: white;
            box-shadow: 0 5px 15px rgba(0,0,0,0.03);
        }
        .detail-card .card-header {
            background: white;
            padding: 2rem 1.5rem;
            border-bottom: 1px solid #e9ecef;
        }
        .detail-card .card-body {
            padding: 1.5rem;
            background: white;
        }
        .info-table {
            width: 100%;
            border-collapse: collapse;
            border: 1px solid #dee2e6;
            border-radius: 12px;
            overflow: hidden;
        }
        .info-table th {
            width: 35%;
            background-color: #f8f9fa;
            padding: 1rem 1.5rem;
            font-weight: 600;
            color: #495057;
            border: 1px solid #dee2e6;
        }
        .info-table td {
            padding: 1rem 1.5rem;
            font-size: 1rem;
            border: 1px solid #dee2e6;
        }
        .avatar-circle {
            width: 100px;
            height: 100px;
            background-color: #f8f9fa;
            border-radius: 50%;
            display: flex;
            align-items: center;
            justify-content: center;
            margin: 0 auto 1rem;
            border: 2px solid #e9ecef;
        }
        .avatar-circle i {
            font-size: 3.5rem;
            color: #adb5bd;
        }
        .gpa-badge {
            font-size: 1.3rem;
            font-weight: bold;
            padding: 0.5rem 1.2rem;
            border-radius: 24px;
            display: inline-block;
        }
        .btn-back {
            border-radius: 30px;
            padding: 10px 30px;
            font-weight: 500;
            transition: all 0.3s ease;
            background-color: #f8f9fa;
            border: 1px solid #dee2e6;
            color: #495057;
        }
        .btn-back:hover {
            transform: translateX(-5px);
            background-color: #e9ecef;
            border-color: #ced4da;
        }
        .faculty-badge {
            padding: 6px 14px;
            border-radius: 20px;
            font-weight: 500;
            display: inline-block;
            background-color: #f8f9fa;
            color: #495057;
            border: 1px solid #dee2e6;
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
            <a href="${dashboardUrl}" class="nav-link-custom me-3">
                Dashboard
            </a>
            <a href="${studentsUrl}" class="nav-link-custom active">
                Sinh viên
            </a>
        </div>
    </div>
</nav>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-8 col-lg-7">
            <div class="card detail-card">
                <div class="card-header text-center">
                    <div class="avatar-circle">
                        <i class="bi bi-person-circle"></i>
                    </div>
                    <h3 class="mb-1 fw-bold" style="color: #212529;">${student.fullName}</h3>
                    <p class="mb-0" style="color: #6c757d;">
                        <i class="bi bi-code-slash me-1"></i> Mã số: ${student.studentCode}
                    </p>
                </div>
                <div class="card-body">
                    <table class="info-table">
                        <tbody>
                        <tr>
                            <th><i class="bi bi-building me-2"></i> Khoa</th>
                            <td>
                                <span class="faculty-badge">
                                    ${student.faculty}
                                </span>
                            </td>
                        </tr>
                        <tr>
                            <th><i class="bi bi-calendar-event me-2"></i> Năm nhập học</th>
                            <td><span class="fw-bold" style="color: #212529;">${student.enrollmentYear}</span></td>
                        </tr>
                        <tr>
                            <th><i class="bi bi-star-fill me-2"></i> GPA</th>
                            <td>
                                <c:choose>
                                    <c:when test="${student.gpa >= 3.6}">
                                        <div class="gpa-badge" style="background-color: #c5e1d4; color: #198754;">
                                                ${student.gpa}
                                            <i class="bi bi-trophy-fill ms-2"></i>
                                        </div>
                                    </c:when>
                                    <c:when test="${student.gpa >= 3.0}">
                                        <div class="gpa-badge" style="background-color: #d3f9f9; color: #0c8599;">
                                                ${student.gpa}
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="gpa-badge" style="background-color: #ffe8cc; color: #e8590c;">
                                                ${student.gpa}
                                        </div>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                        <tr>
                            <th><i class="bi bi-info-circle me-2"></i> Trạng thái</th>
                            <td>
                                <c:choose>
                                    <c:when test="${student.status == 'Đang học'}">
                                        <span class="badge px-3 py-2 fs-6 rounded-pill" style="background-color: #2b8a3e; color: #FFFFFF;">
                                            <i class="bi bi-check-circle-fill me-1"></i> ${student.status}
                                        </span>
                                    </c:when>
                                    <c:when test="${student.status == 'Bảo lưu'}">
                                        <span class="badge px-3 py-2 fs-6 rounded-pill" style="background-color: #e8590c; color: #FFFFFF;">
                                            <i class="bi bi-pause-circle-fill me-1"></i> ${student.status}
                                        </span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="badge px-3 py-2 fs-6 rounded-pill" style="background-color: #0c8599; color: #FFFFFF;">
                                            <i class="bi bi-graduation-cap-fill me-1"></i> ${student.status}
                                        </span>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="card-footer bg-white border-0 pb-4 text-center">
                    <a href="${studentsUrl}" class="btn btn-back">
                        <i class="bi bi-arrow-left me-2"></i>Quay lại danh sách
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>