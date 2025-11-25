import java.time.LocalDate;

public class Empleado {
    int idEmpleado;
    String nombre;
    String puesto;
    String tipoJornada;
    String email;
    String telefono;
    LocalDate fechaContratacion;
    double salarioHora;
    boolean activo;

    public Empleado(String nombre, String puesto, String tipoJornada, String email, String telefono, LocalDate fechaContratacion, double salarioHora, boolean activo){
        this.nombre= nombre;
        this.puesto = puesto;
        this.tipoJornada = tipoJornada;
        this.email = email;
        this.telefono = telefono;
        this.fechaContratacion = fechaContratacion;
        this.salarioHora = salarioHora;
        this.activo = activo;
    }
    public Empleado(int idEmpleado){
        this.idEmpleado = idEmpleado;
    }
    public Empleado(int idEmpleado, String nombre, String puesto, String tipoJornada, String email, String telefono, LocalDate fechaContratacion, double salarioHora, boolean activo){
        this.idEmpleado = idEmpleado;
        this.nombre= nombre;
        this.puesto = puesto;
        this.tipoJornada = tipoJornada;
        this.email = email;
        this.telefono = telefono;
        this.fechaContratacion = fechaContratacion;
        this.salarioHora = salarioHora;
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "idEmpleado=" + idEmpleado +
                ", nombre='" + nombre + '\'' +
                ", puesto='" + puesto + '\'' +
                ", tipoJornada='" + tipoJornada + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", fechaContratacion=" + fechaContratacion +
                ", salarioHora=" + salarioHora +
                ", activo=" + activo +
                '}';
    }
}
