package servlets;

import classes.*;
import com.sun.xml.internal.xsom.impl.scd.Iterators;
import database.DBConnector;

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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

      List<Task> tasklist = TaskList.getTaskList();
      request.setAttribute("tasklist_list", tasklist);

      List<CalItems> items = Quickstart.getItems();
      request.setAttribute("calendar_list", items);
      // adding more attributes in here

      Quote quote = new Quote();

      System.out.println("quote value: " + quote.getQuote());
      System.out.println("author value: " + quote.getAuthor());

      request.setAttribute("quote_return", quote.getQuote());
      request.setAttribute("author_return", quote.getAuthor());

      //
      RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
      dispatcher.forward(request, response);

    }

}
