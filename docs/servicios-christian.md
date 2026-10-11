# Servicios y polimorfismo

Rama: `christian-servicios-polimorfismo`.

Integra los commits existentes de `main` y `version-steven`. El modelo de personas,
citas y consultas conserva la autoría de Steven en el historial.

## Punto de entrada para la demostración

Ejecutar `com.uped.clinica.demo.DemoServicios` con JDK 21 o posterior.
En IntelliJ, abrir `pom.xml` como proyecto Maven y ejecutar el método main de esa clase.
El Main original permanece disponible.

## Para conectar el menú

Crear una instancia de cada servicio al iniciar el menú y reutilizarla durante toda
la sesión. Cada nueva instancia sin parámetros crea su propio repositorio vacío.

```java
PacienteServicio pacientes = new PacienteServicio();
MedicoServicio medicos = new MedicoServicio();
```

- `registrar(Paciente)` y `registrar(Medico)`: reciben un objeto completo.
- `registrar(...)`: también acepta los datos separados, como muestra DemoServicios.
- `buscarPorId(int)` y `buscarPorId(String)`: devuelven el registro encontrado.
- `listar()`: devuelve los registros en orden de alta, en una lista de estructura inmodificable.
- Los datos inválidos, duplicados y búsquedas sin resultado generan `IllegalArgumentException`; el menú puede mostrar `getMessage()` al usuario.

## Validaciones

ID positivo y único dentro de cada repositorio; nombre, apellido y teléfono obligatorios.
Paciente: expediente obligatorio y único, fecha de nacimiento presente y no futura.
Médico: especialidad y horario obligatorios. El horario se guarda como texto, sin
validación de disponibilidad de citas. Los registros viven en memoria y se pierden
al cerrar el programa. No se conecta una base de datos.

## Polimorfismo que se demuestra

- Sobrecarga: `registrar(objeto)` / `registrar(datos)` y `buscarPorId(int)` / `buscarPorId(String)`.
- Sobrescritura existente en el modelo: `getRol()` y `toString()` en Paciente y Medico.
- Despacho dinámico: DemoServicios recorre un arreglo Persona[] y ejecuta las versiones de cada objeto.
- Interfaz: ambos repositorios cumplen RepositorioPersonas<T>; los servicios dependen de ese contrato y la demo usa un mismo método mostrarListado para ambos.

La interfaz Operaciones conserva sus firmas originales. `guardar()` sin argumentos
informa el número de registros; el alta real utiliza `guardar(persona)`.
`buscarPorId(String)` del repositorio conserva su salida en consola; las búsquedas
de los servicios devuelven el objeto para que el menú lo use.

## Pruebas

La clase `src/test/java/com/uped/clinica/PruebaServicios.java` se ejecuta como un programa
Java. Comprueba altas, búsquedas, duplicados, datos inválidos, protección de la lista,
repositorio compartido y despacho dinámico. No requiere bibliotecas de pruebas.

## Uso de IA

Se utilizó ChatGPT/Codex para preparar la implementación de servicios, el almacenamiento
en memoria, la demostración y las pruebas. Se verificó compilación con objetivo Java 21
y se ejecutaron pruebas de comportamiento y la demo. La revisión y comprensión personal
del código para la defensa corresponde al integrante; no se afirma autoría manual del
código generado ni se asignan porcentajes de participación.

## Integración del equipo pendiente

Conectar los servicios al menú, acordar la rama de integración y completar README,
Kanban, porcentajes consensuados y video conforme a la guía. Esta rama no implementa
la gestión de citas ni reemplaza las tareas de pantallas del equipo.
