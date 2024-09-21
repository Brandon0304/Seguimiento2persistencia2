package Class;

import java.io.Serializable;

public class Tarea implements Serializable {
    private String titulo;
    private String descripcion;
    private String fechaInicio;
    private String fechaFin;
    private String estado;
    private Empleado empleado;


    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(String fechaInicio) { this.fechaInicio = fechaInicio; }

    public String getFechaFin() { return fechaFin; }
    public void setFechaFin(String fechaFin) { this.fechaFin = fechaFin; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public Empleado getEmpleado() { return empleado; }
    public void setEmpleado(Empleado empleado) { this.empleado = empleado; }

    @Override
    public String toString() {
        return "Tarea: " + titulo + ", Descripción: " + descripcion + ", Inicio: " + fechaInicio + ", Fin: " + fechaFin + ", Estado: " + estado + ", Asignado a: " + empleado.getNombre() + " " + empleado.getApellido();
    }
}


