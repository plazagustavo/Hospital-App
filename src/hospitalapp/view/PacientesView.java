package hospitalapp.view;

import hospitalapp.model.HospitalData;
import hospitalapp.model.Paciente;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class PacientesView {
    private VBox root;
    
    public PacientesView(Stage stage){
        root = new VBox(10);
        root.setStyle("-fx-padding:20:");
        
        //campos de entrada
        TextField txtDni = new TextField();
        txtDni.setPromptText("DNI");
        TextField txtNombre = new TextField();
        txtNombre.setPromptText("NOMBRE");
        TextField txtApellido = new TextField();
        txtApellido.setPromptText("APELLIDO");
        TextField txtObraSocial = new TextField();
        txtObraSocial.setPromptText("OBRA SOCIAL");
        
        //Botones
        
        Button btnAgregar = new Button("Agregar");
        Button btnEliminar = new Button("Eliminar");
        
        HBox form = new HBox(10, txtDni, txtNombre, txtApellido, txtObraSocial, btnAgregar, btnEliminar);
        form.setStyle("-fx-aligment: center;");
        
        TableView<Paciente> tabla = new TableView<>(HospitalData.getPacientes());
        TableColumn<Paciente, String> cDni = new TableColumn<>("DNI");
        TableColumn<Paciente, String> cNom = new TableColumn<>("Nombre");
        TableColumn<Paciente, String> cApe = new TableColumn<>("Apellido");
        TableColumn<Paciente, String> cObc = new TableColumn<>("Obra Social");
        
        cDni.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getDni()));
        cNom.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getNombre()));
        cApe.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getApellido()));
        cObc.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getObraSocial()));
        
        tabla.getColumns().addAll(cDni, cNom, cApe, cObc);
        tabla.setPrefHeight(250);
        
        btnAgregar.setOnAction(e -> {
                if (txtDni.getText().isEmpty() || txtNombre.getText().isEmpty())
                    return;
                HospitalData.getPacientes().add(new Paciente(txtDni.getText(), txtNombre.getText(), txtApellido.getText(), txtObraSocial.getText()));
                txtDni.clear();
                txtNombre.clear();
                txtApellido.clear();
                txtObraSocial.clear();
        });
        btnEliminar.setOnAction(e -> {
            Paciente sel = tabla.getSelectionModel().getSelectedItem();
            if (sel != null) {
                HospitalData.getPacientes().remove(sel);
            }
        });
        
        root.getChildren().addAll(form, tabla, btnEliminar);
        
    }
    public VBox getRoot(){
        return root;
    }
    
}
