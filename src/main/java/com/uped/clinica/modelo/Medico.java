package com.uped.clinica.modelo;

public class Medico extends Persona{
    private String especialidad;
    private String horario;

    public Medico(int id, String nombre, String apellido, String telefono,
                  String especialidad, String horario) {
        super(id, nombre, apellido, telefono);
        this.especialidad = especialidad;
        this.horario = horario;
    }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }

    @Override
    public String getRol() {
        return "Médico";
    }

    @Override
    public String toString() {
        return super.toString() + " | " + especialidad + " | Horario: " + horario;
    }
}
