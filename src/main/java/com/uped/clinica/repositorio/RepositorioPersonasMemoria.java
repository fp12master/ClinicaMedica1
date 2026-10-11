package com.uped.clinica.repositorio;

import com.uped.clinica.modelo.Operaciones;
import com.uped.clinica.modelo.Persona;
import com.uped.clinica.modelo.RepositorioPersonas;
import java.util.ArrayList;
import java.util.List;

public abstract class RepositorioPersonasMemoria<T extends Persona>
        implements RepositorioPersonas<T>, Operaciones {
    private final List<T> personas = new ArrayList<>();

    @Override
    public void guardar(T persona) {
        if (persona == null || persona.getId() <= 0) {
            throw new IllegalArgumentException("La persona debe tener un ID positivo.");
        }
        if (buscarPorId(persona.getId()) != null) {
            throw new IllegalArgumentException("Ya existe una persona con ese ID.");
        }
        personas.add(persona);
    }

    @Override
    public T buscarPorId(int id) {
        for (T persona : personas) {
            if (persona.getId() == id) return persona;
        }
        return null;
    }

    @Override
    public List<T> listar() {
        return List.copyOf(personas);
    }

    // Conserva las firmas originales de Operaciones.
    // El alta real recibe el objeto mediante guardar(T).
    @Override
    public void guardar() {
        System.out.println("Registros en memoria: " + personas.size());
    }

    @Override
    public void buscarPorId(String id) {
        final int numero;
        try {
            numero = Integer.parseInt(id == null ? "" : id.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El ID debe ser un numero entero.");
        }
        T persona = buscarPorId(numero);
        System.out.println(persona == null ? "Registro no encontrado." : persona);
    }
}
