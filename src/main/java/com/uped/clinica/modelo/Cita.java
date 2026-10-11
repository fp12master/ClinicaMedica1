package com.uped.clinica.modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cita {
    private int id;
    private LocalDate fecha;
    private LocalTime hora;
    private EstadoCita estado;
    private Paciente paciente;
    private Medico medico;
    private Consulta consulta;

    public Cita(int id, LocalDate fecha, LocalTime hora, Paciente paciente, Medico medico) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.paciente = paciente;
        this.medico = medico;
        this.estado = EstadoCita.PROGRAMADA; // toda cita nueva empieza programada
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public LocalTime getHora() { return hora; }
    public void setHora(LocalTime hora) { this.hora = hora; }

    public EstadoCita getEstado() { return estado; }

    public Paciente getPaciente() { return paciente; }
    public Medico getMedico() { return medico; }
    public Consulta getConsulta() { return consulta; }

    public void cancelar() {
        this.estado = EstadoCita.CANCELADA;
    }

    public void reprogramar(LocalDate nuevaFecha, LocalTime nuevaHora) {
        this.fecha = nuevaFecha;
        this.hora = nuevaHora;
        this.estado = EstadoCita.PROGRAMADA;
    }

    public void registrarConsulta(Consulta consulta) {
        this.consulta = consulta;
        this.estado = EstadoCita.ATENDIDA;
    }

    @Override
    public String toString() {
        return "Cita #" + id + " | " + fecha + " " + hora + " | " + estado
                + " | Paciente: " + paciente.getNombreCompleto()
                + " | Médico: " + medico.getNombreCompleto();
    }
}
