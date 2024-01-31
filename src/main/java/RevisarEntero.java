import java.util.Scanner;

public class RevisarEntero {
    static int obtenerNumeroEntero(Scanner scanner) {
        System.out.print("Introduce un número entero: ");
        int pasar = 0;
        while (!scanner.hasNextInt()) {
            System.out.println("Error: Debes introducir un número entero.");
            System.out.print("Introduce un número entero: ");
            scanner.next();
        }
        pasar = scanner.nextInt();
        scanner.nextLine();
        return pasar;
    }
}
