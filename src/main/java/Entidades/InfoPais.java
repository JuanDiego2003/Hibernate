package Entidades;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cafes")
public class InfoPais {
    @Id
    private int id;
    @Column(name = "pais")
    private String pais="";
    @Column(name = "año  2016/17")
    private int Anos2016_17=0;
    @Column(name = "año  2017/18")
    private int Anos2017_18=0;
    @Column(name = "año  2018/19")
    private int Anos2018_19=0;
    @Column(name = "año  2019/20")
    private int Anos2019_20=0;
    @Column(name = "Total")
    private int Total_domestic_consumption=0;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "infopais_cafetypes",
            joinColumns = @JoinColumn(name = "pais_id"),
            inverseJoinColumns = @JoinColumn(name = "cafetypes_id"))
    private Set<CafeTypes> cafeTypes = new HashSet<>();
}
