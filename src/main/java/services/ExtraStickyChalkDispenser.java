package services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Specializes;


@Specializes
@ApplicationScoped
public class ExtraStickyChalkDispenser extends ChalkDispenser {

    @Override
    public void dispenseChalk() {
        System.out.println("Dispensing extra sticky chalk");
    }
}
