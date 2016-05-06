package main.Sinners;

import org.junit.Before;
import org.junit.Test;

import javax.validation.Validator;

import java.util.Date;
import java.util.EnumSet;

import static org.junit.Assert.*;

/**
 * Created by tieorange on 06/05/16.
 */
public class SinnerUniqueTest {
    private static Sinner sinner;

    @Before
    public void setUp() throws Exception {
        EnumSet<SinnerType> sinnerTypes = EnumSet.of(SinnerType.LIAR, SinnerType.MURDERER);
        sinner = new Sinner("bob", "marley", new Date(), sinnerTypes, 20, 3);

    }

    @Test
    public void addSin() throws Exception {
        try {
            sinner.addSin("killing");
            sinner.addSin("killing");
        } catch (Exception e) {
            assertEquals("Sin with such a name already added", e.getMessage());
        }
    }

}