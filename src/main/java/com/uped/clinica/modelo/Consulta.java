package com.uped.clinica.modelo;

public class Consulta {
    private String diagnostico;
    private String tratamiento;
    private String receta;

    public Consulta(String diagnostico, String tratamiento, String receta) {
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.receta = receta;
    }

    public String getDiagnostico() { return diagnostico; }
    public void setDiagnostico(String diagnostico) { this.diagnostico = diagnostico; }

    public String getTratamiento() { return tratamiento; }
    public void setTratamiento(String tratamiento) { this.tratamiento = tratamiento; }

    public String getReceta() { return receta; }
    public void setReceta(String receta) { this.receta = receta; }

    @Override
    public String toString() {
        return "Diagnóstico: " + diagnostico + " | Tratamiento: " + tratamiento
                + " | Receta: " + receta;
    }


}
