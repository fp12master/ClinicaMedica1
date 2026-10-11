package com.uped.clinica.util;

import com.uped.clinica.modelo.Persona;

public class Validaciones {
    private Validaciones() {}

    public static void texto(String valor, String campo) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(campo + " es obligatorio.");
        }
    }

    public static void id(int id) {
        if (id <= 0) throw new IllegalArgumentException("El ID debe ser positivo.");
    }

    public static int convertirId(String id) {
        texto(id, "ID");
        try {
            int numero = Integer.parseInt(id.trim());
            id(numero);
            return numero;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El ID debe ser un numero entero.");
        }
    }

    public static void persona(Persona persona) {
        if (persona == null) throw new IllegalArgumentException("La persona es obligatoria.");
        id(persona.getId());
        texto(persona.getNombre(), "Nombre");
        texto(persona.getApellido(), "Apellido");
        texto(persona.getTelefono(), "Telefono");
    }
}
