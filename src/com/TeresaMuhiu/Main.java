package com.TeresaMuhiu;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// Mortgage Calculator
        //program that calculates monthly payments
        //and displays it as currency

        final byte MONTHS_IN_A_YEAR = 12;
        final byte PERCENT = 100;
//
        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        //allows user to enter info. Integer is a good data type for storing the principal
        //As short is not enough as short can only store 32000 dollars
        //Int allows to store values up to 2 billion

        int principal = scanner.nextInt();


        System.out.print("Annual Interest Rate: ");
        //double data type is to big as
        // interest rate is a small number so float is the better choice
        float annualInterestRate = scanner.nextFloat();
        //to get monthlyInterest Rate need to divide
        //the annual Interest rate by 12 and then by 100
        float monthlyInterestRate = annualInterestRate / MONTHS_IN_A_YEAR / PERCENT;
        //System.out.print(monthlyInterestRate);

        System.out.print("Period (Years): ");
        byte years = scanner.nextByte(); //byte bc maximum # we want to support is 30 so 1 byte is sufficient enough
        int numberOfPayments = years * MONTHS_IN_A_YEAR;

        double mortgage = principal * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments))-1;
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + formattedMortgage);



    }
}
