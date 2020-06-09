<%@page contentType="text/html; charset=utf-8"%>
<%@page import="model.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html class="no-js" lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>CS24/7 | Your Store</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="<c:url value='/css/plugins.css' />">

<link rel="stylesheet" href="<c:url value='/css/common.css' />">
<link rel="stylesheet" href="<c:url value='/css/main.css' />">

</head>
<body>
	<!-- Navigation Start  -->
	<nav class="navbar navbar-default navbar-sticky bootsnav">

		<div class="container">
			<!-- Start Header Navigation -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#navbar-menu">
					<i class="fa fa-bars"></i>
				</button>
				<a class="navbar-brand" href="<c:url value='/master/main' />"><img
					src="<c:url value='/img/CS247_main_l.png' />" class="logo" alt=""></a>
			</div>
			<!-- End Header Navigation -->

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="navbar-menu">
				<ul class="nav navbar-nav navbar-right" data-in="fadeInDown"
					data-out="fadeOutUp">
					<li><a href="<c:url value='/master/main' />">Home</a></li>
					<c:if test="${empty userId}">
						<li><a href="<c:url value='/user/register/choose' />">Register</a></li>
						<li><a href="<c:url value='/user/login/choose' />">Login</a></li>
					</c:if>
					<c:if test="${!empty userId }">
						<li><a><c:out value="${userId}" />님</a></li>
						<li><a href="<c:url value='/user/master/mypage' />">MyPage</a></li>
						<li><a href="<c:url value='/user/logout' />">Logout</a></li>
					</c:if>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
	</nav>
	<!-- Navigation End  -->

	<section class="features">
		<div class="container">
			<div class="col-md-4 col-sm-4">
				<div class="features-content">
					<br> <br> <br> <br> <br> <span
						class="box1"><span aria-hidden="true" class="icon-dial"></span></span>
					<a href="<c:url value='/master/showStock' />">
						<h3>매장 재고 확인</h3>
					</a>
					<p>당신의 매장 내 재고를 확인해보세요!</p>
					<br> <br> <br> <br> <br>
				</div>
			</div>

			<div class="col-md-4 col-sm-4">
				<div class="features-content">
					<br>
					<br>
					<br>
					<br>
					<br> <span class="box1"><span aria-hidden="true"
						class="icon-search"></span></span> <a
						href="<c:url value='/master/showReservation' />">
						<h3>제품 예약 내역</h3>
					</a>
					<p>당신의 매장에 예약된 상품 내역을 확인해보세요!</p>
					<br>
					<br>
					<br>
					<br>
					<br>
				</div>
			</div>

			<div class="col-md-4 col-sm-4">
				<div class="features-content">
					<br>
					<br>
					<br>
					<br>
					<br> <span class="box1"><span aria-hidden="true"
						class="icon-printer"></span></span> <a
						href="<c:url value='/master/showCount' />">
						<h3>제품 검색 현황</h3>
					</a>
					<p>일주일간 가장 인기있었던 상품을 확인해보세요!</p>
					<br>
					<br>
					<br>
					<br>
					<br>
				</div>
			</div>
		</div>
	</section>

	<!-- footer start -->
	<footer>
		<div class="container">
			<div class="col-md-3 col-sm-6">
				<h4>Featured Job</h4>
				<ul>
					<li><a href="#">Browse Jobs</a></li>
					<li><a href="#">Premium MBA Jobs</a></li>
					<li><a href="#">Access Database</a></li>
					<li><a href="#">Manage Responses</a></li>
					<li><a href="#">Report a Problem</a></li>
					<li><a href="#">Mobile Site</a></li>
					<li><a href="#">Jobs by Skill</a></li>
				</ul>
			</div>

			<div class="col-md-3 col-sm-6">
				<h4>Latest Job</h4>
				<ul>
					<li><a href="#">Browse Jobs</a></li>
					<li><a href="#">Premium MBA Jobs</a></li>
					<li><a href="#">Access Database</a></li>
					<li><a href="#">Manage Responses</a></li>
					<li><a href="#">Report a Problem</a></li>
					<li><a href="#">Mobile Site</a></li>
					<li><a href="#">Jobs by Skill</a></li>
				</ul>
			</div>

			<div class="col-md-3 col-sm-6">
				<h4>Reach Us</h4>
				<address>
					<ul>
						<li>60 Hwarang-ro 13-gil, Wolgok 2-dong, Seongbuk-gu, Seoul<br>
							Republic of Korea
						</li>
						<li>Email: CS24_7@gmail.com</li>
						<li>Call: 02 940 4000</li>
						<li>Skype: CS24_7@skype</li>
						<li>FAX: 02 940 4182</li>
					</ul>
				</address>
			</div>

			<div class="col-md-3 col-sm-6">
				<h4>Drop A Mail</h4>
				<form>
					<input type="text" class="form-control input-lg"
						placeholder="Your Name"> <input type="text"
						class="form-control input-lg" placeholder="Email...">
					<textarea class="form-control" placeholder="Message"></textarea>
					<button type="submit" class="btn btn-primary">Send</button>
				</form>
			</div>


		</div>
		<div class="copy-right">
			<p>
				&copy;Copyright NEWMAN Corporation | Design By <a
					href="https://themezhub.com/">ThemezHub</a>
			</p>
		</div>
	</footer>
</body>
</html>