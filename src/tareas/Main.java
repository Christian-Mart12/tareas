package tareas;

import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GestorTareas gestor = new GestorTareas();
        Scanner scanner = new Scanner(System.in);
        char opc;

        do {
            System.out.println("\nMenú:");
            System.out.println("a. Crear una nueva tarea");
            System.out.println("b. Consultar una tarea por su ID");
            System.out.println("c. Editar una tarea");
            System.out.println("d. Eliminar una tarea");
            System.out.println("e. Agregar una subtarea a una tarea existente");
            System.out.println("f. Editar una subtarea");
            System.out.println("g. Eliminar una subtarea");
            System.out.println("h. Marcar tarea o subtarea como completada");
            System.out.println("i. Salir");
            System.out.print("Selecciona una opción: ");
            opc = scanner.next().charAt(0);
            scanner.nextLine();

            switch (opc) {
                case 'a':
                    System.out.print("ID de la tarea: ");
                    int idTarea = scanner.nextInt();
                    scanner.nextLine();  
                    System.out.print("Nombre de la tarea: ");
                    String nombreTarea = scanner.nextLine();
                    System.out.print("Descripción de la tarea: ");
                    String descripcionTarea = scanner.nextLine();
                    System.out.print("Fecha de creación (yyyy-mm-dd): ");
                    String fechaCreacionStr = scanner.nextLine();
                    System.out.print("Fecha límite (yyyy-mm-dd): ");
                    String fechaLimiteStr = scanner.nextLine();

                    try {
                        Date fechaCreacion = new Date(fechaCreacionStr);
                        Date fechaLimite = new Date(fechaLimiteStr);
                        gestor.crearTarea(idTarea, nombreTarea, descripcionTarea, fechaCreacion, fechaLimite);
                        System.out.println("Tarea creada correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error en el formato de fecha. Use yyyy-mm-dd.");
                    }
                    break;

                case 'b':
                    System.out.print("ID de la tarea a consultar: ");
                    idTarea = scanner.nextInt();
                    tarea tarea = gestor.consultarTareaPorId(idTarea);
                    if (tarea != null) {
                        System.out.println("Tarea encontrada: " + tarea);
                    } else {
                        System.out.println("Tarea no encontrada.");
                    }
                    break;

                case 'c':
                    System.out.print("ID de la tarea a editar: ");
                    idTarea = scanner.nextInt();
                    scanner.nextLine();  
                    System.out.print("Nuevo nombre de la tarea: ");
                    nombreTarea = scanner.nextLine();
                    System.out.print("Nueva descripción de la tarea: ");
                    descripcionTarea = scanner.nextLine();
                    System.out.print("Nueva fecha límite (yyyy-mm-dd): ");
                    fechaLimiteStr = scanner.nextLine();

                    try {
                        Date nuevaFechaLimite = new Date(fechaLimiteStr);
                        boolean editado = gestor.editarTarea(idTarea, nombreTarea, descripcionTarea, nuevaFechaLimite);
                        if (editado) {
                            System.out.println("Tarea editada correctamente.");
                        } else {
                            System.out.println("No se pudo editar la tarea.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error en el formato de fecha. Use yyyy-mm-dd.");
                    }
                    break;

                case 'd':
                    System.out.print("ID de la tarea a eliminar: ");
                    idTarea = scanner.nextInt();
                    boolean eliminado = gestor.eliminarTarea(idTarea);
                    if (eliminado) {
                        System.out.println("Tarea eliminada correctamente.");
                    } else {
                        System.out.println("No se pudo eliminar la tarea.");
                    }
                    break;

                case 'e':
                    System.out.print("ID de la tarea a la que agregar la subtarea: ");
                    idTarea = scanner.nextInt();
                    System.out.print("ID de la subtarea: ");
                    int idSubtarea = scanner.nextInt();
                    scanner.nextLine();  
                    System.out.print("Nombre de la subtarea: ");
                    String nombreSubtarea = scanner.nextLine();
                    System.out.print("Descripción de la subtarea: ");
                    String descripcionSubtarea = scanner.nextLine();

                    boolean agregada = gestor.agregarSubtarea(idTarea, idSubtarea, nombreSubtarea, descripcionSubtarea);
                    if (agregada) {
                        System.out.println("Subtarea agregada correctamente.");
                    } else {
                        System.out.println("No se pudo agregar la subtarea.");
                    }
                    break;

                case 'f':
                    System.out.print("ID de la subtarea a editar: ");
                    idSubtarea = scanner.nextInt();
                    scanner.nextLine();  
                    System.out.print("Nuevo nombre de la subtarea: ");
                    nombreSubtarea = scanner.nextLine();
                    System.out.print("Nueva descripción de la subtarea: ");
                    descripcionSubtarea = scanner.nextLine();

                    boolean editada = gestor.editarSubtarea(idSubtarea, nombreSubtarea, descripcionSubtarea);
                    if (editada) {
                        System.out.println("Subtarea editada correctamente.");
                    } else {
                        System.out.println("No se pudo editar la subtarea.");
                    }
                    break;

                case 'g':
                    System.out.print("ID de la subtarea a eliminar: ");
                    idSubtarea = scanner.nextInt();
                    boolean eliminada = gestor.eliminarSubtarea(idSubtarea);
                    if (eliminada) {
                        System.out.println("Subtarea eliminada correctamente.");
                    } else {
                        System.out.println("No se pudo eliminar la subtarea.");
                    }
                    break;

                case 'h':
                    System.out.print("ID de la tarea o subtarea a marcar como completada: ");
                    int id = scanner.nextInt();
                    boolean marcada = false;
                    if (id < 1000) {
                        marcada = gestor.marcarTareaComoCompletada(id);
                    } else {
                        marcada = gestor.marcarSubtareaComoCompletada(id);
                    }
                    if (marcada) {
                        System.out.println("Tarea o subtarea marcada como completada.");
                    } else {
                        System.out.println("No se pudo marcar como completada la tarea o subtarea.");
                    }
                    break;

                case 'i':
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        } while (opc != 'i');

        scanner.close();
    }
}
