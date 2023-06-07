package view;
import model.Cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ClientesInterfaz extends JFrame {
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
    private ArrayList<Cliente> listaClientes;
    private int indiceActual;

    public ClientesInterfaz() {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        Cliente cliente = new Cliente();
        clientes.add(cliente);

        // Configurar la ventana de clientes
        setTitle("PowerGym - Clientes");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicializar la lista de clientes y el índice actual
        listaClientes = clientes;
        indiceActual = 0;

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
        btnMenuPrincipal.setBounds(320, 478, 150, 30);

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

        // Configurar el ActionListener para el botón "Anterior"
        btnAnterior.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (indiceActual > 0) {
                    indiceActual--;
                    mostrarClienteActual();
                }
            }
        });

        // Configurar el ActionListener para el botón "Siguiente"
        btnSiguiente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (indiceActual < listaClientes.size() - 1) {
                    indiceActual++;
                    mostrarClienteActual();
                }
            }
        });

        // Configurar el ActionListener para el botón "Buscar"
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int idBuscado = Integer.parseInt(txtId.getText());
                Cliente clienteEncontrado = buscarClientePorId(idBuscado);
                if (clienteEncontrado != null) {
                    int indiceEncontrado = listaClientes.indexOf(clienteEncontrado);
                    indiceActual = indiceEncontrado;
                    mostrarClienteActual();
                } else {
                    JOptionPane.showMessageDialog(ClientesInterfaz.this, "No se encontró ningún cliente con ese ID.",
                            "Búsqueda de Cliente", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Configurar el ActionListener para el botón "Menú Principal"
        btnMenuPrincipal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para volver al menú principal
                dispose(); // Cerrar la ventana actual
                MenuPrincipalInterfaz menuPrincipal = new MenuPrincipalInterfaz();
                menuPrincipal.setVisible(true);
            }
        });

        // Mostrar el primer cliente de la lista
        mostrarClienteActual();

        getContentPane().setLayout(null);
    }

    private void mostrarClienteActual() {
        Cliente cliente = listaClientes.get(indiceActual);
        txtId.setText(String.valueOf(cliente.getId()));
        txtNombre.setText(cliente.getNombre());
        txtApellidos.setText(cliente.getApellidos());
        txtDni.setText(cliente.getDni());
        txtEmail.setText(cliente.getEmail());
        txtFechaAlta.setText(cliente.getFechaAlta());
        txtIban.setText(cliente.getIban());
    }

    private Cliente buscarClientePorId(int id) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }
}
