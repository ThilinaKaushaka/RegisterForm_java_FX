import controll.registerFormControll.RegisterControll;
import controll.registerFormControll.registerFormController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Starter extends Application {



    public static void main(String[] args) {
        launch();

    }





    @Override
    public void start(Stage stage) throws Exception {


        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("view/register_Form/User_Register_Form.fxml"))));
        stage.setTitle("register form");
        stage.setTitle("Register Form");
        registerFormController.setStage(stage);

        stage.show();



    }






}
