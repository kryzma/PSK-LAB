package services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;

@ApplicationScoped
public class ProteinShakeMachine implements ShakeMachine {

    @Override
    public void getShake() {
        System.out.println("Drinking protein shake!");
    }
}
