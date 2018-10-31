package mflaschberger;

//import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class CartPlaceController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String theOrder = "";

       /* Cookie cookie2 = null;
        Cookie[] cookies2 = null;
        // Get an array of Cookies associated with the this domain
        cookies2 = request.getCookies();
        if( cookies2 != null ) {
            for (int i = 0; i < cookies2.length; i++) {
                cookie2 = cookies2[i];
                if (cookie2.getName().equals("cartItem")) {
                    theOrder = cookie2.getValue() + ",";
                }
            }
        }*/

        Enumeration paramNames = request.getParameterNames();
        String paramName;

        while(paramNames.hasMoreElements()) {
            paramName = (String)paramNames.nextElement();
            if(paramName.equals("cartItem")) {
                String[] paramValues = request.getParameterValues(paramName);
                // Read single valued data
                if (paramValues.length == 1) {
                    String paramValue = paramValues[0];
                    if (paramValue.length() == 0)
                        theOrder += "Empty Cart";
                    else
                        theOrder += paramValue;
                } else {
                    for (int i = 0; i < paramValues.length; i++) {
                        theOrder += paramValues[i] + ",";
                    }
                    theOrder = theOrder.substring(0, theOrder.length() - 1);
                }
            }
        }
        Cookie items = new Cookie("cartItem", theOrder);

        items.setMaxAge(60*60*24);
        response.addCookie( items );

        String site = new String("cart");
        response.setStatus(response.SC_MOVED_TEMPORARILY);
        response.setHeader("Location", site);
    }
}


