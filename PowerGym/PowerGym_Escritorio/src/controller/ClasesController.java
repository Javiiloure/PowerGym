package controller;

import model.Clase;

import view.ClasesInterfaz;
import view.ClientesInterfaz;
import bbdd.BDConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Clase;

public class ClasesController {

    private ClasesInterfaz view;
    private BDConnection bdConnection;
    private Connection connection;

    public ClasesController() {
        bdConnection = new BDConnection();
    }
    
    public void setVista(ClasesInterfaz interfaz) {
        this.view = interfaz;
    }

    public void iniciar() {
        bdConnection.startConnection();
        connection = bdConnection.getConnection();
        view.setAñadirButtonListener(e -> añadirClase());
        view.setEliminarButtonListener(e -> eliminarClase());
        view.setModificarButtonListener(e -> modificarClase());
        view.setBuscarButtonListener(e -> buscarClasePorId());
        //view.setVolverMenuPrincipalButtonListener(e -> volverMenuPrincipal());
        //view.setWindowClosingListener(e -> cerrarConexion());
        mostrarClaseSiguiente();
    }

    public void añadirClase() {
        Clase clase = obtenerDatosClase();
        if (clase != null) {
            String query = "INSERT INTO clases (nombre, descripcion, duracion, plazas_max) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, clase.getNombre());
                statement.setString(2, clase.getDescripcion());
                statement.setInt(3, Integer.parseInt(clase.getDuracion()));
                statement.setInt(4, clase.getPlazasMax());
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(view, "Clase añadida correctamente");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(view, "Error al añadir la clase: " + e.getMessage());
            }
        }
    }

    public void eliminarClase() {
        int id = obtenerIdClase();
        if (id != 0) {
            String query = "DELETE FROM clases WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                int rowsDeleted = statement.executeUpdate();
                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(view, "Clase eliminada correctamente");
                    mostrarClaseSiguiente();
                } else {
                    JOptionPane.showMessageDialog(view, "No se encontró ninguna clase con el ID especificado");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(view, "Error al eliminar la clase: " + e.getMessage());
            }
        }
    }

    public void modificarClase() {
        Clase clase = obtenerDatosClase();
        if (clase != null) {
            String query = "UPDATE clases SET nombre = ?, descripcion = ?, duracion = ?, plazas_max = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, clase.getNombre());
                statement.setString(2, clase.getDescripcion());
                statement.setInt(3, Integer.parseInt(clase.getDuracion()));
                statement.setInt(4, clase.getPlazasMax());
                statement.setInt(5, clase.getId());
                int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(view, "Clase modificada correctamente");
                } else {
                    JOptionPane.showMessageDialog(view, "No se encontró ninguna clase con el ID especificado");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(view, "Error al modificar la clase: " + e.getMessage());
            }
        }
    }

    public void buscarClasePorId() {
        int id = obtenerIdClase();
        if (id != 0) {
            String query = "SELECT * FROM clases WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    Clase clase = new Clase();
                    clase.setId(resultSet.getInt("id"));
                    clase.setNombre(resultSet.getString("nombre"));
                    clase.setDescripcion(resultSet.getString("descripcion"));
                    clase.setDuracion(String.valueOf(resultSet.getInt("duracion")));
                    clase.setPlazasMax(resultSet.getInt("plazas_max"));
                    mostrarClase(clase);
                } else {
                    JOptionPane.showMessageDialog(view, "No se encontró ninguna clase con el ID especificado");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(view, "Error al buscar la clase: " + e.getMessage());
            }
        }
    }

    private void mostrarClase(Clase clase) {
        view.setIdText(String.valueOf(clase.getId()));
        view.setNombreText(clase.getNombre());
        view.setDescripcionText(clase.getDescripcion());
        view.setDuracionText(String.valueOf(clase.getDuracion()));
        view.setPlazasMaxText(String.valueOf(clase.getPlazasMax()));
    }

    private Clase obtenerDatosClase() {
        int id = obtenerIdClase();
        String nombre = view.getNombreText();
        String descripcion = view.getDescripcionText();
        int duracion = obtenerDuracionClase();
        int plazasMax = obtenerPlazasMaxClase();
        if (nombre.isEmpty() || descripcion.isEmpty() || duracion == 0 || plazasMax == 0) {
            JOptionPane.showMessageDialog(view, "Por favor, complete todos los campos correctamente");
            return null;
        }
        Clase clase = new Clase(id, nombre, descripcion, String.valueOf(duracion), plazasMax);
        return clase;
    }

    private int obtenerIdClase() {
        String idText = view.getIdText();
        if (!idText.isEmpty()) {
            try {
                return Integer.parseInt(idText);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(view, "El ID de la clase debe ser un valor numérico");
            }
        }
        return 0;
    }

    private int obtenerDuracionClase() {
        String duracionText = view.getDuracionText();
        if (!duracionText.isEmpty()) {
            try {
                return Integer.parseInt(duracionText);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(view, "La duración de la clase debe ser un valor numérico");
            }
        }
        return 0;
    }

    private int obtenerPlazasMaxClase() {
        String plazasMaxText = view.getPlazasMaxText();
        if (!plazasMaxText.isEmpty()) {
            try {
                return Integer.parseInt(plazasMaxText);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(view, "El número de plazas máximas de la clase debe ser un valor numérico");
            }
        }
        return 0;
    }

    private void mostrarClaseSiguiente() {
        String query = "SELECT * FROM clases LIMIT 1";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Clase clase = new Clase();
                clase.setId(resultSet.getInt("id"));
                clase.setNombre(resultSet.getString("nombre"));
                clase.setDescripcion(resultSet.getString("descripcion"));
                clase.setDuracion(String.valueOf(resultSet.getInt("duracion")));
                clase.setPlazasMax(resultSet.getInt("plazas_max"));
                mostrarClase(clase);
            } else {
                JOptionPane.showMessageDialog(view, "No hay clases disponibles");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Error al mostrar la clase: " + e.getMessage());
        }
    }

    private void volverMenuPrincipal() {
        bdConnection.endConnection();
        view.dispose();
        new MenuPrincipalController().iniciar();
    }

    private void cerrarConexion() {
        bdConnection.endConnection();
    }
}
