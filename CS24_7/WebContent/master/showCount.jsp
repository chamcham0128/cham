<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

<link rel="icon" href="img/favicon.png" type="image/png">
<title>MeetMe Personal</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="vendors/linericon/style.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="vendors/owl-carousel/owl.carousel.min.css">
<link rel="stylesheet" href="vendors/lightbox/simpleLightbox.css">
<link rel="stylesheet" href="vendors/nice-select/css/nice-select.css">
<link rel="stylesheet" href="vendors/animate-css/animate.css">
<link rel="stylesheet" href="vendors/popup/magnific-popup.css">
<!-- main css -->
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/responsive.css">
<title>CS24/7 | Statistic</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- All Plugin Css -->
<link rel="stylesheet" href="<c:url value='/css/plugins.css' />">

<!-- Style & Common Css -->
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



	<!-- Inner Banner -->



	<section class="jobs">
		<div class="container">
			<c:forEach var="rank" items="${countList}" varStatus="status">
				<form method="post"
					action="<c:url value="/master/showCount">
                 <c:param name="pname" value="${rank.pname}"/>
                 <c:param name="count" value="${rank.count}"/>
                 <c:param name="catno" value="${rank.catno}"/>
            </c:url>">
					<div class="company-list">
						<div class="row">
							<div class="col-md-2 col-sm-2">
								<div class="row heading">
									<h1>${status.index + 1}</h1>
								</div>
							</div>
							<div class="col-md-8 col-sm-8">
								<div class="company-content">
									<h3>${rank.pname}</h3>
									<p>
										<span class="company-name">상품명 :${rank.pname}</span><span
											class="company-location"> 검색 횟수 : ${rank.count}</span><span
											class="package">카테고리 번호 : ${rank.catno}</span>

									</p>
								</div>
							</div>
							<div class="col-md-2 col-sm-2">
								<h1>${rank.count}번</h1>
							</div>
						</div>
					</div>
				</form>
			</c:forEach>
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






