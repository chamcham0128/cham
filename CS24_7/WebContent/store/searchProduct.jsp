<%@page contentType="text/html; charset=utf-8"%>
<%@page import="model.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html class="no-js" lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>CS24/7 | Search Product</title>
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
				<a class="navbar-brand" href="<c:url value='/' />"> <img
					src="<c:url value='/img/CS247_main_l.png' />" class="logo" alt="">
				</a> <a class="navbar-brand" href="<c:url value='/' />"> </a>
			</div>
			<!-- End Header Navigation -->

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="navbar-menu">
				<ul class="nav navbar-nav navbar-right" data-in="fadeInDown"
					data-out="fadeOutUp">

					<li><a href="<c:url value='/' />">Home</a></li>
					<c:if test="${empty userId}">
						<li><a href="<c:url value='/user/register/choose' />">Register</a></li>
						<li><a href="<c:url value='/user/login/choose' />">Login</a></li>
					</c:if>
					<c:if test="${!empty userId }">
						<li><a><c:out value="${userId}" />님</a></li>
						<li><a href="<c:url value='/user/customer/mypage' />">MyPage</a></li>
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
			<div class="row heading">
				<h2>Find you want!</h2>
				<p>가장 가까운 매장을 확인해보세요.</p>
				<div class="row top-pad">
					<div class="filter">
						<div class="col-md-2 col-sm-3">
							<p>Another?</p>
						</div>

						<div class="col-md-10 col-sm-9 pull-right">
							<form name="form" method="POST"
								action="<c:url value='/store/searchProduct' />">

								<div class="col-md-4 col-sm-4 no-pad">
									<input type="text" class="form-control"
										placeholder="Write here!" name="pname" />
								</div>

								<div class="col-md-4 col-sm-4 no-pad">
									<select class="selectpicker form-control" name="catno">
										<option value="1">음료/주류</option>
										<option value="2">과자/초콜릿/빵</option>
										<option value="3">간편식/라면/통조림</option>
										<option value="4">유제품</option>
										<option value="5">냉장식품</option>
										<option value="6">냉동식품</option>
										<option value="7">위생용품</option>
										<option value="8">의약외품</option>
										<option value="9">일회용품</option>
										<option value="10">문구/완구</option>
										<option value="11">잡화</option>
										<option value="12">담배</option>
										<option value="13">기타</option>
									</select>
								</div>
								<div class="col-md-2 col-sm-2 no-pad">
									<input type="submit" class="btn seub-btn form-control "
										value="submit" />
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="companies">
				<c:forEach var="product" items="${productList}">
					<form method="post"
						action="<c:url value="/store/showProduct">
                     		<c:param name="location" value="${product.location}"/>
                     		<c:param name="sname" value="${product.sname}"/>
                     		<c:param name="sbrand" value="${product.sbrand}"/>
                     		<c:param name="pname" value="${product.pname}"/>
                     		<c:param name="price" value="${product.price}"/>
                     		<c:param name="amount" value="${product.amount}"/>
                     		<c:param name="phone" value="${product.phone}"/>
                     		<c:param name="brand" value="${product.brand}"/>
                     		<c:param name="sno" value="${product.sno}"/>
                     		<c:param name="pno" value="${product.pno}"/>
                     		<c:param name="birth" value="${user.birth}"/>
                     		<c:param name="id" value="${user.id}"/>
                     		<c:param name="gender" value="${user.gender}"/>
                     		</c:url>">
						<div class="company-list">
							<div class="row">
								<div class="col-md-2 col-sm-2">
									<div class="company-logo">
										<img class="img-responsive" />
									</div>
								</div>
								<div class="col-md-8 col-sm-8">
									<div class="company-content">
										<h3>${product.pname}</h3>
										<p>
											<span class="company-name"><i class="fa fa-briefcase"></i>${product.sbrand}</span><span
												class="company-location"><i class="fa fa-map-marker"></i>
												${product.location}</span><span class="package"><i
												class="fa fa-money"></i>${product.price}원</span>
										</p>
									</div>
								</div>
								<div class="col-md-2 col-sm-2">
									<button type="submit" class="btn view-job" name="View Job">Product
										Details</button>
								</div>
							</div>
						</div>
					</form>
				</c:forEach>
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