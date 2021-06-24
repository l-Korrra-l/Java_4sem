import org.apache.http.util.EntityUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;


@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        exec2(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        exec(request, response);
    }

    public void exec(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");

        ServletContext sc = this.getServletContext();
        PrintWriter out = response.getWriter();

        for (Cookie c:request.getCookies() ) {
            if (c.getName().equals("cookie"))
            {

                out.println("<p>Last doGet : " + c.getValue()+ "</p>");
                out.println("<p>Protocol - " + request.getProtocol() + "</p>");
            }
        }


        Cookie cookie;
        cookie = new Cookie("cookie", request.getMethod() +" "+ (new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())));
        response.addCookie(cookie);
    }

    public void exec2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");

        ServletContext sc = this.getServletContext();
        PrintWriter out = response.getWriter();

       // out.println(EntityUtils.toString(response.getEntity(), "UTF-8"));
        Cookie cookie;
        cookie = new Cookie("cookie", request.getMethod() +" "+ (new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())));
        response.addCookie(cookie);
    }
}

