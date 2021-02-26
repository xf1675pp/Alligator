
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.*;


/**
 *
 * @author Raju
 */
public class MovieDriver 
{

       
       /**
       *This method updates the movie details
       */
       public updateMovie(int movie_id, String title, String native_name)
       {
              
       }
       

    //This method will return true if a movie is created.
    public boolean createMovie(){
        return true;
    }

       public static void main(String[] args)
       {
           
           try {
               Class.forName("com.mysql.cj.jdbc.Driver");
               //1.Connecting to database
               //Connection allConn= DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb");
        	
        	   
        	String url = "jdbc:mysql://localhost:3306/omdb";
   			 String user = "root";
   			 String password = "";
   			Connection allConn = DriverManager.getConnection( url, user, password);
   			
               //2. Creating a statement
               Statement allStmt = allConn.createStatement();

               //3. Sql Query
               ResultSet allsql = allStmt.executeQuery("SELECT * FROM movies");

               //Process the result
               while (allsql.next())
               {
                   System.out.println(allsql.getString("movie_id"));
                   System.out.println(allsql.getString("english_name"));
                   System.out.println(allsql.getString("native_name"));
                   System.out.println(allsql.getString("year_made"));
                   System.out.println("------------------------------------------"); 
               }
               allsql.close();

       }
           catch (Exception exc)
           {
               exc.printStackTrace();
           }
       }

}
