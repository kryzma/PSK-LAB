package usecases;

import entities.Machine;
import entities.Weight;
import lombok.Getter;
import lombok.Setter;
import persistence.WeightsDAO;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter
@Setter
@Transactional
public class EditWeight implements Serializable {

    @Inject
    private WeightsDAO weightsDAO;

    @Getter @Setter
    private Weight weightToUpdate = new Weight();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        Integer weightId = Integer.parseInt(requestParameters.get("weightId"));
        this.weightToUpdate = weightsDAO.findOne(weightId);
        this.weightToUpdate.setId(weightId);
    }

    @Transactional
    public String updateWeight() {
        try {
            // Simulating complex object validation
            this.weightsDAO.update(weightToUpdate);
        }
        catch (OptimisticLockException e) {
            System.out.println("Optimistic lock happened!");
            return "dialog.xhtml";
        }
        return "weight.xhtml?faces-redirect=true&weightId=" + this.weightToUpdate.getId();
    }

    @Transactional
    public String overwrite(Integer id) {
        Weight weightToInsert = this.weightsDAO.findOne(weightToUpdate.getId());
        weightToInsert.setName(weightToUpdate.getName());
        this.weightsDAO.persist(weightToInsert);
        return "weight.xhtml?faces-redirect=true&weightId=" + this.weightToUpdate.getId();
    }

}
