// Author: Christopher Champion
// ID: 17192467
package cse105_cw2;

// Do NOT change this class name
import java.util.Scanner;

public class CSE105_CW2 {

    public static void main(String[] args) {
        String input = "XXX-023456-1234-56";
        // Valid input for first three characters is:
        // BKK, KKB, TMB, SCB          
        // Valid input for the last two digits/year is:
        // 03 to 20

        // Scanner for user input
        Scanner kbInput = new Scanner(System.in);
        System.out.print("Enter 18 digit account number in format XXX-023456-1234-56: ");

        input = kbInput.nextLine();

        boolean valid = validateString(input);
        System.out.println("Valid string = " + valid);
    }

    //do not change the name or return type of this method
    public static boolean validateString(String input) {

        boolean validInput = false;
        boolean validFormat = false;
        boolean validLength = false;
        boolean validBank = false;
        boolean validYear = false;

        // Check '-'
        if (input.substring(3).contains("-")
                && input.substring(10).contains("-")
                && input.substring(15).contains("-")) {
            validFormat = true;
        } else {
            System.out.println("Invalid format: '-'");
        }

        // Check length
        if (input.length() == 18) {
            validLength = true;
        } else {
            System.out.println("Invalid account number length");
        }

        // Split input
        String[] inputChars = input.split("-");
        for (int i = 0; i < inputChars.length; i++) {
            System.out.println(inputChars[i]);
        }

        // Check bank abbreviation
        String acctBankName = inputChars[0];
        if (acctBankName.equalsIgnoreCase("BKK") || acctBankName.equalsIgnoreCase("KKB")
                || acctBankName.equalsIgnoreCase("TMB") || acctBankName.equalsIgnoreCase("SCB")) {
            validBank = true;
        } else {
            System.out.println("Invalid acct abbreviation");
        }

        // Check year
        String year = inputChars[3];
        int acctYear = Integer.parseInt(year);
        if (acctYear > 2 && acctYear < 21) {
            validYear = true;
        } else {
            System.out.println("Invalid year");
        }

        // Check valid input
        if (validFormat && validLength && validBank && validYear) {
            validInput = true;
        }

        return validInput;
    }

}
