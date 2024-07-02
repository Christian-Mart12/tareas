package tareas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class tarea {
    private int id;
    private String nombre;
    private String descripcion;
    private Date fechaCreacion;
    private Date fechaLimite;
    private EstadoTarea estado;
    private List<Subtarea> subtareas;

    public tarea(int id, String nombre, String descripcion, Date fechaCreacion, Date fechaLimite) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaLimite = fechaLimite;
        this.estado = EstadoTarea.PENDIENTE;
        this.subtareas = new ArrayList<>();
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

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public EstadoTarea getEstado() {
        return estado;
    }

    public void setEstado(EstadoTarea estado) {
        this.estado = estado;
    }

    public List<Subtarea> getSubtareas() {
        return subtareas;
    }

    public void agregarSubtarea(Subtarea subtarea) {
        subtareas.add(subtarea);
    }

    public boolean eliminarSubtarea(int subtareaId) {
        for (Subtarea subtarea : subtareas) {
            if (subtarea.getId() == subtareaId) {
                subtareas.remove(subtarea);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaLimite=" + fechaLimite +
                ", estado=" + estado +
                ", subtareas=" + subtareas +
                '}';
    }
}
