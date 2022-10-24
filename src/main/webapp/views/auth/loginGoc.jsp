<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<style>
.header {
	position: relative;
}

.runImg {
	position: absolute;
	top: 250px;
	left: 500px;
}

footer {
	background-color: hsl(255, 80%, 36%);
}

#navbar {
	position: sticky;
	position: -webkit-sticky;
}

#navbar a:hover {
	background-color: #ddd;
	color: black;
}

.header {
	position: relative;
}

.carousel-run {
	position: absolute;
	bottom: 0%;
	right: 0;
	width: 60%;
	height: 100px;
}
</style>
<style>
.header {
	position: relative;
}

.runImg {
	position: absolute;
	top: 250px;
	left: 500px;
}

footer {
	background-color: hsl(255, 80%, 36%);
}

#navbar {
	position: sticky;
	position: -webkit-sticky;
}

#navbar a:hover {
	background-color: #ddd;
	color: black;
}

.header {
	position: relative;
}

.carousel-run {
	position: absolute;
	bottom: 0%;
	right: 0;
	width: 60%;
	height: 200px;
}
</style>
</head>

<body>
	<div class="container-fluid p-0">
		<nav
			class="navbar navbar-expand-lg navbar-light bg-warning text-white  fixed-top p-0"
			id="navbar" id="navbar-example2">
			<div class="container-fluid">
				<a class="navbar-brand" href="/home"><img src="../img/huong.png"
					style="width: 60px; height: 40px;" alt=""> Home </a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#!about"> Giới thiệu</a></li>
						<li class="nav-item"><a class="nav-link" href="#!contact">Liên
								Hệ</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/shoppingCart/list">Shop Cart</a></li>
						<li class="nav-item"><a class="nav-link" href="/home/product">Danh
								Sách Sản Phẩm</a></li>
					</ul>
					<div class="d-flex">
						<div class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="#"
								id="navbarScrollingDropdown" role="button"
								data-bs-toggle="dropdown" aria-expanded="false"> Tài Khoản </a>
							<ul class="dropdown-menu"
								aria-labelledby="navbarScrollingDropdown">
								<c:if test="${sessionScope.user == null }"><li><a class="dropdown-item" href="/login">Đăng Nhập</a></li></c:if>
								<c:if test="${sessionScope.admin == null }"><li><a class="dropdown-item" href="#">CRUD</a></li></c:if>
								<li><a class="dropdown-item" href="#">Đổi Mật Khẩu</a></li>
								
								<li><hr class="dropdown-divider"></li>
								<li><a class="dropdown-item" href="#">Something else
										here</a></li>
										<c:if test="${sessionScope.user == null }"><li><a class="dropdown-item" href="/logout">Đăng Xuất</a></li></c:if>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</nav>
		<!--  -->
	<div class="col-10 offset-1">
		<c:if test="${not empty sessionScope.error }">
			<div class="alert alert-danger">${sessionScope.error}</div>
			<c:remove var="error" scope="session"/>
		</c:if> 
		<div class="col-10 offset-1">
			<form action="/login" method="Post">
				<div class="mt-3">
					<label for="email">Email</label>
					<input type="" name="username" id="email"  class="form-control"/>
				</div>
				<div class="mt-3">
					<label for="password">password</label>
					<input type="password" name="password" id="password"  class="form-control"/>
				</div>
				<div class="mt-3">
					<button class="btn btn-primary ">Login</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>