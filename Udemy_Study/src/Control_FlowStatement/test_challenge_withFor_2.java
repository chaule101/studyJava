package Control_FlowStatement;
/*
Write a method called isOdd with an int parameter and call it number. The method needs to return a boolean.

Check that number is > 0, if it is not return false.

If number is odd return true, otherwise  return false.

Write a second method called sumOdd that has 2 int parameters start and end, which represent a range of numbers.

The method should use a for loop to sum all odd numbers  in that range including the end and return the sum.

It should call the method isOdd to check if each number is odd.

The parameter end needs to be greater than or equal to start and both start and end parameters have to be greater than 0.

If those conditions are not satisfied return -1 from the method to indicate invalid input.

Example input/output:

* sumOdd(1, 100); → should return 2500

* sumOdd(-1, 100); →  should return -1

* sumOdd(100, 100); → should return 0

* sumOdd(13, 13); → should return 13 (This set contains one number, 13, and it is odd)

* sumOdd(100, -100); → should return -1

* sumOdd(100, 1000); → should return 247500


TIP: use the remainder operator to check if the number is odd

NOTE: Both methods  needs to be defined as public static like we have been doing so far in the course.
NOTE: Do not add a  main method to solution code.
 */

public class test_challenge_withFor_2 {
    public static void main(String[] args) {
        System.out.println(sumOdd(1, 11));
    }

    public static boolean isOdd(int is) {
        if (is < 0) {
            return false;
        } else if (is % 2 != 0) {
//            System.out.println("Odd number : " + is);
            return true;
        }
        return false;
    }


    public static int sumOdd(int start, int end) {
        int sum = 0;
//        int count = 0;
        //Star must greater than End and both of them must greater than 0
        if (start <= end && start > 0 && end > 0) {
            for (int i = start; i <= end; i++) {
                if (isOdd(i)) {
//                    count++;
                    sum += i;
                    System.out.println("Odd number is :" + i);
                }

            }
            return sum;
        }else{
            return -1;
        }
    }
}


