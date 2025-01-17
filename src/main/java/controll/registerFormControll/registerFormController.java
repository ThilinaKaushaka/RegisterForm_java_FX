package controll.registerFormControll;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
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
        boolean Lc=true;
        if(txtUserName.getText().equals(""))lblErrorMessege.setText(lblErrorMessege.getText()+"Enter User Name \n");
        if (txtEmail.getText().equals(""))lblErrorMessege.setText(lblErrorMessege.getText()+"Enter Email \n");

        if(!txtPassWord.getText().equals(txtReEnterPassword.getText())){
            lblErrorMessege.setText(lblErrorMessege.getText()+"Enter Password Again");
            txtPassWord.setText("");
            txtReEnterPassword.setText("");
        }

        if (new RegisterControll().isHaveUser(txtEmail.getText())){
            new Alert(Alert.AlertType.ERROR,"Email is Alrady Use").show();
            txtEmail.setText("");
            Lc=false;
        }else {
            if (Lc && !txtUserName.getText().equals("") && !txtEmail.getText().equals("") &&  !txtPassWord.getText().equals("") &&  !txtReEnterPassword.getText().equals("") && txtPassWord.getText().equals(txtReEnterPassword.getText())){
                try {
                    boolean is=new RegisterControll().userRegister(new User(
                            txtUserName.getText(),
                            txtEmail.getText(),
                            txtPassWord.getText()
                    ));

                    if (is){

                        new Alert(Alert.AlertType.CONFIRMATION,"Added Succus!").show();

                        txtUserName.setText("");
                        txtEmail.setText("");
                        txtPassWord.setText("");
                        txtReEnterPassword.setText("");
                    }

                } catch (SQLException e) {

                }finally {
                    System.gc();
                }
            }else {
                new Alert(Alert.AlertType.ERROR,"try again ! ").show();
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

    @Override
    public boolean isHaveUser(String email) {
        return false;
    }
}
