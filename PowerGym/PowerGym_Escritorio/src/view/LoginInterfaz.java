package view;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginInterfaz extends JFrame implements ActionListener {
    private JLabel lblTitulo;
    private JLabel lblUsuario;
    private JLabel lblContraseña;
    private JTextField txtUsuario;
    private JPasswordField txtContraseña;
    private JButton btnLogin;

    public LoginInterfaz() {
        // Configurar la ventana de inicio de sesión
        setTitle("PowerGym - Iniciar Sesión");
        setSize(658, 672);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear los componentes
        lblTitulo = new JLabel("PowerGym");
        lblUsuario = new JLabel("Usuario:");
        lblContraseña = new JLabel("Contraseña:");
        txtUsuario = new JTextField();
        txtContraseña = new JPasswordField();
        btnLogin = new JButton("Iniciar Sesión");

        // Configurar la posición y tamaño de los componentes
        lblTitulo.setBounds(254, 80, 150, 30);
        lblUsuario.setBounds(134, 180, 100, 30);
        txtUsuario.setBounds(254, 180, 250, 30);
        lblContraseña.setBounds(134, 230, 100, 30);
        txtContraseña.setBounds(254, 230, 250, 30);
        btnLogin.setBounds(254, 280, 150, 30);

        // Agregar los componentes a la ventana
        add(lblTitulo);
        add(lblUsuario);
        add(txtUsuario);
        add(lblContraseña);
        add(txtContraseña);
        add(btnLogin);

        // Registrar el listener de eventos
        btnLogin.addActionListener(this);

        // Mostrar la ventana de inicio de sesión
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            // Cerrar la ventana de inicio de sesión
            dispose();

            // Abrir la ventana del menú principal
            MenuPrincipalInterfaz menuPrincipal = new MenuPrincipalInterfaz();
            menuPrincipal.setVisible(true);
        }
    }

    public static void main(String[] args) {
        // Crear la instancia de la interfaz de inicio de sesión
        LoginInterfaz login = new LoginInterfaz();
    }
}
