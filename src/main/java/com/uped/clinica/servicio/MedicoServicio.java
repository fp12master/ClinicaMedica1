package com.uped.clinica.servicio;

import com.uped.clinica.modelo.Medico;
import com.uped.clinica.modelo.RepositorioPersonas;
import com.uped.clinica.repositorio.MedicoRepositorio;
import com.uped.clinica.util.Validaciones;
import java.util.List;
import java.util.Objects;

public class MedicoServicio {
    private final RepositorioPersonas<Medico> repositorio;

    public MedicoServicio() {
        this(new MedicoRepositorio());
    }

    public MedicoServicio(RepositorioPersonas<Medico> repositorio) {
        this.repositorio = Objects.requireNonNull(repositorio, "Repositorio obligatorio.");
    }

    public void registrar(Medico persona) {
        Validaciones.persona(persona);
        Validaciones.texto(persona.getEspecialidad(), "Especialidad");
        Validaciones.texto(persona.getHorario(), "Horario");
        repositorio.guardar(persona);
    }

    public void registrar(int id, String nombre, String apellido, String telefono,
                          String especialidad, String horario) {
        registrar(new Medico(id, nombre, apellido, telefono, especialidad, horario));
    }

    public Medico buscarPorId(int id) {
        Validaciones.id(id);
        Medico persona = repositorio.buscarPorId(id);
        if (persona == null) throw new IllegalArgumentException("No existe un registro con ese ID.");
        return persona;
    }

    public Medico buscarPorId(String id) {
        return buscarPorId(Validaciones.convertirId(id));
    }

    public List<Medico> listar() {
        return repositorio.listar();
    }
}
