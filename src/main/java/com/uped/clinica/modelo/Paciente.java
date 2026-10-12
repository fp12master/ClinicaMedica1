package com.uped.clinica.modelo;

// HERENCIA
public class Paciente extends Persona {
    private String padecimiento;

    public Paciente(String id, String nombre, String padecimiento) {
        super(id, nombre); // Llama al constructor de Persona
        this.padecimiento = padecimiento;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Paciente: " + nombre + " | Padecimiento: " + padecimiento);
    }
}