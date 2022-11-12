import java.util.Scanner;
import java.util.regex.Pattern;
public class UserRegistrationProblem {
    @FunctionalInterface
    public interface Validator{
        public boolean check(String type,String value);
    }

    Pattern namePattern = Pattern.compile("[A-Z][a-z]{2,}");
    Pattern emailPattern = Pattern.compile("^(?!.*\\.\\.)[^.][a-zA-Z0-9+_.-]+[^.]@[a-zA-Z0-9&&[^.]][a-zA-Z0-9.]*[\\.]{1}[a-zA-z]{2,}$");
    Pattern mobilePattern = Pattern.compile("[0-9]{2} [0-9]{10}");
    Pattern passwordPattern = Pattern.compile("^(?=.*[0-9])(?=.*[A-Z])(?=[^@#$%^&-+=()]*[@#$%^&-+=()][^@#$%^&-+=()]*$).{8,}$");

    public final String NAME_TYPE = "NAME";
    public final String EMAIL_TYPE = "EMAIL";
    public final String MOBILE_TYPE = "MOBILE";
    public final String PASSWORD_TYPE = "PASSWORD";

    Validator validator = (String type,String value) -> {
        switch (type) {
            case NAME_TYPE:
                return namePattern.matcher(value).matches();
            case EMAIL_TYPE:
                return emailPattern.matcher(value).matches();
            case MOBILE_TYPE:
                return mobilePattern.matcher(value).matches();
            case PASSWORD_TYPE:
                return passwordPattern.matcher(value).matches();
            default:
                return false;
        }
    };

    public boolean validate(String type, String value) throws UserException{
       boolean isValid = validator.check(type,value);
       if(isValid){
           return isValid;
       }
       else{
           throw new UserException(" "+ type + " ");
       }
    }
    public boolean validate(User user)throws UserException{
        String invalidTypes="";
        if(!validator.check(NAME_TYPE,user.getFirstName())){
            invalidTypes +=" FIRST "+NAME_TYPE+ " ,";
        }
        if(! validator.check(NAME_TYPE, user.getLastName())) {
            invalidTypes += " LAST "+NAME_TYPE+", ";
        }
        if(! validator.check(EMAIL_TYPE, user.getEmail())) {
            invalidTypes += " "+EMAIL_TYPE+", ";
        }
        if(! validator.check(MOBILE_TYPE, user.getMobile())) {
            invalidTypes += " "+MOBILE_TYPE+", ";
        }
        if(! validator.check(PASSWORD_TYPE, user.getPassword())) {
            invalidTypes += " "+PASSWORD_TYPE+" ";
        }

        if(invalidTypes.isBlank()) {
            return true;
        } else {
            throw new UserException(invalidTypes);
        }

    }



    public static void main(String[] args) {
        UserRegistrationProblem user = new UserRegistrationProblem();
        System.out.println("Validation check for FirstName");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        try {
            if (user.validate(user.NAME_TYPE, name)) {
                System.out.println("Correct");
            } else {
                System.out.println("Incorrect, Name should be start from Capital Letter");
            }
        }
        catch(UserException e){
            System.out.println(e);
        }
        System.out.println("Validation check for LastName");
        String lastName = scan.nextLine();
        try {
            if (user.validate(user.NAME_TYPE, lastName)) {
                System.out.println("Correct");
            } else {
                System.out.println("Incorrect, LastName should be start from Capital Letter");
            }
        }
        catch(UserException e){
            System.out.println(e);
        }
        System.out.println("Validation check for Email");
        String email = scan.nextLine();
        try{
            if (user.validate(user.EMAIL_TYPE, email)) {
                System.out.println("Correct");
            } else {
                System.out.println("Incorrect");
            }
        }
        catch(UserException e){
            System.out.println(e);
        }
        System.out.println("Validation check for password");
        String password = scan.nextLine();
        try {
            if (user.validate(user.NAME_TYPE, password)) {
                System.out.println("Correct");
            } else {
                System.out.println("Incorrect");
            }
        }
        catch(UserException e){
            System.out.println(e);
        }
        System.out.println("Validation check for mobile");
        String mobile = scan.nextLine();
        try {
            if (user.validate(user.NAME_TYPE, mobile)) {
                System.out.println("Correct");
            } else {
                System.out.println("Incorrect");
            }
        }
        catch (UserException e){
            System.out.println(e);
        }
    }
}
