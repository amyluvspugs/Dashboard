package servlets;

import database.DBConnector;
import Quickstart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class MainServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
       PrintWriter writer = response.getWriter();

       ResultSet resultSet = null;
       Statement statement = null;

        Date now = new Date(); // The current date/time

        Quickstart calendar = new Quickstart();


       // attempting to add css

       // String path = request.getContextPath();

        String cssTag="<link rel='stylesheet' type='text/css' href='" + request.getContextPath() + "/main3.css' />";

              writer.println("<html>");
              writer.println("<head>"+"<title>Title Name</title>"+cssTag+"</head>");
            writer.println("<body>");
            writer.println("<div id='container'>");
        writer.println("<div id='secondary'>");
        writer.println("<h1><p>The time is: " + now + "</h1></p></div>");

            writer.println("<div id='content'>");

        //end

       try {
           Connection conn = new DBConnector().getConn();
           statement = conn.createStatement();
           resultSet = statement.executeQuery("SELECT * FROM quotes");
           writer.print("QUOTES, ");
           writer.println();
           while(resultSet.next()){
              // System.out.println(resultSet.getString("quote"));
              // System.out.println(resultSet.getString("author"));
               writer.print(resultSet.getString("quote") + ", ");
               writer.print(resultSet.getString("author") + ", ");
           }
       } catch (SQLException e){
           System.out.println(e.getErrorCode());
       } finally {
           if (resultSet != null) {
               try {
                   resultSet.close();
               } catch (SQLException sqlEx) {
                   System.out.println(sqlEx);
               }
           }

           if (statement != null){
               try {
                   statement.close();
               } catch (SQLException sqlEx) {
                   System.out.println(sqlEx);
               }
           }
       }
        // closing css
        writer.println("</div>");
        writer.println("<div id='primary'>");
        writer.println("my cat is noah");
        //writer.println("</div>");

        writer.println("</div></div></body></html>");
    }
}
