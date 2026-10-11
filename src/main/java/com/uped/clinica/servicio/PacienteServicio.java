package com.uped.clinica.servicio;

import com.uped.clinica.modelo.Paciente;
import com.uped.clinica.modelo.RepositorioPersonas;
import com.uped.clinica.repositorio.PacienteRepositorio;
import com.uped.clinica.util.Validaciones;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class PacienteServicio {
    private final RepositorioPersonas<Paciente> repositorio;

    public PacienteServicio() {
        this(new PacienteRepositorio());
    }

    public PacienteServicio(RepositorioPersonas<Paciente> repositorio) {
        this.repositorio = Objects.requireNonNull(repositorio, "Repositorio obligatorio.");
    }

    public void registrar(Paciente persona) {
        Validaciones.persona(persona);
        Validaciones.texto(persona.getNumeroExpediente(), "Expediente");
        if (persona.getFechaNacimiento() == null ||
                persona.getFechaNacimiento().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de nacimiento debe ser valida y no futura.");
        }
        for (Paciente existente : repositorio.listar()) {
            if (existente.getNumeroExpediente().trim()
                    .equalsIgnoreCase(persona.getNumeroExpediente().trim())) {
                throw new IllegalArgumentException("Ya existe un paciente con ese expediente.");
            }
        }
        repositorio.guardar(persona);
    }

    public void registrar(int id, String nombre, String apellido, String telefono,
                          String numeroExpediente, LocalDate fechaNacimiento) {
        registrar(new Paciente(id, nombre, apellido, telefono, numeroExpediente, fechaNacimiento));
    }

    public Paciente buscarPorId(int id) {
        Validaciones.id(id);
        Paciente persona = repositorio.buscarPorId(id);
        if (persona == null) throw new IllegalArgumentException("No existe un registro con ese ID.");
        return persona;
    }

    public Paciente buscarPorId(String id) {
        return buscarPorId(Validaciones.convertirId(id));
    }

    public List<Paciente> listar() {
        return repositorio.listar();
    }
}
