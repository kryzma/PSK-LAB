package services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

@Alternative
@ApplicationScoped
public class MilkShakeMachine implements ShakeMachine {

    @Override
    public void getShake() {
        System.out.println("Drinking milk shake!");
    }
}
