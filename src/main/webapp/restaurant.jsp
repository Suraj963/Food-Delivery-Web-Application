<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.fooddelivery.model.Restaurant" %>

<!DOCTYPE html>
<html>
<head>
	<title>Swiggy</title>
	<style>
		body {
			margin: 0;
			padding: 0;
			font-family: Arial, sans-serif;
		}

		nav {
			display: flex;
			align-items: center;
			justify-content: space-between;
			background-color: #fff;
			padding: 10px 20px;
			box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
		}

		nav img {
			height: 30px;
		}

		nav input[type="text"] {
			padding: 5px;
			border: none;
			border-radius: 5px;
			margin-right: 10px;
			width: 300px;
		}

		nav .profile {
			display: flex;
			align-items: center;
			justify-content: center;
			height: 30px;
			width: 30px;
			border-radius: 50%;
			background-color: #f2f2f2;
			cursor: pointer;
		}

		.banner {
			display: flex;
			align-items: center;
			justify-content: center;
			flex-direction: column;
			height: 400px;
			background: linear-gradient(to right, #8e24aa, #6a1b9a);
			color: #fff;
			text-align: center;
			padding: 50px;
		}

		.banner img {
			height: 200px;
			margin-left: 50px;
		}

		.banner h1 {
			font-size: 40px;
			margin-bottom: 20px;
		}

		.food-types {
			display: flex;
			align-items: center;
			justify-content: center;
			flex-wrap: wrap;
			padding: 50px;
		}

		.food-types img {
			height: 100px;
			margin: 20px;
			border-radius: 50%;
			box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
			cursor: pointer;
		}

		.food-types p {
			font-size: 16px;
			margin-top: 10px;
			text-align: center;
		}
	</style>
</head>
<body>
	<nav>
		<img src="https://i.imgur.com/3yjZQ4N.png" alt="Swiggy logo">
		<input type="text" placeholder="Search for restaurant and food">
		<div class="profile"></div>
	</nav>
	<div class="banner">
		<h1>Order Food Online in Bangalore</h1>
		<img src="images/swiggy.avif" alt="Food banner" height="500px" width="100%">
	</div>
	<div class="food-types">
		<div>
			<img src="https://i.imgur.com/3yjZQ4N.png" alt="Idli">
			<p>Idli</p>
		</div>
		<div>
			<img src="https://i.imgur.com/3yjZQ4N.png" alt="Dosa">
			<p>Dosa</p>
		</div>
		<div>
			<img src="https://i.imgur.com/3yjZQ4N.png" alt="Paratha">
			<p>Paratha</p>
		</div>
		<div>
			<img src="https://i.imgur.com/3yjZQ4N.png" alt="Vada">
			<p>Vada</p>
		</div>
		<div>
			<img src="https://i.imgur.com/3yjZQ4N.png" alt="Pongal">
			<p>Pongal</p>
		</div>
		<div>
			<img src="https://i.imgur.com/3yjZQ4N.png" alt="Sandwich">
			<p>Sandwich</p>
		</div>
		<div>
			<img src="https://i.imgur.com/3yjZQ4N.png" alt="Pancake">
			<p>Pancake</p>
		</div>
	</div>
</body>
</html>

 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
