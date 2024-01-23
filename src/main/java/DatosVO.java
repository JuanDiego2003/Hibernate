import Entidades.CafeTypes;
import Entidades.InfoPais;

import java.util.ArrayList;
import java.util.List;

public class DatosVO {
    private List<InfoPais> listInfoPais = new ArrayList<>();
    private List<CafeTypes> listCafeTypes = new ArrayList<>();

    public List<InfoPais> getListInfoPais() {
        return listInfoPais;
    }

    public void setListInfoPais(List<InfoPais> listInfoPais) {
        this.listInfoPais = listInfoPais;
    }

    public List<CafeTypes> getListCafeTypes() {
        return listCafeTypes;
    }

    public void setListCafeTypes(List<CafeTypes> listCafeTypes) {
        this.listCafeTypes = listCafeTypes;
    }
}
