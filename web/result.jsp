<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="mflaschberger.Game" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Matt's Gaming Store Listing</title>
    <link rel="stylesheet" href="css/Store.css">
</head>

<body>
<h1 align="center">Matt's Gaming Store</h1>
<h2 align="center">Recommended Product(s)</h2><form action="Addtocart">


<p align="center">

        <%
        List recs = (List)request.getAttribute("recommendations");
        Iterator it = recs.iterator();
        while(it.hasNext())
        {
        Game w = (Game) it.next();
            out.print("<br><br>" + w.getgameName() + " <tab> " + w.getPrice() + "0" +
                    "<br>" + w.getgameDescription() +
                    "<br>" + " <input type=checkbox name=item value='" + w.getgameName() + "'> Add to Cart");
        }
        %>
</p></br>
    <p align="center"><input type="submit" value="Place Order"></p>
</form>
<p align="center"><a href="form.jsp">Back</a> <a href="index.jsp">Home</a> <a href="cart.jsp">View Cart</a>
    <a href="../../../../Store3/bill.jsp">View Bill</a></p>
    <br><footer>Copyright &copy; 2018 Ardent Arms<div><a href="mailto:abezhani@my.wctc.edu">Andi Bezhani</a></div></footer></br>
</body>
</html>
