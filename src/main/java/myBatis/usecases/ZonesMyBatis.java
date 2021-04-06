package myBatis.usecases;

import lombok.Getter;
import lombok.Setter;
import myBatis.dao.ZoneMapper;
import myBatis.model.Zone;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class ZonesMyBatis {
    @Inject
    private ZoneMapper zoneMapper;

    @Getter
    private List<Zone> allZones;

    @Getter @Setter
    private Zone zoneToCreate = new Zone();

    @PostConstruct
    public void init() {
        this.loadAllZones();
    }

    @Transactional
    public String createZone() {
        zoneMapper.insert(zoneToCreate);
        return "/myBatisWeb/indexMB.xhtml?faces-redirect=true";
    }

    private void loadAllZones() {
        this.allZones = zoneMapper.selectAll();
    }

}
