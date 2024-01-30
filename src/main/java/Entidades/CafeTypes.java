package Entidades;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "cafes_types")
public class CafeTypes {
    @Id
    private int id;
    @Column(name = "cafe_type")
    private String cafeType="";

    @ManyToMany(mappedBy = "cafeTypes", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private Set<InfoPais> paises = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCafeType() {
        return cafeType;
    }

    public void setCafeType(String cafeType) {
        this.cafeType = cafeType;
    }

    public Set<InfoPais> getPaises() {
        return paises;
    }

    public void setPaises(Set<InfoPais> paises) {
        this.paises = paises;

    }
}
