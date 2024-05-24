module ads.puj.proyectoprestamolibros {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    opens ads.puj.proyectoadsprestamo.dominio to com.google.gson;
    opens ads.puj.proyectoadsprestamo to javafx.fxml; // Abre el paquete al módulo javafx.fxml
    exports ads.puj.proyectoadsprestamo;
}
