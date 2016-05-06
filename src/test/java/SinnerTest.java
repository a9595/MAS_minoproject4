import main.Sinners.Sinner;
import main.Sinners.SinnerType;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Date;
import java.util.EnumSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by tieorange on 06/05/16.
 */
public class SinnerTest {
    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void nameIsTooShort() {
        EnumSet<SinnerType> sinnerTypes = EnumSet.of(SinnerType.LIAR, SinnerType.MURDERER);
        Sinner sinner = new Sinner("b", "marley", new Date(), sinnerTypes, 20, 3);

        Set<ConstraintViolation<Sinner>> constraintViolations =
                validator.validate(sinner);

        assertEquals(1, constraintViolations.size());
        assertEquals("size must be between 2 and 14", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void amountOfLies() {
        EnumSet<SinnerType> sinnerTypes = EnumSet.of(SinnerType.LIAR, SinnerType.MURDERER);
        Sinner sinner = new Sinner("bob", "marley", new Date(), sinnerTypes, 3, 3);

        Set<ConstraintViolation<Sinner>> constraintViolations =
                validator.validate(sinner);

        assertEquals(1, constraintViolations.size());
        assertEquals("must be greater than or equal to 20", constraintViolations.iterator().next().getMessage());
    }
}