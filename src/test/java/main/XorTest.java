package main;

import main.Torturers.TorturerWithSpikes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by tieorange on 06/05/16.
 */
public class XorTest {
    private static TortureDepartment tortureDepartment;
    private TorturersTorturingDepartment torturersTorturingDepartment;

    @Before
    public void setUp() throws Exception {
        tortureDepartment = new TortureDepartment("boiling room");
        torturersTorturingDepartment = new TorturersTorturingDepartment("hell for torturers");


    }

    @Test
    public void fail() throws Exception {
        try {
            TorturerWithSpikes torturerWithSpikesBAD = new TorturerWithSpikes("Mifelos", tortureDepartment);
            torturerWithSpikesBAD.setTorturersTorturingDepartment(torturersTorturingDepartment);
        } catch (Exception e) {
            String message = e.getMessage();
            assertEquals("another department is already set - allowed only 1 type of department", message);
        }
    }
}