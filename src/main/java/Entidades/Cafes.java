package Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cafes")
public class Cafes {
    @Id
    private int id;
    @Column(name = "pais")
    private String pais;
    @Column(name = "año  2016/17")
    private int Anos2016_17;
    @Column(name = "año  2017/18")
    private int Anos2017_18;
    @Column(name = "año  2018/19")
    private int Anos2018_19;
    @Column(name = "año  2019/20")
    private int Anos2019_20;
    @Column(name = "Total")
    private int Total_domestic_consumption;
}
