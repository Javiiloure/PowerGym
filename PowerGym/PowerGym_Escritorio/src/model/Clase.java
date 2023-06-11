package model;

public class Clase {
    private int id;
    private String nombre;
    private String descripcion;
    private String duracion;
    private int plazasMax;

    public Clase() {
        this.id = 0;
        this.nombre = "";
        this.descripcion = "";
        this.duracion = "";
        this.plazasMax = 0;
    }

    public Clase(int id, String nombre, String descripcion, String duracion, int plazasMax) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.plazasMax = plazasMax;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public int getPlazasMax() {
        return plazasMax;
    }

    public void setPlazasMax(int plazasMax) {
        this.plazasMax = plazasMax;
    }
}
