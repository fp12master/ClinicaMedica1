package com.uped.clinica.modelo;

import java.util.List;

public interface RepositorioPersonas<T extends Persona> {
    void guardar(T persona);
    T buscarPorId(int id);
    List<T> listar();
}
