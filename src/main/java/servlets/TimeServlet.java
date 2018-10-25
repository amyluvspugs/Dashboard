package servlets;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class TimeServlet extends HttpServlet {
        public void doGet(HttpServletRequest request, HttpServletResponse response)
                throws IOException {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            Date now = new Date(); // The current date/time


            // attempting to add css
            String cssTag="<link rel='stylesheet' type='text/css' href='" + request.getContextPath() + "/main3.css' />";


            out.println("<html>");
            out.println("<head><title>Time Check</title>"+cssTag+"</head>");

            out.println("<body>");
            out.println("<div id='container'>");
            out.println("<div id='content'>");

            //end

            out.println("<h1>The time is: " + now + "</h1>");
            out.println("</div></div></body></html>");
        }
    }
