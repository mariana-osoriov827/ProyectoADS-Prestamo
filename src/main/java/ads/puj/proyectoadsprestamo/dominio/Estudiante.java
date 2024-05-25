package ads.puj.proyectoadsprestamo.dominio;

public class Estudiante {
    Integer cedula;
    String nombre;

    public Estudiante(String cedula, String nombre) {
        validarNombre(nombre);
        validarCedulaString(cedula);
        this.cedula = Integer.parseInt(cedula);
        this.nombre = nombre;
    }

    public Estudiante() {
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedulaFromString(String cedulaStr) {
        validarCedulaString(cedulaStr);
        this.cedula = Integer.parseInt(cedulaStr);
    }

    private void validarCedulaString(String cedulaStr) {
        if (cedulaStr == null || cedulaStr.trim().isEmpty()) {
            throw new IllegalArgumentException("La cédula no puede estar vacía.");
        }
        try {
            int cedula = Integer.parseInt(cedulaStr);
            if (cedula <= 0) {
                throw new IllegalArgumentException("La cédula debe ser un número positivo.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("La cédula debe ser un número entero válido.");
        }
    }
    private void validarNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        validarNombre(nombre);
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "cedula=" + cedula +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
