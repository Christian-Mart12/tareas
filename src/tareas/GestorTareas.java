package tareas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestorTareas {
    private List<tarea> tareas;

    public GestorTareas() {
        this.tareas = new ArrayList<>();
    }

    public void crearTarea(int id, String nombre, String descripcion, Date fechaCreacion, Date fechaLimite) {
        tarea nuevaTarea = new tarea(id, nombre, descripcion, fechaCreacion, fechaLimite);
        tareas.add(nuevaTarea);
    }

    public tarea consultarTareaPorId(int tareaId) {
        for (tarea tarea : tareas) {
            if (tarea.getId() == tareaId) {
                return tarea;
            }
        }
        return null;
    }

    public boolean editarTarea(int tareaId, String nuevoNombre, String nuevaDescripcion, Date nuevaFechaLimite) {
        tarea tarea = consultarTareaPorId(tareaId);
        if (tarea != null) {
            tarea.setNombre(nuevoNombre);
            tarea.setDescripcion(nuevaDescripcion);
            tarea.setFechaLimite(nuevaFechaLimite);
            return true;
        }
        return false;
    }

    public boolean eliminarTarea(int tareaId) {
        tarea tarea = consultarTareaPorId(tareaId);
        if (tarea != null) {
            tareas.remove(tarea);
            return true;
        }
        return false;
    }

    public boolean agregarSubtarea(int tareaId, int subtareaId, String nombre, String descripcion) {
        tarea tarea = consultarTareaPorId(tareaId);
        if (tarea != null) {
            Subtarea nuevaSubtarea = new Subtarea(subtareaId, nombre, descripcion, tarea);
            tarea.agregarSubtarea(nuevaSubtarea);
            return true;
        }
        return false;
    }

    public boolean editarSubtarea(int subtareaId, String nuevoNombre, String nuevaDescripcion) {
        for (tarea tarea : tareas) {
            for (Subtarea subtarea : tarea.getSubtareas()) {
                if (subtarea.getId() == subtareaId) {
                    subtarea.setNombre(nuevoNombre);
                    subtarea.setDescripcion(nuevaDescripcion);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean eliminarSubtarea(int subtareaId) {
        for (tarea tarea : tareas) {
            if (tarea.eliminarSubtarea(subtareaId)) {
                return true;
            }
        }
        return false;
    }

    public boolean marcarTareaComoCompletada(int tareaId) {
        tarea tarea = consultarTareaPorId(tareaId);
        if (tarea != null) {
            tarea.setEstado(EstadoTarea.COMPLETADA);
            return true;
        }
        return false;
    }

    public boolean marcarSubtareaComoCompletada(int subtareaId) {
        for (tarea tarea : tareas) {
            for (Subtarea subtarea : tarea.getSubtareas()) {
                if (subtarea.getId() == subtareaId) {
                    subtarea.setEstado(EstadoTarea.COMPLETADA);
                    return true;
                }
            }
        }
        return false;
    }

    public List<tarea> getTareas() {
        return tareas;
    }
}
