public class EmployeeManagement {
    //Crear un usuario
    public void createEmployee(){
        String query = "INSERT INTO usuarios (nombre, puesto, tipo_jornada, email, telefono, fecha_contratacion, salario_hora, activo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    }
}
