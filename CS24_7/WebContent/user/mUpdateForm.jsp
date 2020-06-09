
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>CS24/7 | Update</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- All Plugin Css -->
<link rel="stylesheet" href="<c:url value='/css/plugins.css' />">

<!-- Style & Common Css -->
<link rel="stylesheet" href="<c:url value='/css/common.css' />">
<link rel="stylesheet" href="<c:url value='/css/main.css' />">
<script>
   function userModify() {
      if (form.password.value == "") {
         alert("비밀번호를 입력하십시오.");
         form.password.focus();
         return false;
      }
      if (form.password.value != form.password2.value) {
         alert("비밀번호가 일치하지 않습니다.");
         form.name.focus();
         return false;
      }
      if (form.name.value == "") {
         alert("이름을 입력하십시오.");
         form.name.focus();
         return false;
      }
      var emailExp = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
      if (emailExp.test(form.email.value) == false) {
         alert("이메일 형식이 올바르지 않습니다.");
         form.email.focus();
         return false;
      }
      var phoneExp = /^\d{2,3}-\d{3,4}-\d{4}$/;
      if (phoneExp.test(form.phone.value) == false) {
         alert("전화번호 형식이 올바르지 않습니다.");
         form.phone.focus();
         return false;
      }
      form.submit();
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

				<h4>Update Information</h4>
				<form name="form" method="POST"
					action="<c:url value='/user/master/update' />">
					<div class="form-group">
						<label>User ID</label> <input type="text" name="id"
							class="form-control" value="${user.id}" readonly>
					</div>
					<div class="form-group">
						<label>Password</label> <input type="text" name="pwd"
							value="${user.pwd}" class="form-control">
					</div>
					<div class="form-group">
						<label>Name</label> <input type="text" name="name"
							value="${user.name}" class="form-control">
					</div>
					<div class="form-group">
						<label>Birth</label> <input type="text" name="birth"
							value="${user.birth}" placeholder="YYYY-MM-DD"
							class="form-control">
					</div>
					<div class="form-group">
						<label>Phone</label> <input type="text" name="phone"
							value="${user.phone}" placeholder="010-XXXX-XXXX"
							class="form-control">
					</div>
					<div class="form-group">
						<label>Email</label> <input type="email" name="email"
							value="${user.email}" placeholder="cs24_7@gmail.com"
							class="form-control">
					</div>
					<div class="form-group">
						<label>licenseNo</label> <input type="text" name="licenseNo"
							value="${user.licenseNo}" placeholder="000-00-00000"
							class="form-control" readonly>
					</div>

					<div class="form-group">
						<label>Location</label> <input type="text" name="location"
							value="${store.location}" placeholder="서울시 마포구 양화로 6길"
							class="form-control">
					</div>

					<div class="form-group">
						<label>Store name</label> <input type="text" name="storename"
							value="${store.sbrand} ${store.sname}" placeholder="CU 합정역점"
							class="form-control">
					</div>

					<div class="form-group">
						<label>store phone number</label> <input type="text" name="sphone"
							value="${store.phone}" placeholder="XX-XXX-XXXX"
							class="form-control">
					</div>

					<div class="form-group text-right">
						<button type="submit" class="btn btn-primary btn-block"
							onClick="userModify()">UPDATE</button>
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
