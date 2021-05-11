package usecases;

import entities.Zone;
import interceptor.LoggedInvocation;
import lombok.Getter;
import lombok.Setter;
import persistence.ZonesDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Zones {

    @Inject
    private ZonesDAO zonesDAO;

    @Getter @Setter
    private Zone zoneToCreate = new Zone();

    @Getter
    private List<Zone> allZones;

    @PostConstruct
    public void init(){
        this.loadAllZones();
    }

    @LoggedInvocation
    @Transactional
    public String createZone(){
        this.zonesDAO.persist(zoneToCreate);
        return "index?faces-redirect=true";
    }

    private void loadAllZones(){
        this.allZones = zonesDAO.loadAll();
    }
}
