package Control_FlowStatement;

public class test_challenge_withFor_1 {
    public static void main(String[] args) {
        int sum = 0;
        int count = 0;
        for (int i = 1; i < 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                count++;
                sum += i;
                System.out.println("test 1 number is :" + i);
            }
            if (count == 5) {
                break;
            }
        }
        System.out.println("Sum" + "\t" + sum);
    }
}


