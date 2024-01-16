package Entidades;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class CafeTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToMany(cascade = CascadeType.ALL)
    private int id;
    @Column(name = "cafe type")
    private String cafeType;

    @ManyToMany()
    private Set<InfoPais> paises = new HashSet<>();


}
