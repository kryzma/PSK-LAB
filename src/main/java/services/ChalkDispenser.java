package services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;

@ApplicationScoped
@Default
public class ChalkDispenser {

    public void dispenseChalk() {
        System.out.println("Dispensing chalk");
    }

}
