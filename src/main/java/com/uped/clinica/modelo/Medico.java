package com.uped.clinica.modelo;

// HERENCIA
public class Medico extends Persona {
    private String especialidad;

    public Medico(String id, String nombre, String especialidad) {
        super(id, nombre); // Llama al constructor de Persona
        this.especialidad = especialidad;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Doctor: " + nombre + " | Especialidad: " + especialidad);
    }
}