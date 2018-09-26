package servlets;

import database.DBConnector;
import classes.CalItems;
import classes.Quickstart;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.jsp.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

public class MainServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

//       PrintWriter writer = response.getWriter();
//
//       ResultSet resultSet = null;
//       Statement statement = null;
////
//
////
//      try {
//           Connection conn = new DBConnector().getConn();
//           statement = conn.createStatement();
//           resultSet = statement.executeQuery("SELECT * FROM quotes");
////           writer.print("QUOTES, ");
////           writer.println();
////           while(resultSet.next()){
////               writer.print(resultSet.getString("quote") + ", ");
////               writer.print(resultSet.getString("author") + ", ");
////           }
//       } catch (SQLException e){
//           System.out.println(e.getErrorCode());
//       } finally {
//           if (resultSet != null) {
//               try {
//                   resultSet.close();
//               } catch (SQLException sqlEx) {
//                   System.out.println(sqlEx);
//               }
//           }
//
//           if (statement != null){
//               try {
//                   statement.close();
//               } catch (SQLException sqlEx) {
//                   System.out.println(sqlEx);
//               }
//           }
//
//          request.setAttribute("quote_list", resultSet);
//          RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
//          dispatcher.forward(request, response);
//       }

      List<CalItems> items = Quickstart.getItems();
      request.setAttribute("calendar_list", items);
      RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
      dispatcher.forward(request, response);

    }

}
