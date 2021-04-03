package usecases;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

import entities.Weight;
import entities.Zone;
import lombok.Getter;
import lombok.Setter;
import persistence.WeightsDAO;
import persistence.ZonesDAO;


@Model
public class WeightsForZone implements Serializable {

    @Inject
    private ZonesDAO zonesDAO;

    @Inject
    private WeightsDAO weightsDAO;

    @Getter @Setter
    private Zone zone;

    @Getter @Setter
    private Weight weightToCreate = new Weight();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer zoneId = Integer.parseInt(requestParameters.get("zoneId"));
        this.zone = zonesDAO.findOne(zoneId);
    }

    @Transactional
    public String createWeight() {
        weightToCreate.setZone(this.zone);
        weightsDAO.persist(weightToCreate);
        return "weights?faces-redirect=true&zoneId=" + this.zone.getId();
    }
}
