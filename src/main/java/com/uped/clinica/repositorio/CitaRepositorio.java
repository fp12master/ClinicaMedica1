package com.uped.clinica.repositorio;
import com.uped.clinica.modelo.Operaciones;

public class CitaRepositorio implements Operaciones {

    @Override
    public void guardar() {
        System.out.println("Registrando nueva cita médica...");
    }

    @Override
    public void buscarPorId(String id) {
        System.out.println("Buscando la cita con el folio: " + id);
    }
}