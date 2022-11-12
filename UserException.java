public class UserException extends Exception{
        public UserException(String inputType){
            super("invalid" + inputType+"input occur");
        }
}
