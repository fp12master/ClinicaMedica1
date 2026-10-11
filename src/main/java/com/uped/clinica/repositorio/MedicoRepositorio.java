package com.uped.clinica.repositorio;
import com.uped.clinica.modelo.Operaciones;

public class MedicoRepositorio implements Operaciones {

    @Override
    public void guardar() {
        System.out.println("Guardando médico en la base de datos...");
    }

    @Override
    public void buscarPorId(String id) {
        System.out.println("Buscando al médico con el ID: " + id);
    }
}