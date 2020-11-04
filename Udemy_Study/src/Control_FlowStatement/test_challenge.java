package Control_FlowStatement;

public class test_challenge {
    public static void main(String[] args) {
        getDaysInMonth(11,2020);
    }

    public static boolean isLeapYear(int year) {
      boolean isValueYear = (year >= 1 && year < 9999) ?true : false;
      if(!isValueYear){
          System.out.println("Invalid year");
          return false;
      }else if(year%4==0 && year%100!=0 || year%400==0 ){
          System.out.println("is Leap Year");
          return true;
      }else {
          System.out.println("Is not Leap Year");
          return false;
      }

    }
    public static int getDaysInMonth(int month, int year){

        if(month<1 || month >12 || year<1 || year>9999){
            System.out.println("Invalid month");
            return -1;
        }else{
            System.out.println("year : " + year);
            switch (month){
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    System.out.println("31 days");
                    return 31;
                case 2:
                    if(isLeapYear(year)){
                        System.out.println("month:" + month + " : " +"29 days");
                        return 29;
                    }else{
                        System.out.println("28 days");
                        return 28;
                    }
                case 4: case 6: case 9: case 11:
                    System.out.println("30 days");
                    return 30;
                default:
                    System.out.println("Invalid value");
                    return -1;
            }
        }




        }
    }

