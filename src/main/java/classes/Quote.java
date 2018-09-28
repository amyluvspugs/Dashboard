package classes;

import database.DBConnector;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Quote {
//
//           PrintWriter writer = response.getWriter();
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
//////           writer.print("QUOTES, ");
//////           writer.println();
//////           while(resultSet.next()){
//////               writer.print(resultSet.getString("quote") + ", ");
//////               writer.print(resultSet.getString("author") + ", ");
//////           }
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

}
