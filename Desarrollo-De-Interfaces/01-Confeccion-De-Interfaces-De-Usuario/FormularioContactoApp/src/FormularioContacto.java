import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioContacto {
    private JTextField nombreTextField;
    private JTextField emailTextField;
    private JTextArea mensajeTextArea;
    private JButton buttonEnviar;
    private JLabel etNombre;
    private JLabel etEmail;
    private JPanel panelPrincipal;

    public FormularioContacto() {
        buttonEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Este código se ejecuta cuando se hace clic en buttonEnviar
                String nombre = nombreTextField.getText();
                String email = emailTextField.getText();
                String mensaje = mensajeTextArea.getText();
                //Validaciones básicas
                if (nombre.trim().isEmpty() || email.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(panelPrincipal,"Por favor, complete todos los campos", "Campos incompletos", JOptionPane.WARNING_MESSAGE); // Usamos panelPrincipal como padre
                    return; // No continuar si los campos están vacíos
                }
                String mensajeConfirmacion = "El usuario: " + nombre + ", con Email: " + email + "Ha enviado el siguiente mensaje: " + mensaje;
                JOptionPane.showMessageDialog(panelPrincipal,mensajeConfirmacion,"confirmación de Envío", JOptionPane.INFORMATION_MESSAGE); // Usamos panelPrincipal como padre del diálogo
                // Limpiar los campos después de enviar
                nombreTextField.setText("");
                emailTextField.setText("");
                mensajeTextArea.setText("");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Formulario de Contacto"); // Título de la ventana
                // Crea una instancia de tu clase de formulario (que es un JPanel)
                FormularioContacto formulario = new FormularioContacto();
                frame.setContentPane(formulario.panelPrincipal); // Establece el panel del formulario como contenido de la ventana

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack(); // Ajusta el tamaño de la ventana al contenido preferido
                frame.setLocationRelativeTo(null); // Centra la ventana
                frame.setVisible(true);
            }
        });
    }
}
