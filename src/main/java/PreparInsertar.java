import Entidades.CafeTypes;
import Entidades.CafeTypesDAO;
import Entidades.InfoPais;
import Entidades.InfoPaisDAO;

public class PreparInsertar {
    public static void InsertarInicial(DatosVO datosVO){
        LeerArchivo.leerArchivo(datosVO);
        for(CafeTypes cafe: datosVO.getListCafeTypes()){
            CafeTypesDAO.InsertarCafeTypes(cafe);
        }
        for (InfoPais info : datosVO.getListInfoPais()) {
            InfoPaisDAO.InsertarInfoPais(info);
        }
        datosVO.getListInfoPais().clear();
        datosVO.getListCafeTypes().clear();
        System.out.println("Se han insertado los datos del dataset\n");
    }
}
