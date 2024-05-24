package ads.puj.proyectoadsprestamo;

import ads.puj.proyectoadsprestamo.dominio.Libro;
import ads.puj.proyectoadsprestamo.negocio.INegocioPrestamo;
import ads.puj.proyectoadsprestamo.negocio.NegocioPrestamo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PrestamoController implements Initializable {
    private INegocioPrestamo negocio = new NegocioPrestamo();
    private final ObservableList<String> observableLibros = FXCollections.observableArrayList();
    private final ObservableList<String> observableLibrosCarrito = FXCollections.observableArrayList();
    @FXML
    private Button Limpiar;
    @FXML
    private ComboBox cmbCatalogo = new ComboBox();
    @FXML
    private ComboBox denomBilletes;
    @FXML
    private Button Mod;
    @FXML
    private Button salir;
    @FXML
    private Spinner cant= new Spinner();
    @FXML
    private Button Editar;
    @FXML
    private ListView LibrosCarro = new ListView<>();
    @FXML
    private Spinner MCant = new Spinner();
    @FXML
    private Spinner cant1= new Spinner();
    @FXML
    private Label lblTotal;
    @FXML
    private Label cargados;
    @FXML
    private Spinner cant2= new Spinner();
    @FXML
    private Button Agregar;
    @FXML
    private Button Guardar;
    @FXML
    private Button Eliminar;
    @FXML
    private ComboBox denomMonedas;
    @FXML
    private Button VerCarrito;
    @FXML
    private Label TotalPago;
    @FXML
    private TextField CedulaEstudiante = new TextField();
    @FXML
    private TextField NombreEstudiante=new TextField();

    private void loadLibros() {
        negocio.cargarLibros();
        observableLibros.setAll(negocio.getNombresCatalogo());
        cmbCatalogo.getItems().addAll(observableLibros);
    }

    private Libro getLibroSeleccionado() {
        String selectedNombre = cmbCatalogo.getValue().toString();
        for (Libro libro : negocio.getCatalogo()) {
            if (libro.getNombre().equals(selectedNombre)) {
                return libro;
            }
        }
        return null;
    }


    @FXML
    public void onButtonInsertar(ActionEvent actionEvent) {
    }

    @FXML
    public void onButtonLimpiar(ActionEvent actionEvent) {
    }

    @FXML
    public void onButtonModificar(ActionEvent actionEvent) {
    }

    @FXML
    public void onButtonEliminar(ActionEvent actionEvent) {
    }

    @FXML
    public void onButtonAgregar(ActionEvent actionEvent) {
        Libro libroSel = getLibroSeleccionado();
        Integer cantidad = (Integer) cant.getValue();
        negocio.agregarLibroAlPrestamo(libroSel, cantidad);
        lblTotal.setText(String.valueOf(negocio.totalizarPrestamo()));
        observableLibrosCarrito.setAll(negocio.getPrestamoactual().getLineas().toString());
        LibrosCarro.setItems(observableLibrosCarrito);
    }
    @FXML
    @Deprecated
    public void onButtonGuardar(ActionEvent actionEvent) {
        negocio.guardarPrestamo();
    }

    @FXML
    @Deprecated
    public void onButtonEditar(ActionEvent actionEvent) {
    }

    @Deprecated
    public void onButtonSalir(ActionEvent actionEvent) {
        try {
            // Cargar el nuevo FXML para la PantallaPrestamo
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pantallaInicio.fxml"));
            Parent root = fxmlLoader.load();

            // Obtener el controlador del FXML cargado
            PrestamoController prestamoController = fxmlLoader.getController();

            // Obtener el Stage actual
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

            // Crear una nueva escena con el contenido del FXML cargado
            Scene scene = new Scene(root);

            // Configurar la nueva escena en el Stage
            stage.setScene(scene);
            stage.setTitle("Pantalla inicio");

            // Mostrar el Stage
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadLibros();
        initializeSpinners();
    }
    @FXML
    private void initializeSpinners() {
        // Inicializar el spinner 'cant' con un rango de 0 a 10 y un valor inicial de 0
        SpinnerValueFactory<Integer> valor= new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
        cant.setValueFactory(valor);

        // Inicializar el spinner 'MCant' con un rango de 0 a 100 y un valor inicial de 0
        SpinnerValueFactory<Integer> valor2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        MCant.setValueFactory(valor2);

        // Inicializar el spinner 'cant1' con un rango de 0 a 100 y un valor inicial de 0
        SpinnerValueFactory<Integer> valor3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        cant1.setValueFactory(valor3);

        // Inicializar el spinner 'cant2' con un rango de 0 a 100 y un valor inicial de 0
        SpinnerValueFactory<Integer> valor4 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        cant2.setValueFactory(valor4);
    }
    @FXML
    public void onButtonIniciar(ActionEvent actionEvent) {
        String cedulaEstudiante = CedulaEstudiante.getText();
        String nombreEstudiante = NombreEstudiante.getText();
        if (cedulaEstudiante.isEmpty() || nombreEstudiante.isEmpty()) {
            return;
        }
        negocio.iniciarPrestamo(nombreEstudiante, cedulaEstudiante);
        try {
            // Cargar el nuevo FXML para la PantallaPrestamo
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pantallaPrestamo.fxml"));
            Parent root = fxmlLoader.load();

            // Obtener el controlador del FXML cargado
            PrestamoController prestamoController = fxmlLoader.getController();

            // Obtener el Stage actual
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

            // Crear una nueva escena con el contenido del FXML cargado
            Scene scene = new Scene(root);

            // Configurar la nueva escena en el Stage
            stage.setScene(scene);
            stage.setTitle("Pantalla de Prestamo");

            // Mostrar el Stage
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void onButtonCargar(ActionEvent actionEvent) {
        if (negocio.cargarLibros()) {
            cargados.setText("Libros cargados exitosamente! ");
        } else {
            cargados.setText("Error al cargar los libros.");
        }
    }
}