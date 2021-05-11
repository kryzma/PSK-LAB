package usecases;

import services.ShakeMachine;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class Shakes {

    @Inject
    private ShakeMachine shakeMachine;

    public String drinkShake() {
        shakeMachine.getShake();
        return "index?faces-redirect=true";
    }
}
