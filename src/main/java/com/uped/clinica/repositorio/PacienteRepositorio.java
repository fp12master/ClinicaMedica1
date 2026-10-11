package com.uped.clinica.repositorio;
import com.uped.clinica.modelo.Operaciones;

public class PacienteRepositorio implements Operaciones {

    @Override
    public void guardar() {
        System.out.println("Guardando paciente en el sistema...");
    }

    @Override
    public void buscarPorId(String id) {
        System.out.println("Buscando el expediente del paciente con ID: " + id);
    }
}