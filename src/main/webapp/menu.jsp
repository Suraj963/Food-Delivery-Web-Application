<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.fooddelivery.model.Menu" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha384-Z2lhWItrMOhC5E5Qq4Gt3YsC2qLE2HsGQpiR8UvWhvIyjbltvIOn2Ippaa6Ic5Wg" crossorigin="anonymous">

    <style>
        h1 {
            text-align: center;
            margin-bottom: 20px;
        }

        .menu-card {
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            transition: box-shadow 0.3s ease-in-out;
            height: 250px; /* Set your desired height */
        }

        .menu-card:hover {
            box-shadow: 0 0 20px rgba(0,0,0,0.2);
            transform: translateY(-5px);
        }

        .menu-card .card-body {
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            height: 100%;
        }

        .menu-card h5 {
            color: #007bff;
            margin-bottom: 10px;
        }

        .menu-card p {
            flex-grow: 1;
            margin-bottom: 10px;
        }

        .menu-card a {
            display: block;
            width: 100%;
            background-color: #007bff;
            color: #fff;
            padding: 10px 15px;
            text-decoration: none;
            border-radius: 5px;
        }

        .menu-card a:hover {
            background-color: #0056b3;
        }
        
           .menu-card .add-to-cart-btn {
        display: block;
        width: 100%; /* Extend button width to fill the card */
        background-color: #007bff;
        color: #fff;
        padding: 10px 15px;
        margin-top: 10px;
        text-decoration: none;
        border-radius: 0 0 5px 5px; /* Rounded corners only at the bottom */
        transition: background-color 0.3s ease;
    }

	    .menu-card .add-to-cart-btn:hover {
	        background-color: #0056b3;
	    }
    </style>
</head>
<body>
    <h1>Menu</h1>

    <div class="container">
        <div class="row">
            <%
                List<Menu> menuList = (List<Menu>) request.getAttribute("menuList");
                for (Menu menuItem : menuList) {
            %>
                <div class="col-md-3 mb-4">
                    <div class="card menu-card">
                        <div class="card-body">
                            <h5 class="card-title restaurant-name"><%= menuItem.getItemName() %></h5>
                            <p><%= menuItem.getDescription() %></p>
                            <p class="card-text">Price : <%= menuItem.getPrice() %> Rs</p>
                            
                            <form action="cart" method="post">
                            <input type="hidden" name="itemId" value="<%= menuItem.getMenuID()%>">
                            Quantity : <input type="number" name="quantity" value="1" min="1" class="quantity-input">
                            <input type="submit" value="Add to Cart" class="add-to-cart-btn" class="btn btn-primary view-menu-btn">
                            <input type="hidden" name="action" value="add">
                            </form>
                            
                        </div>
                    </div>
                </div>
            <%
                }
            %>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
