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

    public static void InsertarInfoPais(DatosVO datosVO) {
        InfoPais infoPais= ObtenerDatos.ObtenerInfoPais();
        datosVO.getListInfoPais().add(infoPais);
        ComprobarExistencia.ComprobarExiste("InfoPais",datosVO);
        if (datosVO.getListInfoPais().isEmpty()){
            InfoPaisDAO.ConsultarInfoPais(datosVO.getListInfoPais());
            infoPais.setId(datosVO.getListInfoPais().get(datosVO.getListInfoPais().size()-1).getId()+1);
            InfoPaisDAO.InsertarInfoPais(infoPais);
            System.out.println("Se ha insertado correctamente");
        }else{
            System.out.println("Este Pais ya existe");
        }
        datosVO.getListInfoPais().clear();
        datosVO.getListCafeTypes().clear();
    }
    public static void InsertarCafeTypes(DatosVO datosVO) {
        CafeTypes cafeTypes= ObtenerDatos.ObtenerCafeTypes();
        datosVO.getListCafeTypes().add(cafeTypes);
        ComprobarExistencia.ComprobarExiste("cafetypes",datosVO);
        if (datosVO.getListCafeTypes().isEmpty()){
            CafeTypesDAO.ConsultarCafeTypes(datosVO.getListCafeTypes());
            cafeTypes.setId(datosVO.getListCafeTypes().get(datosVO.getListCafeTypes().size()-1).getId()+1);
            CafeTypesDAO.InsertarCafeTypes(cafeTypes);
            System.out.println("Se ha insertado correctamente");
        }else{
            System.out.println("Este cafe ya existe");
        }
        datosVO.getListInfoPais().clear();
        datosVO.getListCafeTypes().clear();
    }
}
