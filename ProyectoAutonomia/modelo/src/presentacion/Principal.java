package aplicacion;

import modelo.Automovil;
import modelo.Motocicleta;
import modelo.AutonomiaException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Creando Automóvil...");
        Automovil auto = crearAutomovil(scanner);
        if (auto != null) {
            auto.mostrarInfo();
        } else {
            System.out.println("No se pudo crear el automóvil debido a un error.");
        }

        System.out.println("Creando Motocicleta...");
        Motocicleta moto = crearMotocicleta(scanner);
        if (moto != null) {
            moto.mostrarInfo();
        } else {
            System.out.println("No se pudo crear la motocicleta debido a un error.");
        }

        scanner.close();
    }

    private static Automovil crearAutomovil(Scanner scanner) {
        try {
            int cilindraje = leerEntero(scanner, "Ingrese cilindraje del automóvil (cc): ");
            int peso = leerEntero(scanner, "Ingrese peso del automóvil (kg): ");
            int tanque = leerEntero(scanner, "Ingrese tamaño del tanque del automóvil (galones): ");

            return new Automovil(cilindraje, peso, tanque);
        } catch (AutonomiaException e) {
            System.out.println("Error al crear el automóvil: " + obtenerMensajeError(e));
            return null;
        }
    }

    private static Motocicleta crearMotocicleta(Scanner scanner) {
        try {
            int cilindraje = leerEntero(scanner, "Ingrese cilindraje de la motocicleta (cc): ");
            int peso = leerEntero(scanner, "Ingrese peso de la motocicleta (kg): ");
            int tanque = leerEntero(scanner, "Ingrese tamaño del tanque de la motocicleta (galones): ");

            return new Motocicleta(cilindraje, peso, tanque);
        } catch (AutonomiaException e) {
            System.out.println("Error al crear la motocicleta: " + obtenerMensajeError(e));
            return null;
        }
    }

    private static int leerEntero(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada inválida. " + mensaje);
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static String obtenerMensajeError(AutonomiaException e) {
        return switch (e.getMessage()) {
            case "El cilindraje debe ser mayor a 0." -> "Valor inválido: el cilindraje debe ser mayor que cero.";
            case "El peso debe ser mayor a 0." -> "Valor inválido: el peso debe ser mayor que cero.";
            case "El tamaño del tanque debe ser mayor a 0." -> "Valor inválido: el tamaño del tanque debe ser mayor que cero.";
            default -> "Ocurrió un error desconocido.";
        };
    }
}

