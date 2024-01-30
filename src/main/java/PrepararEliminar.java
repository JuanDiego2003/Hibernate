import Entidades.CafeTypesDAO;
import Entidades.InfoPaisDAO;

public class PrepararEliminar {
    public static void EliminarInfoPais(DatosVO datosVO){
        PrepararConsultar.TipoConsulta(datosVO,"pais",true);
        ComprobarExistencia.ComprobarExiste("InfoPais",datosVO);
        if (datosVO.getListInfoPais().isEmpty()) {
            System.out.println("No existe");
        }else{
            InfoPaisDAO.EliminarInfoPais(datosVO.getListInfoPais().get(0));
        }
    }
    public static void EliminarCafeTypes(DatosVO datosVO){
        PrepararConsultar.TipoConsulta(datosVO,"cafetypes",true);
        ComprobarExistencia.ComprobarExiste("cafetypes",datosVO);
        if (datosVO.getListCafeTypes().isEmpty()) {
            System.out.println("No existe");
        }else{
            CafeTypesDAO.EliminarCafeTypes(datosVO.getListCafeTypes().get(0));
        }
    }
}
