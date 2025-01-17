package DBConnection;

import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetDBConnection {
    public static GetDBConnection instance;

    @Getter
    @Setter
    private Connection connection;

    private GetDBConnection() throws SQLException {
        connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade","root","13345");
    }

    public static GetDBConnection getInstance() throws SQLException {
        return instance==null?instance=new GetDBConnection():instance;
    }


}
