package classes;

import database.DBConnector;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskList {
    public static List<Task> getTaskList() throws IOException {
        System.out.println("***ENTERED THE GETTASKLIST()");
        ResultSet resultSet = null;
        Statement statement = null;

        Integer id;
        String owner = "amynhenning@gmail.com";   //TODO temporarily hard coded
        String task;
        Boolean complete;  // does that translate to the sql type?
        Boolean archive;
        //TODO  add an array
        List<Task> list = new ArrayList<>();

//    public TaskList(){
//        getTaskList();
//    }
//
//    public void getTaskList() {   // pass in owner id

        try {
            System.out.println("*** UNDER THE TRY ");
            Connection conn = new DBConnector().getConn();
            statement = conn.createStatement();
            //resultSet = statement.executeQuery("SELECT * FROM quotes");
            //TODO add to SQL select statement the logged in user and where archive is false
            //resultSet = statement.executeQuery("SELECT COUNT(text) FROM TASKS where user='amynhenning@gmail.com'");

            resultSet = statement.executeQuery("SELECT * FROM TASKS where user='amynhenning@gmail.com'");

            while (resultSet.next()) {
               // count = resultSet.getInt("text");
                System.out.println("****in the while loop");
                id = resultSet.getInt("id");
                owner = resultSet.getString("user");
                task = resultSet.getString("text");
                complete = resultSet.getBoolean("completed");
                archive = resultSet.getBoolean("archive");
                list.add(new Task(id, owner, task, complete, archive));
                System.out.println(task);

            }



            //resultSet.next();

            //resultSet.


        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException sqlEx) {
                    System.out.println(sqlEx);
                }
            }
        }

//            if (statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException sqlEx) {
//                    System.out.println(sqlEx);
//                }
//            }
        //   }
        return list;
    }
}


//    public Boolean getComplete(){
//        return complete;
//    }
//    public String getTask(){
//        return task;
//    }


//}
