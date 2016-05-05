package main.Torturers;

import main.TortureDepartment;
import main.TorturersTorturingDepartment;

/**
 * Created by tieorange on 26/04/16.
 */
public class TorturerWithKnife extends Torturer {

    public TorturerWithKnife(String name, TortureDepartment tortureDepartment) {
        super(name + " with knife", tortureDepartment);
    }

    public TorturerWithKnife(String name, TorturersTorturingDepartment torturersTorturingDepartment) {
        super(name + " with knife", torturersTorturingDepartment);
    }

    @Override
    public void punish() {
        System.out.println("Torturer punished with a knife");
    }
}
