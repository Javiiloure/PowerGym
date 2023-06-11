
import controller.ClasesController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClasesInterfaz {

    private JFrame frame;
    private JLabel lblId, lblNombre, lblDescripcion, lblDuracion, lblPlazasMax;
    private JTextField txtId, txtNombre, txtDescripcion, txtDuracion, txtPlazasMax;
    private JButton btnAnterior, btnSiguiente, btnBuscar, btnAgregar, btnEliminar, btnModificar, btnVolver;
    private ClasesController controller;

    public ClasesInterfaz() {
        controller = new ClasesController();
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Gestión de Clases");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        lblId = new JLabel("ID:");
        lblId.setBounds(10, 10, 60, 20);
        frame.getContentPane().add(lblId);

        txtId = new JTextField();
        txtId.setBounds(100, 10, 100, 20);
        frame.getContentPane().add(txtId);
        txtId.setColumns(10);

        lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(10, 40, 60, 20);
        frame.getContentPane().add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(100, 40, 100, 20);
        frame.getContentPane().add(txtNombre);
        txtNombre.setColumns(10);

        lblDescripcion = new JLabel("Descripción:");
        lblDescripcion.setBounds(10, 70, 80, 20);
        frame.getContentPane().add(lblDescripcion);

        txtDescripcion = new JTextField();
        txtDescripcion.setBounds(100, 70, 100, 20);
        frame.getContentPane().add(txtDescripcion);
        txtDescripcion.setColumns(10);

        lblDuracion = new JLabel("Duración:");
        lblDuracion.setBounds(10, 100, 60, 20);
        frame.getContentPane().add(lblDuracion);

        txtDuracion = new JTextField();
        txtDuracion.setBounds(100, 100, 100, 20);
        frame.getContentPane().add(txtDuracion);
        txtDuracion.setColumns(10);

        lblPlazasMax = new JLabel("Plazas Máximas:");
        lblPlazasMax.setBounds(10, 130, 100, 20);
        frame.getContentPane().add(lblPlazasMax);

        txtPlazasMax = new JTextField();
        txtPlazasMax.setBounds(120, 130, 80, 20);
        frame.getContentPane().add(txtPlazasMax);
        txtPlazasMax.setColumns(10);

        btnAnterior = new JButton("<");
        btnAnterior.setBounds(10, 170, 50, 20);
        btnAnterior.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.mostrarClaseAnterior();
            }
        });
        frame.getContentPane().add(btnAnterior);

        btnSiguiente = new JButton(">");
        btnSiguiente.setBounds(70, 170, 50, 20);
        btnSiguiente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.mostrarClaseSiguiente();
            }
        });
        frame.getContentPane().add(btnSiguiente);

        btnBuscar = new JButton("Buscar por ID");
        btnBuscar.setBounds(130, 170, 120, 20);
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idStr = txtId.getText();
                if (!idStr.isEmpty()) {
                    int id = Integer.parseInt(idStr);
                    controller.buscarClasePorId(id);
                } else {
                    JOptionPane.showMessageDialog(frame, "Ingrese un ID válido");
                }
            }
        });
        frame.getContentPane().add(btnBuscar);

        btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(260, 10, 100, 20);
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String descripcion = txtDescripcion.getText();
                String duracionStr = txtDuracion.getText();
                String plazasMaxStr = txtPlazasMax.getText();
                if (!nombre.isEmpty() && !descripcion.isEmpty() && !duracionStr.isEmpty() && !plazasMaxStr.isEmpty()) {
                    int duracion = Integer.parseInt(duracionStr);
                    int plazasMax = Integer.parseInt(plazasMaxStr);
                    controller.agregarClase(nombre, descripcion, duracion, plazasMax);
                } else {
                    JOptionPane.showMessageDialog(frame, "Ingrese todos los campos");
                }
            }
        });
        frame.getContentPane().add(btnAgregar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(260, 40, 100, 20);
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idStr = txtId.getText();
                if (!idStr.isEmpty()) {
                    int id = Integer.parseInt(idStr);
                    controller.eliminarClase(id);
                } else {
                    JOptionPane.showMessageDialog(frame, "Ingrese un ID válido");
                }
            }
        });
        frame.getContentPane().add(btnEliminar);

        btnModificar = new JButton("Modificar");
        btnModificar.setBounds(260, 70, 100, 20);
        btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idStr = txtId.getText();
                String nombre = txtNombre.getText();
                String descripcion = txtDescripcion.getText();
                String duracionStr = txtDuracion.getText();
                String plazasMaxStr = txtPlazasMax.getText();
                if (!idStr.isEmpty() && !nombre.isEmpty() && !descripcion.isEmpty() && !duracionStr.isEmpty() && !plazasMaxStr.isEmpty()) {
                    int id = Integer.parseInt(idStr);
                    int duracion = Integer.parseInt(duracionStr);
                    int plazasMax = Integer.parseInt(plazasMaxStr);
                    controller.modificarClase(id, nombre, descripcion, duracion, plazasMax);
                } else {
                    JOptionPane.showMessageDialog(frame, "Ingrese todos los campos");
                }
            }
        });
        frame.getContentPane().add(btnModificar);

        btnVolver = new JButton("Volver");
        btnVolver.setBounds(260, 130, 100, 20);
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.volverMenuPrincipal();
            }
        });
        frame.getContentPane().add(btnVolver);
    }

    public void mostrarClase(Clase clase) {
        txtId.setText(String.valueOf(clase.getId()));
        txtNombre.setText(clase.getNombre());
        txtDescripcion.setText(clase.getDescripcion());
        txtDuracion.setText(String.valueOf(clase.getDuracion()));
        txtPlazasMax.setText(String.valueOf(clase.getPlazasMax()));
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(frame, mensaje);
    }

    public void mostrarPrimeraClase() {
        txtId.setText("");
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtDuracion.setText("");
        txtPlazasMax.setText("");
    }

    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }
}
