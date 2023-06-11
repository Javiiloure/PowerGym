package controller;

import model.Cliente;
import bbdd.BDConnection;
import view.ClientesInterfaz;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClientesController {
    private BDConnection conexion;
    private ClientesInterfaz vista;
    private ArrayList<Cliente> clientes;
    private int indiceActual;

    public ClientesController() {
        conexion = new BDConnection();
        vista = new ClientesInterfaz(this);
        clientes = new ArrayList<>();
        indiceActual = 0;

        cargarClientesDesdeBaseDatos();

        // Configurar la vista y los eventos...
    }

    public void setVista(ClientesInterfaz interfaz) {
        this.vista = interfaz;
    }

    private void cargarClientesDesdeBaseDatos() {
        try {
            conexion.startConnection();
            Statement statement = conexion.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM clientes");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String apellidos = resultSet.getString("apellidos");
                String dni = resultSet.getString("dni");
                String email = resultSet.getString("email");
                String fechaAlta = resultSet.getString("fecha_alta");
                String iban = resultSet.getString("iban");
                String usuario = resultSet.getString("usuario");
                String contraseña = resultSet.getString("contraseña");

                Cliente cliente = new Cliente(id, nombre, apellidos, dni, email, fechaAlta, iban, usuario, contraseña);
                clientes.add(cliente);
            }

            resultSet.close();
            statement.close();

            if (!clientes.isEmpty()) {
                indiceActual = 0;
                mostrarClienteEnVista(indiceActual);
            } else {
                limpiarCamposDeTexto();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void mostrarPrimerClienteEnVista(int indice) {
        Cliente cliente = clientes.get(indice);
        vista.setIdText(String.valueOf(cliente.getId()));
        vista.setNombreText(cliente.getNombre());
        vista.setApellidosText(cliente.getApellidos());
        vista.setDniText(cliente.getDni());
        vista.setEmailText(cliente.getEmail());
        vista.setFechaAltaText(cliente.getFechaAlta());
        vista.setIbanText(cliente.getIban());
    }

    public void mostrarClienteEnVista(int indice) {
        Cliente cliente = clientes.get(indice);
        vista.setIdText(String.valueOf(cliente.getId()));
        vista.setNombreText(cliente.getNombre());
        vista.setApellidosText(cliente.getApellidos());
        vista.setDniText(cliente.getDni());
        vista.setEmailText(cliente.getEmail());
        vista.setFechaAltaText(cliente.getFechaAlta());
        vista.setIbanText(cliente.getIban());
    }

    public void limpiarCamposDeTexto() {
        vista.setIdText("");
        vista.setNombreText("");
        vista.setApellidosText("");
        vista.setDniText("");
        vista.setEmailText("");
        vista.setFechaAltaText("");
        vista.setIbanText("");
    }

    public void mostrarClienteAnterior() {
        if (indiceActual > 0) {
            indiceActual--;
            mostrarClienteEnVista(indiceActual);
        }
    }

    public void mostrarClienteSiguiente() {
        if (indiceActual < clientes.size() - 1) {
            indiceActual++;
            mostrarClienteEnVista(indiceActual);
        }
    }

    public void buscarCliente(String id) {
        for (int i = 0; i < clientes.size(); i++) {
            if (String.valueOf(clientes.get(i).getId()).equals(id)) {
                indiceActual = i;
                mostrarClienteEnVista(indiceActual);
                return;
            }
        }
        limpiarCamposDeTexto();
    }

    public void volverMenuPrincipal() {
        // Lógica para regresar al menú principal
    }
}