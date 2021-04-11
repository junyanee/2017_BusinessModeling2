
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBAccessor {
	private Connection connect = null;
	private Statement statement = null;
	protected ResultSet resultSet = null;


	void connect() throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw e;
		}

		try {
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/insurance?useSSL=false", "root",
					"park89");
		} catch (SQLException e) {
			throw e;
		}
	}

	ResultSet executeQuery(String query) throws SQLException {
		try {
            statement = connect.createStatement();
            boolean type = statement.execute(query);
            if (type) {
            	return resultSet = statement.executeQuery(query); 
            }


	    } catch (SQLException e) {
	        throw e;
	    } 
		
        return resultSet;
	}
}
