package persistence;

import entities.Machine;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class MachinesDAO {
    @PersistenceContext
    private EntityManager em;

    public List<Machine> loadAll() {
        return em.createNamedQuery("Machine.findAll", Machine.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Machine machine) {
        this.em.persist(machine);
    }

}
