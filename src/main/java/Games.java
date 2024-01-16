import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "games")
public class Games {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Games() {
    }

    @Override
    public String toString() {
        return "Games{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    @Id
    private int id;
    @Column(name = "nombre")
    private String nombre;
}
