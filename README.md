# Laboratorio 2: Herencia, Clases Abstractas, Polimorfismo e Interfaces
**Asignatura:** Programación III

## Equipo de Desarrollo y Coevaluación
* **Felipe Alessandro Luna Lemus** (LL-69842-25) - 95%
* **Jonathan Daniel Olivares Bonifacio** (OB-64726-23) - 95%
* **Christian Alexander Sorto Cortez** (SC-68754-25) - 95%
* **Carlos Steven Serrano Diaz** (SD-68643-25) - 75%

## Descripción del Proyecto y Evolución
Este proyecto consiste en un sistema de gestión para una Clínica Médica, encargado de administrar el registro de médicos, pacientes y el agendamiento de citas.

**Evolución desde el Laboratorio I:**
Para esta segunda entrega, el proyecto fue refactorizado aplicando conceptos avanzados de Programación Orientada a Objetos:
* **Clases Abstractas:** Se implementó la superclase abstracta `Persona` para encapsular los atributos comunes (ID, nombre) sin permitir instanciación directa.
* **Herencia:** Las clases `Medico` y `Paciente` heredan de `Persona`, reutilizando el código base e inicializando atributos mediante `super()`.
* **Interfaces:** Se diseñó la interfaz `Operaciones` como contrato estricto para la capa de persistencia de datos (métodos `guardar()` y `buscarPorId()`).
* **Polimorfismo:** Se aplicó sobrescritura (`@Override`) en los repositorios (ej. `CitaRepositorio`) para dar comportamiento dinámico a los métodos de la interfaz, además de gestionar las operaciones a través de la capa de servicios.

## Instrucciones de Ejecución
Para compilar y ejecutar este proyecto localmente, siga los siguientes pasos:

1. **Requisitos previos:**
    * Java Development Kit (JDK) versión 17 o superior.
    * IDE recomendado: IntelliJ IDEA, Eclipse o NetBeans.
2. **Clonar el repositorio:**
   ```bash
   git clone [https://github.com/fp12master/ClinicaMedica1.git]

Abrir el proyecto: Abra la carpeta clonada en su IDE.

Ejecución: Localice la clase principal en la ruta src/main/java/com/uped/clinica/Main.java (o en su paquete correspondiente). Haga clic derecho sobre el archivo y seleccione "Run 'Main.main()'". El sistema se ejecutará en la consola integrada mostrando el menú principal.

Declaración de uso de Inteligencia Artificial
Durante el desarrollo de este laboratorio, se utilizaron herramientas de IA (Google Gemini) con los siguientes propósitos:

Resolución de conflictos en Git: Para identificar correctamente las líneas de código a conservar durante la resolución de Merge Conflicts al unificar las ramas del equipo.

Estructuración de tareas: Para redactar y organizar técnicamente las tarjetas del tablero Kanban.

Validación: Todo el código o sugerencia generada fue validado manualmente, implementándolo en IntelliJ IDEA, verificando que compilara sin errores y asegurando que cumpliera estrictamente con los criterios de la rúbrica (Herencia, Abstracción, Interfaces).