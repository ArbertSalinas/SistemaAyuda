package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Ayuda;
import model.Estado;
import model.TipoAyuda;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class JPUniversityController {

    @FXML
    private TextField codigoField;

    @FXML
    private TextField nombreField;

    @FXML
    private ComboBox<TipoAyuda> tipoAyudaComboBox;

    @FXML
    private ListView<Ayuda> ayudasListView;

    @FXML
    private Label entregadasLabel;

    @FXML
    private Label rechazadasLabel;

    @FXML
    private Label asignadasLabel;

    @FXML
    private Label estudiantesFavorecidosLabel;

    private ObservableList<Ayuda> ayudas;
    private Set<String> estudiantesFavorecidos;

    public void initialize() {
        ayudas = FXCollections.observableArrayList();
        ayudasListView.setItems(ayudas);
        tipoAyudaComboBox.setItems(FXCollections.observableArrayList(TipoAyuda.values()));
        estudiantesFavorecidos = new HashSet<>();
    }

    @FXML
    private void handleAsignarAyuda() {
        String codigo = codigoField.getText();
        String nombre = nombreField.getText();
        TipoAyuda tipoAyuda = tipoAyudaComboBox.getValue();

        if (codigo.isEmpty() || nombre.isEmpty() || tipoAyuda == null) {
            // Manejar campos vacíos
            return;
        }

        Ayuda nuevaAyuda = new Ayuda(codigo, nombre, tipoAyuda, LocalDate.now(), Estado.ASIGNADA);
        ayudas.add(nuevaAyuda);
        actualizarContadores();
    }

    @FXML
    private void handleEntregarAyuda() {
        Ayuda ayudaSeleccionada = ayudasListView.getSelectionModel().getSelectedItem();
        if (ayudaSeleccionada != null && ayudaSeleccionada.getEstado() == Estado.ASIGNADA) {
            ayudaSeleccionada.setEstado(Estado.ENTREGADA);
            estudiantesFavorecidos.add(ayudaSeleccionada.getCodigoEstudiante());
            actualizarContadores();
        }
    }

    @FXML
    private void handleRechazarAyuda() {
        Ayuda ayudaSeleccionada = ayudasListView.getSelectionModel().getSelectedItem();
        if (ayudaSeleccionada != null && ayudaSeleccionada.getEstado() == Estado.ASIGNADA) {
            ayudaSeleccionada.setEstado(Estado.RECHAZADA);
            actualizarContadores();
        }
    }

    private void actualizarContadores() {
        long entregadas = ayudas.stream().filter(a -> a.getEstado() == Estado.ENTREGADA).count();
        long rechazadas = ayudas.stream().filter(a -> a.getEstado() == Estado.RECHAZADA).count();
        long asignadas = ayudas.stream().filter(a -> a.getEstado() == Estado.ASIGNADA).count();

        entregadasLabel.setText("Ayudas Entregadas: " + entregadas);
        rechazadasLabel.setText("Ayudas Rechazadas: " + rechazadas);
        asignadasLabel.setText("Ayudas Asignadas: " + asignadas);
        estudiantesFavorecidosLabel.setText("Estudiantes Favorecidos: " + estudiantesFavorecidos.size());
    }
}
