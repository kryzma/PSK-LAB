package services;

import javax.enterprise.context.ApplicationScoped;
import java.util.Random;


@ApplicationScoped
public class SimpleLockerCodeGenerator implements LockerCodeGenerator {

    @Override
    public int generateLockerCode() {
        Random rand = new Random();

        return Math.abs(rand.nextInt()) % 100;
    }
}
