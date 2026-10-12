package com.uped.clinica.demo;

import com.uped.clinica.modelo.*;
import com.uped.clinica.repositorio.*;
import com.uped.clinica.servicio.*;
import java.time.LocalDate;

public class DemoServicios {
    public static void main(String[] args) {
        RepositorioPersonas<Paciente> pacientes = new PacienteRepositorio();
        RepositorioPersonas<Medico> medicos = new MedicoRepositorio();
        PacienteServicio pacienteServicio = new PacienteServicio(pacientes);
        MedicoServicio medicoServicio = new MedicoServicio(medicos);

        System.out.println("=== REGISTRO: DOS FORMAS ===");
        pacienteServicio.registrar(1, "Ana", "Lopez", "70000001",
                "EXP-001", LocalDate.of(2000, 5, 10));
        pacienteServicio.registrar(new Paciente(2, "Luis", "Perez",
                "70000002", "EXP-002", LocalDate.of(1995, 3, 20)));
        medicoServicio.registrar(10, "Marta", "Ruiz", "70000003",
                "Medicina general", "08:00-12:00");
        medicoServicio.registrar(new Medico(11, "Carlos", "Diaz",
                "70000004", "Pediatria", "13:00-17:00"));

        System.out.println("=== BUSQUEDA: int Y String ===");
        System.out.println(pacienteServicio.buscarPorId(1));
        System.out.println(pacienteServicio.buscarPorId("2"));
        System.out.println(medicoServicio.buscarPorId(10));
        System.out.println(medicoServicio.buscarPorId("11"));

        System.out.println("=== SOBRESCRITURA Y DESPACHO DINAMICO ===");
        Persona[] personas = {pacienteServicio.buscarPorId(1),
                medicoServicio.buscarPorId(10)};
        for (Persona persona : personas) {
            System.out.println(persona.getRol() + ": " + persona.getNombreCompleto());
            System.out.println(persona.toString());
        }

        System.out.println("=== INTERFAZ: MISMO METODO, DISTINTOS REPOSITORIOS ===");
        mostrarListado(pacientes);
        mostrarListado(medicos);

        System.out.println("=== VALIDACION DE DUPLICADOS ===");
        try {
            pacienteServicio.registrar(1, "Otra", "Persona", "70000005",
                    "EXP-003", LocalDate.of(2001, 1, 1));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void mostrarListado(RepositorioPersonas<? extends Persona> repositorio) {
        for (Persona persona : repositorio.listar()) {
            System.out.println(persona.getRol() + " - " + persona.getNombreCompleto());
        }
    }
}
