
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

	/* this method will delete the movie that has same movie_id input. 
	 * return true if movie with the movie_id has been deleted.
	 * return false if movie with the movie_id has fail to delete.
	 */
	public boolean deleteMovie(int movie_id){
		
	}


       
       /**
       *This method updates the movie details
       */
       public updateMovie(int movie_id, String title, String native_name)
       {
              
       }
       

    //This method will return true if a movie is created.
    public boolean createMovie(){

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
    
                String url = "jdbc:mysql://localhost:3306/omdb";
                String user = "root";
                String password = "";
                Connection allConn = DriverManager.getConnection(url, user, password);
    
                // grab input from user for new movie details
                Scanner in = new Scanner(System.in);
    
                System.out.println("Please enter a Movie Name: ");
                String english_name = in.nextLine();
    
                System.out.println("Please enter the native name of the movie: ");
                String native_name = in.nextLine();
    
                System.out.println("Please enter a Movie Year: ");
                String year_made = in.nextLine();
    
                int nextMovie_id = 0;
    
                // Creating a statement to find the next index for the movie
                Statement allStmt = allConn.createStatement();
    
                // 3. Sql Query for the movie index of new movie
                ResultSet allsql = allStmt.executeQuery("SELECT max(movie_id) from movies");
    
                // assign the next movie ID to nextmovie_id variable
                if(allsql.next()){
                    nextMovie_id = allsql.getInt(1) + 1;
                }
    
                //statement for the insert query into the db
                String sql = "INSERT INTO movies (movie_id, native_name, english_name, year_made) VALUES (?, ?, ?, ?)";
                
                //create prepared statement for insertion 
                PreparedStatement statement = allConn.prepareStatement(sql);
                statement.setLong(1, nextMovie_id);
                statement.setString(2, native_name);
                statement.setString(3, english_name);
                statement.setString(4, year_made);
                 
                //print a message if added correctly
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("A new movie has been created successfully!");
                }
                
                //close connections
                allsql.close();
                in.close();
            
                //catch for errors of db connection
            } catch (Exception exc) {
                exc.printStackTrace();
            }
    
            return true;
        }
      
	 //This method edits movie data-Sapana
	
    public boolean editmovie(){
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
