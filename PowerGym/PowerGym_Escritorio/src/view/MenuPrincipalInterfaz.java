package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.*;

public class MenuPrincipalInterfaz extends JFrame {
    private JButton btnClientes;
    private JButton btnClases;
    private JButton btnContabilidad;
    private JButton btnEmpleados;
    private JButton btnCuotasPromociones;

    public MenuPrincipalInterfaz() {
        // Configurar la ventana
        setTitle("PowerGym");
        setSize(658, 672);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        // Crear los botones
        btnClientes = new JButton("Clientes");
        btnClientes.setBounds(81, 151, 150, 30);

        btnClases = new JButton("Clases");
        btnClases.setBounds(372, 151, 150, 30);

        btnContabilidad = new JButton("Contabilidad");
        btnContabilidad.setBounds(81, 317, 150, 30);

        btnEmpleados = new JButton("Empleados");
        btnEmpleados.setBounds(372, 317, 150, 30);

        btnCuotasPromociones = new JButton("Cuotas y Promociones");
        btnCuotasPromociones.setBounds(169, 503, 310, 30);

        // Agregar los botones a la ventana
        getContentPane().add(btnClientes);
        getContentPane().add(btnClases);
        getContentPane().add(btnContabilidad);
        getContentPane().add(btnEmpleados);
        getContentPane().add(btnCuotasPromociones);

        // Manejadores de eventos
        btnClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentanaClientes();
            }
        });

        btnClases.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentanaClases();
            }
        });

        btnContabilidad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentanaContabilidad();
            }
        });

        btnEmpleados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentanaEmpleados();
            }
        });

        btnCuotasPromociones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentanaCuotasPromociones();
            }
        });
    }

    private void abrirVentanaClientes() {
    	ClientesController controller = new ClientesController();
    	ClientesInterfaz ventanaClientes = new ClientesInterfaz(controller);
    	controller.setVista(ventanaClientes);
    	controller.mostrarPrimerClienteEnVista(0);
    	ventanaClientes.setVisible(true);
        setVisible(false);
    }

    private void abrirVentanaEmpleados() {
    	EmpleadosController controller = new EmpleadosController();
    	EmpleadosInterfaz ventanaEmpleados = new EmpleadosInterfaz(controller);
    	controller.setVista(ventanaEmpleados);
    	controller.mostrarPrimerEmpleadoEnVista(0);
    	ventanaEmpleados.setVisible(true);
        setVisible(false);
    }

    private void abrirVentanaClases() {
    	ClasesController controller = new ClasesController();
    	ClasesInterfaz ventanaClases = new ClasesInterfaz(controller);
    	controller.setVista(ventanaClases);
    	//controller.mostrarPrimerEmpleadoEnVista(0);
    	ventanaClases.setVisible(true);
        setVisible(false);
    }

    private void abrirVentanaContabilidad() {
        // Lógica para abrir la ventana de contabilidad
    }

    private void abrirVentanaCuotasPromociones() {
        // Lógica para abrir la ventana de cuotas y promociones
    }
}
