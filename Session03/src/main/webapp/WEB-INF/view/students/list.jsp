<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách Sinh viên - StudentHub</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <style>
        * {
            font-family: 'Inter', sans-serif;
        }
        body {
            background-color: #f5f7fa;
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
        .main-card {
            border-radius: 12px;
            border: 1px solid #dee2e6;
            overflow: hidden;
            background: white;
        }
        .main-card .card-header {
            background-color: #e9ecef;
            border-bottom: 1px solid #dee2e6;
            padding: 1rem 1.5rem;
        }
        .filter-bar {
            background-color: #f8f9fa;
            padding: 1rem;
            border-radius: 8px;
            margin-bottom: 1.5rem;
            border: 1px solid #dee2e6;
        }
        .input-custom {
            border: 1px solid #dee2e6;
            border-radius: 999px;
            padding: 8px 14px;
            transition: all 0.2s ease;
            width: 100%;
        }
        .input-custom:focus {
            border-color: #adb5bd;
            box-shadow: 0 0 0 0.15rem rgba(0,0,0,0.05);
            outline: none;
        }
        .btn-custom {
            border-radius: 999px;
            padding: 8px 20px;
            font-weight: 500;
            border: 1px solid #dee2e6;
            background-color: #f8f9fa;
            color: #495057;
            transition: all 0.2s ease;
            text-decoration: none;
            display: inline-block;
        }
        .btn-custom:hover {
            background-color: #e9ecef;
            border-color: #ced4da;
            color: #212529;
        }
        .btn-primary-custom {
            border-radius: 999px;
            padding: 8px 20px;
            font-weight: 500;
            border: none;
            background-color: #212529;
            color: white;
            transition: all 0.2s ease;
            text-decoration: none;
            display: inline-block;
        }
        .btn-primary-custom:hover {
            background-color: #343a40;
            color: white;
        }
        .table-custom {
            border: 1px solid #dee2e6;
            border-radius: 8px;
            width: 100%;
        }
        .table-custom thead th {
            background-color: #f8f9fa;
            color: #495057;
            font-weight: 600;
            border: 1px solid #dee2e6;
            padding: 12px 8px;
        }
        .table-custom tbody td {
            border: 1px solid #dee2e6;
            padding: 10px 8px;
            vertical-align: middle;
        }
        .table-custom tbody tr:hover {
            background-color: #f8f9fa;
        }
        .badge-status {
            display: inline-flex;
            align-items: center;
            gap: 4px;
            padding: 6px 14px;
            border-radius: 999px;
            font-weight: 500;
            font-size: 0.85rem;
        }
        .sort-btn {
            border-radius: 6px;
            transition: all 0.2s ease;
            border: 1px solid #dee2e6;
            color: #495057;
            background-color: white;
            padding: 5px 12px;
            text-decoration: none;
        }
        .sort-btn:hover {
            background-color: #f8f9fa;
            border-color: #ced4da;
            color: #212529;
        }
        .alert-custom {
            border-radius: 8px;
            background-color: #f8f9fa;
            border: 1px solid #dee2e6;
            color: #495057;
        }
        code {
            background: transparent;
            padding: 0;
            color: #212529;
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
            <a href="${dashboardUrl}" class="nav-link-custom me-3">Dashboard</a>
            <a href="${studentsUrl}" class="nav-link-custom active">Sinh viên</a>
        </div>
    </div>
</nav>

<div class="container">
    <div class="row mb-4">
        <div class="col-12">
            <h2 class="fw-bold mb-2" style="color: #212529;">Quản lý sinh viên</h2>
            <p style="color: #6c757d;">Tìm kiếm, lọc và xem thông tin chi tiết</p>
        </div>
    </div>

    <div class="main-card">
        <div class="card-header">
            <h5 class="mb-0 fw-bold" style="color: #212529;">
                Danh sách Sinh viên
            </h5>
        </div>
        <div class="card-body p-4">

            <div class="filter-bar">
                <div class="row g-3 align-items-end">
                    <div class="col-md-4">
                        <label class="form-label text-muted small mb-1" style="font-weight: 600;">Tìm kiếm</label>
                        <input type="text" class="input-custom" id="searchInput"
                               placeholder="Nhập tên sinh viên..." value="${searchKeyword}">
                    </div>
                    <div class="col-md-3">
                        <label class="form-label text-muted small mb-1 fon" style="font-weight: 600;">Lọc khoa</label>
                        <input type="text" class="input-custom" id="facultyInput"
                               placeholder="Nhập tên khoa..." value="${facultyKeyword}">
                    </div>
                    <div class="col-md-auto ms-auto">
                        <a href="#" class="btn-primary-custom" id="searchBtn">
                            <i class="bi bi-search me-1"></i> Tìm kiếm
                        </a>
                    </div>
                    <div class="col-md-auto">
                        <a href="${studentsUrl}" class="btn-custom">
                            Xem tất cả
                        </a>
                    </div>
                </div>
            </div>

            <c:if test="${isFiltering}">
                <div class="alert alert-custom alert-dismissible fade show mb-3">
                    <i class="bi bi-check-circle-fill me-2"></i>
                    <strong>Tìm thấy ${resultCount} sinh viên</strong> phù hợp
                    <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                </div>
            </c:if>

            <c:if test="${isFiltering == false}">
                <div class="mb-3 d-flex gap-2 align-items-center">
                    <span class="text-muted small">Sắp xếp theo:</span>
                    <a href="${studentsUrl}?sortBy=name" class="sort-btn btn-sm"  style="border-radius: 999px; border: 1px solid #dee2e6; color: #495057; background: white; padding: 5px 12px; text-decoration: none;">
                        <i class="bi bi-sort-alpha-down me-1"></i>Tên
                    </a>
                    <a href="${studentsUrl}?sortBy=gpa" class="sort-btn btn-sm"  style="border-radius: 999px; border: 1px solid #dee2e6; color: #495057; background: white; padding: 5px 12px; text-decoration: none;">
                        <i class="bi bi-sort-numeric-down-alt me-1"></i>GPA
                    </a>
                </div>
            </c:if>

            <div class="table-responsive">
                <table class="table table-custom">
                    <thead>
                    <tr>
                        <th style="width: 5%; text-align: center;">STT</th>
                        <th style="width: 12%;">Mã SV</th>
                        <th style="width: 20%;">Họ tên</th>
                        <th style="width: 20%;">Khoa</th>
                        <th style="width: 12%;">Năm nhập học</th>
                        <th style="width: 10%;">GPA</th>
                        <th style="width: 13%;">Trạng thái</th>
                        <th style="width: 8%; text-align: center;">Chi tiết</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${students}" var="s" varStatus="loop">
                        <tr>
                            <td style="text-align: center;">${loop.count}</td>
                            <td><code>${s.studentCode}</code></td>
                            <td><strong>${s.fullName}</strong></td>
                            <td>${s.faculty}</td>
                            <td>${s.enrollmentYear}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${s.gpa >= 3.6}">
                                        <span class="fw-bold" style="color: #2b8a3e;">${s.gpa}</span>
                                    </c:when>
                                    <c:when test="${s.gpa >= 3.0}">
                                        <span class="fw-bold" style="color: #0c8599;">${s.gpa}</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="fw-bold" style="color: #e8590c;">${s.gpa}</span>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${s.status == 'Đang học'}">
                                        <span class="badge-status" style="background-color: #d3f9d8; color: #2b8a3e;">
                                            <i class="bi bi-check-circle-fill"></i> ${s.status}
                                        </span>
                                    </c:when>
                                    <c:when test="${s.status == 'Bảo lưu'}">
                                        <span class="badge-status" style="background-color: #ffe8cc; color: #e8590c;">
                                            <i class="bi bi-pause-circle-fill"></i> ${s.status}
                                        </span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="badge-status" style="background-color: #d3f9f9; color: #0c8599;">
                                            <i class="bi bi-graduation-cap-fill"></i> ${s.status}
                                        </span>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td style="text-align: center;">
                                <a href="${studentsUrl}/detail?id=${s.id}"
                                   class="btn-custom" style="padding: 4px 14px; font-size: 0.85rem;">
                                    <i class="bi bi-eye"></i> Xem
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script>
    (() => {
        const searchBtn = document.getElementById('searchBtn');
        if (!searchBtn) return;

        const studentsUrl = '${studentsUrl}';
        const searchInput = document.getElementById('searchInput');
        const facultyInput = document.getElementById('facultyInput');

        const doSearch = () => {
            const search = searchInput ? searchInput.value.trim() : '';
            const faculty = facultyInput ? facultyInput.value.trim() : '';

            const params = [];
            if (search) params.push('search=' + encodeURIComponent(search));
            if (faculty) params.push('faculty=' + encodeURIComponent(faculty));

            let url = studentsUrl;
            if (params.length > 0) {
                url = studentsUrl + '?' + params.join('&');
            }
            window.location.href = url;
        };

        searchBtn.addEventListener('click', (e) => {
            e.preventDefault();
            doSearch();
        });
    })();
</script>

</body>
</html>