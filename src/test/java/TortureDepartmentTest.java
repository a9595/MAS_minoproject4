import main.TortureDepartment;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by tieorange on 02/05/16.
 */
public class TortureDepartmentTest {
    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void nameIsNull() {
        TortureDepartment department = new TortureDepartment(null);

        Set<ConstraintViolation<TortureDepartment>> constraintViolations =
                validator.validate(department);

        assertEquals(1, constraintViolations.size());
        assertEquals("may not be null", constraintViolations.iterator().next().getMessage());
    }



}