package tareas;

public class Subtarea {
    private int id;
    private String nombre;
    private String descripcion;
    private EstadoTarea estado;
    private tarea tareaPadre;

    public Subtarea(int id, String nombre, String descripcion, tarea tareaPadre) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = EstadoTarea.PENDIENTE;
        this.tareaPadre = tareaPadre;
    }

    public int getId() {
        return id;
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

    public EstadoTarea getEstado() {
        return estado;
    }

    public void setEstado(EstadoTarea estado) {
        this.estado = estado;
    }

    public tarea getTareaPadre() {
        return tareaPadre;
    }

    @Override
    public String toString() {
        return "Subtarea{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                '}';
    }
}
