package main.Torturers;

import main.TortureDepartment;

/**
 * Created by tieorange on 26/04/16.
 */
public class TorturerWithKnife extends Torturer {

    public TorturerWithKnife(String name, TortureDepartment tortureDepartment) {
        super(name + " with knife", tortureDepartment);
    }

    @Override
    public void punish() {
        System.out.println("Torturer punished with a knife");
    }
}
