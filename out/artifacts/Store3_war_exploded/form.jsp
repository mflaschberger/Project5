<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Matt's Gaming: Selection</title>
    <link rel="stylesheet" href="css/ardentarmsstyle.css">
</head>
<body>
<h1 align="center">Matt's Gaming</h1>
<h2 align="center">game Selection</h2>
<form id="form1" name="form1" method="POST" action="InventoryList.do">
    <p align="center">Please Select game Category<p>
    <p align="center">

        <select id="game" name="game" size ="1">
            <option value="FPS">Frist Person Shooter</option>
            <option value="Sports">Sports</option>
        </select>
    </p>
    <center>
        <input id="beerSubmit" name="beerSubmit" type="submit" value="Get Product List">
    </center>
</form>
<p align="center"><a href="index.jsp">Home</a> <a href="cart.jsp">View Cart</a> <a href="../../../../Store3/bill.jsp">View Bill</a></p>
</body>
</html>