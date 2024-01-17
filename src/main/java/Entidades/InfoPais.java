package Entidades;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "info_pais")
public class InfoPais {
    @Id
    private int id =0;
    @Column(name = "pais")
    private String pais="";
    @Column(name = "año_2016_17")
    private int Anos2016_17=0;
    @Column(name = "año_2017_18")
    private int Anos2017_18=0;
    @Column(name = "año_2018_19")
    private int Anos2018_19=0;
    @Column(name = "año_2019_20")
    private int Anos2019_20=0;
    @Column(name = "Total")
    private int Total_domestic_consumption=0;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "infopais_cafetypes",
            joinColumns = @JoinColumn(name = "pais_id"),
            inverseJoinColumns = @JoinColumn(name = "cafetypes_id"))
    private Set<CafeTypes> cafeTypes = new HashSet<>();

    public int getId() {
        return id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getAnos2016_17() {
        return Anos2016_17;
    }

    public void setAnos2016_17(int anos2016_17) {
        Anos2016_17 = anos2016_17;
    }

    public int getAnos2017_18() {
        return Anos2017_18;
    }

    public void setAnos2017_18(int anos2017_18) {
        Anos2017_18 = anos2017_18;
    }

    public int getAnos2018_19() {
        return Anos2018_19;
    }

    public void setAnos2018_19(int anos2018_19) {
        Anos2018_19 = anos2018_19;
    }

    public int getAnos2019_20() {
        return Anos2019_20;
    }

    public void setAnos2019_20(int anos2019_20) {
        Anos2019_20 = anos2019_20;
    }

    public int getTotal_domestic_consumption() {
        return Total_domestic_consumption;
    }

    public void setTotal_domestic_consumption(int total_domestic_consumption) {
        Total_domestic_consumption = total_domestic_consumption;
    }

    public Set<CafeTypes> getCafeTypes() {
        return cafeTypes;
    }

    public void setCafeTypes(Set<CafeTypes> cafeTypes) {
        this.cafeTypes = cafeTypes;
    }

    public void setId(int i) {
    }
}
