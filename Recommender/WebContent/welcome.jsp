<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Behind the Mirror-Home</title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="../js/typeahead/0.11.1/typeahead.bundle.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="welcome.js"></script>
<script>
	$(document)
			.ready(
					function() {
						$("#shampoo")
								.click(
										function(event) {
											$
													.ajax({
														type : 'POST',
														url : 'ProductsServlet',
														datatype : 'json',
														success : function(
																result) {
															console.log(result
																	+ "hi");
															result1 = JSON
																	.parse(result);
															$('#display')
																	.html();
															var tab = "<table border='1|1'>";
															tab += "<td>"
																	+ "<b>"
																	+ "<h5>"
																	+ "Product Image"
																	+ "</h5>"
																	+ "</b>"
																	+ "</td>";
															tab += "<td>"
																	+ "<b>"
																	+ "Item Description"
																	+ "</b>"
																	+ "</td>";
															//tab+="<td>"+"<b>"+"Use"+"</b>"+"</td>";
															//tab+="<td>"+"<b>"+"Rating"+"</b>"+"</td>";
															for (var i = 0; i < result1.length; i = i + 8) {
																tab += "<tr>";
																tab += "<td>"
																		+ "<img src="+result1[i+7]+" style=width:128px;height:128px;>"
																		+ "</td>";
																tab += "<td>"
																		+ "<b>"
																		+ "<a href="+result1[i+6]+">"
																		+ result1[i+1]
																		+ "</a>"
																		+ "<b>"
																		+ "<br>"
																		+ "Price: "
																		+ result1[i + 3]
																		+ "<br>"
																		+ "Desription: "
																		+ result1[i + 2]
																		+ "<br>"
																		+ "Use: "
																		+ result1[i + 4]
																		+ "<br>"
																		+ "Rating: "
																		+ result1[i + 5]
																		+ "</td>";
																//tab+="<td>"+result1[i+2]+"</td>";
																//tab+="<td>"+result1[i+3]+"</td>";
																tab += "</tr>";
															}
															tab += "</table>";
															tab += "<br>";
															tab += "<br>";
															$("#display").html(
																	tab);
														}
													});
										});

					});
	$(document)
			.ready(
					function() {
						$("#viewCart")
								.click(
										function(event) {
											var uid = '5833e7d5a3028e3433c61211';
											$
													.ajax({
														type : 'POST',
														url : 'CartServlet',
														datatype : 'json',
														data : 'uid',
														success : function(
																result) {
															console.log(result
																	+ "hi");
															/**/
															var result1 = result[0];
															var resultTot = result[1];
															console
																	.log(resultTot
																			+ "hi");
															$('#display1')
																	.html();
															var tab = "Your Cart"
															tab += "<table border='1|1'>";
															tab += "<td>"
																	+ "<b>"
																	+ "Product Image"
																	+ "</b>"
																	+ "</td>";
															tab += "<td>"
																	+ "<b>"
																	+ "Item Description"
																	+ "</b>"
																	+ "</td>";
															//tab+="<td>"+"<b>"+"Use"+"</b>"+"</td>";
															//tab+="<td>"+"<b>"+"Rating"+"</b>"+"</td>";
															for (var i = 0; i < result1.length; i = i + 9) {
																tab += "<tr>";
																tab += "<td>"
																	+ "<img src="+result1[i+6]+" style=width:128px;height:128px;>"
																	+ "</td>";
																tab += "<td>"
																		+ "<b>"
																		+ "<a href="+result1[i+1]+">"
																		+ result1[i]
																		+ "</a>"
																		+ "<b>"
																		+ "<br>"
																		+ "Desription: "
																		+ result1[i + 2]
																		+ "<br>"
																		+ "Use: "
																		+ result1[i + 3]
																		+ "<br>"
																		+ "Rating: "
																		+ result1[i + 4]
																		+ "<br>"
																		+ "Price: "
																		+ result1[i + 5]
																		+ "<br>"
																		+ "Users: "
																		+ result1[i + 7]
																		+ "<br>"
																		+ "Reminder: "
																		+ result1[i + 8]
																		+ "<br>"
																		+ "<a href=removeFromCart.html>Remove from Cart"
																		+ "</td>";

																//tab+="<td>"+result1[i+3]+"</td>";
																tab += "</tr>";
															}
															tab += "<tr>"
															tab += "<td>"
															tab += "Total"
															tab += "</td>"
															tab += "<td>"
															tab += "$"
																	+ resultTot
															tab += "</td>"
															tab += "</tr>"
															tab += "</table>";
															tab += "<br>";
															tab += "<a href=Checkout>"
															tab += "<button> Proceed to checkout</button>"
															tab += "<br>";
															$("#display").html(
																	tab);
														}
													});
										});

					});
</script>

<!-- 
<style type="text/css">
.bs-example {
	font-family: sans-serif;
	position: relative;
	margin: 100px;
}
.typeahead, .tt-query, .tt-hint {
	border: 2px solid #CCCCCC;
	border-radius: 8px;
	font-size: 22px; /* Set input font size */
	height: 30px;
	line-height: 30px;
	outline: medium none;
	padding: 8px 12px;
	width: 396px;
}
.typeahead {
	background-color: #FFFFFF;
}
.typeahead:focus {
	border: 2px solid #0097CF;
}
.tt-query {
	box-shadow: 0 1px 1px rgba(0, 0, 0, 0.075) inset;
}
.tt-hint {
	color: #999999;
}
.tt-menu {
	background-color: #FFFFFF;
	border: 1px solid rgba(0, 0, 0, 0.2);
	border-radius: 8px;
	box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
	margin-top: 12px;
	padding: 8px 0;
	width: 422px;
}
.tt-suggestion {
	font-size: 22px;  /* Set suggestion dropdown font size */
	padding: 3px 20px;
}
.tt-suggestion:hover {
	cursor: pointer;
	background-color: #0097CF;
	color: #FFFFFF;
}
.tt-suggestion p {
	margin: 0;
}
</style>
<style>
#search {
float: right;
margin-top: 9px;
width: 250px;
}

.search {
padding: 5px 0;
width: 230px;
height: 30px;
position: relative;
center: 10px;
float: center;
line-height: 22px;
}

.search input {
    position: absolute;
    width: 200px;
    float: Left;
    margin-left: 210px;
    -webkit-transition: all 0.7s ease-in-out;
    -moz-transition: all 0.7s ease-in-out;
    -o-transition: all 0.7s ease-in-out;
    transition: all 0.7s ease-in-out;
    height: 30px;
    line-height: 18px;
    padding: 0 2px 0 2px;
    border-radius:1px;
}
-->

<style>
nav {
	float: left;
	max-width: 160px;
	margin: 0;
	padding: 1em;
}

nav ul {
	list-style-type: none;
	padding: 0;
}

nav ul a {
	text-decoration: none;
}

header, footer {
	padding: 1em;
	color: white;
	background-color: black;
	clear: left;
	text-align: center;
}

article {
	margin-left: 170px;
	border-left: 1px solid gray;
	padding: 1em;
	overflow: hidden;
}

table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}

.drop {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
}

.list {
	float: right;
}

.list a, .dropbtn {
	display: inline-block;
	color: BLUE;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

.list a:hover, .dropdown:hover .dropbtn {
	
}

li.dropdown {
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
	text-align: left;
}

.dropdown-content a:hover {
	background-color: #FFFFFF
}

.dropdown:hover .dropdown-content {
	display: block;
}
</style>

</head>

<body>
	<header>
		<h3 align="left">Behind the Mirror</h3>
	</header>

	<div align="right" class="container">
		<ul id="drop">
			<li class="dropdown" id="list"><a href="#" class="dropbtn">My
					Account</a>
				<div class="dropdown-content">
					<a href="EditProfile.html">Edit Profile</a><br /> <a href="#">Recent
						Purchases</a><br /> <a href="Logout">Logout</a>
				</div></li>

			<li id="list" class="dropbtn"><a href="#" id="viewCart">View
					Cart</a></li>
		</ul>
	</div>
	<!-- 	<div class="bs-example" align="right">
		<input type="text" class="typeahead tt-query" autocomplete="off"
			spellcheck="false" placeholder="Search your Product">
	</div>
	-->
	<br>
	<nav>
		<div align="left" class="container">
			<h5>Hello ${username}</h5>
			Products <br> <a href="#" data-toggle="collapse"
				data-target="#hair"> Hair</a>
			<div id="hair" class="collapse">
				<ul>
					<li><a href="#" name="shampoo" id="shampoo">Shampoo</a></li>
					<li><a href="#" name="conditioner" id="conditioner">Conditioner</a></li>
					<li><a href="#" name="serum" id="serum">Serum</a></li>
					<li><a href="#" name="hairSpray" id="hairSpray">HairSpray</a></li>
					<li><a href="#" name="mask" id="mask">Mask</a></li>
				</ul>
			</div>
			<br /> <a href="#" data-toggle="collapse" data-target="#face">
				Face</a>
			<div id="face" class="collapse">
				<ul>
					<li><a href="#" name="cream" id="cream">Cream</a></li>
					<li><<a href="#" name="cleanser" id="cleanser">Cleanser</a></li>
					<li><a href="#" name="scrub" id="scrub">Scrub</a></li>
					<li><a href="#" name="sunscreen" id="sunscreen">SunScreen</a></li>
					<li><a href="#" name="moisturiser" id="moisturiser">Moisturiser</a></li>
				</ul>
			</div>
			<br /> <a href="#" data-toggle="collapse" data-target="#body">
				Body</a>
			<div id="body" class="collapse">
				<ul>
					<li><a href="#">Cream</a></li>
					<li><a href="#">Wash</a></li>
					<li><a href="#">Scrub</a></li>
					<li><a href="#">Lotion</a></li>
					<li><a href="#">Inshower Lotion</a></li>
				</ul>
			</div>
			<br /> <a href="#" data-toggle="collapse" data-target="#hand">
				Hand</a>
			<div id="hand" class="collapse">
				<ul>
					<li><a href="#">Cream</a></li>
					<li><a href="#">Wash</a></li>
					<li><a href="#">Scrub</a></li>
				</ul>
			</div>
			<br /> <a href="#" data-toggle="collapse" data-target="#foot">
				Foot</a>
			<div id="foot" class="collapse">
				<ul>
					<li><a href="#">Cream</a></li>
					<li><a href="#">Lotion</a></li>
					<li><a href="#">Scrub</a></li>
				</ul>
			</div>
	</nav>
	<br />
	<br>
	<br>
	<!-- <div class="collapse" id="collapseExample">
			<table width=50%>
				<tr>
					<th>PRODUCT</th>
					<th>DESCRIPTION</th>
					<th>RATING</th>
				</tr>
				<tr>
					<th><a href="#">Dove Shampoo</a></th>
					<th>For healthy hair, use dove shampoo daily as it nourishes
						hair for fuller,cleaner long hair</th>
					<th>3.2/5</th>
				<tr>
					<th><a href="#">Loreal Shampoo</a></th>
					<th>volumizing hair, clean scalp, no split ends</th>
					<th>3.25/5</th>
				<tr>
					<th><a href="shampoo.html">Biolage Shampoo</a></th>
					<th>Paraben free shampoo with natural ingredients and cleanses
						your hair for naturally long smooth tresses</th>
					<th>3.75/5</th>
			</table>
		</div>-->
	<article>

		<iframe width="200" height="200"
			src="https://www.youtube.com/embed/litXW91UauE" frameborder="0"
			allowfullscreen></iframe>
		<div id="display"></div>
		<div id="display1"></div>
		<br> <br>
		<h4>${addedToCart}</h4>
		<table>
			<tr>
				<c:forEach items="${suggestions}" var="record">
					<td>
						<div>
							<b><img src="${record.image}"
								style="width: 128px; height: 128px;"></b><br> <b><a
								href="${record.address}">${record.productName}</a> <br>${record.description}
								<br>${record.rating}</b>
						</div>
					</td>
					<br>
				</c:forEach>
			</tr>

		</table>
	</article>

	<br>
</body>
</html>
<!-- 
<body>
	<div class="container" align="center">
		<h3>Behind the Mirror</h3>
		<hr>
	</div>

	<div align="right">
		<form class="form-horizontal" method="post" action="Logout">
			<input type="submit" class="btn btn-default" id="logout"
				value="Logout">
		</form>
	</div>
	<!-- <input type="submit" align="left" class="btn btn-default" id="cart"
		value="My Cart">
-->
<!-- s	<div align="center">
		<p>Hello ${username}</p>
		<p>It's good to see you today.</p>
		<div class="dropdown">
			<button class="btn btn-default dropdown-toggle" type="button"
				id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="true">
				Dropdown <span class="caret"></span>
			</button>
			<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
				<li><a href="ProductSelect">Hair</a></li>
				<li><a href="ProductsServlet">Face</a></li>
				<li><a href="ProductsServlet">Hands</a></li>
				<li role="separator" class="divider"></li>
				<li><a href="#">Separated link</a></li>
			</ul>
		</div>
	</div>


</body>
</html>-->
