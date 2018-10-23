package classes;

import database.DBConnector;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class Quote {

    ResultSet resultSet = null;
    Statement statement = null;
    String quote;
    String author;

    public Quote(){
        setQuote();
    }

    public void setQuote() {
        try {
            Connection conn = new DBConnector().getConn();
            //statement = conn.createStatement();
            statement = conn.createStatement();
            //resultSet = statement.executeQuery("SELECT * FROM quotes");
            resultSet = statement.executeQuery("SELECT * FROM QUOTES where idQuotes=10");
            resultSet.next();

            quote = resultSet.getString("quote");
            author = resultSet.getString("author");

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

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException sqlEx) {
                    System.out.println(sqlEx);
                }
            }
        }
    }

    public String getQuote(){
        return quote;
    }
    public String getAuthor(){
        return author;
    }
}
