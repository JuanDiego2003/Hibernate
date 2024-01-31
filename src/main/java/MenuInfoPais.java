import Entidades.InfoPaisDAO;

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
                    System.out.println("Como quieres consultar");
                    PrepararConsultar.TipoConsulta(datosVO, "pais", false);
                    InfoPaisDAO.ConsultarInfoPais(datosVO.getListInfoPais());
                    MostrarResultados.ResultadosInfoPais(datosVO.getListInfoPais());
                    break;
                case "2":
                    PreparInsertar.InsertarInfoPais(datosVO);
                    break;
                case "3":
                    System.out.println("Como quiere eliminar");
                    PrepararEliminar.EliminarInfoPais(datosVO);
                    break;
                case "4":
                    PrepararActualizar.ActualizarInfoPais(datosVO);
                    break;
                case "5":
                    continuar = true;
                    break;
                default:
                    System.out.println("introduce una opcion correcta");
                    break;
            }
        } while (!continuar);


    }
}
