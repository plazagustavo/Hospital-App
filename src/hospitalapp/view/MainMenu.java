package hospitalapp.view;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MainMenu {
    private VBox root;

    public MainMenu(Stage stage) {
        root = new VBox(20);
        root.setStyle("-fx-padding: 30; -fx-alignment: center;");

        
        Button btnPacientes = new Button("Gestionar pacientes ");
        Button btnDoctores = new Button("Gestionar Doctores");
        Button btnTurnos = new Button("Gestion de turnos");
        
        root.getChildren().addAll(btnPacientes, btnDoctores, btnTurnos);
        
        btnPacientes.setOnAction(e -> abrirVentana(stage, new PacientesView(stage).getRoot(), "Portal Paciente"));
        //    btnDoctores.setOnAction(e -> abrirVentana(stage, new DoctoresView(stage).getRoot(), "Portal Doctores"));
        // TO DO:  btnTurnos.setOnAction(e -> abrirVentana(stage, new TurnosView(stage).getRoot(), "Portal Turnos"));

    }

    public Parent getRoot() {
        return root;
    }
    
    public void abrirVentana(Stage stage, VBox contenido, String titulo){
        Stage nuevo = new Stage();
        nuevo.setTitle(titulo);
        nuevo.setScene(new Scene(contenido, 800, 400));
        nuevo.show();
    } 
    
    

}
