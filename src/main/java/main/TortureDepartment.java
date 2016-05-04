package main;

import main.PunishmentTools.PunishmentTool;
import main.Torturers.Torturer;

import javax.validation.constraints.NotNull;
import java.util.*;

/**
 * Created by tieorange on 21/04/16.
 */
public class TortureDepartment {

    @NotNull
    private String name;

    private Set<SufferingProcess> sufferingProcesses = new HashSet<>(); // with an attribute
    private Map<String, Torturer> torturersMap = new HashMap<>(); // qualified
    private List<PunishmentTool> punishmentTools = new ArrayList<>();

    public TortureDepartment(String name) {
        setName(name);
    }

    public Torturer getTorturerById(String id) {
        if (id != null) {
            return torturersMap.get(id);
        } else {
            throw new RuntimeException("id is NULL");
        }
    }

    public void addTorturer(Torturer newTorturer) {
        if (newTorturer == null) {
            throw new RuntimeException("main.Torturers is NULL");
        } else {
            if (!torturersMap.containsKey(newTorturer.getId())) {
                torturersMap.put(newTorturer.getId(), newTorturer);
                if (newTorturer.getTortureDepartment() != this) // check if already setted
                    newTorturer.setTortureDepartment(this);
            } else {
                throw new RuntimeException("main.Torturers is already in this main.TortureDepartment");
            }
        }
    }

    public void removeTorturerById(String id) {
        if (id == null) {
            throw new IllegalArgumentException("id is NULL");
        } else {
            torturersMap.remove(id);
        }
    }

    public Set<SufferingProcess> getSufferingProcesses() {
        return sufferingProcesses;
    }

    public void addSufferingProcess(SufferingProcess sufferingProcess) {
        if (sufferingProcess.getTortureDepartment() != this) {
            throw new IllegalArgumentException("main.SufferingProcess torture department is different");
        }

        if (!this.sufferingProcesses.contains(sufferingProcess)) {
            sufferingProcesses.add(sufferingProcess);
        } else {
            throw new IllegalArgumentException("This main.SufferingProcess is already added");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        /*if (name == null) {
            throw new IllegalArgumentException("name is NULL");
        } else {*/
        this.name = name;
//        }
    }

    // punishment tools:
    public List<PunishmentTool> getPunishmentTools() {
        return new ArrayList<>(punishmentTools);
    }

    public void addPunishmentTool(PunishmentTool punishmentTool) {
        if (punishmentTool != null) {
            if (!punishmentTools.contains(punishmentTool)) {
                punishmentTools.add(punishmentTool);
                punishmentTool.setTortureDepartment(this);
            } else {
                throw new IllegalArgumentException("this punishmentTool is already added");
            }
        } else {
            throw new IllegalArgumentException("punishmentTool is NULL");
        }
    }

    public void removePunishmentTool(PunishmentTool punishmentTool) {
        if (punishmentTools.contains(punishmentTool)) {
            punishmentTools.remove(punishmentTool);
            punishmentTool.setTortureDepartment(null);
        }

    }

}
