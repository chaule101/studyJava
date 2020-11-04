package Control_FlowStatement;

public class test_challenge_withFor {
    public static void main(String[] args) {

//        System.out.println("10000 at 2% is : " + calculateInterest(10000,2));
        for (int i = 2; i < 9; i++) {
            System.out.println("10000 at" + "\t" + i + "\t" + "is" + "\t" +
                    String.format("%.2f", calculateInterest(20000, i)));
        }
        System.out.println("==============================================");

        int count=0 ;
        for(int i = 2;i<100;i++){
            if(isPrime(i)){
                count++;
                System.out.println("Prime number :" + i);
                if(count==3){
                    System.out.println("Exitting for loop");
                    break;
                }
            }
        }

    }


    public static double calculateInterest(double amount, double interestRate) {
        return (amount * (interestRate / 100));
    }

    public static boolean isPrime(int n) {
        if(n==1){
            return false;

        }for(int i = 2;i<=n/2;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}

