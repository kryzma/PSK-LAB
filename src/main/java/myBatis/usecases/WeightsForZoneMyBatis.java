package myBatis.usecases;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

import myBatis.model.Weight;
import myBatis.model.Zone;
import lombok.Getter;
import lombok.Setter;
import myBatis.dao.WeightMapper;
import myBatis.dao.ZoneMapper;


@Model
public class WeightsForZoneMyBatis implements Serializable {

    @Inject
    private ZoneMapper zoneMapper;

    @Inject
    private WeightMapper weightMapper;

    @Getter @Setter
    private Zone zone;

    @Getter @Setter
    private Weight weightToCreate = new Weight();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer zoneId = Integer.parseInt(requestParameters.get("zoneId"));
        this.zone = zoneMapper.selectByPrimaryKey(zoneId);
    }

    @Transactional
    public String createWeight() {
        weightToCreate.setZoneId(zone.getId());
        weightMapper.insert(weightToCreate);
        return "/myBatisWeb/weightsMB?faces-redirect=true&zoneId=" + this.zone.getId();
    }
}
