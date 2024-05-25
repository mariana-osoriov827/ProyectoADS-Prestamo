package ads.puj.proyectoadsprestamo.integracion;
import ads.puj.proyectoadsprestamo.dominio.Libro;
import ads.puj.proyectoadsprestamo.dominio.Prestamo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import java.io.*;
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

    public void guardarPrestamo(Prestamo prestamo) throws JsonIOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(prestamo);
        System.out.println(json);

        String filename = getNextFilename("src/main/resources/ads/puj/proyectoadsprestamo/", "prestamo");

        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getNextFilename(String directoryPath, String baseFilename) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.startsWith(baseFilename) && name.endsWith(".json"));
        if (files == null || files.length == 0) {
            return directoryPath + baseFilename + "1.json";
        }
        int maxNumber = 0;
        for (File file : files) {
            String name = file.getName();
            String numberStr = name.substring(baseFilename.length(), name.length() - 5); // Extract number part
            try {
                int number = Integer.parseInt(numberStr);
                if (number > maxNumber) {
                    maxNumber = number;
                }
            } catch (NumberFormatException e) {
                // Ignore files that do not match the expected format
            }
        }
        return directoryPath + baseFilename + (maxNumber + 1) + ".json";
    }
}