<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Danh sách danh mục</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h2 class="mb-3">Danh sách danh mục</h2>

    <table class="table table-bordered table-hover">
        <thead class="table-light">
            <tr>
                <th>#</th>
                <th>Ảnh đại diện</th>
                <th>Tên danh mục</th>
                <th>Thao tác</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${cateList}" var="cate" varStatus="st">
            <tr>
                <!-- Số thứ tự -->
                <td>${st.index + 1}</td>

                <!-- Ảnh: load qua servlet /image -->
                <td>
                    <c:url value="/image" var="imgUrl">
                        <c:param name="fname" value="${cate.icon}" />
                    </c:url>
                    <img src="${imgUrl}" alt="icon" width="120" height="100"/>
                </td>

                <!-- Tên danh mục -->
                <td>${cate.catename}</td>

                <!-- Link edit & delete -->
                <td>
                    <c:url value="/edit" var="editUrl">
                        <c:param name="id" value="${cate.cateid}" />
                    </c:url>

                    <c:url value="/delete" var="deleteUrl">
                        <c:param name="id" value="${cate.cateid}" />
                    </c:url>

                    <a href="${editUrl}" class="btn btn-sm btn-primary">Sửa</a>
                    <a href="${deleteUrl}" class="btn btn-sm btn-danger"
                       onclick="return confirm('Bạn có chắc muốn xóa?');">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="mt-3">
    <c:url value="/add-category.jsp" var="addUrl" />
    <a href="${addUrl}" class="btn btn-success btn-lg">
        ➕ Thêm danh mục
    </a>
</div>
    
</div>
</body>
</html>
