import Entidades.CafeTypes;
import Entidades.CafeTypesDAO;
import Entidades.InfoPaisDAO;

public class ComprobarExistencia {
    public static void ComprobarExiste(String tabla, DatosVO datosVO){
        if ("infopais".equalsIgnoreCase(tabla)){
            InfoPaisDAO.ConsultarInfoPais(datosVO.getListInfoPais());
        }else {
            CafeTypesDAO.ConsultarCafeTypes(datosVO.getListCafeTypes());
        }
    }
}
