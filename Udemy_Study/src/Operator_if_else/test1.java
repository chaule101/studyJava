package Operator_if_else;

public class test1 {
    public static void main(String[] args) {
        // write your code here
        double a = 20.00d;
        double b = 80.00d;
        double result = (a+b)*100.0d;
        System.out.println("Result = " + result);
        int valueRemainder = (int) (result%40.00d);
        System.out.println("Remainder = " + valueRemainder);
        boolean isRemaider =(valueRemainder==0) ?true : false ;
        System.out.println("Is Remaider = " + isRemaider);
        if(!isRemaider){
            System.out.println("Got some remaider");

        }
    }
}
