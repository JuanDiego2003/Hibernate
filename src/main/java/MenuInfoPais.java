import java.util.Scanner;

public class MenuInfoPais {
    public static void Menu(DatosVO datosVO) {
        Scanner sc = new Scanner(System.in);


        boolean continuar = false;
        do {
            System.out.println("Que accion quiere realizar?");
            System.out.println("1. Consultar");
            System.out.println("2. Insertar");
            System.out.println("3. Eliminar");
            System.out.println("4. Editar");
            System.out.println("5. Salir");

            String opcion = sc.nextLine();
            switch (opcion.toLowerCase()) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    continuar = true;
                    break;
                default:
                    System.out.println("introduce una opcion correcta");
                    break;
            }
        }while (!continuar);


    }
}
