package Class;

import java.io.Serializable;

public class Empleado implements Serializable {
    private String nombre;
    private String apellido;
    private int edad;
    private String cargo;
    private String departamento;
    private double salario;


    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }

    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }

    @Override
    public String toString() {
        return nombre + " " + apellido + ", " + edad + " años, " + cargo + ", Departamento: " + departamento + ", Salario: $" + salario;
    }
}

