package usecases;

import services.ChalkDispenser;
import services.ShakeMachine;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class Chalk {

    @Inject
    private ChalkDispenser chalkDispenser;

    public String dispenseChalk() {
        chalkDispenser.dispenseChalk();
        return "index?faces-redirect=true";
    }

}
