package Class;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Empleado> empleados = new ArrayList<>();
    private static List<Tarea> tareas = new ArrayList<>();

    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            String menu = "MENÚ:\n"
                    + "1. Registrar nuevo empleado\n"
                    + "2. Actualizar datos del empleado\n"
                    + "3. Asignar nueva tarea\n"
                    + "4. Mostrar lista de empleados\n"
                    + "5. Mostrar tareas de empleado\n"
                    + "6. Actualizar estado de tarea\n"
                    + "7. Salir\n"
                    + "Seleccione una opción";


            String opcion = JOptionPane.showInputDialog(menu);
            if (opcion != null) {
                switch (opcion) {
                    case "1":
                        registrarEmpleado();
                        break;
                    case "2":
                        actualizarEmpleado();
                        break;
                    case "3":
                        asignarTarea();
                        break;
                    case "4":
                        mostrarEmpleados();
                        break;
                    case "5":
                        mostrarTareasEmpleado();
                        break;
                    case "6":
                        actualizarEstadoTarea();
                        break;
                    case "7":
                        salir = true;
                        JOptionPane.showMessageDialog(null, "Saliendo del sistema.");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción inválida");
                }
            } else {
                salir = true;
            }
        }
    }

    private static void registrarEmpleado() {
        Empleado empleado = new Empleado();
        empleado.setNombre(JOptionPane.showInputDialog("Ingrese nombre:"));
        empleado.setApellido(JOptionPane.showInputDialog("Ingrese apellido:"));
        empleado.setEdad(Integer.parseInt(JOptionPane.showInputDialog("Ingrese edad:")));
        empleado.setCargo(JOptionPane.showInputDialog("Ingrese cargo:"));
        empleado.setDepartamento(JOptionPane.showInputDialog("Ingrese departamento:"));
        empleado.setSalario(Double.parseDouble(JOptionPane.showInputDialog("Ingrese salario:")));

        empleados.add(empleado);
        JOptionPane.showMessageDialog(null, "Empleado registrado exitosamente.");
    }

    private static void actualizarEmpleado() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado a actualizar:");
        for (Empleado emp : empleados) {
            if (emp.getNombre().equalsIgnoreCase(nombre)) {
                String nuevoApellido = JOptionPane.showInputDialog("Nuevo apellido (dejar en blanco para no cambiar):");
                if (!nuevoApellido.isEmpty()) {
                    emp.setApellido(nuevoApellido);
                }

                String nuevaEdadStr = JOptionPane.showInputDialog("Nueva edad (0 para no cambiar):");
                if (!nuevaEdadStr.isEmpty()) {
                    int nuevaEdad = Integer.parseInt(nuevaEdadStr);
                    if (nuevaEdad > 0) {
                        emp.setEdad(nuevaEdad);
                    }
                }

                String nuevoCargo = JOptionPane.showInputDialog("Nuevo cargo (dejar en blanco para no cambiar):");
                if (!nuevoCargo.isEmpty()) {
                    emp.setCargo(nuevoCargo);
                }

                String nuevoDepartamento = JOptionPane.showInputDialog("Nuevo departamento (dejar en blanco para no cambiar):");
                if (!nuevoDepartamento.isEmpty()) {
                    emp.setDepartamento(nuevoDepartamento);
                }

                String nuevoSalarioStr = JOptionPane.showInputDialog("Nuevo salario (0 para no cambiar):");
                if (!nuevoSalarioStr.isEmpty()) {
                    double nuevoSalario = Double.parseDouble(nuevoSalarioStr);
                    if (nuevoSalario > 0) {
                        emp.setSalario(nuevoSalario);
                    }
                }

                JOptionPane.showMessageDialog(null, "El empleado fue actualizado exitosamente.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "El empleado no fue encontrado.");
    }

    private static void asignarTarea() {
        Tarea tarea = new Tarea();
        tarea.setTitulo(JOptionPane.showInputDialog("Ingrese el nombre de la tarea:"));
        tarea.setDescripcion(JOptionPane.showInputDialog("Ingrese una descripción de la tarea:"));
        tarea.setFechaInicio(JOptionPane.showInputDialog("Ingrese la fecha de inicio:"));
        tarea.setFechaFin(JOptionPane.showInputDialog("Ingrese la fecha de fin:"));
        tarea.setEstado("Pendiente");

        String nombreEmpleado = JOptionPane.showInputDialog("Ingrese nombre del empleado a asignar la tarea:");
        for (Empleado emp : empleados) {
            if (emp.getNombre().equalsIgnoreCase(nombreEmpleado)) {
                tarea.setEmpleado(emp);
                tareas.add(tarea);
                JOptionPane.showMessageDialog(null, "Tarea asignada exitosamente.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Empleado no encontrado.");
    }

    private static void mostrarEmpleados() {
        StringBuilder sb = new StringBuilder("Listado de Empleados:\n");
        for (Empleado emp : empleados) {
            sb.append("Nombre:"+ ""+emp.getNombre()).append(" ").append(emp.getApellido()).append("\n");
            sb.append("Cargo: "+ ""+emp.getCargo()).append(" -- ").append("Departamento: "+ ""+emp.getDepartamento()).append("\n");
            sb.append("Edad: "+emp.getEdad()).append(" -- ").append("Salario: "+emp.getSalario()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void mostrarTareasEmpleado() {
        String nombreEmpleado = JOptionPane.showInputDialog("Ingrese el nombre del empleado:");
        StringBuilder sb = new StringBuilder("Tareas de " + nombreEmpleado + ":\n");
        for (Tarea tarea : tareas) {
            if (tarea.getEmpleado().getNombre().equalsIgnoreCase(nombreEmpleado)) {
                sb.append(tarea.getTitulo()).append(": ").append(tarea.getEstado()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void actualizarEstadoTarea() {
        String tituloTarea = JOptionPane.showInputDialog("Ingrese el nombre de la tarea:");
        for (Tarea tarea : tareas) {
            if (tarea.getTitulo().equalsIgnoreCase(tituloTarea)) {
                String nuevoEstado = JOptionPane.showInputDialog("Ingrese un nuevo estado (Pendiente/Completada):");
                tarea.setEstado(nuevoEstado);
                JOptionPane.showMessageDialog(null, "La tarea fue actualizada.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Tarea no encontrada.");
    }
}