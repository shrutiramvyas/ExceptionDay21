import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class UserRegistrationTest {
    private Boolean expectedResult;
//    ArrayList<> happyCase = new ArrayList<>();
//    ArrayList<> sadCase = new ArrayList<>();

    private String inputType;
    private  String type;
    private UserRegistrationProblem userRegistrationProblem;

    @Before
    public void initialize(){
        userRegistrationProblem = new UserRegistrationProblem();
    }
    public UserRegistrationTest(Boolean expectedResult,String inputType, String type) {
        this.inputType = inputType ;
        this.type = type;
        this.expectedResult = expectedResult;
    }
    @Parameterized.Parameters
    public static Collection input(){
        return Arrays.asList(new Object[][]{ { true, "Shruti","NAME_TYPE"},{true, "Dadhich","NAME_TYPE"},{true,"sdnk1993@gmail.com","EMAIL_TYPE"}, {true,"91 8949829904","MOBILE_TYPE"}, {true,"Shruti@123","PASSWORD_TYPE"}});
    }

    @Test
    public void testParameterUserRegistration() throws UserException {
        System.out.println("Parameterized " + inputType);
        Assert.assertEquals(expectedResult, userRegistrationProblem.validate(type,inputType));
        }
    }

