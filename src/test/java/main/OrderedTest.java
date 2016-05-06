package main;

import main.PunishmentTools.CuttingPunishmentTool;
import main.PunishmentTools.ExplosivePunishmentTool;
import main.PunishmentTools.PunishmentTool;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by tieorange on 06/05/16.
 */
public class OrderedTest {

    private TortureDepartment tortureDepartment;
    private PunishmentTool punishmentToolFirst;
    private PunishmentTool punishmentToolSecond;

    @Before
    public void setUp() {
        tortureDepartment = new TortureDepartment("boiling room");
        punishmentToolSecond = new ExplosivePunishmentTool("sdfsdf", 2, tortureDepartment, 4.5, 6);
        punishmentToolFirst = new CuttingPunishmentTool("name", 1, tortureDepartment, 1, 2);
    }

    @Test
    public void addPunishmentTool() throws Exception {
        List<PunishmentTool> punishmentTools = tortureDepartment.getPunishmentTools();

        boolean isFirstIndex = punishmentTools.get(0) == punishmentToolFirst;
        boolean isSecondIndex = punishmentTools.get(1) == punishmentToolSecond;
        assertTrue(isFirstIndex);
        assertTrue(isSecondIndex);
    }

}