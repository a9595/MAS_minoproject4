package main;

import main.MyUtils.MyTools;
import main.Sinners.Sinner;
import main.Sinners.SinnerType;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.EnumSet;

import static org.junit.Assert.*;

/**
 * Created by tieorange on 06/05/16.
 */
public class BagTest {


    private TortureDepartment tortureDepartment;
    private SufferingProcess process;
    private Sinner sinner;

    @Before
    public void setUp() throws Exception {
        tortureDepartment = new TortureDepartment("boiling room");
        EnumSet<SinnerType> sinnerTypes = EnumSet.of(SinnerType.LIAR, SinnerType.MURDERER);
        sinner = new Sinner("bob", "marley", new Date(), sinnerTypes, 3, 3);

        process = new SufferingProcess(MyTools.getStartDateExample(), MyTools.getEndDateExample(), tortureDepartment, sinner);

    }

    @Test
    public void isPossibleToAddDuplicates() throws Exception {
        sinner.addSufferingProcess(process);
        sinner.addSufferingProcess(process);
    }

    @Test
    public void isPossibleToAddDuplicates2() throws Exception {
        tortureDepartment.addSufferingProcess(process);
        tortureDepartment.addSufferingProcess(process);
    }

}