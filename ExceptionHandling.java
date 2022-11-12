public class ExceptionHandling {
    static int divideByZero(int a, int b)
    {
        System.out.println("dividebyzero");
        int i = a / b;
        return i;
    }

    static int computeDivision(int a, int b)
    {
        int res = 0;
        try {

            res = divideByZero(a, b);
            System.out.println("computeDivision");
        }

        catch (NumberFormatException ex) {
            System.out.println(
                    "NumberFormatException is occurred");
        }
        return res;
    }
    public static void main(String args[])
    {
        int a = 1;
        int b = 0;
        try {
            int i = computeDivision(a, b);
        }
        catch (ArithmeticException ex){
            System.out.println(ex.getMessage());
        }
    }
}
