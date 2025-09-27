<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Bootstrap CSS -->
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

<div class="container mt-5">
    <div class="card shadow" style="max-width:400px;margin:auto;">
        <div class="card-body text-center">
            <!-- Avatar -->
            <c:url value="/avatar" var="imgUrl">
                <c:param name="fname" value="${account.avatar}" />
            </c:url>
            <img src="${imgUrl}" class="img-profile rounded-circle mb-3" style="width:100px;height:100px;object-fit:cover;border:2px solid #007bff;">

            <!-- Thông tin -->
            <h4 class="mb-3">${account.fullname}</h4>
            <p class="mb-1"><strong>Email:</strong> ${account.email}</p>

            <!-- Nút thay đổi -->
            <button class="btn btn-outline-primary mt-3" type="button" data-toggle="collapse" data-target="#editProfile" aria-expanded="false" aria-controls="editProfile">
                Thay đổi thông tin
            </button>

            <!-- Form chỉnh sửa (ẩn/hiện khi bấm nút) -->
            <div class="collapse mt-4" id="editProfile">
                <form method="post" action="updateProfile" 	enctype="multipart/form-data">
                    <div class="form-group text-left">
                        <label for="email">Email</label>
                        <input type="text" class="form-control" id="email" name="email"
                               value="${account.email}" required>
                    </div>
                    <div class="form-group text-left">
                        <label for="fullname">Họ tên</label>
                        <input type="text" class="form-control" id="fullname" name="fullname"
                               value="${account.fullname}" required>
                    </div>
                    <!-- Có thể bổ sung upload avatar ở đây nếu muốn -->
                    <div class="form-group text-left">
                        <label for="avatar">Đổi ảnh đại diện (avatar)</label>
                        <input type="file" class="form-control-file" id="avatar" name="avatar" accept="image/*">
                    </div>
                    <button type="submit" class="btn btn-primary btn-block">Lưu thay đổi</button>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS (đặt trước </body>) -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>