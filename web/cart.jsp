<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="mflaschberger.Game" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Bill</title>
    <link rel="stylesheet" href="css/Store.css"></head>
<body>
<h1 align="center">Bill</h1>
<div id="rcorners">
    <h3>Final Bill</h3>
    <form action="bill.go">
        <table>
            <%
                List recs = (List) request.getAttribute("catalog");
                Iterator it = recs.iterator();
                double total = 0;
                while (it.hasNext()) {
                    Game item = (Game) it.next();
                    out.print("<tr class='purch'><td> " + item.getgameName() + " </td><td>" +
                            String.format("$%3.2f",item.getPrice()) + "</td></tr>");
                    total+=item.getPrice();
                }
                out.print("<tr class='total' ><td>Total:</td><td>" +
                        String.format("$%3.2f",total) + "</td></tr>");
            %>
        </table>
        <input type="submit" value="Complete Order">
    </form>
</div>
<p align="center"><a href="index.jsp">Home</a>  <a href="cat.go">Products</a>  <a href="cart">Shopping Cart</a></p>
<br><footer><div><a href="mailto:mflaschberger@my.wctc.edu">Matthew Flaschberger</a></div></footer></br>
</body>
</html>
