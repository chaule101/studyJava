package Control_FlowStatement;

public class test_Switch {
    public static void main(String[] args) {
//        int value = 1;
//        if(value==1){
//            System.out.println("Value is 1");
//        }else if(value==2){
//            System.out.println("Value is 2");
//        }else {
//            System.out.println("Not 1 or 2");
//        }
//        int swicthValue = 2;
//        switch (swicthValue){
//            case 1:
//                System.out.println("value is 1");
//                break;
//            case 2:
//                System.out.println("Value is 2");
//                break;
//            case 3 : case 4 : case 5:
//                System.out.println("It maybe is 3 or 4 or 5");
//                System.out.println("Actually it is  " +swicthValue);
//                break;
//            default:
//                System.out.println("Out of range");
//                System.out.println("It is " +swicthValue);
//                break;
//            //default means at any other case that's not covered above
//        }
        String switchValue = "z";
        switch (switchValue){
            case "A":
            System.out.println("It is A");
            break;
            case  "B":
                System.out.println("It is B");
                break;
            case "C":
                System.out.println("It is C");
                break;
            case "E" :  case "D":
                System.out.println("It maybe E or D");
                System.out.println("Actually it is " + switchValue);
                break;
            default:
                System.out.println("Out of range");
                break;
        }

        String month = "January";
        switch (month.toLowerCase()){
            case "january":
                System.out.println("this is January");
                break;
            case"june":
                System.out.println("This is June");
                break;
            default:
                System.out.println("It maybe May");
                break;
        }
        printDayOfWeek(1);


    }
    private static void printDayOfWeek(int day){
                 switch (day) {
                     case 0:
                         System.out.println("It is Sunday");
                         break;
                     case 1:
                         System.out.println("It is Monday");
                         break;
                     case 2:
                         System.out.println("It is Tuesday");
                         break;
                     case 3:
                         System.out.println("It is Wednesday");
                         break;
                     case 4:
                         System.out.println("It is Thurday");
                         break;
                     case 5:
                         System.out.println("It is Friday");
                         break;
                     case 6:
                         System.out.println("It is Saturday");
                         break;
                     default:
                         System.out.println("Invalid day");
                         break;
                 }
    }











}