package hospitalapp;

import hospitalapp.model.HospitalData;
import hospitalapp.view.MainMenu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        HospitalData.caragarDatosDemo();
        
        MainMenu menu = new MainMenu(stage);
        Scene scene = new Scene(menu.getRoot(), 300, 200);
        stage.setTitle("Hospital Manager");
        stage.setScene(scene);
        stage.show();
        
    }
}
