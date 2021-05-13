package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Weight.findAll", query = "select a from Weight as a")
})
@Table(name = "WEIGHT")
@Getter @Setter
public class Weight {

    public Weight() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "NAME")
    private String name;

    @ManyToOne
    private Zone zone;

    @Version
    @Column(name="OPT_LOCK_VERSION")
    private Integer version;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weight weight = (Weight) o;
        return Objects.equals(id, weight.id) && Objects.equals(name, weight.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
