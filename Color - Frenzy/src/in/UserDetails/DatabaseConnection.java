package in.UserDetails;

import java.sql.DriverManager;
// import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class DatabaseConnection {

    private static final String _jdbcUrl = "jdbc:mariadb://localhost:3306/Cognitive_Project";
    private static final String _user = "root";
    private static final String _password = "new_password";

    public void insertIntoDatabase(String PlayerName, int PlayerAge, String PlayerGender, int PlayerScore) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(_jdbcUrl, _user, _password);

            String SQLQuery = "insert into PlayerInfo (Player_Name, Player_Age, Player_Gender, Score) values (?, ?, ?, ?)";
            statement = connection.prepareStatement(SQLQuery);

            statement.setString(1, PlayerName);
            statement.setInt(2, PlayerAge);
            statement.setString(3, PlayerGender);
            statement.setInt(4, PlayerScore);

            statement.executeUpdate();

        } catch(SQLException exception) {
            System.out.println("Database Connection or Query Error: " + exception.getMessage());
        } finally {
            try {
                if(statement != null) statement.close();
                if(connection != null) connection.close();
            } catch(Exception except) {
                System.out.println("Error while closing the Resources: " + except.getMessage());
            }
        }


    }
    
}