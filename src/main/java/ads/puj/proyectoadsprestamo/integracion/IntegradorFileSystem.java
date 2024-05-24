package ads.puj.proyectoadsprestamo.integracion;
import ads.puj.proyectoadsprestamo.dominio.Libro;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegradorFileSystem {

    public List<Libro> readLibrosFromJson() throws JsonIOException, JsonSyntaxException {
        Gson gson = new Gson();
        List<Libro> catalogo = new ArrayList<>();
        try (Reader reader = new FileReader("src/main/resources/ads/puj/proyectoadsprestamo/catalogo.json")) {
            Libro[] librosArray = gson.fromJson(reader, Libro[].class);
            catalogo = Arrays.asList(librosArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return catalogo;
    }

    private static void guardarPrestamo(List<Libro> catalogo) throws JsonIOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(catalogo);
        System.out.println(json);
        try (FileWriter writer = new FileWriter("src/main/resources/ads/puj/proyectoadsprestamo/prestamos.json")) {
            gson.toJson(catalogo, writer);
        } catch (IOException e) {
        }
    }
}