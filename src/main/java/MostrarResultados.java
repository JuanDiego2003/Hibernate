import Entidades.CafeTypes;
import Entidades.InfoPais;
import Entidades.InfoPaisDAO;

import java.util.List;

public class MostrarResultados {
    public static void ResultadosInfoPais(List<InfoPais> listInfoPais) {
        for (InfoPais list : listInfoPais) {
            System.out.println("id       Pais       2016-17       2017-18       2018-19       2019-20");
            System.out.println(list.getId() + "       " + list.getPais() + "         " + list.getAnos2016_17() + "         " + list.getAnos2017_18() + "         " + list.getAnos2018_19() + "         " + list.getAnos2019_20());
        }
    }

    public static void ResultadosCafeTypes(List<CafeTypes> listCafeTypes) {
        for (CafeTypes list : listCafeTypes) {
            System.out.println("id       cafe");
            System.out.println(list.getId() + "       " + list.getCafeType());
        }
    }

}
