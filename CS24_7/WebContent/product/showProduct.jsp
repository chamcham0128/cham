<%@page contentType="text/html; charset=utf-8"%>
<%@page import="model.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html class="no-js" lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>CS24/7 | Product Details</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- All Plugin Css -->
<link rel="stylesheet" href="<c:url value='/css/plugins.css' />">

<!-- Style & Common Css -->
<link rel="stylesheet" href="<c:url value='/css/common.css' />">
<link rel="stylesheet" href="<c:url value='/css/main.css' />">

<script>
function reservation() {   
    alert("예약이 완료되었습니다.");
}
        
</script>
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
				<a class="navbar-brand" href="<c:url value='/' />"><img
					src="<c:url value='/img/CS247_main_l.png' />" class="logo" alt=""></a>
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
	<section class="profile-detail">
		<div class="container">
			<div class="col-md-12">
				<div class="row">
					<div class="basic-information">
						<div class="col-md-3 col-sm-3">
							<img src="img/user.jpg" alt="" class="img-responsive">
						</div>
						<div class="col-md-9 col-sm-9">
							<div class="profile-content">
								<h2>
									${productList.pname}<span>${productList.brand}</span>
								</h2>
								<p>${productList.sname}</p>
								<ul class="information">
									<li><span>Name:</span>${productList.pname}</li>
									<li><span>Price:</span>${productList.price}</li>
									<li><span>Stock:</span>${productList.amount}</li>
									<li><span>Phone:</span>${productList.phone}</li>
									<li><span>Location:</span>${productList.location}</li>
								</ul>
							</div>
						</div>
						<ul class="social">
							<li><div class="col-md-10 col-sm-10">
									<div class="company-content"></div>
								</div></li>
							<li>
								<div class="col-md-10 col-sm-10">
									<div class="company-content">
										<c:if test="${!empty userId }">
											<a
												href="<c:url value='/store/reservation'>
                              <c:param name="sno" value="${productList.sno}"/>
                                    <c:param name="pno" value="${productList.pno}"/>
                                    <c:param name="userId" value="${user.id}"/> <!-- 수정  -->
                                    <c:param name="pname" value="${productList.pname}"/>
                                    <c:param name="gender" value="${user.gender}"/>
                                    <c:param name="birth" value="${user.birth}"/>
                                    <c:param name="pcount" value="1"/>
                                    <c:param name="location" value="${productList.location}"/>
                                    <c:param name="sname" value="${productList.sname}"/>
                                    <c:param name="sbrand" value="${productList.sbrand}"/>
                                    <c:param name="price" value="${productList.price}"/>
                                    <c:param name="amount" value="${productList.amount}"/>
                                    <c:param name="phone" value="${productList.phone}"/>
                                    <c:param name="brand" value="${productList.brand}"/>
                                    </c:url>"
												onclick="reservation()"><h3>
													<span class="internship">Reservation</span>
												</h3></a>
										</c:if>
									</div>
								</div>
							</li>
							<li>
								<div class="col-md-10 col-sm-10">
									<div class="company-content">
										<!-- 수정 -->
										<a
											href="<c:url value='/product/showReview'>
                              <c:param name='pno' value='${productList.pno}'/>
                              </c:url>"><h3>
												<span class="full-time">Show Review</span>
											</h3></a>
										<!-- 수정 -->
									</div>
								</div>
							</li>
							<li>
								<div class="col-md-10 col-sm-10">
									<div class="company-content">
										<!-- 수정 -->
										<c:if test="${!empty userId }">
											<a
												href="<c:url value='/product/writeReview'>
                              <c:param name='pno' value='${productList.pno}'/>
                              </c:url>"><h3>
													<span class="part-time">Write Review</span>
												</h3></a>
										</c:if>
										<!-- 수정 -->
									</div>
								</div>
							</li>
							<li><div class="col-md-10 col-sm-10">
									<div class="company-content"></div>
								</div></li>
						</ul>
					</div>
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