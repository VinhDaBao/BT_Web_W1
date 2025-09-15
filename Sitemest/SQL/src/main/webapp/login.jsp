<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

    <style>
        body {
            background: linear-gradient(135deg, #74ebd5 0%, #9face6 100%);
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            font-family: Arial, sans-serif;
        }
        .login-card {
            background: #fff;
            border-radius: 15px;
            box-shadow: 0 10px 25px rgba(0,0,0,0.2);
            padding: 30px;
            width: 100%;
            max-width: 400px;
        }
        .login-card h2 {
            text-align: center;
            margin-bottom: 25px;
            font-weight: bold;
            color: #333;
        }
        .form-control:focus {
            box-shadow: none;
            border-color: #6a82fb;
        }
        .btn-custom {
            background: #6a82fb;
            color: #fff;
            font-weight: bold;
            border-radius: 25px;
        }
        .btn-custom:hover {
            background: #5a72ea;
        }
    </style>
</head>
<body>
    <div class="login-card">
        <h2>Đăng nhập</h2>
        
        <!-- Hiển thị thông báo nếu có -->
        <c:if test="${alert != null}">
            <div class="alert alert-danger">${alert}</div>
        </c:if>

        <form action="login" method="post">
            <div class="mb-3 input-group">
                <span class="input-group-text"><i class="fa fa-user"></i></span>
                <input type="text" name="username" class="form-control" placeholder="Tên đăng nhập" required>
            </div>
            <div class="mb-3 input-group">
                <span class="input-group-text"><i class="fa fa-lock"></i></span>
                <input type="password" name="password" class="form-control" placeholder="Mật khẩu" required>
            </div>
            <button type="submit" class="btn btn-custom w-100">Đăng nhập</button>
        </form>
	<div class="text-center mt-2">
        <a href="forgotpassword.jsp">Quên mật khẩu?</a>
    </div>
        <div class="text-center mt-3">
            <small>Chưa có tài khoản? <a href="register.jsp">Đăng ký ngay</a></small>
        </div>
    </div>
</body>
</html>
