import Entidades.CafeTypes;
import Entidades.InfoPais;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeerArchivo {
    public static void leerArchivo(DatosVO datosVO) {
        File file = new File("Coffee_domestic_consumption.csv");
        try (
                Reader reader = Files.newBufferedReader(Paths.get(file.toURI()));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)
        ) {
            HashMap<String, CafeTypes> mapaCafeTypes = new HashMap<>();
            boolean firstSkip = false;
            int idCafe = 1;
            int idPais = 1;
            for (CSVRecord csvRecord : csvParser) {
                //Saltarse la primera linea
                if (!firstSkip) {
                    firstSkip = true;
                    continue;
                }
                //Definicion de objetos
                InfoPais infoPais = new InfoPais();
                //Datos de InfoPais
                infoPais.setId(idPais);
                idPais++;
                infoPais.setPais(csvRecord.get(0));
                infoPais.setAnos2016_17(Integer.parseInt(csvRecord.get(2)));
                infoPais.setAnos2017_18(Integer.parseInt(csvRecord.get(3)));
                infoPais.setAnos2018_19(Integer.parseInt(csvRecord.get(4)));
                infoPais.setAnos2019_20(Integer.parseInt(csvRecord.get(5)));
                infoPais.setTotal_domestic_consumption(Long.parseLong(csvRecord.get(6)));
                //Separar los cafes
                String[] cafes = Separador(csvRecord.get(1));
                //Comprobar el cafe si existe o no para guardarlo o recuperar la informacion ya guardada
                for (String cafe : cafes) {
                    CafeTypes cafeTypes = new CafeTypes();
                    if (mapaCafeTypes.containsKey(cafe)) {
                        cafeTypes.setId(mapaCafeTypes.get(cafe).getId());
                        cafeTypes.setCafeType(mapaCafeTypes.get(cafe).getCafeType());
                    } else {
                        cafeTypes.setId(idCafe);
                        idCafe++;
                        cafeTypes.setCafeType(cafe);
                        mapaCafeTypes.put(cafeTypes.getCafeType(), cafeTypes);
                    }
                    infoPais.getCafeTypes().add(cafeTypes);
                    cafeTypes.getPaises().add(infoPais);
                }
                datosVO.getListInfoPais().add(infoPais);
            }
            for (Map.Entry<String, CafeTypes> cafe : mapaCafeTypes.entrySet()) {
                datosVO.getListCafeTypes().add(cafe.getValue());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String[] Separador(String cafes) {
        return cafes.split("/");
    }
}
