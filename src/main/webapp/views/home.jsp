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
						<c:if test="${sessionScope.account.role == true }">
							<li class="nav-item"><a class="nav-link"
								href="/home/product"> <i class="bi bi-person-lines-fill"></i>
									<b>Danh Sách Sản Phẩm</b>
							</a></li>
						</c:if>
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
													<li><a class="dropdown-item"
														href="/home/order/admin/list-order"> <i
															class="bi bi-clock-history"></i> Danh Sách Mua Hàng
													</a></li>
												</c:if>
												<c:if test="${sessionScope.account.role != true }">
													<li><a class="dropdown-item"
														href="/home/order/showOrderByAccount"> <i
															class="bi bi-clock-history"></i> Lịch sử mua hàng
													</a></li>
												</c:if>
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
		<!-- 					END NAV									 -->

		<!-- 					HEADER									 -->
		<div
			class="header text-center border-bottom border-secondary border-5">
			<div class="row">
				<div class="col-sm-12">
					<a href="/home"><img
						src="${pageContext.request.contextPath}/img/banner.png"
						style="width: 100%; height: 400px;" alt=""></a>
				</div>
			</div>
			<div class="carousel-run">
				<div class="row bg-dark p-0">
					<div class="col-sm-4 p-0 m-0">
						<div id="carouselExampleInterval" class="carousel slide"
							data-bs-ride="carousel">
							<div class="carousel-inner">
								<div class="carousel-item active" data-bs-interval="2000">
									<a href="#!viewTest/{{sj.Id}}"><img
										src="${pageContext.request.contextPath}/img/carousel1.jpg"
										style="max-width: 100%; height: 180px" class="d-block w-100"
										alt="..."></a>
								</div>
								<div class="carousel-item border border-secondary"
									data-bs-interval="2000">
									<a href="#!viewTest/{{sj.Id}}"><img
										src="${pageContext.request.contextPath}/img/Aug.png"
										style="max-width: 100%; height: 180px" class="d-block w-100"
										alt="..."></a>
								</div>
								<div class="carousel-item" data-bs-interval="2000">
									<a href="#!viewTest/{{sj.Id}}"><img
										src="${pageContext.request.contextPath}/img/carousel4.jpg"
										style="max-width: 100%; height: 180px" class="d-block w-100"
										alt="..."></a>
								</div>
							</div>
						</div>
					</div>
					<div class="col-sm-4 p-0 m-0">
						<div id="carouselExampleInterval1" class="carousel slide"
							data-bs-ride="carousel">
							<div class="carousel-inner">
								<div class="carousel-item" data-bs-interval="2000">
									<img src="${pageContext.request.contextPath}/img/carousel1.jpg"
										style="max-width: 100%; height: 180px" class="d-block w-100"
										alt="...">
								</div>
								<div class="carousel-item active" data-bs-interval="2000">
									<img src="${pageContext.request.contextPath}/img/Aug.png"
										style="max-width: 100%; height: 180px" class="d-block w-100"
										alt="...">
								</div>
								<div class="carousel-item" data-bs-interval="2000">
									<img src="${pageContext.request.contextPath}/img/carousel4.jpg"
										style="max-width: 100%; height: 180px" class="d-block w-100"
										alt="...">
								</div>
							</div>
						</div>
					</div>
					<div class="col-sm-4 p-0 m-0">
						<div id="carouselExampleInterval2" class="carousel slide"
							data-bs-ride="carousel">
							<div class="carousel-inner">
								<div class="carousel-item" data-bs-interval="2000">
									<img src="${pageContext.request.contextPath}/img/carousel1.jpg"
										style="max-width: 100%; height: 180px" class="d-block w-100"
										alt="...">
								</div>
								<div class="carousel-item" data-bs-interval="2000">
									<img src="${pageContext.request.contextPath}/img/Aug.png"
										style="max-width: 100%; height: 180px" class="d-block w-100"
										alt="...">
								</div>
								<div class="carousel-item active" data-bs-interval="2000">
									<img src="${pageContext.request.contextPath}/img/carousel4.jpg"
										style="max-width: 100%; height: 180px" class="d-block w-100"
										alt="...">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- 					END MENU							 -->

		<!-- 				CATEGORY LAYOUT -->
		<div class="row m-3">
			<h3>Danh Mục</h3>
			<hr>
			<c:forEach var="item" items="${listCategory}">
				<div class="col-sm-2">
					<a href="/home/category/${item.id}" class="">
						<div class=" card m-1 p-2">
							<div class="text-center">
								<input name="categoryId" hidden="true" value="${item.id}">
								<img class=" "
									src="${pageContext.request.contextPath}/images/${item.image}"
									style="width: 50px; height: 50px" alt="...">
							</div>
							<div class="card-body text-center">
								<h6 class="card-title">${item.name}</h6>
							</div>
						</div>
					</a>
				</div>
			</c:forEach>
		</div>

		<!-- 				PRODUCT LAYOUT -->
		<div class="row">
			<h1 class="text-white text-center bg-danger">Danh Sách Sản Phẩm</h1>
			<div class="m-3">
				<form action="/home" method="get">
					<div class="row col-12">
						<div class="col-6">
							<label>Sắp xếp theo</label> <select name="sort_by"
								class="form-control">
								<option value="id">Mặc Định</option>
								<option value="name">Tên Sản Phẩm</option>
								<option value="price">Giá</option>
								<option value="createDate">Ngày Đăng</option>
							</select>
						</div>
						<div class="col-6">
							<label>Thứ tự</label> <select name="sort_direction"
								class="form-control">
								<option value="asc">Tăng Dần</option>
								<option value="desc">Giảm Dần</option>
							</select>
						</div>
					</div>
					<button class="btn btn-primary">Lọc</button>
					<a class="btn btn-danger" href="/home">Reset</a>
				</form>
			</div>
			<article class="col-sm-12">
				<div class="row pl-3 m-2">
					<c:forEach var="item" items="${pageData.content}">
						<div class="col-sm-3  mb-3">
							<div class="card border border-primary" style="height: 450px">
								<div style="height: 400px">
									<a href="/home/product/detail/${item.id }"> <img
										src="${pageContext.request.contextPath}/images/${item.image }"
										style="height: 250px" class="card-img-top" alt="...">
									</a>
									<h3 class="card-title text-center">${item.name}</h3>
								</div>
								<div class="card-body" style="height: 100px">
									<div class="row">

										<div class="col-sm-6">
											<p class="card-text text-center">
												<b>$ ${item.price}</b>
											</p>
										</div>
										<div class="col-sm-6">
											<c:if test="${item.available == true}">
												<div class="card-text text-center">Còn Hàng</div>
											</c:if>
											<c:if test="${item.available != true}">
												<del class="card-text text-center text-danger">Hết
													Hàng</del>
											</c:if>
										</div>
									</div>
								</div>
								<div class="card-footer text-center">
									<c:if test="${item.available == true}">
										<a href="/shoppingCart/add/${item.id}" class="btn btn-primary"><i
											class="bi bi-cart3"></i> <b> Thêm</b></a>
									</c:if>
									<%-- <c:if test="${item.available == true}">
										<a class="btn btn-primary"><i
											class="bi bi-cart3"></i> <b>
												Thêm</b></a>
									</c:if> --%>

									<a href="/home/product/detail/${item.id }"
										class="btn btn-warning text-white"><i
										class="bi bi-ticket-detailed-fill"></i><b>Chi tiết</b></a>
								</div>
							</div>
						</div>

					</c:forEach>
				</div>
				<div class="d-flex justify-content-center">
					<ul class="pagination">
						<c:forEach begin="0" end="${pageData.totalPages - 1 }"
							varStatus="page">
							<li class="page-item"><a class="page-link"
								href="/home?page=${page.index}">${page.index + 1}</a></li>
						</c:forEach>
					</ul>
				</div>
			</article>
		</div>
		<!-- 						FOOTER 									 -->
		<footer>
			<div class="row p-5">
				<div class="col-sm-4">
					<p class="text-center">
						<img src="./images/Fpoly_white.png" alt="">
					</p>
					<div class="clearfix wrapper-social"
						style="margin-top: 10px; display: flex; justify-content: center;">
						<div class="pull-left" style="margin-right: 15px;">
							<a href="https://www.facebook.com/fpt.poly" target="_blank"
								rel="noopener noreferrer"><img
								class="img-responsive lazyloaded"
								src="https://caodang.fpt.edu.vn/wp-content/themes/poly-2015/images/ico-fb-landing.png"
								data-ll-status="loaded">
								<noscript>
									<img class="img-responsive"
										src="https://caodang.fpt.edu.vn/wp-content/themes/poly-2015/images/xico-fb-landing.png.pagespeed.ic.7wvYx5wg-6.webp" />
								</noscript></a>
						</div>
						<div class="pull-left" style="margin-right: 15px;">
							<a
								href="https://www.youtube.com/channel/UCHXm-vzOfAuLucVBKDUfhvQ"
								target="_blank" rel="noopener noreferrer"><img
								class="img-responsive lazyloaded"
								src="https://caodang.fpt.edu.vn/wp-content/themes/poly-2015/images/ico-youtube-landing.png"
								data-ll-status="loaded">
								<noscript>
									<img class="img-responsive"
										src="https://caodang.fpt.edu.vn/wp-content/themes/poly-2015/images/xico-youtube-landing.png.pagespeed.ic.1X68wukCQj.webp" />
								</noscript> </a>
						</div>
						<div class="pull-left" style="margin-right: 15px;">
							<a href="https://www.tiktok.com/@fptpolytechnic?lang=en"
								target="_blank" rel="noopener noreferrer"><img
								class="img-responsive lazyloaded"
								src="https://caodang.fpt.edu.vn/wp-content/uploads/icon-tiktok.png"
								data-ll-status="loaded">
								<noscript>
									<img class="img-responsive"
										src="https://caodang.fpt.edu.vn/wp-content/uploads/xicon-tiktok.png.pagespeed.ic.vlzCpD1E6j.webp" />
								</noscript> </a>
						</div>
						<div class="pull-left">
							<a
								href="http://vi.wikipedia.org/wiki/Tr%C6%B0%E1%BB%9Dng_Cao_%C4%91%E1%BA%B3ng_Th%E1%BB%B1c_h%C3%A0nh_FPT"
								target="_blank" rel="noopener noreferrer"><img
								class="img-responsive lazyloaded"
								src="https://caodang.fpt.edu.vn/wp-content/themes/poly-2015/images/ico-wiki-landing.png"
								data-ll-status="loaded">
								<noscript>
									<img class="img-responsive"
										src="https://caodang.fpt.edu.vn/wp-content/themes/poly-2015/images/xico-wiki-landing.png.pagespeed.ic.aC7_ZAw9LQ.webp" />
								</noscript> </a>
						</div>
					</div>
					<div class="phone d-flex justify-content-center "
						style="padding-top: 30px;">
						<div class="title">
							<p class="text-warning fs-3">
								<b> THÔNG TIN LIÊN HỆ</b>
							</p>
							<p class="text-white fs-6">Điện Thoại : 0989898989</p>
							<p class="text-white fs-6">Email: caodang@fpt.edu.vn</p>
						</div>
					</div>
				</div>
				<div class="col-sm-8">
					<h3 class="text-warning">HỆ THỐNG VĂN PHÒNG FPT</h3>

					<div class="row">
						<div class="col-sm-6 pt-3">
							<div class="Hanoi text-white pb-3">
								<p class="fs-4">
									<u>Cơ sở Hà Nội</u>
								</p>
								<p>
									<i class="bi bi-pin-map-fill text-warning"></i> Văn phòng tuyển
									sinh: Toà nhà FPT Polytechnic , Phố Trịnh Văn Bô, phường Phương
									Canh, quận Nam Từ Liêm, TP Hà Nội
								</p>
								<p>
									<i class="bi bi-telephone-inbound-fill text-warning"></i>
									0989898989
								</p>
							</div>
							<div class="HaiPhong text-white">
								<p class="fs-4">
									<u>Cơ sở Hải Phòng</u>
								</p>
								<p>
									<i class="bi bi-pin-map-fill text-warning"></i> Văn phòng tuyển
									sinh: 271 Lê Thánh TÔng, phường Máy Chai, quận Ngô Quyền, TP
									Hải Phòng
								</p>
								<p>
									<i class="bi bi-telephone-inbound-fill text-warning"></i>
									0989898989
								</p>
							</div>
						</div>
						<div class="col-sm-6 pt-3">
							<div class="HCM text-white pb-3">
								<p class="fs-4">
									<u>Cơ sở Hồ Chí Minh</u>
								</p>
								<p>
									<i class="bi bi-pin-map-fill text-warning"></i> Văn phòng tuyển
									sinh: 778/B1 Nguyễn Kiệm, phường 4, quận Phú Nhuận, TP Hồ Chí
									Minh
								</p>
								<p>
									<i class="bi bi-telephone-inbound-fill text-warning"></i>
									0989898989
								</p>
							</div>
							<div class="TayNguyen text-white">
								<p class="fs-4">
									<u>Cơ sở Tây Nguyên</u>
								</p>
								<p>
									<i class="bi bi-pin-map-fill text-warning"></i> Văn phòng tuyển
									sinh: Tổ dân phố 8, phường Tân An, TP.Buoom Ma Thuật, Đắc Lắk
								</p>
								<p>
									<i class="bi bi-telephone-inbound-fill text-warning"></i>
									0989898989
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</footer>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

</body>

</html>