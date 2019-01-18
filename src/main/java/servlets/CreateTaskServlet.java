package servlets;

import database.DBConnector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTaskServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        // TODO gets the currently logged in user

        String user = "amynhenning@gmail.com";
        String task = request.getParameter("task");


        PrintWriter writer = response.getWriter();
        PreparedStatement statement = null;
        String sql = "INSERT INTO tasks (user, text) values (?,?)";

        try {
            Connection conn = new DBConnector().getConn();
            statement = conn.prepareStatement(sql);
            statement.setString(1, user);
            statement.setString(2, task);
            // statement.setString(email, password);
            int i = statement.executeUpdate();
            //writer.println(i+" records inserted");
            response.sendRedirect("/main");
            //writer.println(i + " records inserted");

        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }

    }

}
