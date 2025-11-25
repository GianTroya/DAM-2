import java.time.LocalDate;

public class Empleado {
    // ATRIBUTOS
    private int idEmpleado;
    private String nombre;
    private String puesto;
    private String tipoJornada;
    private String email;
    private String telefono;
    private LocalDate fechaContratacion;
    private double salarioHora;
    private boolean activo;

    // CONSTRUCTORES
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

    //GETTERS

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoJornada() {
        return tipoJornada;
    }

    public String getPuesto() {
        return puesto;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public double getSalarioHora() {
        return salarioHora;
    }

    public boolean isActivo() {
        return activo;
    }

    // TO STRING
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
