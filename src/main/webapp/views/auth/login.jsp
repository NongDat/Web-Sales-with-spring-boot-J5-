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
	top: 350px;
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
	width: 50%;
	height: 180px;
}
</style>
</head>

<body>
	<div class="container-fluid p-0" style="background-color: #EEEEEE">
		<nav
			class="navbar navbar-expand-lg navbar-light bg-warning text-white  fixed-top p-0"
			id="navbar" id="navbar-example2">
			<div class="container-fluid">
				<a class="navbar-brand" href="/home"> <img
					src="${pageContext.request.contextPath}/images/logo.png"
					style="width: 80px; height: 60px;" alt=""> <i
					class="bi bi-house-door"></i> <b>Home</b>
				</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse text-dark"
					id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#!about"> <i
								class="bi bi-person-lines-fill"></i> <b>Giới thiệu</b>
						</a></li>
						<c:if test="${sessionScope.account.role == true}">
							<li class="nav-item"><a class="nav-link" href="#!contact">
									<i class="bi bi-download"></i> <b>Thêm Tài Khoản</b>
							</a></li>
						</c:if>

						<li class="nav-item"><a class="nav-link"
							href="/shoppingCart/list"> <i class="bi bi-cart-check"></i> <b>Giỏ
									Hàng</b>
						</a></li>
						<li class="nav-item"><a class="nav-link" href="/home/product">
								<i class="bi bi-person-lines-fill"></i> <b>Danh Sách Sản
									Phẩm</b>
						</a></li>
					</ul>
					<div class="d-flex ">
						<div class="nav-item dropdown">
							<c:if test="${sessionScope.account != null }">
								<div class="row" style="margin-right: 3px">
									<div class="col-sm-2 d-flex align-items-center">
										<img class="rounded-circle" width="30px"
											src="${pageContext.request.contextPath}/images/${sessionScope.account.photo}">
									</div>
									<div class="col-sm-8 p-0 m-0">
										<a class="nav-link dropdown-toggle" href="#"
											id="navbarScrollingDropdown" role="button"
											data-bs-toggle="dropdown" aria-expanded="false"> <b>${sessionScope.account.fullname }</b>
										</a>
										<ul class="dropdown-menu"
											aria-labelledby="navbarScrollingDropdown">
											<c:if test="${sessionScope.account != null }">
												<li><a class="dropdown-item"
													href="/home/account/EditProfile?action=AddOrEdit&username=${sessionScope.account.username}">
														<i class="bi bi-person-badge-fill"></i> Tài Khoản Của Tôi
												</a></li>
												<c:if test="${sessionScope.account.role == true }">
													<li><a class="dropdown-item"
														href="/home/account/listAccount"> <i
															class="bi bi-person-lines-fill"></i> Danh sách Tài Khoản
													</a></li>
													<li><a class="dropdown-item"
														href="/home/account/newAccount"> <i
															class="bi bi-download"></i> Thêm Tài Khoản
													</a></li>
												</c:if>
												<li><a class="dropdown-item"
													href="/home/order/showOrderByAccount"> <i
														class="bi bi-clock-history"></i> Lịch sử mua hàng
												</a></li>
												<li><a class="dropdown-item" href="/logout"> <i
														class="bi bi-bug-fill"></i> Hỗ Trợ
												</a></li>
												<li><a class="dropdown-item" href="/logout"> <i
														class="bi bi-box-arrow-right"></i> Đăng Xuất
												</a></li>
											</c:if>
										</ul>
									</div>
								</div>
							</c:if>
							<!--No Name-->
							<c:if test="${sessionScope.account == null }">
								<div class="row">
									<a class="nav-link dropdown-toggle" style="width: 180px"
										href="#" id="navbarScrollingDropdown" role="button"
										data-bs-toggle="dropdown" aria-expanded="false"> <b>Tài
											Khoản</b>
									</a>
									<ul class="dropdown-menu"
										aria-labelledby="navbarScrollingDropdown">
										<li><a class="dropdown-item" href="/login">Đăng Nhập</a></li>
										<li><a class="dropdown-item"
											href="/home/account/register">Đăng Ký</a></li>
										<li><a class="dropdown-item" href="/logout">Hỗ Trợ</a></li>
									</ul>
								</div>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</nav>
		<!--	END NAV				  -->
		<section class="vh-100">
			<div class="container-fluid">
				<div class="row">
					<div class="col-sm-6 text-black">

						
						<div class="d-flex align-items-center h-custom-2 px-5 ms-xl-4 mt-1 pt-2 pt-xl-0 mt-xl-n5">

							<form:form style="width: 23rem;" action="/login" method="Post" modelAttribute="AccountLoginDTO">

								<h1 class="fw-normal mb-3 pb-3 text-center" style="letter-spacing: 1px;">
									<b>Đăng Nhập</b>
								</h1>
								<div class="form-outline mb-4">
									 <label class="form-label" for="form2Example18">
									 	UserName
									 </label>
									<form:input path="username"  type="text" id="form2Example18" name="username" class="form-control form-control-lg" />
									<form:errors path="username" element="div" cssClass="text-danger"/>
								</div>

								<div class="form-outline mb-4">
									<label class="form-label" for="form2Example28">
										Password
									</label>
									<form:input path="password" type="password" name="password" id="form2Example28"
										class="form-control form-control-lg" /> 
									<form:errors path="password" element="div" cssClass="text-danger"/>
								</div>
								<c:if test="${not empty sessionScope.errorLogin }">
									<div class="alert alert-danger">${sessionScope.errorLogin}</div>
									<c:remove var="errorLogin" scope="session" />
								</c:if>
								<div class="pt-1 mb-4">
									<button class="btn btn-info btn-lg btn-block" type="submit">Login</button>
								</div>

								<p class="small mb-5 pb-lg-2">
									<a class="text-muted" href="#!">Forgot password?</a>
								</p>
								<p>
									Don't have an account? <a href="/home/account/register" class="link-info">Register
										here</a>
								</p>

							</form:form>

						</div>

					</div>
					<div class="col-sm-6 px-0 d-none d-sm-block">
						<img
							src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/img3.webp"
							alt="Login image" class="w-100 vh-100"
							style="object-fit: cover; object-position: left;">
					</div>
				</div>
			</div>
		</section>
	</div>
</body>
</html>