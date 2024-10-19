<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.fooddelivery.model.Order" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Confirmation</title>
<style>
    body {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        min-height: 100vh;
        margin: 0;
        font-size: 18px;
    }

    h1, p {
        text-align: center;
    }

    .order-details {
        margin-top: 20px;
        padding: 20px;
        border: 1px solid #ddd;
        border-radius: 10px;
        transition: transform 0.3s ease-in-out;
    }

    .order-details:hover {
        transform: scale(1.05);
    }

    a {
        display: inline-block;
        margin-top: 20px;
        padding: 10px 20px;
        background-color: #007bff;
        color: #fff;
        text-decoration: none;
        border-radius: 5px;
        transition: background-color 0.3s ease-in-out;
    }

    a:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
    <h1>Order Confirmation</h1>

    <%
    Order order = (Order)session.getAttribute("order");
    if (order != null) {
    %>
    <div class="order-details">
        <p>Thank you for your order!</p>
        
        <p>Order ID: <%=order.getOrderID()%></p>
        
        <p>Total Amount: <%=order.getTotalAmount()%></p>
        
        <p>Status: <%=order.getStatus()%></p>
        
        <p>Payment Method: <%=order.getPaymentMethod()%></p>
        
        <!-- You can add more details here if needed -->
        
        <%-- You may also list the items in the order if you have that data --%>
    </div>
    <%
    } else {
    %>
        <p>Order details are not available at the moment.</p>
    <%
    }
    %>
    <a href="home">Return to Home</a>
</body>
</html>
