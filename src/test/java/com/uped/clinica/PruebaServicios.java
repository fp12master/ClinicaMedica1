package com.uped.clinica;

import com.uped.clinica.modelo.*;
import com.uped.clinica.repositorio.*;
import com.uped.clinica.servicio.*;
import java.time.LocalDate;

public class PruebaServicios {
    private static int comprobaciones;

    public static void main(String[] args) {
        PacienteRepositorio repositorio = new PacienteRepositorio();
        PacienteServicio pacientes = new PacienteServicio(repositorio);
        MedicoServicio medicos = new MedicoServicio();
        LocalDate nacimiento = LocalDate.of(2000, 1, 1);
        pacientes.registrar(1, "Ana", "Lopez", "70000001", "EXP1", nacimiento);
        Paciente segundo = new Paciente(2, "Luis", "Perez", "70000002", "EXP2", nacimiento);
        pacientes.registrar(segundo);
        comprobar(pacientes.buscarPorId(1).getNombre().equals("Ana"));
        comprobar(pacientes.buscarPorId(" 2 ") == segundo);
        comprobar(pacientes.listar().size() == 2);
        comprobar(new PacienteServicio(repositorio).buscarPorId(2) == segundo);
        falla(() -> pacientes.registrar(1, "Ana", "Lopez", "70000001", "EXP3", nacimiento));
        falla(() -> pacientes.registrar(3, "Ana", "Lopez", "70000001", " exp1 ", nacimiento));
        falla(() -> pacientes.registrar(3, " ", "Lopez", "70000001", "EXP3", nacimiento));
        falla(() -> pacientes.registrar(3, "Ana", "Lopez", "", "EXP3", nacimiento));
        falla(() -> pacientes.registrar(3, "Ana", "Lopez", "70000001", "EXP3", LocalDate.now().plusDays(1)));
        falla(() -> pacientes.registrar(3, "Ana", "Lopez", "70000001", "EXP3", null));
        falla(() -> pacientes.registrar((Paciente) null));
        falla(() -> pacientes.buscarPorId(0));
        falla(() -> pacientes.buscarPorId(99));
        falla(() -> pacientes.buscarPorId("abc"));
        falla(() -> pacientes.buscarPorId((String) null));
        comprobar(pacientes.listar().size() == 2);
        try {
            pacientes.listar().clear();
            throw new AssertionError("La lista debe proteger su estructura.");
        } catch (UnsupportedOperationException esperado) { comprobaciones++; }
        medicos.registrar(10, "Marta", "Ruiz", "70000003", "General", "08:00-12:00");
        medicos.registrar(new Medico(11, "Carlos", "Diaz", "70000004", "Pediatria", "13:00-17:00"));
        comprobar(medicos.buscarPorId(10).getEspecialidad().equals("General"));
        comprobar(medicos.buscarPorId("11").getNombre().equals("Carlos"));
        falla(() -> medicos.registrar(10, "Marta", "Ruiz", "70000003", "General", "08:00-12:00"));
        falla(() -> medicos.registrar(12, "Marta", "Ruiz", "70000003", "", "08:00-12:00"));
        falla(() -> medicos.registrar(12, "Marta", "Ruiz", "70000003", "General", ""));
        falla(() -> medicos.buscarPorId(99));
        comprobar(medicos.listar().size() == 2);
        Persona[] personas = {pacientes.buscarPorId(1), medicos.buscarPorId(10)};
        comprobar(personas[0].getRol().equals("Paciente"));
        comprobar(personas[1].getRol().equals("Médico"));
        comprobar(personas[0].toString().contains("Expediente"));
        comprobar(personas[1].toString().contains("Horario"));
        comprobar(repositorio instanceof Operaciones);
        comprobar(new MedicoRepositorio() instanceof Operaciones);
        System.out.println(comprobaciones + " comprobaciones correctas.");
    }

    private static void comprobar(boolean condicion) {
        if (!condicion) throw new AssertionError("Comprobacion fallida.");
        comprobaciones++;
    }

    private static void falla(Runnable accion) {
        try { accion.run(); }
        catch (IllegalArgumentException esperado) { comprobaciones++; return; }
        throw new AssertionError("Se esperaba rechazar el dato invalido.");
    }
}
