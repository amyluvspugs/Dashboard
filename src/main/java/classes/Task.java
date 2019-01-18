package classes;

import database.DBConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import database.DBConnector;

import java.sql.*;
import java.util.List;

public class Task {

    ResultSet resultSet = null;
    Statement statement = null;
    Integer id;
    String owner = "amynhenning@gmail.com";   //TODO temporarily hard coded
    String task;
    Boolean complete;  // does that translate to the sql type?
    Boolean archive;
    //TODO  add an array


public Task(){

}

public Task(Integer id, String owner, String task, Boolean complete, Boolean archive){
    super();
    this.id = id;
    this.task = task;
    this.owner = owner;
    this.complete = complete;
    this.archive = archive;
}
    public Integer getId() {return id;}

    public String getTask(){return task;}

    public String getOwner(){return owner;}

    public Boolean getComplete(){return complete;}

    public Boolean getArchive(){return archive;}

    public void setArchive(Integer id){
        // going to set the archive to true for the record with the id passed in

        PreparedStatement statement = null;
        String sql = "UPDATE Tasks SET archive = true WHERE id = id";

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