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


      List<CalItems> items = Quickstart.getItems();
      request.setAttribute("calendar_list", items);
      RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
      dispatcher.forward(request, response);

    }

}
