package services;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import java.util.Random;


@Decorator
public abstract class ComplexLockerCodeGenerator implements LockerCodeGenerator {

    @Inject @Delegate
    LockerCodeGenerator lockerCodeGenerator;

    @Override
    // Adds digits to already generated code
    public int generateLockerCode() {
        Random rand = new Random();

        int current_num = lockerCodeGenerator.generateLockerCode();
        if(current_num==0){
            current_num = 1;
        }
        current_num = current_num * 1000;

        int three_digits = rand.nextInt() % 1000;
        current_num += three_digits;

        return current_num;
    }
}
