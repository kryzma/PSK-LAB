package persistence;

import entities.Zone;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ZonesDAO {

    @PersistenceContext
    @Inject
    private EntityManager em;

    public List<Zone> loadAll() {
        return em.createNamedQuery("Zone.findAll", Zone.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Transactional
    public void persist(Zone zone) {
        this.em.persist(zone);
    }

    public Zone findOne(Integer id) {
        return em.find(Zone.class, id);
    }

    @Transactional
    public Zone update(Zone zone) {
        System.out.println("hello");
        return em.merge(zone);
    }
}
