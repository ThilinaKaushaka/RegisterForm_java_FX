package controll.registerFormControll;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.User;


import java.sql.Connection;
import java.sql.SQLException;

public class registerFormController implements RegisterFormService {

    private static Stage stage;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private JFXButton btnRegister;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXPasswordField txtPassWord;

    @FXML
    private JFXPasswordField txtReEnterPassword;

    @FXML
    private JFXTextField txtUserName;

    @FXML
    private Label lblErrorMessege;

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        stage.close();
        System.gc();
    }

    @FXML
    void btnRegisterOnAction(ActionEvent event) {
        if(txtUserName.getText().equals(""))lblErrorMessege.setText(lblErrorMessege.getText()+"Enter User Name \n");
        if (txtEmail.getText().equals(""))lblErrorMessege.setText(lblErrorMessege.getText()+"Enter Email \n");

        if(!txtPassWord.getText().equals(txtReEnterPassword.getText())){
            lblErrorMessege.setText(lblErrorMessege.getText()+"Enter Password Again");
            txtPassWord.setText("");
            txtReEnterPassword.setText("");
        }

        if ( !txtUserName.getText().equals("") && !txtEmail.getText().equals("") &&  !txtPassWord.getText().equals("") &&  !txtReEnterPassword.getText().equals("") && txtPassWord.getText().equals(txtReEnterPassword.getText())){
            try {
                boolean Lc=new RegisterControll().userRegister(new User(
                        txtUserName.getText(),
                        txtEmail.getText(),
                        txtPassWord.getText()
                ));

                if (Lc){
                    txtUserName.setText("");
                    txtEmail.setText("");
                    txtPassWord.setText("");
                    txtReEnterPassword.setText("");
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                System.gc();
            }
        }


    }

    public static void setStage(Stage st){
        stage=st;
    }



    @Override
    public Connection getDBConnection() throws SQLException {
        return null;
    }

    @Override
    public boolean userRegister(User user) throws SQLException {
        return false;
    }
}
