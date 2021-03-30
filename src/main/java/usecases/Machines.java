package usecases;

import entities.Machine;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Model
public class Machines implements Serializable {

    private List<Machine> allMachines;
    @PostConstruct
    public void init() {
        loadPlayers();
    }

    public void loadPlayers() {
        // TODO this is a mock implementation - later we will connect it to real database
        List<Machine> machines = new ArrayList<>();
        machines.add(new Machine("Squat rack"));
        machines.add(new Machine("Weight bench"));
        this.allMachines = machines;
    }

    public List<Machine> getAllMachines() {
        return allMachines;
    }

}
