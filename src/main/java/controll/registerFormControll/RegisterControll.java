package controll.registerFormControll;

import DBConnection.GetDBConnection;
import model.User;
import org.jasypt.util.text.BasicTextEncryptor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegisterControll implements RegisterFormService{
    @Override
    public Connection getDBConnection() throws SQLException {
        return GetDBConnection.getInstance().getConnection();
    }

    @Override
    public boolean userRegister(User user) throws SQLException {
        String key="#D99Tbbn%dgfpklgdG";
        BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor() ;
        basicTextEncryptor.setPassword(key);




        String sql="Insert into users (username,email,password) Values(?,?,?)";

        PreparedStatement statement=getDBConnection().prepareStatement(sql);

        statement.setObject(1,user.getUserName());
        statement.setObject(2,user.getEmail().toLowerCase());
        statement.setObject(3,basicTextEncryptor.encrypt(user.getPassword()));
        return 0<statement.executeUpdate();
    }

    @Override
    public boolean isHaveUser(String email) {
        ResultSet resultSet;
        try {
            return getDBConnection().createStatement().executeQuery("select * from users WHERE email='" + email.toLowerCase() + "'").next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }

    public List<User> getAllUser(){
        ArrayList<User> userArrayList=new ArrayList<>();
        try {
            Connection connection=getDBConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users");

            while (resultSet.next())userArrayList.add(new User(
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)
            ));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return userArrayList;
    }


}
