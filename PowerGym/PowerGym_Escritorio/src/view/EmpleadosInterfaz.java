package view;

import javax.swing.*;
import java.awt.event.ActionListener;
import controller.EmpleadosController;

public class EmpleadosInterfaz extends JFrame {
    private JLabel lblId;
    private JLabel lblNombre;
    private JLabel lblApellidos;
    private JLabel lblDni;
    private JLabel lblEmail;
    private JLabel lblFechaAlta;
    private JLabel lblIban;
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtApellidos;
    private JTextField txtDni;
    private JTextField txtEmail;
    private JTextField txtFechaAlta;
    private JTextField txtIban;
    private JButton btnAnterior;
    private JButton btnSiguiente;
    private JButton btnBuscar;
    private JButton btnMenuPrincipal; // Botón para volver al menú principal

    private EmpleadosController controller; // Referencia al controlador

    public EmpleadosInterfaz(EmpleadosController controller) {
        this.controller = controller;

        // Configurar la ventana de empleados
        setTitle("PowerGym - Empleados");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear los componentes
        lblId = new JLabel("ID:");
        lblNombre = new JLabel("Nombre:");
        lblApellidos = new JLabel("Apellidos:");
        lblDni = new JLabel("DNI:");
        lblEmail = new JLabel("Email:");
        lblFechaAlta = new JLabel("Fecha de Alta:");
        lblIban = new JLabel("IBAN:");
        txtId = new JTextField();
        txtNombre = new JTextField();
        txtApellidos = new JTextField();
        txtDni = new JTextField();
        txtEmail = new JTextField();
        txtFechaAlta = new JTextField();
        txtIban = new JTextField();
        btnAnterior = new JButton("Anterior");
        btnSiguiente = new JButton("Siguiente");
        btnBuscar = new JButton("Buscar");
        btnMenuPrincipal = new JButton("Menú Principal");

        // Configurar la posición y tamaño de los componentes
        lblId.setBounds(50, 50, 100, 30);
        txtId.setBounds(160, 50, 150, 30);
        lblNombre.setBounds(50, 90, 100, 30);
        txtNombre.setBounds(160, 90, 150, 30);
        lblApellidos.setBounds(50, 130, 100, 30);
        txtApellidos.setBounds(160, 130, 150, 30);
        lblDni.setBounds(50, 170, 100, 30);
        txtDni.setBounds(160, 170, 150, 30);
        lblEmail.setBounds(50, 210, 100, 30);
        txtEmail.setBounds(160, 210, 150, 30);
        lblFechaAlta.setBounds(50, 250, 100, 30);
        txtFechaAlta.setBounds(160, 250, 150, 30);
        lblIban.setBounds(50, 290, 100, 30);
        txtIban.setBounds(160, 290, 150, 30);
        btnAnterior.setBounds(50, 330, 100, 30);
        btnSiguiente.setBounds(160, 330, 100, 30);
        btnBuscar.setBounds(320, 50, 100, 30);
        btnMenuPrincipal.setBounds(320, 476, 150, 30);

        // Agregar los componentes a la ventana
        getContentPane().add(lblId);
        getContentPane().add(txtId);
        getContentPane().add(lblNombre);
        getContentPane().add(txtNombre);
        getContentPane().add(lblApellidos);
        getContentPane().add(txtApellidos);
        getContentPane().add(lblDni);
        getContentPane().add(txtDni);
        getContentPane().add(lblEmail);
        getContentPane().add(txtEmail);
        getContentPane().add(lblFechaAlta);
        getContentPane().add(txtFechaAlta);
        getContentPane().add(lblIban);
        getContentPane().add(txtIban);
        getContentPane().add(btnAnterior);
        getContentPane().add(btnSiguiente);
        getContentPane().add(btnBuscar);
        getContentPane().add(btnMenuPrincipal);

        // Configurar el layout
        getContentPane().setLayout(null);

        // Configurar el botón "Menú Principal" como el botón predeterminado (se activa al presionar Enter)
        getRootPane().setDefaultButton(btnMenuPrincipal);

        // Asignar listeners a los botones
        btnAnterior.addActionListener(e -> controller.mostrarEmpleadoAnterior());
        btnSiguiente.addActionListener(e -> controller.mostrarEmpleadoSiguiente());
        btnBuscar.addActionListener(e -> {
            String id = txtId.getText();
            controller.buscarEmpleado(id);
        });
       // btnMenuPrincipal.addActionListener(e -> controller.volverMenuPrincipal());
    }

    // Métodos para obtener los valores de los campos de texto

    public String getIdText() {
        return txtId.getText();
    }

    public String getNombreText() {
        return txtNombre.getText();
    }

    public String getApellidosText() {
        return txtApellidos.getText();
    }

    public String getDniText() {
        return txtDni.getText();
    }

    public String getEmailText() {
        return txtEmail.getText();
    }

    public String getFechaAltaText() {
        return txtFechaAlta.getText();
    }

    public String getIbanText() {
        return txtIban.getText();
    }

    // Métodos para establecer los valores de los campos de texto

    public void setIdText(String id) {
        txtId.setText(id);
    }

    public void setNombreText(String nombre) {
        txtNombre.setText(nombre);
    }

    public void setApellidosText(String apellidos) {
        txtApellidos.setText(apellidos);
    }

    public void setDniText(String dni) {
        txtDni.setText(dni);
    }

    public void setEmailText(String email) {
        txtEmail.setText(email);
    }

    public void setFechaAltaText(String fechaAlta) {
        txtFechaAlta.setText(fechaAlta);
    }

    public void setIbanText(String iban) {
        txtIban.setText(iban);
    }

    // Métodos para establecer los listeners de los botones

    public void setAnteriorButtonListener(ActionListener listener) {
        btnAnterior.addActionListener(listener);
    }

    public void setSiguienteButtonListener(ActionListener listener) {
        btnSiguiente.addActionListener(listener);
    }

    public void setBuscarButtonListener(ActionListener listener) {
        btnBuscar.addActionListener(listener);
    }

    public void setMenuPrincipalButtonListener(ActionListener listener) {
        btnMenuPrincipal.addActionListener(listener);
    }

    // Método para configurar el cierre de la ventana

    public void setWindowClosingListener(java.awt.event.WindowListener listener) {
        addWindowListener(listener);
    }
}