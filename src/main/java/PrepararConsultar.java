import Entidades.CafeTypes;
import Entidades.InfoPais;

import java.util.Scanner;

public class PrepararConsultar {
    static Scanner sc = new Scanner(System.in);

    public static void TipoConsulta(DatosVO datosVO, String contexto, boolean verificarExistencia) {
        System.out.println("1. Por id");
        System.out.println("2. Por " + contexto);
        if (!verificarExistencia) {
            System.out.println("3. Todo");
        }
        boolean continuar = true;
        InfoPais infoPais = new InfoPais();
        CafeTypes cafeTypes = new CafeTypes();
        do {
            String opcion = sc.nextLine();
            switch (opcion.toLowerCase()) {
                case "1":
                    System.out.println("introduce un id");
                    if (contexto.equalsIgnoreCase("pais")) {
                        infoPais.setId(RevisarEntero.obtenerNumeroEntero(sc));
                    } else {
                        cafeTypes.setId(RevisarEntero.obtenerNumeroEntero(sc));
                    }
                    break;
                case "2":
                    System.out.println("introduce un " + contexto + " o letras que contiene (sequencia de letras que tenga)");
                    if (contexto.equalsIgnoreCase("pais")) {
                        assert infoPais != null;
                        infoPais.setPais(sc.nextLine());
                    } else {
                        assert cafeTypes != null;
                        cafeTypes.setCafeType(sc.nextLine());
                    }
                    break;
                case "3":
                    if (!verificarExistencia) {
                        if (contexto.equalsIgnoreCase("pais")) {
                            infoPais = null;
                        } else {
                            cafeTypes = null;
                        }
                        break;
                    }
                default:
                    System.out.println("introduce una opcion valida");
                    continuar = false;
            }
        } while (!continuar);
        if (contexto.equalsIgnoreCase("pais")) {
            datosVO.getListInfoPais().add(infoPais);
        } else {
            datosVO.getListCafeTypes().add(cafeTypes);
        }
    }
}
