package servlets;
import database.DBConnector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class RegisterServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        PrintWriter writer = response.getWriter();
        PreparedStatement statement = null;
        String sql = "INSERT INTO users (email, password) values (?,?)";

        try {
            Connection conn = new DBConnector().getConn();
            statement = conn.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);
            // statement.setString(email, password);
            int i = statement.executeUpdate();
            //writer.println(i+" records inserted");
            writer.println(i + " records inserted");

        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
    }
}