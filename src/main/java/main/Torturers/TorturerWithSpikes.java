package main.Torturers;

import main.TortureDepartment;

/**
 * Created by tieorange on 26/04/16.
 */
public class TorturerWithSpikes extends Torturer {

    public TorturerWithSpikes(String name, TortureDepartment tortureDepartment) {
        super(name + " with spikes", tortureDepartment);
    }

    @Override
    public void punish() {
        System.out.println("Torturer punished with Spikes");
    }
}
