import java.util.Scanner;

public class RevisarEntero {
    static int obtenerNumeroEntero(Scanner scanner) {
        System.out.print("Introduce un número entero: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Error: Debes introducir un número entero.");
            System.out.print("Introduce un número entero: ");
            scanner.next();
        }

        return scanner.nextInt();
    }
}
