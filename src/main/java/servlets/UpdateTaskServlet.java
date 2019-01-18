package servlets;

import database.DBConnector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateTaskServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
     //ToDo needs to do 2 things - mark complete or archive depending on what was clicked

       // going to set the archive to true for the record with the id passed in

        //int id = request.getIntHeader("id");
        //Integer id = request.getIntHeader("id");
        String id = request.getParameter("id");

       //int id = Integer.parseInt(request.getParameter("id"));
       //Integer id = Integer.valueOf(request.getParameter("id"));

        //int id = Integer.valueOf(request.getParameter("id"));

        System.out.println("id value in the updateservlet: " + id);
        PreparedStatement statement = null;
        //String sql = "UPDATE Tasks SET archive = true WHERE id = id";
        String sql = "UPDATE dashboard.tasks SET archive = 1 WHERE id = " + id;

        try{
            Connection conn = new DBConnector().getConn();
            statement = conn.prepareStatement(sql);
            statement.executeUpdate();
            //writer.println(i+" records inserted");

        }catch (SQLException e){
            System.out.println(e.getErrorCode());
        }
    }
}
