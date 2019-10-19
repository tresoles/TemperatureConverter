package TempConvert;


import java.util.Scanner;


/**
 * TempConvert.java
 *******************************
 * A program that converts the user temperature and chosen scale to a
 * temperature of the scale that the user chose it to be changed to.
 * ___________________________________________
 * Trevon Lamb 10/11/2019 CMSC 255
 * Section 2
 */

public class TempConvert {

    public static void main(String[] args) {
        processData();

    }//End of Main



    public static void processData(){
        // put loop in here
        Scanner input = new Scanner(System.in);
        boolean result = true;
           do{
            System.out.println("Enter the temperature to convert: ");
            double temp = input.nextDouble();
            input.nextLine();

            System.out.println("Enter the current scale of the temperature: ");
            String scale = input.nextLine();

            System.out.println("Enter the scale you want to convert the temperature to: ");
            String convertScale = input.nextLine();

            if(checkValidity(temp, scale)){
                //68.50 degrees Fahrenheit is 293.28 degrees Kelvin
                if(scale.equals("Fahrenheit") && convertScale.equals("Celsius")) {
                    double cValue1 = convertFahtoCel(temp);
                    System.out.printf("%.2f degrees %s is %.2f degrees %s\n",temp,scale,cValue1,convertScale);
                }
                else if (scale.equals("Fahrenheit") && convertScale.equals("Kelvin")) {
                    double cValue2 = convertFahtoKel(temp);
                    System.out.printf("%.2f degrees %s is %.2f degrees %s\n",temp,scale,cValue2,convertScale);
                }
                else if (scale.equals("Celsius") && convertScale.equals("Fahrenheit")) {
                    double cValue3 = convertCeltoFah(temp);
                    System.out.printf("%.2f degrees %s is %.2f degrees %s\n",temp,scale,cValue3,convertScale);
                }
                else if (scale.equals("Celsius") && convertScale.equals("Kelvin")) {
                    double cValue4 = convertCeltoKel(temp);
                    System.out.printf("%.2f degrees %s is %.2f degrees %s\n",temp,scale,cValue4,convertScale);
                }
                else if (scale.equals("Kelvin") && convertScale.equals("Celsius")) {
                    double cValue5 = convertKeltoCel(temp);
                    System.out.printf("%.2f degrees %s is %.2f degrees %s\n",temp,scale,cValue5,convertScale);
                }
                else if (scale.equals("Kelvin") && convertScale.equals("Fahrenheit")) {
                    double cValue6 = convertKeltoFah(temp);
                    System.out.printf("%.2f degrees %s is %.2f degrees %s\n",temp,scale,cValue6,convertScale);
                }
                else if (scale.equals(convertScale)){
                    System.out.printf("%.2f degrees %s is %.2f degrees %s\n",temp,scale,temp,convertScale);
                }
            }
            else{
                System.out.println(temp + " degrees " + scale + " is not a valid temperature");
            }
            System.out.println("Would you like to convert another temperature? Enter quit to exit.");
            String decision = input.nextLine();
            if (decision.equals("quit")){
                result = false;
            }
            else {

            }
           }
           while(result);

    }// End of proccessData

    public static boolean checkValidity(double temp, String scale) {
        boolean check = false;

        if(scale.equals("Fahrenheit") && (temp >= -459.40 && temp <= 1000)){
             check = true;
        }

        else if (scale.equals("Celsius") && (temp >= -273 && temp <= 1000)){
             check = true;
        }

        else if (scale.equals("Kelvin") && (temp >= 0 && temp <= 1000)){
             check = true;
        }
//
//        else {
//            check = false;
//        }
        return check;
    }// End of checkValidity

    public static double convertFahtoCel(double aTemp) {
        double Cel1 = (aTemp - 32) / (9 / 5.0);
        return Cel1;
    }/* End of convertFahtoCel */

    public static double convertFahtoKel(double aTemp){
        //double ftC1 = (aTemp - 32) / (9 / 5);
        return convertCeltoKel(convertFahtoCel(aTemp));
        //double ctK1 = ftC1 + 273;
        //return ctK1;
    } //End of convertFahtoKel

    public static double convertCeltoFah(double aTemp) {
        double ctF1 = (aTemp * (9 / 5.0)) + 32;
        return ctF1;
    } // End of convertCeltoFah

    public static double convertCeltoKel(double aTemp) {
        double ctK2 = (aTemp + 273);
        return ctK2;
    } // End of convertCeltoKel

    public static double convertKeltoCel(double aTemp){
        double ktC1 = (aTemp - 273);
        return ktC1;
    } // End of convertKeltoCel

    public static double convertKeltoFah(double aTemp){
//        double ktC1 = (aTemp - 273);
        return convertCeltoFah(convertKeltoCel(aTemp));
//        double ctF2 = (ktC1 * (9 / 5.0)) + 32;
//        return ctF2;
    } // End of convertKeltoFah

}//End of Class
