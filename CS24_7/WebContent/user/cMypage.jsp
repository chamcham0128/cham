<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>CS24/7 | MyPage</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- All Plugin Css -->
<link rel="stylesheet" href="<c:url value='/css/plugins.css' />">

<!-- Style & Common Css -->
<link rel="stylesheet" href="<c:url value='/css/common.css' />">
<link rel="stylesheet" href="<c:url value='/css/main.css' />">
<script>
function userRemove() {
   alert("회원탈퇴 되었습니다.")
}

function Removereservation() {   
   alert("예약취소가 완료되었습니다.");
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

	<!-- login section start -->
	<section class="login-wrapper">
		<div class="container">
			<div class="col-md-6 col-sm-8 col-md-offset-3 col-sm-offset-2">

				<h4>My Information</h4>
				<form name="form" method="POST"
					action="<c:url value='/user/customer/mypage'> 
               <c:param name="" value=""/>
               </c:url>">


					<div class="form-group">
						<label>User ID&nbsp;&nbsp;:&nbsp;&nbsp;${user.id}</label>
					</div>
					<div class="form-group">
						<label>Password&nbsp;&nbsp;:&nbsp;&nbsp;${user.pwd}</label>
					</div>
					<div class="form-group">
						<label>Name&nbsp;&nbsp;:&nbsp;&nbsp;${user.name}</label>
					</div>
					<div class="form-group">
						<label>Birth&nbsp;&nbsp;:&nbsp;&nbsp;${user.birth}</label>
					</div>
					<div class="form-group">
						<label>Phone&nbsp;&nbsp;:&nbsp;&nbsp;${user.phone}</label>
					</div>
					<div class="form-group">
						<label>Email&nbsp;&nbsp;:&nbsp;&nbsp;${user.email}</label>
					</div>
					<div class="form-group">
						<label>Gender&nbsp;&nbsp;:&nbsp;&nbsp;${user.gender}</label>
					</div>

					<div class="form-group">
						<h4>My Reservation</h4>
						<br> <label> <c:forEach var="nList"
								items="${pnameList}">
                          ${nList.pname}&nbsp;&nbsp;${nList.pcount}개&nbsp;&nbsp;
                          &nbsp;위치 :&nbsp;${nList.location}<br>전화번호:&nbsp;${nList.phone}      
                          <div class="form-group text-right">

									<a
										href="<c:url value='/store/reservation/delete'>
                  <c:param name="sno" value="${nList.sno}"/>
                  <c:param name="pname" value="${nList.pname}"/>
                  <c:param name="id" value="${nList.id}"/>
                  </c:url>"
										onclick="Removereservation()">예약취소</a><br>
								</div>
							</c:forEach>
						</label>


					</div>


					<div class="form-group text-right">

						<a
							href="<c:url value='/user/customer/update/form'>
                       <c:param name='id' value='${user.id}'/>
                    </c:url>">수정</a>
						&nbsp; <a
							href="<c:url value='/user/customer/delete'>
                     <c:param name='id' value='${user.id}'/>
                    </c:url>"
							onclick="userRemove()">회원탈퇴</a>


					</div>

				</form>

			</div>
		</div>
	</section>
	<!-- login section End -->

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









