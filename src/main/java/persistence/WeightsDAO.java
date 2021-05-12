package persistence;

import entities.Weight;
import entities.Zone;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class WeightsDAO {

    @Inject
    private EntityManager em;

    public void persist(Weight weight) {
        this.em.persist(weight);
    }

    public Weight findOne(Integer id) {
        return em.find(Weight.class, id);
    }

    public Weight update(Weight weight) {
        return em.merge(weight);
    }

}
