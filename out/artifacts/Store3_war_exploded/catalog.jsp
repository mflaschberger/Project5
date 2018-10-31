<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="mflaschberger.Game" %>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Gaming Catalog</title>
    <link rel="stylesheet" href="css/Store.css">
</head>
<body>
<h1 align="center">Matt's gaming</h1>

<form action="cartplace.go">
    <table>
        <%
            List recs = (List) request.getAttribute("catalog");
            Iterator it = recs.iterator();
            while (it.hasNext()) {
                Game item = (Game) it.next();
                out.print("<tr><td>" + item.getgameName() + "</td><td>$" + item.getPrice() + "</td><td>Add to Cart<input type='checkbox' name='cartItem' value=" + item.getGameNumber() + "></td></tr>");
            }
        %>

    </table>
    <input type="submit" value="Purchase">
</form>

<p align="center"><a href="index.jsp">Home</a> <a href="cat.go">Products</a>  <a href="cart">Shopping Cart</a></p>
</body>
</html>