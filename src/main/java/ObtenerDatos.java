import Entidades.CafeTypes;
import Entidades.InfoPais;
import Entidades.InfoPaisDAO;

import java.util.Scanner;

public class ObtenerDatos {
    public static CafeTypes ObtenerCafeTypes() {
        CafeTypes cafeTypes = new CafeTypes();
        Scanner scanner = new Scanner(System.in);
        String cafe="";
        do {
            System.out.println("introduce un cafe (no se puede dejar vacio)");
            cafe=scanner.nextLine();
        }while (cafe.isEmpty());
        cafeTypes.setCafeType(cafe);
        return cafeTypes;
    }

    public static InfoPais ObtenerInfoPais() {
        InfoPais infoPais = new InfoPais();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del país: ");
        infoPais.setPais(scanner.nextLine());
        infoPais.setAnos2016_17(ingresarEntero("Ingrese el valor para Anos2016_17: "));
        infoPais.setAnos2017_18(ingresarEntero("Ingrese el valor para Años 2016_17: "));
        infoPais.setAnos2018_19(ingresarEntero("Ingrese el valor para Años 2016_17: "));
        infoPais.setAnos2019_20(ingresarEntero("Ingrese el valor para Años 2016_17: "));
        infoPais.setTotal_domestic_consumption(ingresarLong("Ingrese el valor para Total_domestic_consumption: "));
        return infoPais;
    }

    private static int ingresarEntero(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        int valor = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.print(mensaje);
            String input = scanner.nextLine();

            try {
                if (!input.isEmpty()) {
                    valor = Integer.parseInt(input);
                    entradaValida = true;
                } else {
                    System.out.println("Por favor, ingrese un valor entero no vacío.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un valor entero válido.");
            }
        }

        return valor;
    }

    private static long ingresarLong(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        long valor = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.print(mensaje);
            String input = scanner.nextLine();

            try {
                if (!input.isEmpty()) {
                    valor = Long.parseLong(input);
                    entradaValida = true;
                } else {
                    System.out.println("Por favor, ingrese un valor long no vacío.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un valor long válido.");
            }
        }

        return valor;
    }
}
