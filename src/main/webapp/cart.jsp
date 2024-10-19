<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.fooddelivery.model.Cart" %>
<%@ page import="com.fooddelivery.model.CartItem" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shopping Cart</title>

    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 20px;
        }

        h1 {
            color: #333;
        }

        .cart-items {
            margin-top: 20px;
        }

        .cart-item {
            background-color: #fff;
            padding: 15px;
            margin-bottom: 10px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .cart-item h3 {
            color: #333;
        }

        form {
            margin-top: 10px;
        }

        .add-more-items-btn {
            display: inline-block;
            padding: 10px 20px;
            margin-top: 10px;
            text-decoration: none;
            color: #fff;
            background-color: #27ae60;
            border: 1px solid #27ae60;
            border-radius: 5px;
            transition: background-color 0.3s ease, color 0.3s ease;
        }

        .add-more-items-btn:hover {
            background-color: #219653;
            color: #fff;
        }

        .proceed-to-checkout-btn {
            display: inline-block;
            padding: 10px 20px;
            margin-top: 10px;
            text-decoration: none;
            color: #fff;
            background-color: #e74c3c;
            border: 1px solid #e74c3c;
            border-radius: 5px;
            transition: background-color 0.3s ease, color 0.3s ease;
        }

        .proceed-to-checkout-btn:hover {
            background-color: #c0392b;
            color: #fff;
        }

        .update-btn,
        .remove-btn {
            display: inline-block;
            padding: 5px 10px;
            margin-top: 10px;
            text-decoration: none;
            color: #fff;
            border-radius: 5px;
            transition: background-color 0.3s ease, color 0.3s ease;
        }

        .update-btn {
            background-color: #3498db;
            border: 1px solid #3498db;
        }

        .update-btn:hover {
            background-color: #2980b9;
            color: #fff;
        }

        .remove-btn {
            background-color: #e67e22;
            border: 1px solid #e67e22;
        }

        .remove-btn:hover {
            background-color: #d35400;
            color: #fff;
        }
    </style>
</head>
<body>

    <h1>Your Shopping Cart</h1>

    <div class="cart-items">
        <%
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart != null && !cart.getItems().isEmpty()) { 
                for (CartItem item: cart.getItems().values()) {
        %>
        <div class="cart-item">
            <h3><%=item.getName()%></h3>
            <p>&#x20B9; <%=item.getPrice()%></p>

            <form action="cart" method="post">
                <input type="hidden" name="itemId" value="<%=item.getItemId()%>">
                <label>Quantity: <input type="number" name="quantity" value="<%=item.getQuantity()%>" min="1"></label>
                <input type="submit" name="action" value="update" class="update-btn">
                <input type="submit" name="action" value="remove" class="remove-btn">
            </form>

        </div>

        <%
            }
        } else {
        %>
        <p>Your cart is Empty</p>
        <%
            }
        %>

        <a href="menu?restaurantId=<%=session.getAttribute("resturantId")%>" class="add-more-items-btn">Add More Items</a>

        <%
            if (session.getAttribute("cart") != null) {
        %>
        <form action="checkout.jsp" method="post">
            <input type="submit" value="Proceed to Checkout" class="proceed-to-checkout-btn">
        </form>
        <%
            }
        %>

    </div>

</body>
</html>













