<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Checkout</title>
  <style>
    .card {
      background-color: #e6e6fa;
      padding: 20px;
      border-radius: 10px;
      box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
      transition: 0.3s;
    }

    .card:hover {
      box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
    }

    textarea {
      width: 100%;
      height: 120px;
      padding: 12px 20px;
      margin: 8px 0;
      box-sizing: border-box;
      border: none;
      border-radius: 4px;
      background-color: #f8f8ff;
      resize: none;
    }

    select {
      width: 100%;
      padding: 12px 20px;
      margin: 8px 0;
      box-sizing: border-box;
      border: none;
      border-radius: 4px;
      background-color: #f8f8ff;
    }

    input[type=submit] {
      background-color: #4CAF50;
      color: white;
      padding: 12px 20px;
      border: none;
      border-radius: 4px;
      cursor: pointer;
    }

    input[type=submit]:hover {
      background-color: #45a049;
    }
  </style>
</head>
<body>
  <div class="card">
    <h2>Checkout</h2>
    <form action="checkout" method="post">
      <label for="address">Delivery Address:</label>
      <textarea id="address" name="address" required></textarea><br><br>
      <label>Payment Method: </label>
      <select name="paymentMethod">
        <option value="Credit Card">Credit Card</option>
        <option value="Debit Card">Debit Card</option>
        <option value="Cash">Cash on Delivery</option>
        <option value="UPI">UPI</option>
      </select><br><br>
      <input type="submit" value="Place Order">
    </form>
  </div>
</body>
</html>
