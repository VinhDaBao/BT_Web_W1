<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="edit" var="edit"></c:url>
<form role="form" action="${edit}" method="post"
	enctype="multipart/form-data">
	<input name="id" value="${category.cateid }" hidden="">
	<div class="form-group">
		<label>Tên danh sách:</label> <input type="text" class="form-control"
			value="${category.catename }" name="name" />
	</div>
<div class="form-group">
    <c:url value="/image" var="imgUrl">
        <c:param name="fname" value="${category.icon}" />
    </c:url>
    <img class="img-responsive" width="100px" src="${imgUrl}" alt="">
    <label>Ảnh đại diện</label>
    <input type="file" name="icon" />
</div>
	<button type="submit" class="btn btn-default">Edit</button>
	<button type="reset" class="btn btn-primary">Reset</button>
</form>