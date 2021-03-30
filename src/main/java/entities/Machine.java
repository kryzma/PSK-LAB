package entities;

import java.io.Serializable;

public class Machine implements Serializable {
    String name;

    public Machine(String name) {
        this.name = name;
    }

    public Machine() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
