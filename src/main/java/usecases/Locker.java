package usecases;

import services.LockerCodeGenerator;

import javax.decorator.Delegate;
import javax.enterprise.inject.Model;
import javax.inject.Inject;


@Model
public class Locker {

    @Inject
    private LockerCodeGenerator lockerCodeGenerator;

    public String generateCode() {
        int code = lockerCodeGenerator.generateLockerCode();
        System.out.println(code);
        return "index?faces-redirect=true";
    }

}
