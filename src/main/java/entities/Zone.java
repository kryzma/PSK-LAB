package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Zone.findAll", query = "select a from Zone as a")
})
@Table(name = "ZONE")
@Getter @Setter
public class Zone implements Serializable {

    public Zone() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "NAME")
    private String name;

    @ManyToMany
    private List<Machine> machines = new ArrayList<>();

    @OneToMany(mappedBy = "zone")
    private List<Weight> weights = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zone zone = (Zone) o;
        return Objects.equals(id, zone.id) && Objects.equals(name, zone.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

}
