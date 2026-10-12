package com.uped.clinica.modelo;

import java.time.LocalDate;

public class Paciente extends Persona {
    private String numeroExpediente;
    private LocalDate fechaNacimiento;

    public Paciente(int id, String nombre, String apellido, String telefono,
                    String numeroExpediente, LocalDate fechaNacimiento) {
        super(id, nombre, apellido, telefono);
        this.numeroExpediente = numeroExpediente;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNumeroExpediente() { return numeroExpediente; }
    public void setNumeroExpediente(String numeroExpediente) { this.numeroExpediente = numeroExpediente; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    @Override
    public String getRol() {
        return "Paciente";
    }

    @Override
    public String toString() {
        return super.toString() + " | Expediente: " + numeroExpediente
                + " | Nacimiento: " + fechaNacimiento;
    }

}
