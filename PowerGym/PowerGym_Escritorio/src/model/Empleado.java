package model;

public class Empleado {
    private int id;
    private String nombre;
    private String apellidos;
    private String dni;
    private String email;
    private String fechaAlta;
    private String iban;
    private String usuario;
    private String contraseña;

    public Empleado() {
    	this.id = 0;
        this.nombre = "";
        this.apellidos = "";
        this.dni = "";
        this.email = "";
        this.fechaAlta = "";
        this.iban = "";
        this.usuario = "";
        this.contraseña = "";
    }
    
    public Empleado(int id, String nombre, String apellidos, String dni, String email, String fechaAlta, String iban, String usuario, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.email = email;
        this.fechaAlta = fechaAlta;
        this.iban = iban;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}