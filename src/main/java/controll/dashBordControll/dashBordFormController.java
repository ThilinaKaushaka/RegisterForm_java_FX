package controll.dashBordControll;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;

public class dashBordFormController {

    public JFXButton btnRegisterNewUser;
    @FXML
    private JFXButton btnCustomerForm;

    @FXML
    private JFXButton btnItem;

    @FXML
    private JFXButton btnOrder;

    @FXML
    private AnchorPane loadFormContent;

    @FXML
    void btnCustomerFormOnAction(ActionEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/customerForm/customerForm.fxml");
        assert resource !=null;

        Parent load = FXMLLoader.load(resource);

        loadFormContent.getChildren().clear();
        loadFormContent.getChildren().add(load);
    }

    @FXML
    void btnItemOnAction(ActionEvent event) {

    }

    @FXML
    void btnOrderOnAction(ActionEvent event) {

    }

    public void btnRegisterNewUserOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/register_Form/User_Register_Form.fxml");
        assert resource !=null;
        Parent load = FXMLLoader.load(resource);

        loadFormContent.getChildren().clear();
        loadFormContent.getChildren().add(load);
    }
}
