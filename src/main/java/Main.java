import Entidades.CafeTypes;
import Entidades.CafeTypesDAO;
import Entidades.InfoPais;
import Entidades.InfoPaisDAO;

import java.util.LinkedList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienbenido a la base de datos de Cafetype");
        DatosVO datosVO = new DatosVO();
        PreparInsertar.InsertarInicial(datosVO);
        boolean continuar = true;
        do {
            System.out.println("Escoge con que tabla quieres usar");
            System.out.println("1. InfoPais");
            System.out.println("2. Cafetypes");
            System.out.println("3. Salir");
            String opcion = sc.nextLine();
            switch (opcion.toLowerCase()) {
                case "1":
                    MenuInfoPais.Menu(datosVO);
                    break;
                case "2":
                    MenuCafeTypes.Menu(datosVO);
                    break;
                case "3":
                    continuar = false;
                    break;
                default:
                    System.out.println("introduce una opcion correcta");
                    break;
            }
        } while (continuar);
    }
}

