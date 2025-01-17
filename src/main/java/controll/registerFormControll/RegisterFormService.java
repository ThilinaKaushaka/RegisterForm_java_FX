package controll.registerFormControll;

import model.User;

import java.sql.Connection;
import java.sql.SQLException;

public interface RegisterFormService {
    Connection getDBConnection() throws SQLException;
    boolean userRegister(User user) throws SQLException;
}
