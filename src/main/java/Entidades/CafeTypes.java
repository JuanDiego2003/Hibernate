package Entidades;

import javax.persistence.Column;
import javax.persistence.Id;

public class CafeTypes {
    @Id
    private int id;
    @Column(name = "cafe type")
    private String cafeType;
    @Column(name = "id pais")
    private int id_Pais ;
}
