import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

public class Expenses {

    public static void main (String[] args) {
        //test
        double[] moneyList = new double[50];
        Scanner scnr = new Scanner(System.in);
        String[] names = new String[50];
        StringWriter outputIncome = new StringWriter();
        PrintWriter editIncome = new PrintWriter(outputIncome);
        StringWriter outputExpenses = new StringWriter();
        PrintWriter editExpenses = new PrintWriter(outputExpenses);
        boolean shouldContinue = true;
        boolean inputAccepted = false;
        String nextString;
        //test comment

        float expenseSubtotal = 0;
        float incomeSubtotal = 0;
        int index = 0;
        int longestWordLen = 0;
        double max;
        int maxNumDigit = 3;
        int digitCount = 3;

        System.out.println("Please input the name of your expense the ENTER key,\nthen the cost of the expense,\nbefore pressing the ENTER key again.\nPositive and negative values are accepted.\nNo extra symbols are to be used when entering the costs.\nWhen you're done simply press ENTER one more time.");
        while (shouldContinue) {

            nextString = scnr.nextLine();
            if (nextString.equals("")){

                shouldContinue = false;

            }
            else {

                names[index] = nextString;
                inputAccepted = false;
                while(!inputAccepted && shouldContinue) {
                    inputAccepted = true;
                    String input = scnr.nextLine();

                    try {

                        moneyList[index] = Float.parseFloat(input);

                    }
                    catch(NumberFormatException e){

                        System.out.println("Enter a number please.");
                        inputAccepted = false;

                    }
                    digitCount = digitAfterOnesPlace.count((int) moneyList[index]);


                    if (digitCount != String.valueOf(input).length() - 1 && moneyList[index] > 0) {

                        System.out.println("Please reenter value in dollars and cents separated by a decimal.");
                        inputAccepted = false;

                    } else if (digitCount != String.valueOf(input).length() - 2 && moneyList[index] < 0) {

                        System.out.println("Please reenter value in dollars and cents separated by a decimal.");
                        inputAccepted = false;

                    }

                    if (inputAccepted){

                        index++;

                    }

                }

            }


        }





        for (int i = 0; i < index; i++){

            if (names[i].length() > longestWordLen){
                longestWordLen = names[i].length();
            }

        }

        for (int i = 0; i < index; i++){

            if (moneyList[i] < 0){

                expenseSubtotal = (float) (expenseSubtotal + moneyList[i]);

            }
            else{

                incomeSubtotal = (float) (incomeSubtotal + moneyList[i]);

            }

        }
        max = Math.max(Math.abs(expenseSubtotal), incomeSubtotal);
        maxNumDigit = digitAfterOnesPlace.count((int) max);


        for (int i = 0; i < index; i++) {

            digitCount = digitAfterOnesPlace.count((int) moneyList[i]);


            if (moneyList[i] < 0){
                editExpenses.print(names[i] + "          ");
                for (int g = 0; g < longestWordLen - names[i].length(); g++){

                    editExpenses.print(" ");

                }
                editExpenses.print("$ ");
                editExpenses.print("(");
                for (int x = 0; x < maxNumDigit - digitCount + 1; x++){

                    editExpenses.print(" ");

                }
                editExpenses.printf("%.2f)\n", Math.abs(moneyList[i]));

            }
            else{
                editIncome.print(names[i] + "          ");
                for (int g = 0; g < longestWordLen - names[i].length(); g++){

                    editIncome.print(" ");

                }
                editIncome.print("$ ");
                for (int x = 0; x < maxNumDigit - digitCount + 2; x++){

                    editIncome.print(" ");

                }
                editIncome.printf("%.2f\n", Math.abs(moneyList[i]));

            }



        }

        int spacerLength = 0;

        System.out.printf("Income:\n%s", outputIncome.toString());
        System.out.print("Subtotal: ");

        if (("Subtotal: ").length() < longestWordLen + 10);{

            spacerLength = longestWordLen + 10 - ("Subtotal: ").length();
            spacer.gapLen(spacerLength);


        }
        System.out.print("$ ");
        digitCount = digitAfterOnesPlace.count((int) incomeSubtotal);

        spacer.gapLen(maxNumDigit - digitCount + 2);

        System.out.printf("%.2f\n", incomeSubtotal);





        System.out.printf("\nExpenses:\n%s", outputExpenses.toString());
        System.out.printf("Subtotal: ");
        spacer.gapLen(spacerLength);

        System.out.print("$ ");
        digitCount = digitAfterOnesPlace.count((int) expenseSubtotal);
        spacer.gapLen(maxNumDigit - digitCount);
        System.out.printf("(%.2f)\n", expenseSubtotal);


        System.out.printf("\nTotal: ");
        spacer.gapLen(spacerLength + 3);

        System.out.print("$ ");

        digitCount = digitAfterOnesPlace.count((int) ((int) incomeSubtotal - expenseSubtotal));

        if ((incomeSubtotal + expenseSubtotal) < 0){

            spacer.gapLen(maxNumDigit - digitCount);

            System.out.printf("(%.2f)\n", (incomeSubtotal + expenseSubtotal));

        }
        else {

            spacer.gapLen(maxNumDigit - digitCount + 2);
            System.out.printf("%.2f\n", (incomeSubtotal + expenseSubtotal));

        }


    }

}