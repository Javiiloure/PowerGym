package controller;

import model.Empleado;
import bbdd.BDConnection;
import view.EmpleadosInterfaz;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmpleadosController {
	
	private BDConnection conexion;
    private EmpleadosInterfaz vista;
    private ArrayList<Empleado> empleados;
    private int indiceActual;

    public EmpleadosController() {
    	
    	conexion = new BDConnection();
        vista = new EmpleadosInterfaz(this);
        empleados = new ArrayList<>();
        indiceActual = 0;

        cargarEmpleadosDesdeBaseDatos();

        // Configurar la vista y los eventos...
    }

    private void cargarEmpleadosDesdeBaseDatos() {
        try {
        	
            Statement statement = conexion.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM empleados");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String apellidos = resultSet.getString("apellidos");
                String dni = resultSet.getString("dni");
                String email = resultSet.getString("email");
                String fechaAlta = resultSet.getString("fecha_alta");
                String iban = resultSet.getString("iban");
                String usuario = resultSet.getString("usuario");
                String pass = resultSet.getString("contraseña");

                
                Empleado empleado = new Empleado(id, nombre, apellidos, dni, email, fechaAlta, iban, usuario, pass);
                empleados.add(empleado);
            }

            resultSet.close();
            statement.close();

            if (!empleados.isEmpty()) {
                indiceActual = 0;
                mostrarEmpleadoEnVista(indiceActual);
            } else {
                limpiarCamposDeTexto();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void mostrarEmpleadoEnVista(int indice) {
        Empleado empleado = empleados.get(indice);
        vista.setIdText(String.valueOf(empleado.getId()));
        vista.setNombreText(empleado.getNombre());
        vista.setApellidosText(empleado.getApellidos());
        vista.setDniText(empleado.getDni());
        vista.setEmailText(empleado.getEmail());
        vista.setFechaAltaText(empleado.getFechaAlta());
        vista.setIbanText(empleado.getIban());
    }

    private void limpiarCamposDeTexto() {
        vista.setIdText("");
        vista.setNombreText("");
        vista.setApellidosText("");
        vista.setDniText("");
        vista.setEmailText("");
        vista.setFechaAltaText("");
        vista.setIbanText("");
    }

    public void mostrarEmpleadoAnterior() {
        if (indiceActual > 0) {
            indiceActual--;
            mostrarEmpleadoEnVista(indiceActual);
        }
    }

    public void mostrarEmpleadoSiguiente() {
        if (indiceActual < empleados.size() - 1) {
            indiceActual++;
            mostrarEmpleadoEnVista(indiceActual);
        }
    }

    public void buscarEmpleado(String id) {
        for (int i = 0; i < empleados.size(); i++) {
            Empleado empleado = empleados.get(i);
            if (String.valueOf(empleado.getId()).equals(id)) {
                indiceActual = i;
                mostrarEmpleadoEnVista(indiceActual);
                break;
            }
        }
    }

    // Resto de métodos del controlador...
}