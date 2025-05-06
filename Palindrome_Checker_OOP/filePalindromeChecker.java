package Palindrome_Checker_OOP;

import java.io.File;
import java.util.Scanner;

public class filePalindromeChecker {
    private String fileName;

    public filePalindromeChecker(String fileName){
        this.fileName = fileName;
    }

    public void palindromeChecker(){
        File file = new File(fileName);
        try(Scanner fileReader = new Scanner(file)){
            if(!fileReader.hasNextLine()){
                System.out.println("This file is empty");
                return;
            }
            while (fileReader.hasNextLine()){
                String nextLine = fileReader.nextLine();
                palindromeChecker checker = new palindromeChecker(nextLine);
                System.out.println(nextLine + " = " + checker);
            }
            System.out.println("\nThe program has fully scanned the file");
            System.out.println("No more lines had been detected");
            System.out.println("\nProgram will now terminate..");
            System.out.println("Goodbye!");
        } catch(Exception e){
            System.out.println("Error: " + e);
        }
    }
}
