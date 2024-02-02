import Entidades.CafeTypes;
import Entidades.CafeTypesDAO;
import Entidades.InfoPais;
import Entidades.InfoPaisDAO;

public class PrepararActualizar {
    public static void ActualizarInfoPais(DatosVO datosVO){
        PrepararConsultar.TipoConsulta(datosVO,"pais",true);
        ComprobarExistencia.ComprobarExiste("InfoPais",datosVO);
        if (datosVO.getListInfoPais().isEmpty()) {
            System.out.println("No existe");
        }else{
            System.out.println("Los datos que hay guardados son: ");
            MostrarResultados.ResultadosInfoPais(datosVO.getListInfoPais());
            InfoPais infoPais=ObtenerDatos.ObtenerInfoPais();
            infoPais.setId(datosVO.getListInfoPais().get(0).getId());
            InfoPaisDAO.ActualizarInfoPais(infoPais);
        }
        datosVO.getListInfoPais().clear();

    }
    public static void ActualizarCafeTypes(DatosVO datosVO){
        PrepararConsultar.TipoConsulta(datosVO,"cafetypes",true);
        ComprobarExistencia.ComprobarExiste("cafetypes",datosVO);
        if (datosVO.getListCafeTypes().isEmpty()) {
            System.out.println("No existe");
        }else{

            System.out.println("Los datos que hay guardados son: ");
            MostrarResultados.ResultadosCafeTypes(datosVO.getListCafeTypes());
            CafeTypes cafeType=ObtenerDatos.ObtenerCafeTypes();
            cafeType.setId(datosVO.getListCafeTypes().get(0).getId());
            CafeTypesDAO.ActualizarCafeTypes(cafeType);
        }
        datosVO.getListCafeTypes().clear();
    }
}
