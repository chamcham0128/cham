<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>CS24/7 | Stock of Your Store</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- All Plugin Css -->
<link rel="stylesheet" href="<c:url value='/css/plugins.css' />">

<!-- Style & Common Css -->
<link rel="stylesheet" href="<c:url value='/css/common.css' />">
<link rel="stylesheet" href="<c:url value='/css/main.css' />">
<script>
   function deleteStock() {
      alert("상품의 삭제가 완료되었습니다.");
     
   }

   function updateStock() {
      alert("상품 수량의 수정이 완료되었습니다.");
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

	<section class="inner-banner"
		style="backend: #242c36 url(https://via.placeholder.com/1920x600) no-repeat;">
		<div class="container">
			<div class="caption">
				<h2>Your Store</h2>
				<p>
					매장 내 재고를 <span>추가 및 수정</span>하세요!
				</p>
			</div>
		</div>
	</section>
	<section class="login-wrapper">
		<div class="container">
			<div class="col-md-6 col-sm-8 col-md-offset-3 col-sm-offset-2">
				<form name="form" method="POST"
					action="<c:url value='/master/addStock'>
               <c:param name="sno" value="${sno}"/>
               </c:url>">
					상품명 : <input type="text" name="pname" size="20">&emsp;&emsp;
					수량 : <input type="text" name="amount" size="5">&emsp;&emsp;
					<button type="submit" class="btn btn-package">추가</button>
					<br> <br>
				</form>
				<c:forEach var="stock" items="${stockList}">
					<div class="form-group">
						<table style="width: 600px">
							<tr>
								<td style="width: 80%;">
									<form method="post"
										action="<c:url value='/master/updateStock'>
                     <c:param name="sno" value="${stock.sno}"/>
                      <c:param name="pno" value="${stock.pno}"/>
                      <c:param name="pname" value="${stock.pname}"/>
                     </c:url>">
										<table style="width: 480px;">
											<tr>
												<td style="width: 60%; text-align: left;">&emsp;
													${stock.pname}&emsp;</td>
												<td style="width: 25%;">&emsp;&emsp;<input type="text"
													name="update_amount" value="${stock.amount}" size="1"
													style="text-align: right;">개&emsp;&emsp;
												</td>
												<td style="width: 15%;"><button type="submit"
														onclick="updateStock()">수정</button></td>
											</tr>
										</table>
									</form>
								</td>
								<td style="text-align: left; width: 20%;"><form
										method="post"
										action="<c:url value='/master/deleteStock'>
                      <c:param name="sno" value="${stock.sno}"/>
                      <c:param name="pno" value="${stock.pno}"/>
                      <c:param name="pname" value="${stock.pname}"/>
                     <c:param name="amount" value="${stock.amount}"/>
                      </c:url>">
										<button type="submit" onclick="deleteStock()">삭제</button>
									</form></td>
							</tr>
						</table>
					</div>
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