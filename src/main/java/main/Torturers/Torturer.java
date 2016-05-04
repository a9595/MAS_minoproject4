package main.Torturers;

import main.HellPets.HellPet;
import main.MAS.ObjectPlus4;
import main.TortureDepartment;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by tieorange on 21/04/16.
 */
public abstract class Torturer extends ObjectPlus4 {

    public static final String roleBelongsTo = "Belongs to";
    public static final String roleManages = "Manages";

    private static final String EXTENT_FILE_PATH = "/tmp/extent.torturer";
    private static List<Torturer> extent = new ArrayList<>();
    private String id; // Qualified
    private TortureDepartment tortureDepartment;
    private String name;
    private HellPet hellPet;

    public Torturer(String name, TortureDepartment tortureDepartment) {
        this();
        setName(name);
        UUID uuid = UUID.randomUUID();
        setId(uuid.toString());
        setTortureDepartment(tortureDepartment);
    }

    public Torturer() {
        super();
        if (isIdAlreadyExist(this)) {
            throw new RuntimeException("Torturer with such ID already exist");
        } else {
            Torturer.extent.add(this);
        }
    }

    public static void saveExtent() {
        try {
            FileOutputStream fileOut =
                    new FileOutputStream(EXTENT_FILE_PATH);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(extent);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in " + EXTENT_FILE_PATH);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void loadExtent() {
        try {
            FileInputStream fileIn = new FileInputStream(EXTENT_FILE_PATH);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            extent = (List<Torturer>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Extent class not found");
            c.printStackTrace();
            return;
        }
    }

    //region Getters and Setters
    public TortureDepartment getTortureDepartment() {
        return tortureDepartment;
    }

    public void setTortureDepartment(TortureDepartment tortureDepartment) {
        if (tortureDepartment == null) {
            throw new IllegalArgumentException("tortureDepartment is NULL");
        } else {
            this.tortureDepartment = tortureDepartment;
            tortureDepartment.addTorturer(this);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null) {
            throw new IllegalArgumentException("id is NULL");
        } else {
            this.id = id;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name is NULL");
        } else {
            this.name = name;
        }
    }

    public HellPet getHellPet() {
        return hellPet;
    }

    public void setHellPet(HellPet hellPet) {
        if (hellPet != null) {
            if (this.hellPet != hellPet) {
                if (this.hellPet != null)
                    this.hellPet.setTorturer(null);
                this.hellPet = hellPet;
                hellPet.setTorturer(this);
            }

        } else {
            throw new IllegalArgumentException("hellPet is NULL");
        }
    }

    public static List<Torturer> getTorturers() {
        List<Torturer> tmp = new ArrayList<>(extent);
        return tmp;
    }

    public static Torturer getTorturerById(String id) {
        List<Torturer> tmp = new ArrayList<>(extent);
        Torturer foundTorturer = null;
        for (Torturer torturer : tmp) {
            if (torturer.getId().equals(id))
                foundTorturer = torturer;
        }
        return foundTorturer;
    }

    public boolean isIdAlreadyExist(Torturer torturer) {
        boolean isExist = false;
        for (Torturer torturer1 : extent) {
            if (torturer1.getId().equals(torturer.getId()))
                isExist = true;
        }
        return isExist;
    }
    //endregion

    public abstract void punish();
}
