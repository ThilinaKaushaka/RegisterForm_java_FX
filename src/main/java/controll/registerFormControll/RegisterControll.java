package controll.registerFormControll;

import DBConnection.GetDBConnection;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class RegisterControll implements RegisterFormService{
    @Override
    public Connection getDBConnection() throws SQLException {
        return GetDBConnection.getInstance().getConnection();
    }

    @Override
    public boolean userRegister(User user) throws SQLException {

        String sql="Insert into users (username,email,password) Values(?,?,?)";

        PreparedStatement statement=getDBConnection().prepareStatement(sql);

        statement.setObject(1,user.getUserName());
        statement.setObject(2,user.getEmail());
        statement.setObject(3,user.getPassword());
        return 0<statement.executeUpdate();
    }
}
