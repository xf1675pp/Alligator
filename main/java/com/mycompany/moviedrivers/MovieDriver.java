
import java.sql.Connection;
import java.sql.*;

/**
 *
 * @author Tenzin & Hamza
 * 
 */

public class MovieDriver 
{

	public static void readMovie(){
		try{	
			Connection allConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omdb", "root", "");

			Statement allStmt = allConn.createStatement();
			ResultSet allsql = allStmt.executeQuery("SELECT * FROM movies, movie_data WHERE movies.movie_id = movie_data.movie_id");

			while(allsql.next()){
				System.out.println(allsql.getString("movie_id"));
				System.out.println(allsql.getString("english_name"));
				System.out.println(allsql.getString("native_name"));
				System.out.println(allsql.getString("year_made"));
				System.out.println(allsql.getString("tag_line"));
				System.out.println(allsql.getString("movie_id"));
				System.out.println(allsql.getString("language"));
				System.out.println(allsql.getString("country"));
				System.out.println(allsql.getString("genre"));
				System.out.println(allsql.getString("plot"));
			}
		}
		catch (Exception exc)
		{
			exc.printStackTrace();
		}
	}

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
		readMovie();
	}

}
