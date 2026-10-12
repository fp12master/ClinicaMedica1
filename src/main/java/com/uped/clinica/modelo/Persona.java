package com.uped.clinica.modelo;

// CLASE ABSTRACTA
public abstract class Persona {
    protected String id;
    protected String nombre;

    public Persona(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Método abstracto que las clases hijas deberán usar
    public abstract void mostrarDetalles();

    public String getNombre() {
        return nombre;
    }
}