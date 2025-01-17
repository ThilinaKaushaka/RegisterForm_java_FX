package controll.log_In_Form_Controll;

import DBConnection.GetDBConnection;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;
import model.User;
import org.jasypt.util.text.BasicTextEncryptor;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

public class LogInFormController {

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXPasswordField txtPasword;
    @FXML
    private JFXButton btnLogIn;

    @FXML
    private Hyperlink lnkRegisterLink;

    @FXML
    void btnLogInOnAction(ActionEvent event)  {

        String key="#D99Tbbn%dgfpklgdG";

        BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor() ;
        basicTextEncryptor.setPassword(key);



        if ((!txtEmail.getText().equals("")) && (!txtPasword.getText().equals(""))){
            User user = null;

            try {
                ResultSet resultSet = GetDBConnection.getInstance().getConnection().createStatement().executeQuery("select * from users where email='" + txtEmail.getText() +  "'");
                if (resultSet.next()){
                    user=new User(
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4)
                    );


                }else {
                    new Alert(Alert.AlertType.ERROR,"Invalid Email").show();
                    txtEmail.setText("");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            if (user!=null && basicTextEncryptor.decrypt(user.getPassword()).equals(txtPasword.getText())){
                Stage stage=new Stage();
                try {

                    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dash_Bord/dashBord.fxml"))));
                    stage.show();
                    txtPasword.setText("");
                    txtEmail.setText("");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }else {
                new Alert(Alert.AlertType.ERROR,"Incorrect PassWord").show();
                txtPasword.setText("");
            }
        }




    }

    @FXML
    void lnkRegisterLink(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/register_Form/User_Register_Form.fxml"))));
        stage.show();
    }

}
