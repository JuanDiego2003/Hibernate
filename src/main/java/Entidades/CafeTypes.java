package Entidades;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "cafes_types")
public class CafeTypes {
    @Id
    private int id = 0;
    @Column(name = "cafe_type")
    private String cafeType="";

    @ManyToMany(mappedBy = "cafeTypes", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private Set<InfoPais> paises = new HashSet<>();


}
