package ads.puj.proyectoadsprestamo.dominio;

public class Pago {
    Float cantidad;

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    public Pago() {
    }

    public Pago(Float cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Pago{" +
                "cantidad=" + cantidad +
                '}';
    }
}
