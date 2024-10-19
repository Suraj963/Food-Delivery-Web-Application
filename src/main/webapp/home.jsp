<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.fooddelivery.model.Restaurant" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
    <link rel="stylesheet" type="text/css" href="#">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" integrity="sha384-cCtQOrUAD7rwhP8thtJSNuS0i4yG5/tu3vKx7pfLTtiTQ6l2YUaA2aYc9QKb0Lct" crossorigin="anonymous">
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f8f9fa;
        }
        .navbar {
            background-color: #3f51b5; /* Indigo color */
        }
        .navbar-brand {
            color: white;
        }
        .navbar-nav .nav-link {
            color: white !important;
        }
        .navbar-nav .nav-link:hover {
            color: #ffcc00 !important;
        }
        .card {
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            transition: box-shadow 0.3s ease-in-out;
        }
        .card:hover {
            box-shadow: 0 0 20px rgba(0,0,0,0.2);
            transform: translateY(-5px);
        }
        .restaurant-name {
            color: #007bff; /* Blue color */
        }
        .card-img-top {
            height: 150px; /* Set your desired height */
            object-fit: cover;
        }
        .view-menu-btn {
            transition: background-color 0.3s ease-in-out, color 0.3s ease-in-out;
        }
        .view-menu-btn:hover {
            background-color: #ffcc00;
            color: #212529;
        }
        
         .header-title {
            text-align: center;
            margin-bottom: 20px;
        }
    
    </style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">FoodDelivery</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav justify-content-center">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="login.jsp">Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" aria-disabled="true">Disabled</a>
                </li>
            </ul>
        </div>
    </div>
</nav>



<h1 class="header-title">Restaurants</h1>

<div class="container">
    <div class="row">
        <%
        List<Restaurant> restaurants = (List<Restaurant>) request.getAttribute("restaurantList");

        for (Restaurant restaurant : restaurants) {
        %>
        <div class="col-md-3 mb-4">
            <div class="card">
                <a href="menu?restaurantId=<%= restaurant.getRestaurantID()%>">
                    <img src="images/<%= restaurant.getImagePath() %>" alt="Restaurant Image" class="card-img-top img-fluid">
                </a>
                <div class="card-body">
                    <h5 class="card-title restaurant-name"><%= restaurant.getName() %></h5>
                    <p>Cuisine Type: <%= restaurant.getCuisineType() %></p>
                    <p class="card-text">Delivery Time: <%= restaurant.getDeliveryTime() %> minutes <i class="far fa-clock"></i></p>
                    <p>Rating: <%= restaurant.getRating() %> <i class="far fa-star"></i></p>
                    <a href="menu?restaurantId=<%= restaurant.getRestaurantID()%>" class="btn btn-primary view-menu-btn">View Menu</a>
                </div>
            </div>
        </div>
        <% } %>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

</body>
</html>
