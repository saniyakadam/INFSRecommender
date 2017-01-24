<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Your Order Payment</title>
<meta charset="utf-8" />
<link rel="stylesheet" href="css/style.css" media="screen"
	type="text/css" />
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.shop.js"></script>
</head>
<style>
</style>
<body>

	<div class="container">
		<div id="content">
			<h1>Your Order</h1>
			
			<table>
				<tr>
					<td><c:forEach items="${cart}" var="record" varStatus="status">
							<tr>
								<td>
									<div>
										<b><img src="${record.image}"
											style="width: 128px; height: 128px;"></b><br> <b><a
											href="${record.address}">${record.productName}</a> <br>Description:
											${record.description} <br>Rating: ${record.rating}/5 <br>Price:$
											${record.price}<br>
											Number of Users: ${quantity[status.index].users}<br>
											Send Reminders: ${quantity[status.index].remind}</b></div>
								</td>
							</tr>

							<br>
						</c:forEach></td>
						</table>
						
			<div id="pricing">

				<p id="shipping">
					<strong>Shipping Address</strong>: <input type="text">
				</p>

				<p id="sub-total">
					<strong>Sub-Total</strong>:$ ${amt} <span id="stotal"></span>
				</p>
				<p id="tax">
					<strong>Tax</strong>:$ ${tax} <span id="tax"></span>
				</p>
				<p id="total">
					<strong>Total</strong>:$ ${total} <span id="stotal"></span>
				</p>
			</div>

			<div id="user-details">
				<h2>Your Data</h2>
				<div id="user-details-content"></div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-md-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Payment Details</h3>
						<div class="checkbox pull-right">
							<label> <input type="checkbox" /> Remember
							</label>
						</div>
					</div>
					<div class="panel-body">
						<form role="form">
							<div class="form-group">
								<label for="cardNumber"> CARD NUMBER</label>
								<div class="input-group">
									<input type="text" class="form-control" id="cardNumber"
										placeholder="Valid Card Number" required autofocus /> <span
										class="input-group-addon"><span
										class="glyphicon glyphicon-lock"></span></span>
								</div>
							</div>
							<!-- Name -->
							<div class="control-group">
								<label class="control-label" for="username">CARD
									HOLDER'S NAME</label>
								<div class="controls">
									<input type="text" class="form-control" id="cardNumber"
										placeholder="" required />
								</div>
							</div>
							<div class="row">
								<div class="col-xs-7 col-md-7">
									<div class="form-group">
										<label for="expityMonth"> EXPIRY DATE</label>
										<div class="col-xs-6 col-lg-6 pl-ziro">
											<input type="text" class="form-control" id="expityMonth"
												placeholder="MM" required />
										</div>
										<div class="col-xs-6 col-lg-6 pl-ziro">
											<input type="text" class="form-control" id="expityYear"
												placeholder="YY" required />
										</div>
									</div>
								</div>
								<div class="col-xs-5 col-md-5 pull-right">
									<div class="form-group">
										<label for="cvCode"> CVV2 CODE</label> <input type="password"
											class="form-control" id="cvCode" placeholder="CVV2" required />
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
				<ul class="nav nav-pills nav-stacked">
					<li class="active"><a href="#"><span
							class="badge pull-right"><span
								class="glyphicon glyphicon-usd"></span>4200</span> Invoice Total</a></li>
				</ul>

			</div>
		</div>
	</div>
	<form action="OnPayment">
		<input type="submit" class="btn btn-default" id="Pay" value="Pay">
	</form>
	<div>
		<footer align="center"> &copy;Copyrighted by Ramya & Saniya</footer>
	</div>

</body>
</html>

