package main.HellPets;

import main.TortureDepartment;
import main.Torturers.TorturerWithSpikes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tieorange on 06/05/16.
 */
public class HellPetCustomBusinessConstraintTest {
    private static HellPet hellPet;
    private TortureDepartment tortureDepartment;
    private TorturerWithSpikes torturerWithSpikes;

    @Before
    public void setUp() throws Exception {
        tortureDepartment = new TortureDepartment("boiling room");

        // DYNAMIC
        torturerWithSpikes = new TorturerWithSpikes("Mifelos", tortureDepartment);
    }

    @Test
    public void setFlyingSpeed() throws Exception {
        // FAIL:
        try {
            hellPet = new HellPet("bonia", HellPetColor.GREEN, torturerWithSpikes, HellPetType.FLYING, null, 200);
        } catch (Exception e) {
            String message = e.getMessage();
            assertEquals("Such a high speed (>100) is allowed only for RED color HellPet", message);
        }



    }

    @Test
    public void setFlyingSpeedSuccess() throws Exception {
        // SUCCESS:
            hellPet = new HellPet("bonia", HellPetColor.RED, torturerWithSpikes, HellPetType.FLYING, null, 200);

    }

}