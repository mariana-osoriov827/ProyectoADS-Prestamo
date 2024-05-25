package ads.puj.proyectoadsprestamo.dominio;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Prestamo {
    Date fecha;
    List<Pago> pagos = new ArrayList<>();
    Estudiante prestatario;
    List<Linea> lineas = new ArrayList<>();

    public Prestamo() {
        this.fecha = new Date();
    }

    public Date getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "fecha=" + fecha +
                ", pagos=" + pagos +
                ", prestatario=" + prestatario +
                ", lineas=" + lineas;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }

    public Estudiante getPrestatario() {
        return prestatario;
    }

    public void setPrestatario(Estudiante prestatario) {
        this.prestatario = prestatario;
    }

    public List<Linea> getLineas() {
        return lineas;
    }

    public void setLineas(List<Linea> lineas) {
        this.lineas = lineas;
    }

    public Prestamo(Date fecha, List<Pago> pagos, Estudiante prestatario, List<Linea> lineas) {
        this.fecha = fecha;
        this.pagos = pagos;
        this.prestatario = prestatario;
        this.lineas = lineas;
    }

    public void agregarLinea(Linea linea) {
        this.lineas.add(linea);
    }
    public float totalizarPagos(){
        float total = 0;
        for(Pago p: pagos){
            total+=p.getCantidad();
        }
        return total;
    }
}
