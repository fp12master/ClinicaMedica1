package com.uped.clinica.vista;

import java.util.Scanner;

public class MenuPrincipal {

    public void mostrarMenu() {

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== CLINICA MEDICA ===");
            System.out.println("1. Registrar Paciente");
            System.out.println("2. Registrar Medico");
            System.out.println("3. Agendar Cita");
            System.out.println("4. Mostrar Datos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();

            switch(opcion) {

                case 1:
                    System.out.println("Paciente registrado.");
                    break;

                case 2:
                    System.out.println("Medico registrado.");
                    break;

                case 3:
                    System.out.println("Cita agendada.");
                    break;

                case 4:
                    System.out.println("Mostrando datos...");
                    break;

                case 0:
                    System.out.println("Gracias por usar el sistema.");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while(opcion != 0);

        scanner.close();
    }
}
