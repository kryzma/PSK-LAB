package usecases;

import entities.Machine;
import persistence.MachinesDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Model
public class Machines implements Serializable {

    @Inject
    private MachinesDAO machinesDAO;

    private Machine machineToCreate = new Machine();

    private List<Machine> allMachines;
    @PostConstruct
    public void init() {
        loadPlayers();
    }

    public void loadPlayers() {
        this.allMachines = machinesDAO.loadAll();
    }

    public List<Machine> getAllMachines() {
        return allMachines;
    }

    @Transactional
    public String createMachine() {
        this.machinesDAO.persist(machineToCreate);
        return "success";
    }

    public Machine getMachineToCreate() {
        return machineToCreate;
    }

    public void setMachineToCreate(Machine machineToCreate) {
        this.machineToCreate = machineToCreate;
    }

}
